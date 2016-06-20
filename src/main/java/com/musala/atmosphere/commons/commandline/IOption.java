package com.musala.atmosphere.commons.commandline;

public interface IOption {
    /**
     * Gets the {@link CommandLineOption Command Line Option} for this {@link IOption}.
     * 
     * @return the {@link CommandLineOption Command Line Option} for this {@link IOption}
     */
    public CommandLineOption getOption();

    /**
     * Gets the {@link CommandLineArgument Command Line Argument} for this {@link IOption}.
     * 
     * @return the {@link CommandLineArgument Command Line Argument} for this {@link IOption}
     */
    public CommandLineArgument getArgument();;

    /**
     * Checks whether this {@link IOption} has a {@link CommandLineArgument Command Line Argument}.
     * 
     * @return <b>true</b> if this {@link IOption} has a {@link CommandLineArgument Command Line Argument}; <b>false</b>
     *         otherwise
     */
    public boolean hasArgument();

}
