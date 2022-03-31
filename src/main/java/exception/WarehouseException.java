package exception;

public class WarehouseException extends Exception{
    public WarehouseException() {
    }

    public WarehouseException(String message) {
        super(message);
    }

    public WarehouseException(String message, Throwable cause) {
        super(message, cause);
    }

    public WarehouseException(Throwable cause) {
        super(cause);
    }

    public WarehouseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
