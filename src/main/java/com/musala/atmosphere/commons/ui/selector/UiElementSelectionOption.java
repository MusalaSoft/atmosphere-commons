package com.musala.atmosphere.commons.ui.selector;

import com.musala.atmosphere.commons.geometry.Bounds;
import com.musala.atmosphere.commons.geometry.Point;

/**
 * A class defining the different options for selection of attributes in {@link UiElementSelector}
 * 
 * @author boris.strandjev
 */
public enum UiElementSelectionOption {
    /** This option matches the expression verbatim */
    EQUALS("[%s=%s]"),
    /** This option matches the expression as regular expression */
    WORD_MATCH("[%s~=%s]"),
    /** This option matches anything that contains the expression */
    CONTAINS("[%s*=%s]");

    /** The string format to use for {@link Bounds} serialization. */
    private static final String BOUNDS_FORMAT = "[%d,%d][%d,%d]";

    /** The string to use for the selection. */
    private String queryString;

    private UiElementSelectionOption(String queryString) {
        this.queryString = queryString;
    }

    public String constructAttributeSelector(CssAttribute attribute, Object propertyValue) {
        String propertyStringValue;
        if (propertyValue instanceof Bounds) {
            Bounds bounds = (Bounds) propertyValue;
            Point firstBound = bounds.getUpperLeftCorner();
            Point secondBound = bounds.getLowerRightCorner();
            propertyStringValue = String.format(BOUNDS_FORMAT,
                                                firstBound.getX(),
                                                firstBound.getY(),
                                                secondBound.getX(),
                                                secondBound.getY());
        } else {
            propertyStringValue = propertyValue.toString();
        }

        return String.format(queryString, attribute.getHtmlAttributeName(), propertyStringValue);
    }
}
