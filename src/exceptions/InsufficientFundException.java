package exceptions;

public class InsufficientFundException extends Exception {
    public InsufficientFundException() {
        super("Insufficient fund in your account.");
    }

    public InsufficientFundException(String message) {
        super(message);
    }
}
