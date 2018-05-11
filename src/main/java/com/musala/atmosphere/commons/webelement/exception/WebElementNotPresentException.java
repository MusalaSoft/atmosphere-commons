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

package com.musala.atmosphere.commons.webelement.exception;

import com.musala.atmosphere.commons.webelement.selection.WebElementSelectionCriterion;

/**
 * Thrown when a web element can not be found for a given {@link WebElementSelectionCriterion selection criterion}.
 * 
 * @author filareta.yordanova
 *
 */
public class WebElementNotPresentException extends RuntimeException {
    private static final long serialVersionUID = -8408534617750696373L;

    /**
     * Creates new {@link WebElementNotPresentException WebElementNotPresentException}.
     */
    public WebElementNotPresentException() {
        super();
    }

    /**
     * Creates new {@link WebElementNotPresentException WebElementNotPresentException} with the given message.
     * 
     * @param message
     *        - message representing the error that occurred
     */
    public WebElementNotPresentException(String message) {
        super(message);
    }

    /**
     * Creates new {@link WebElementNotPresentException WebElementNotPresentException} with the given message and the
     * {@link Throwable cause} for the exception.
     * 
     * @param message
     *        - message representing the error that occurred
     * @param cause
     *        - the cause for the exception
     */
    public WebElementNotPresentException(String message, Throwable cause) {
        super(message, cause);
    }
}
