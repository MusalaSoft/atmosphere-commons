package com.musala.atmosphere.commons.webelement.actions;

/**
 * Enum containing the actions that can be executed on a {@link WebElement}.
 * 
 * @author yavor.stankov
 *
 */
public enum WebElementActions {
    /** Performs a tap action on a web element selected by given criteria. */
    TAP,
    /** Gets the position of a web element selected by given criteria. */
    GET_POSITION,
    /** Gets the size of a web element selected by given criteria. */
    GET_SIZE,
    /** Gets the values of the attributes of a web element. */
    GET_ATTRIBUTES;
}
