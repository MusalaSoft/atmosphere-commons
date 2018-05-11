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
