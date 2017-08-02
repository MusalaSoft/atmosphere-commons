package com.musala.atmosphere.commons.ui.selector.attribute;

import com.musala.atmosphere.commons.ui.selector.CssAttribute;
import com.musala.atmosphere.commons.ui.selector.UiElementSelectionOption;

/**
 * Helper class which wraps the {@link CssAttribute}, its value and {@link UiElementSelectionOption},
 * to make them easier to create and manage.
 *
 */
public abstract class SelectionAttribute {
    private CssAttribute cssAttribute;
    private UiElementSelectionOption selectionOption;
    private Object attributeValue;

    protected SelectionAttribute(CssAttribute cssAttribute, Object attributeValue) {
        this(cssAttribute, UiElementSelectionOption.EQUALS, attributeValue);
    }

    protected SelectionAttribute(CssAttribute cssAttribute, UiElementSelectionOption selectionOption, Object attributeValue) {
        this.cssAttribute = cssAttribute;
        this.selectionOption = selectionOption;
        this.attributeValue = attributeValue;
    }

    public CssAttribute getCssAttribute() {
        return cssAttribute;
    }

    public void setCssAttribute(CssAttribute cssAttribute) {
        this.cssAttribute = cssAttribute;
    }

    public UiElementSelectionOption getSelectionOption() {
        return selectionOption;
    }

    public void setSelectionOption(UiElementSelectionOption selectionOption) {
        this.selectionOption = selectionOption;
    }

    public Object getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(Object attributeValue) {
        this.attributeValue = attributeValue;
    }
}
