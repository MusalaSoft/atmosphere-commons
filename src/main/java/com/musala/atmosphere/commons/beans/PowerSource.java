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
 * Enumerator for device power supply source. Values used are as seen on <a
 * href="http://developer.android.com/reference/android/os/BatteryManager.html">Android Developer BatteryManager
 * documentation.</a>
 * 
 * @author georgi.gaydarov
 * 
 */
public enum PowerSource implements CommandParameter, Serializable {
    /**
     * Device is unplugged.
     */
    UNPLUGGED(0),
    /**
     * Power source is an AC charger.
     */
    PLUGGED_AC(1),
    /**
     * Power source is a USB port.<br>
     * <b>Note</b> : For emulators, this option is interpreted as {@link #PLUGGED_AC}.
     */
    PLUGGED_USB(2),
    /**
     * Power source is wireless.<br>
     * <b>Note</b> : For emulators, this option is interpreted as {@link #PLUGGED_AC}.
     */
    PLUGGED_WIRELESS(4);

    private int stateId;

    private PowerSource(int stateId) {
        this.stateId = stateId;
    }

    public int getStateId() {
        return stateId;
    }

    public static PowerSource getStateById(int stateId) {
        PowerSource stateToReturn = null;
        for (PowerSource state : PowerSource.values()) {
            if (state.getStateId() == stateId) {
                stateToReturn = state;
                break;
            }
        }
        return stateToReturn;
    }

    @Override
    public String getParameterValue(boolean forEmulator) {
        if (forEmulator) {
            return (this == UNPLUGGED ? "off" : "on");
        }
        return toString();
    }
}
