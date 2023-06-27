package exceptions;

import java.math.BigDecimal;

public class ExceptionTest {
    public static void show() {
        var account = new Account();
        try {
            account.withdraw(new BigDecimal(10));
        } catch (AccountException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
