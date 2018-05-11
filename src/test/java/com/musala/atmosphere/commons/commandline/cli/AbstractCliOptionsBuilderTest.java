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

import static org.junit.Assert.assertEquals;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.junit.Test;

import com.musala.atmosphere.commons.commandline.CommandLineArgument;
import com.musala.atmosphere.commons.commandline.CommandLineOption;
import com.musala.atmosphere.commons.commandline.IOption;

/**
 * 
 * @author yordan.petrov
 * 
 */
public class AbstractCliOptionsBuilderTest {

    private AbstractCliOptionsBuilder cliOptionBuilder = new AbstractCliOptionsBuilder() {

        @Override
        public Options buildOptions() {
            return null;
        }
    };

    private IOption missleOption = new IOption() {
        private CommandLineOption missleClOption = new CommandLineOption("l",
                                                                         "launch",
                                                                         "launches a rocket misle.",
                                                                         true);

        private CommandLineArgument missleSerialClArgument = new CommandLineArgument("missle serial");

        @Override
        public boolean hasArgument() {
            return true;
        }

        @Override
        public CommandLineOption getOption() {
            return missleClOption;
        }

        @Override
        public CommandLineArgument getArgument() {
            return missleSerialClArgument;
        }
    };

    @Test
    public void testBuildOption() {
        Option builtOption = cliOptionBuilder.buildOption(missleOption);

        CommandLineOption missleClOption = missleOption.getOption();
        CommandLineArgument missleSerialClArgument = missleOption.getArgument();

        assertEquals("Built option long name does not match passed option long name.",
                     missleClOption.getLongName(),
                     builtOption.getLongOpt());
        assertEquals("Built option short name does not match passed option short name.",
                     missleClOption.getShortName(),
                     builtOption.getOpt());
        assertEquals("Built option description does not match passed option description.",
                     missleClOption.getDescritpion(),
                     builtOption.getDescription());
        assertEquals("Built option required flag does not match passed option required flag.",
                     missleClOption.isRequired(),
                     builtOption.isRequired());
        assertEquals("Built option argument name does not match passed option argument name.",
                     missleSerialClArgument.getName(),
                     builtOption.getArgName());
    }
}
