package me.dgpr.chapter_2.item_8;

public class BankAttack extends Bank {

    public BankAttack(final int money) {
        super(money);
    }

    @Override
    protected void finalize() throws Throwable {
        this.transfer(1000000000);
    }
}
