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

package com.musala.atmosphere.commons.commandline.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;

import com.musala.atmosphere.commons.commandline.CommandLineArgument;
import com.musala.atmosphere.commons.commandline.CommandLineOption;
import com.musala.atmosphere.commons.commandline.IArgumentParser;
import com.musala.atmosphere.commons.commandline.ICommandLine;
import com.musala.atmosphere.commons.commandline.IOption;
import com.musala.atmosphere.commons.exceptions.ArgumentParseException;
import com.musala.atmosphere.commons.exceptions.CommandLineParseException;
import com.musala.atmosphere.commons.exceptions.NoDefaultValuePresentException;
import com.musala.atmosphere.commons.exceptions.OptionNotPresentException;

/**
 * A command line that uses the <a href="http://commons.apache.org/proper/commons-cli/">Apache Commons CLI</a> library
 * to parse and handle the command line arguments.
 * 
 * @see <a href="http://commons.apache.org/proper/commons-cli/">Apache Commons CLI</a>
 * @see ICommandLine
 * @author yordan.petrov
 * 
 */
public class CliCommandLine implements ICommandLine {
    protected static final Logger LOGGER = Logger.getLogger(CliCommandLine.class);

    private IArgumentParser argumentParser;

    private CommandLine commandLine;

    private Options commandLineOptions;

    /**
     * Constructs a {@link CliCommandLine} object that uses the <a
     * href="http://commons.apache.org/proper/commons-cli/">Apache Commons CLI</a> library to parse and handle the
     * command line arguments.
     * 
     * @param cliOptionsBuilder
     *        - a builder that builds {@link Options Command Line Options}
     * @param argumentParser
     *        - a parser for command line arguments
     */
    public CliCommandLine(AbstractCliOptionsBuilder cliOptionsBuilder, IArgumentParser argumentParser) {
        AbstractCliOptionsBuilder commandLineOptionsBuilder = cliOptionsBuilder;
        this.commandLineOptions = commandLineOptionsBuilder.buildOptions();
        this.argumentParser = argumentParser;
    }

    @Override
    public void printHelp(String commandSyntax) {
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp(commandSyntax, commandLineOptions);
    }

    @Override
    public void parseArguments(String[] arguments) throws CommandLineParseException {
        CommandLineParser commandLineParser = new GnuParser();

        try {
            commandLine = commandLineParser.parse(commandLineOptions, arguments);
        } catch (ParseException e) {
            String message = "Parsing command line parameters failed.";
            LOGGER.fatal(message, e);
            throw new CommandLineParseException(message, e);
        }
    }

    @Override
    public boolean hasOption(IOption iOption) {
        CommandLineOption clOption = iOption.getOption();
        String clOptionLongName = clOption.getLongName();

        return commandLine.hasOption(clOptionLongName);
    }

    @Override
    public String getOption(IOption iOption) throws OptionNotPresentException {
        CommandLineOption clOption = iOption.getOption();
        String clOptionLongName = clOption.getLongName();

        if (hasOption(iOption)) {
            return commandLine.getOptionValue(clOptionLongName);
        }

        String errorMessageFormat = "The argument(s) for option '%s' is not present.";
        String errorMessage = String.format(errorMessageFormat, clOptionLongName);

        throw new OptionNotPresentException(errorMessage);
    }

    @Override
    public Object getParsedOptionValue(IOption iOption) throws OptionNotPresentException, ArgumentParseException {
        try {
            String optionStringValue = getOption(iOption);
            Object optionValue = argumentParser.getOption(iOption, optionStringValue);

            return optionValue;
        } catch (OptionNotPresentException e) {
            CommandLineArgument clArgument = iOption.getArgument();

            try {
                return clArgument.getDefaultValue();
            } catch (NoDefaultValuePresentException e1) {

                CommandLineOption clOption = iOption.getOption();
                String errorMessageFormat = "Option '%s' is not present and does not have a default value.";
                String errorMessage = String.format(errorMessageFormat, clOption.getLongName());

                throw new OptionNotPresentException(errorMessage, e1);
            }
        }
    }

}
