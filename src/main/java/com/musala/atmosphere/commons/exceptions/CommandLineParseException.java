package com.musala.atmosphere.commons.exceptions;

/**
 * Thrown when the parsing of the arguments passed to the command line fails for some reason. For example, unsupported
 * options or invalid syntax.
 * 
 * @author yordan.petrov
 * 
 */
public class CommandLineParseException extends Exception {
    private static final long serialVersionUID = 2902850117363663984L;

    public CommandLineParseException() {
        super();
    }

    public CommandLineParseException(String message) {
        super(message);
    }

    public CommandLineParseException(String message, Throwable inner) {
        super(message, inner);
    }

    public CommandLineParseException(Throwable inner) {
        super(inner);
    }

}
