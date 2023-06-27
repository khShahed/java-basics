package exceptions;

import java.math.BigDecimal;

public class Account {
    private final BigDecimal balance = new BigDecimal(0);

    public void deposit(BigDecimal amount) {

    }

    public void withdraw(BigDecimal amount) throws AccountException {
        if (balance.compareTo(amount) < 0) {
            var fundsException = new InsufficientFundException();

            throw new AccountException(fundsException);
        }
    }
}
