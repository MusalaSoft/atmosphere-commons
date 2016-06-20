package com.musala.atmosphere.commons.exceptions;

/**
 * Thrown when trying to get an option that has not been passed to the command line.
 * 
 * @author yordan.petrov
 * 
 */
public class OptionNotPresentException extends Exception {
    private static final long serialVersionUID = -3303768259274191567L;

    public OptionNotPresentException() {
        super();
    }

    public OptionNotPresentException(String message) {
        super(message);
    }

    public OptionNotPresentException(String message, Throwable inner) {
        super(message, inner);
    }

    public OptionNotPresentException(Throwable inner) {
        super(inner);
    }

}
