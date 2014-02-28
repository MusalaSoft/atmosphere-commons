package com.musala.atmosphere.commons.exceptions;

/**
 * Thrown when an action execution on a device has failed.
 * 
 * @author georgi.gaydarov
 * 
 */
public class CommandFailedException extends Exception {
    private static final long serialVersionUID = -3879797786566060077L;

    public CommandFailedException() {
    }

    public CommandFailedException(String message) {
        super(message);
    }

    public CommandFailedException(String message, Throwable inner) {
        super(message, inner);
    }
}
