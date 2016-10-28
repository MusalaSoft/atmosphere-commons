package com.musala.atmosphere.commons.exceptions;

/**
 * This is a base exception for all Runtime exceptions that might be thrown from Atmosphere framework.
 * 
 * @author yavor.stankov
 * 
 */

public class AtmosphereRuntimeException extends RuntimeException {

    /**
     * auto generated serialization id
     */
    private static final long serialVersionUID = -806936737487760417L;

    public AtmosphereRuntimeException() {
    }

    public AtmosphereRuntimeException(String message) {
        super(message);
    }

    public AtmosphereRuntimeException(String message, Throwable inner) {
        super(message, inner);
    }

    public AtmosphereRuntimeException(Throwable inner) {
        super(inner);
    }
}
