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
