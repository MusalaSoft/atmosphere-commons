package com.musala.atmosphere.commons.commandline;

import com.musala.atmosphere.commons.exceptions.ArgumentParseException;

/**
 * An interface parser for {@link IOption IOptions} passed to the command line.
 * 
 * @see IOption
 * @author yordan.petrov
 * 
 */
public interface IArgumentParser {
    /**
     * Parses the string value of the given {@link IOption}.
     * 
     * @param iOption
     *        - the {@link IOption} the passed string value belongs to
     * @param value
     *        - the value of the {@link IOption option}
     * @return the parsed value of the given {@link IOption option}
     * @throws ArgumentParseException
     *         thrown when the argument parsing fails for some reason
     */
    public abstract Object getOption(IOption iOption, String value) throws ArgumentParseException;
}
