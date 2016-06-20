package com.musala.atmosphere.commons.parameters;

/**
 * A parameter wrapper for string command parameters.
 * 
 * @author boris.strandjev
 */
public class StringCommandParameter implements CommandParameter {
    private String parameterValue;

    public StringCommandParameter(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    @Override
    public String getParameterValue(boolean forEmulator) {
        return parameterValue;
    }
}
