package com.musala.atmosphere.commons.commandline;

import com.musala.atmosphere.commons.exceptions.NoDefaultValuePresentException;

/**
 * Represents a command line argument that can be passed to a {@link CommandLineOption Command Line Option}.
 * 
 * @author yordan.petrov
 * 
 */
public class CommandLineArgument {
    private String name;

    private boolean hasDefaultValue;

    private Object defaultValue;

    /**
     * Constructs a {@link CommandLineArgument Command Line Argument} by a given name of the argument.
     * 
     * @param name
     *        - name of the {@link CommandLineArgument Command Line Argument}
     */
    public CommandLineArgument(String name) {
        this.name = name;
        this.hasDefaultValue = false;
    }

    /**
     * Constructs a {@link CommandLineArgument Command Line Argument} by a given name of the argument and a default
     * value.
     * 
     * @param name
     *        - name of the {@link CommandLineArgument Command Line Argument}
     * @param defaultValue
     *        - default value of the {@link CommandLineArgument Command Line Argument}
     */
    public CommandLineArgument(String name, Object defaultValue) {
        this.name = name;
        this.hasDefaultValue = true;
        this.defaultValue = defaultValue;
    }

    /**
     * Gets the name of this {@link CommandLineArgument Command Line Argument}.
     * 
     * @return the name of this {@link CommandLineArgument Command Line Argument}
     */
    public String getName() {
        return name;
    }

    /**
     * Checks whether this {@link CommandLineArgument Command Line Argument} has a default value.
     * 
     * @return <code>true</code> if the {@link CommandLineArgument Command Line Argument} has a default value;
     *         <code>false</code> if it does not have a default value
     */
    public boolean hasDefaultValue() {
        return hasDefaultValue;
    }

    /**
     * Gets the default value of this {@link CommandLineArgument Command Line Argument}.
     * 
     * @return the default value of this {@link CommandLineArgument Command Line Argument}.
     * @throws NoDefaultValuePresentException if there is no default value.
     */
    public Object getDefaultValue() throws NoDefaultValuePresentException {
        if (hasDefaultValue()) {
            return defaultValue;
        }

        throw new NoDefaultValuePresentException();
    }
}
