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

/**
 * Represent an option that can be passed to the command line.
 * 
 * @see ICommandLine
 * @see CommandLineArgument
 * @author yordan.petrov
 * 
 */
public class CommandLineOption {
    private String shortName;

    private String longName;

    private String descritpion;

    private boolean isRequired;

    /**
     * Constructs a new {@link CommandLineOption Command Line Option} by given short name, long name and description.
     * The option constructed this way is marked as not required.
     * 
     * @param shortName
     *        - short name of the option
     * @param longName
     *        - long name of the option
     * @param description
     *        - description of the option
     */
    public CommandLineOption(String shortName, String longName, String description) {
        this.shortName = shortName;
        this.longName = longName;
        this.descritpion = description;
        this.isRequired = false;
    }

    /**
     * Constructs a new {@link CommandLineOption Command Line Option} by given short name, long name, description and
     * required flag.
     * 
     * @param shortName
     *        - short name of the option
     * @param longName
     *        - long name of the option
     * @param description
     *        - description of the option
     * @param isRequired
     *        - specifies whether the option is required or not
     */
    public CommandLineOption(String shortName, String longName, String description, boolean isRequired) {
        this.shortName = shortName;
        this.longName = longName;
        this.descritpion = description;
        this.isRequired = isRequired;
    }

    /**
     * Gets the short name of this {@link CommandLineOption Command Line Option}.
     * 
     * @return the short name of this {@link CommandLineOption Command Line Option}.
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Gets the long name of this {@link CommandLineOption Command Line Option}.
     * 
     * @return the long name of this {@link CommandLineOption Command Line Option}.
     */
    public String getLongName() {
        return longName;
    }

    /**
     * Gets the description of this {@link CommandLineOption Command Line Option}.
     * 
     * @return the description of this {@link CommandLineOption Command Line Option}.
     */
    public String getDescritpion() {
        return descritpion;
    }

    /**
     * Checks whether this {@link CommandLineOption Command Line Option} is required.
     * 
     * @return <code>true</code> if this {@link CommandLineOption Command Line Option} is required; <code>false</code>
     *         otherwise
     */
    public boolean isRequired() {
        return isRequired;
    }
}
