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
 * Enumeration indicating the current data connection state (cellular).
 * 
 * @author yordan.petrov
 * 
 */
public enum DataState {
    /*
     * Data connection state: Connected.
     */
    DATA_CONNECTED(0),

    /*
     * Data connection state: Currently setting up a data connection.
     */
    DATA_CONNECTING(1),

    /*
     * Data connection state: Disconnected.
     */
    DATA_DISCONNECTED(2),

    /*
     * Data connection state: Suspended.
     */
    DATA_SUSPENDED(3);

    private int dataStateId;

    private DataState(int dataStateId) {
        this.dataStateId = dataStateId;
    }

    public int getId() {
        return dataStateId;
    }

    public static DataState getById(int id) {
        DataState typeById = null;
        for (DataState currentState : DataState.values()) {
            if (currentState.getId() == id) {
                typeById = currentState;
                break;
            }
        }

        return typeById;
    }
}
