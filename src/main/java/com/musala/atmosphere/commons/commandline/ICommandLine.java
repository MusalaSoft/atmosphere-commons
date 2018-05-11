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

import com.musala.atmosphere.commons.exceptions.ArgumentParseException;
import com.musala.atmosphere.commons.exceptions.CommandLineParseException;
import com.musala.atmosphere.commons.exceptions.OptionNotPresentException;

/**
 * A command line interface that handles parsing and obtaining command line arguments.
 * 
 * @author yordan.petrov
 * 
 */
public interface ICommandLine {
    /**
     * Prints the usage help on the command line.
     * 
     * @param commandSyntax
     *        - the syntax of the command for the command line
     */
    public abstract void printHelp(String commandSyntax);

    /**
     * Parses the passed command line arguments.
     * 
     * @param arguments
     *        - arguments that will be parsed
     * @throws CommandLineParseException
     *         thrown when the parsing of the command line arguments fails for some reason; for example, invalid syntax
     */
    public abstract void parseArguments(String[] arguments) throws CommandLineParseException;

    /**
     * Checks whether a given {@link IOption} is passed to the command line.
     * 
     * @param iOption
     *        - the {@link IOption} to check
     * @return <b>true</b> if the given {@link IOption} is passed to the command line; <b>false</b> otherwise
     */
    public abstract boolean hasOption(IOption iOption);

    /**
     * Gets the string value of argument passed with the given {@link IOption}.
     * 
     * @param iOption
     *        - the {@link IOption} that the argument value belongs to
     * @return the string value of argument passed with the given {@link IOption}
     * @throws OptionNotPresentException
     *         when the given {@link IOption} is not passed to the command line
     */
    public abstract String getOption(IOption iOption) throws OptionNotPresentException;

    /**
     * Gets the parsed value of the argument passed with the given {@link IOption} or the default value if such is not
     * passed.
     * 
     * @param iOption
     *        - the {@link IOption} that the argument belongs to
     * @return the parsed value of the argument passed with the given {@link IOption} or the default value if such is
     *         not passed.
     * @throws OptionNotPresentException
     *         thrown when the option is no passed to the command line and a default value does not exist
     * @throws ArgumentParseException
     *         thrown when the parsing of the argument fails for some reason
     */
    public abstract Object getParsedOptionValue(IOption iOption)
        throws OptionNotPresentException,
            ArgumentParseException;
}
