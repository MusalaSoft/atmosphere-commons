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

package com.musala.atmosphere.commons.gesture;

import java.io.Serializable;

/**
 * This class describes an anchor point's coordinates and the time when it should be reached. Used to describe a finger
 * gesture (by using a {@link Timeline Timeline} collection).
 * 
 * @author georgi.gaydarov
 * 
 */
public class Anchor implements Serializable {
    private static final long serialVersionUID = -6965038093837682224L;

    private float x;

    private float y;

    private int timeAfterStart;

    /**
     * Constructs an anchor point.
     * 
     * @param x
     *        - the X anchor position.
     * @param y
     *        - the Y anchor position.
     * @param timeAfterStart
     *        - the point in time when the current anchor point should be reached.
     */
    public Anchor(float x, float y, int timeAfterStart) {
        this.x = x;
        this.y = y;
        this.timeAfterStart = timeAfterStart;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getTimeAfterStart() {
        return timeAfterStart;
    }

    public void setTimeAfterStart(int timeAfterStart) {
        this.timeAfterStart = timeAfterStart;
    }
}
