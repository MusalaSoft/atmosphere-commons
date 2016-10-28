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
