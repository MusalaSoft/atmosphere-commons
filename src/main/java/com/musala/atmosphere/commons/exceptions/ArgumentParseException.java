package com.musala.atmosphere.commons.exceptions;

/**
 * Thrown when the parsing of a command line argument fails for some reason. For example, invalid syntax or invalid
 * value.
 * 
 * @author yordan.petrov
 * 
 */
public class ArgumentParseException extends Exception {
    private static final long serialVersionUID = -8910767145440531022L;

    public ArgumentParseException() {
        super();
    }

    public ArgumentParseException(String message) {
        super(message);
    }

    public ArgumentParseException(String message, Throwable inner) {
        super(message, inner);
    }

    public ArgumentParseException(Throwable inner) {
        super(inner);
    }
}
