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
