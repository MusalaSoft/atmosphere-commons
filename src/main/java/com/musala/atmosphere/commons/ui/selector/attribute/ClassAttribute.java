package com.musala.atmosphere.commons.ui.selector.attribute;

import com.musala.atmosphere.commons.ui.selector.CssAttribute;

/**
 * Helper class to make a {@link CssAttribute#CLASS_NAME} and value pair easier to create and manage.
 *
 */
public class ClassAttribute extends SelectionAttribute {
    public ClassAttribute(String className) {
        super(CssAttribute.CLASS_NAME, className);
    }
}
