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

/**
 * Enumerates all possible element swipe directions.
 * 
 * @author georgi.gaydarov
 * 
 */
public enum SwipeDirection implements Serializable {
    DOWN(0),
    UP(1),
    LEFT(2),
    RIGHT(3);

    private byte directionId;

    private SwipeDirection(int directionNumber) {
        this.directionId = (byte) directionNumber;
    }

    @Override
    public String toString() {
        return ((Byte) directionId).toString();
    }

    public int getDirectionId() {
        return directionId;
    }

    public static SwipeDirection getDirectionById(int directionId) {
        SwipeDirection directionToReturn = null;
        for (SwipeDirection direction : SwipeDirection.values()) {
            if (direction.getDirectionId() == directionId) {
                directionToReturn = direction;
                break;
            }
        }
        return directionToReturn;
    }
}
