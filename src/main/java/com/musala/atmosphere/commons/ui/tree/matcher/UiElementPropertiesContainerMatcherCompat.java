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

package com.musala.atmosphere.commons.ui.tree.matcher;

import com.musala.atmosphere.commons.geometry.Bounds;
import com.musala.atmosphere.commons.geometry.Point;
import com.musala.atmosphere.commons.ui.UiElementPropertiesContainer;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * Concrete {@link UiElementMatcher matcher} that determines whether a match between {@link AccessibilityNodeInfo
 * accessibility node information} and element from type {@link UiElementPropertiesContainer
 * UiElementPropertiesContainer} exists.<br>
 * <b>Note:</b> intended <b>only for API 17</b>. For API 18 use {@link UiElementPropertiesContainerMatcherImpl}.
 *
 * @author filareta.yordanova
 *
 */
public class UiElementPropertiesContainerMatcherCompat implements UiElementMatcher<UiElementPropertiesContainer> {
    @Override
    public boolean match(UiElementPropertiesContainer propertiesContainer, AccessibilityNodeInfo nodeInformation) {
        // TODO Improve the logic for matching components
        Rect accessibilityNodeBounds = new Rect();
        nodeInformation.getBoundsInScreen(accessibilityNodeBounds);
        Bounds propertiesContainerBounds = propertiesContainer.getBounds();

        if (propertiesContainer.getBounds() != null) {
            Point selectorBoundsUpperCorner = propertiesContainerBounds.getUpperLeftCorner();

            if ((accessibilityNodeBounds.height() != propertiesContainerBounds.getHeight())
                    || (accessibilityNodeBounds.width() != propertiesContainerBounds.getWidth())
                    || (selectorBoundsUpperCorner.getX() != accessibilityNodeBounds.left)
                    || (selectorBoundsUpperCorner.getY() != accessibilityNodeBounds.top)) {
                return false;
            }
        }

        if (propertiesContainer.getClassName() != null && nodeInformation.getClassName() != null
                && !propertiesContainer.getClassName().equals(nodeInformation.getClassName().toString())) {
            return false;
        }

        if (propertiesContainer.getPackageName() != null && nodeInformation.getPackageName() != null
                && !propertiesContainer.getPackageName().equals(nodeInformation.getPackageName().toString())) {
            return false;
        }

        String nodeContentDescription = nodeInformation.getContentDescription() != null
                ? nodeInformation.getContentDescription().toString() : null;
        if (propertiesContainer.getContentDescriptor() != null
                && !propertiesContainer.getContentDescriptor().equals(nodeContentDescription)) {
            return false;
        }

        String nodeText = nodeInformation.getText() != null ? nodeInformation.getText().toString() : null;
        if (propertiesContainer.getText() != null && !propertiesContainer.getText().equals(nodeText)) {
            return false;
        }

        return propertiesContainer.isCheckable() == nodeInformation.isCheckable()
                && propertiesContainer.isChecked() == nodeInformation.isChecked()
                && propertiesContainer.isClickable() == nodeInformation.isClickable()
                && propertiesContainer.isEnabled() == nodeInformation.isEnabled()
                && propertiesContainer.isFocusable() == nodeInformation.isFocusable()
                && propertiesContainer.isFocused() == nodeInformation.isFocused()
                && propertiesContainer.isLongClickable() == nodeInformation.isLongClickable()
                && propertiesContainer.isPassword() == nodeInformation.isPassword()
                && propertiesContainer.isScrollable() == nodeInformation.isScrollable()
                && propertiesContainer.isSelected() == nodeInformation.isSelected();
    }
}
