package com.musala.atmosphere.commons.ui.selector.attribute;

import com.musala.atmosphere.commons.ui.selector.CssAttribute;
import com.musala.atmosphere.commons.ui.selector.UiElementSelectionOption;

/**
 * Helper class to make a {@link CssAttribute#CONTENT_DESCRIPTION} and value pair easier to create and manage.
 *
 */
public class ContentDescriptionAttribute extends SelectionAttribute {
    public ContentDescriptionAttribute(String contentDescription) {
        super(CssAttribute.CONTENT_DESCRIPTION, contentDescription);
    }

    public ContentDescriptionAttribute(String contentDescription, UiElementSelectionOption selectionOption) {
        super(CssAttribute.CONTENT_DESCRIPTION, selectionOption, contentDescription);
    }
}
