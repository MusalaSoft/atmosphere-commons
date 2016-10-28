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
