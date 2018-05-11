// This file is part of the ATMOSPHERE mobile testing framework.
// Copyright (C) 2016 MusalaSoft
//
// ATMOSPHERE is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ATMOSPHERE is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with ATMOSPHERE.  If not, see <http://www.gnu.org/licenses/>.

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
