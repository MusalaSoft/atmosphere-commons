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

package com.musala.atmosphere.commons.ui;

import java.io.Serializable;

import com.musala.atmosphere.commons.geometry.Bounds;

/**
 * Defines {@link Serializable} wrapper around the
 * <a href="http://developer.android.com/reference/android/view/accessibility/AccessibilityNodeInfo.html" >
 * AccessibilityNodeInfo</a>'s UI attributes.
 * 
 * @author vassil.angelov
 *
 */
public interface UiElementPropertiesContainer extends Serializable {
    Integer getIndex();

    String getText();

    Boolean isClickable();

    Boolean isScrollable();

    Boolean isLongClickable();

    Boolean isSelected();

    Boolean isPassword();

    Bounds getBounds();

    String getClassName();

    String getPackageName();

    String getContentDescriptor();

    Boolean isCheckable();

    Boolean isChecked();

    Boolean isFocusable();

    Boolean isFocused();

    Boolean isEnabled();

    String getResourceId();
}
