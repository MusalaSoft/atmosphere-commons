package com.musala.atmosphere.commons.webelement.action;

/**
 * Enum containing the actions that can be executed on a {@link WebElement}.
 * 
 * @author yavor.stankov
 *
 */
public enum WebElementAction {
    /** Performs a tap action on a web element selected by given criteria. */
    TAP,
    /** Gets the position of a web element selected by given criteria. */
    GET_POSITION,
    /** Gets the size of a web element selected by given criteria. */
    GET_SIZE,
    /** Gets the values of the attributes of a web element. */
    GET_ATTRIBUTES,
    /** Checks if the current {@link UiWebElement} is selected. */
    IS_SELECTED,
    /** Checks if the current {@link UiWebElement} is displayed. */
    IS_DISPLAYED,
    /** Gets the value of the given CSS property of the current {@link UiWebElement}. */
    GET_CSS_PROPERTY,
    /** Gets the tag name of the current {@link UiWebElement}. */
    GET_TAG_NAME,
    /** Gets the text value of the current {@link UiWebElement}. */
    GET_TEXT,
    /** Focuses a web element selected by given criteria. */
    FOCUS,
    /** Submits the selected form. */
    SUBMIT_FORM;

}
