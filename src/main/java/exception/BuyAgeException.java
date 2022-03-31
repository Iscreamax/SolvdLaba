package exception;

public class BuyAgeException extends Exception {
    public BuyAgeException() {
    }

    public BuyAgeException(String message) {
        super(message);
    }

    public BuyAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuyAgeException(Throwable cause) {
        super(cause);
    }

    public BuyAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
