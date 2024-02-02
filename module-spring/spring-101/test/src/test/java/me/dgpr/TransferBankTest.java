package me.dgpr;

import static com.navercorp.fixturemonkey.api.experimental.JavaGetterMethodPropertySelector.javaGetter;
import static org.assertj.core.api.Assertions.assertThat;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.api.introspector.ConstructorPropertiesArbitraryIntrospector;
import me.dgpr.TransferBankUseCase.Result;
import me.dgpr.TransferBankUseCase.Result.Failure;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TransferBankTest {

    FixtureMonkey fm = FixtureMonkey.builder()
            .objectIntrospector(ConstructorPropertiesArbitraryIntrospector.INSTANCE)
            .build();

    @Mock
    BankPort bankPort;

    @Mock
    EmailPort emailPort;

    @InjectMocks
    TransferBank sut;

    @Test
    void 동일_계좌로_송금할_경우_실패한다() {
        //Arrange
        BankAccount fromAccount = fm.giveMeBuilder(BankAccount.class)
                .set(javaGetter(BankAccount::accountNumber), "1234567890")
                .set(javaGetter(BankAccount::bankCode), "1234")
                .sample();

        BankAccount toAccount = fm.giveMeBuilder(BankAccount.class)
                .set(javaGetter(BankAccount::accountNumber), "1234567890")
                .set(javaGetter(BankAccount::bankCode), "1234")
                .sample();

        long amount = 100_000L;

        //Act
        Result result = sut.invoke(fromAccount, toAccount, amount);

        //Assert
        assertThat(result).isInstanceOf(Failure.class);
        Failure failure = (Failure) result;
        assertThat(failure.throwable()).isInstanceOf(RuntimeException.class)
                .hasMessage("동일 계좌로 송금할 수 없음");
    }

}