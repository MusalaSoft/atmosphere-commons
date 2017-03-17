package com.musala.atmosphere.commons.ui.selector.attribute;

import com.musala.atmosphere.commons.ui.selector.CssAttribute;
import com.musala.atmosphere.commons.ui.selector.UiElementSelectionOption;

/**
 * Helper class to make a {@link CssAttribute#TEXT} and value pair easier to create and manage.
 *
 */
public class TextAttribute extends SelectionAttribute {
    public TextAttribute(String text) {
        super(CssAttribute.TEXT, text);
    }

    public TextAttribute(String text, UiElementSelectionOption selectionOption) {
        super(CssAttribute.TEXT, selectionOption, text);
    }
}
