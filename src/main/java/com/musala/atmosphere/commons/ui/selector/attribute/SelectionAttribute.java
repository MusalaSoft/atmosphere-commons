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
