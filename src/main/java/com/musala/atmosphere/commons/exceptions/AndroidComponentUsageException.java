package com.musala.atmosphere.commons.exceptions;

/**
 * This exception is generally thrown when an android component accessed from outside the android platform.
 * 
 * @author vassil.angelov
 *
 */
public class AndroidComponentUsageException extends AtmosphereRuntimeException {
    private static final long serialVersionUID = -8889675652861871590L;

    public AndroidComponentUsageException() {
    }

    public AndroidComponentUsageException(String message) {
        super(message);
    }

    public AndroidComponentUsageException(String message, Throwable inner) {
        super(message, inner);
    }

    public AndroidComponentUsageException(Throwable inner) {
        super(inner);
    }

}
