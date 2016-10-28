package com.musala.atmosphere.commons.beans;

import java.io.Serializable;

import com.musala.atmosphere.commons.parameters.CommandParameter;

/**
 * A class that represents the battery level command parameter.
 * 
 * @author boris.strandjev
 */
public class BatteryLevel implements CommandParameter, Serializable {
    private int level;

    /**
     * Constructs a bean that represents a battery capacity level.
     * 
     * @param level
     *        - the desired new battery level. This parameter should be between 0 and 100 inclusive, all other values
     *        will result in a {@link IllegalArgumentException} being thrown.
     */
    public BatteryLevel(int level) {
        verifyLevel();
        this.level = level;
    }

    private void verifyLevel() {
        if (level < 0 || level > 100) {
            throw new IllegalArgumentException("Battery level should be in the range [0, 100].");
        }
    }

    @Override
    public String getParameterValue(boolean forEmulator) {
        return String.valueOf(level);
    }

    public int getLevel() {
        return level;
    }
}
