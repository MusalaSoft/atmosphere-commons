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

package com.musala.atmosphere.commons.util.telephony;

/**
 * Enumeration indicating the call state (cellular) on a device.
 * 
 * @author yordan.petrov
 * 
 */
public enum CallState {
    /*
     * Device call state: No activity.
     */
    CALL_STATE_IDLE(0),

    /*
     * Device call state: Off-hook.
     */
    CALL_STATE_OFFHOOK(1),

    /*
     * Device call state: Ringing.
     */
    CALL_STATE_RINGING(2);

    private int callStateId;

    private CallState(int callStateId) {
        this.callStateId = callStateId;
    }

    public int getId() {
        return callStateId;
    }

    public static CallState getById(int id) {
        CallState typeById = null;
        for (CallState currentState : CallState.values()) {
            if (currentState.getId() == id) {
                typeById = currentState;
                break;
            }
        }

        return typeById;
    }
}
