package com.musala.atmosphere.commons.exceptions;

import com.musala.atmosphere.commons.commandline.CommandLineArgument;

/**
 * Thrown when no default value for a given {@link CommandLineArgument Command Line Argument} is present.
 * 
 * @author yordan.petrov
 * 
 */
public class NoDefaultValuePresentException extends Exception {

    private static final long serialVersionUID = -752720307917381603L;

    public NoDefaultValuePresentException() {
    }

    public NoDefaultValuePresentException(String message) {
        super(message);
    }

    public NoDefaultValuePresentException(String message, Throwable inner) {
        super(message, inner);
    }

    public NoDefaultValuePresentException(Throwable inner) {
        super(inner);
    }

}
