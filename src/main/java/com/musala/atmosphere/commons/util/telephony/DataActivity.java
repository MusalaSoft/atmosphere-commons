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
 * Enumeration indicating the type of activity on a data connection (cellular).
 * 
 * @author yordan.petrov
 * 
 */
public enum DataActivity {
    /*
     * Data connection is active, but physical link is down
     */
    DATA_ACTIVITY_DORMANT(0),

    /*
     * Data connection activity: Currently receiving IP PPP traffic.
     */
    DATA_ACTIVITY_IN(1),

    /*
     * Data connection activity: Currently both sending and receiving IP PPP traffic.
     */
    DATA_ACTIVITY_INOUT(2),

    /*
     * Data connection activity: No traffic.
     */
    DATA_ACTIVITY_NONE(3),

    /*
     * Data connection activity: Currently sending IP PPP traffic.
     */
    DATA_ACTIVITY_OUT(4);

    private int dataActivityId;

    private DataActivity(int dataActivityId) {
        this.dataActivityId = dataActivityId;
    }

    public int getId() {
        return dataActivityId;
    }

    public static DataActivity getById(int id) {
        DataActivity typeById = null;
        for (DataActivity currentState : DataActivity.values()) {
            if (currentState.getId() == id) {
                typeById = currentState;
                break;
            }
        }

        return typeById;
    }
}
