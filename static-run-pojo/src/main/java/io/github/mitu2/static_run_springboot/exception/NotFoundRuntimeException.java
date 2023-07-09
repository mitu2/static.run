package io.github.mitu2.static_run_springboot.exception;

import java.io.Serial;

/**
 * @author chenmoand
 * @date 2023/7/9 21:12
 */
public class NotFoundRuntimeException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -8122414064467308641L;

    public NotFoundRuntimeException() {
        super();
    }

    public NotFoundRuntimeException(String message) {
        super(message);
    }

    public NotFoundRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundRuntimeException(Throwable cause) {
        super(cause);
    }

    protected NotFoundRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
