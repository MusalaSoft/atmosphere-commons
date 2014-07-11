package com.musala.atmosphere.commons;

import java.io.Serializable;

/**
 * An enumeration of all the action performed on Android picker widgets.
 * 
 * @author delyan.dimitrov
 * 
 */
public enum PickerAction implements Serializable {
    /**
     * Sets the value of a date picker currently on screen.
     */
    SET_DATE,
    /**
     * Gets the value of a time picker currently on screen.
     */
    GET_TIME;
}
