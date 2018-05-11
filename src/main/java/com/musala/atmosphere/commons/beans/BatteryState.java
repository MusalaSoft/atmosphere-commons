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
 * Enumerates all possible states of the battery - unknown, charging, discharging, not charging and full
 * 
 * @author vladimir.vladimirov
 * 
 */

public enum BatteryState implements CommandParameter, Serializable {
    UNKNOWN("unknown", 1),
    CHARGING("charging", 2),
    DISCHARGING("discharging", 3),
    NOT_CHARGING("not_charging", 4),
    FULL("full", 5);

    private static final String EMULATOR_NOT_CHARGING_STATE_VALUE = "not-charging";

    private String batteryStateValue;

    private int batteryStateNumberValue;

    private BatteryState(String deviceBatteryState, int stateNumber) {
        this.batteryStateValue = deviceBatteryState;
        this.batteryStateNumberValue = stateNumber;
    }

    @Override
    public String toString() {
        return batteryStateValue;
    }

    public int getStateId() {
        return batteryStateNumberValue;
    }

    public static BatteryState getStateById(int stateId) {
        BatteryState stateToReturn = null;
        for (BatteryState state : BatteryState.values()) {
            if (state.getStateId() == stateId) {
                stateToReturn = state;
                break;
            }
        }
        return stateToReturn;
    }

    @Override
    public String getParameterValue(boolean forEmulator) {
        if (this == NOT_CHARGING && forEmulator) {
            // NOT_CHARGING battery state string in emulator console differs from that for real devices
            return EMULATOR_NOT_CHARGING_STATE_VALUE;
        }
        return batteryStateValue;
    }
}
