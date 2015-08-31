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
     * @param throwable
     *        - the cause for the exception
     */
    public WebElementNotPresentException(String message, Throwable cause) {
        super(message, cause);
    }
}
