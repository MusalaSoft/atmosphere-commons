package com.musala.atmosphere.commons.parameters;

/**
 * A parameter wrapper for int command parameters.
 * 
 * @author boris.strandjev
 */
public class IntegerCommandParameter implements CommandParameter {
    private int parameterValue;

    public IntegerCommandParameter(int parameterValue) {
        this.parameterValue = parameterValue;
    }

    @Override
    public String getParameterValue(boolean forEmulator) {
        return String.valueOf(parameterValue);
    }
}
