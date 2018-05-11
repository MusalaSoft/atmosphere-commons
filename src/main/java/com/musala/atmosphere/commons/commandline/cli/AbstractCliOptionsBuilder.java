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

import java.util.List;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

import com.musala.atmosphere.commons.commandline.CommandLineArgument;
import com.musala.atmosphere.commons.commandline.CommandLineOption;
import com.musala.atmosphere.commons.commandline.IOption;

/**
 * Builds the {@link Options CLI Options} that can be used to parse command line arguments with a
 * {@link CommandLineParser}. This class is used for command line argument parsing with the <a
 * href="http://commons.apache.org/proper/commons-cli/">Apache Commons CLI</a> library.
 * 
 * @see <a href="http://commons.apache.org/proper/commons-cli/">Apache Commons CLI</a>
 * @author yordan.petrov
 * 
 */
public abstract class AbstractCliOptionsBuilder {
    protected Options cliOptions = new Options();

    /**
     * Builds a {@link Option CLI Option} from the passed {@link IOption}.
     * 
     * @param iOption
     *        - {@link IOption} object that will be used to build the {@link Option CLI Option}
     * @return a {@link Option CLI Option} built from the passed AgentOption
     */
    @SuppressWarnings("static-access")
    protected Option buildOption(IOption iOption) {
        CommandLineOption clOption = iOption.getOption();

        Option cliOption = OptionBuilder.withLongOpt(clOption.getLongName())
                                        .isRequired(clOption.isRequired())
                                        .hasArg(iOption.hasArgument())
                                        .withDescription(clOption.getDescritpion())
                                        .create(clOption.getShortName());

        if (iOption.hasArgument()) {
            CommandLineArgument clArgument = iOption.getArgument();
            cliOption.setArgName(clArgument.getName());
        }

        return cliOption;
    }

    /**
     * Adds a list of {@link Option CLI Options} to the {@link AbstractCliOptionsBuilder#cliOptions CLI Options field}.
     * 
     * @param cliOptionList
     *        - a list of {@link Option CLI Options} to be added to the {@link AbstractCliOptionsBuilder#cliOptions CLI
     *        Options field}
     */
    protected void addOptions(List<Option> cliOptionList) {
        for (Option cliOption : cliOptionList) {
            cliOptions.addOption(cliOption);
        }
    }

    /**
     * Builds and returns the {@link Options CLI Options} of the agent command line interface.
     * 
     * @return the {@link Options CLI Options} of the agent command line interface
     */
    public abstract Options buildOptions();

}
