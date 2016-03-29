package my.code.library.util;

public class StateCorruptedException extends RuntimeException {
    static final long serialVersionUID = -7064897190445766919L;

    public StateCorruptedException() {
    }

    public StateCorruptedException(String message) {
        super(message);
    }

    public StateCorruptedException(String message, Throwable cause) {
        super(message, cause);
    }

    public StateCorruptedException(Throwable cause) {
        super(cause);
    }

    public StateCorruptedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
