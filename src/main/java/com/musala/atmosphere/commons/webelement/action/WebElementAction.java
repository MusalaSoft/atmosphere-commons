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

package com.musala.atmosphere.commons.webelement.action;

/**
 * Enum containing the actions that can be executed on a WebElement.
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
    /** Checks if the current UiWebElement is selected. */
    IS_SELECTED,
    /** Checks if the current UiWebElement is displayed. */
    IS_DISPLAYED,
    /** Gets the value of the given CSS property of the current UiWebElement. */
    GET_CSS_PROPERTY,
    /** Gets the tag name of the current UiWebElement. */
    GET_TAG_NAME,
    /** Gets the text value of the current UiWebElement. */
    GET_TEXT,
    /** Focuses a web element selected by given criteria. */
    FOCUS;
}
