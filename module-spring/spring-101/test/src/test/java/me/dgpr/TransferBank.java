package me.dgpr;

import me.dgpr.TransferBankUseCase.Result.Failure;

public class TransferBank implements TransferBankUseCase {

    private final TransferHistoryRepository transferHistoryRepository;
    private final EmailPort emailPort;
    private final BankPort bankPort;

    public TransferBank(TransferHistoryRepository transferHistoryRepository, EmailPort emailPort, BankPort bankPort) {
        this.transferHistoryRepository = transferHistoryRepository;
        this.emailPort = emailPort;
        this.bankPort = bankPort;
    }

    @Override
    public Result invoke(BankAccount from, BankAccount to, long amount) {

        // 동일 계좌로 송금할 수 없음
        if (from.bankCode().equals(to.bankCode()) && from.accountNumber().equals(to.accountNumber())) {
            return new Failure(new RuntimeException("동일 계좌로 송금할 수 없음"));
        }

        // FROM 계좌의 잔액이 충분한지 검사
        var balanceOfFromBankAccount = bankPort.getBalance(from.bankCode(), from.accountNumber());
        if (balanceOfFromBankAccount < amount) {
            return new Failure(new RuntimeException("잔액 부족"));
        }

        // TO 계좌로 송금액만큼 입금
        var response = bankPort.deposit(to.bankCode(), to.accountNumber(), amount);
        if (response.isSuccess()) {
            TransferHistory transferHistory = transferHistoryRepository.save(
                    new TransferHistory(
                            System.currentTimeMillis(),
                            from.bankCode(),
                            from.accountNumber(),
                            to.bankCode(),
                            to.accountNumber(),
                            amount
                    )
            );

            emailPort.sendEmail("송금 완료");
            return new Result.Success(transferHistory.getId());
        }

        return new Failure(new RuntimeException("송금 실패"));
    }
}
