package com.musala.atmosphere.commons.exceptions;

/**
 * Thrown in cases of wrong configuration set.
 *
 * @author filareta.yordanova
 *
 */
public class AtmosphereConfigurationException extends AtmosphereRuntimeException {
    private static final long serialVersionUID = -5550348639878749992L;

    /**
     * Creates new {@link AtmosphereConfigurationException AtmosphereConfigurationException}.
     */
    public AtmosphereConfigurationException() {
        super();
    }

    /**
     * Creates new {@link AtmosphereConfigurationException AtmosphereConfigurationException} with the given message.
     *
     * @param message
     *        - message representing the error that occurred
     */
    public AtmosphereConfigurationException(String message) {
        super(message);
    }

    /**
     * Creates new {@link AtmosphereConfigurationException AtmosphereConfigurationException} with the given message and
     * the {@link Throwable cause} for the exception.
     *
     * @param message
     *        - message representing the error that occurred
     * @param cause
     *        - the cause for the exception
     */
    public AtmosphereConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
