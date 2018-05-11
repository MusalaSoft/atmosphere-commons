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
