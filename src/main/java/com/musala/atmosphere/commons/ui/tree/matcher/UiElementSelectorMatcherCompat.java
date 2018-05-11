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
import com.musala.atmosphere.commons.ui.selector.CssAttribute;
import com.musala.atmosphere.commons.ui.selector.UiElementSelectionOption;
import com.musala.atmosphere.commons.ui.selector.UiElementSelector;
import com.musala.atmosphere.commons.util.Pair;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * Concrete {@link UiElementMatcher matcher} that determines whether a match between {@link AccessibilityNodeInfo
 * accessibility node information} and {@link UiElementSelector UI element selector} exists.<br>
 * <b>Note:</b> This implementation is intended <b>only for API 17</b>. For API 18 and above use
 * {@link UiElementSelectorMatcherImpl}.
 *
 * @author filareta.yordanova
 *
 */
public class UiElementSelectorMatcherCompat implements UiElementMatcher<UiElementSelector> {
    @Override
    public boolean match(UiElementSelector selector, AccessibilityNodeInfo nodeInformation) {
        // TODO Improve the logic for matching components
        Bounds selectorBounds = selector.getBoundsValue(CssAttribute.BOUNDS);
        Pair<String, UiElementSelectionOption> selectorClass = selector.getStringValueWithSelectionOption(CssAttribute.CLASS_NAME);
        Pair<String, UiElementSelectionOption> selectorPackage = selector.getStringValueWithSelectionOption(CssAttribute.PACKAGE_NAME);
        Pair<String, UiElementSelectionOption> selectorText = selector.getStringValueWithSelectionOption(CssAttribute.TEXT);
        Pair<String, UiElementSelectionOption> selectorDescription = selector.getStringValueWithSelectionOption(CssAttribute.CONTENT_DESCRIPTION);
        Boolean isClickable = selector.getBooleanValue(CssAttribute.CLICKABLE);
        Boolean isCheckable = selector.getBooleanValue(CssAttribute.CHECKABLE);
        Boolean isChecked = selector.getBooleanValue(CssAttribute.CHECKED);
        Boolean isEnabled = selector.getBooleanValue(CssAttribute.ENABLED);
        Boolean isFocusable = selector.getBooleanValue(CssAttribute.FOCUSABLE);
        Boolean isFocused = selector.getBooleanValue(CssAttribute.FOCUSED);
        Boolean isLongClickable = selector.getBooleanValue(CssAttribute.LONG_CLICKABLE);
        Boolean isPassword = selector.getBooleanValue(CssAttribute.PASSWORD);
        Boolean isScrollable = selector.getBooleanValue(CssAttribute.SCROLLABLE);
        Boolean isSelected = selector.getBooleanValue(CssAttribute.SELECTED);

        Rect nodeBounds = new Rect();
        nodeInformation.getBoundsInScreen(nodeBounds);

        if (selectorBounds != null) {
            Point selectorBoundsUpperCorner = selectorBounds.getUpperLeftCorner();

            if ((nodeBounds.height() != selectorBounds.getHeight()) || (nodeBounds.width() != selectorBounds.getWidth())
                    || (selectorBoundsUpperCorner.getX() != nodeBounds.left)
                    || (selectorBoundsUpperCorner.getY() != nodeBounds.top)) {
                return false;
            }
        }

        String nodeClassName = nodeInformation.getClassName() != null
                ? nodeInformation.getClassName().toString() : null;
        if (selectorClass != null && nodeClassName != null && !isMatch(selectorClass, nodeClassName)) {
            return false;
        }

        String nodePackageName = nodeInformation.getPackageName() != null
                ? nodeInformation.getPackageName().toString() : null;
        if (selectorPackage != null && nodePackageName != null && !isMatch(selectorPackage, nodePackageName)) {
            return false;
        }

        String nodeContentDescription = nodeInformation.getContentDescription() != null
                ? nodeInformation.getContentDescription().toString() : null;
        if (selectorDescription != null && !isMatch(selectorDescription, nodeContentDescription)) {
            return false;
        }


        String nodeText = nodeInformation.getText() != null ? nodeInformation.getText().toString() : null;
        if (selectorText != null && !isMatch(selectorText, nodeText)) {
            return false;
        }

        if (isCheckable != null && isCheckable.booleanValue() != nodeInformation.isCheckable()) {
            return false;
        }

        if (isChecked != null && isChecked.booleanValue() != nodeInformation.isChecked()) {
            return false;
        }

        if (isClickable != null && isClickable.booleanValue() != nodeInformation.isClickable()) {
            return false;
        }

        if (isEnabled != null && isEnabled.booleanValue() != nodeInformation.isEnabled()) {
            return false;
        }

        if (isFocusable != null && isFocusable.booleanValue() != nodeInformation.isFocusable()) {
            return false;
        }

        if (isFocused != null && isFocused.booleanValue() != nodeInformation.isFocused()) {
            return false;
        }

        if (isLongClickable != null && isLongClickable.booleanValue() != nodeInformation.isLongClickable()) {
            return false;
        }

        if (isPassword != null && isPassword.booleanValue() != nodeInformation.isPassword()) {
            return false;
        }

        if (isScrollable != null && isScrollable.booleanValue() != nodeInformation.isScrollable()) {
            return false;
        }

        if (isSelected != null && isSelected.booleanValue() != nodeInformation.isSelected()) {
            return false;
        }

        return true;
    }

    private boolean isMatch(Pair<String, UiElementSelectionOption> selectorPair, String nodeValue) {
        if (nodeValue == null) {
            return false;
        }
        switch (selectorPair.getValue()) {
            case CONTAINS:
                return nodeValue.contains(selectorPair.getKey());
            case EQUALS:
                return nodeValue.equals(selectorPair.getKey());
            case WORD_MATCH:
                return nodeValue.matches(selectorPair.getKey());
            default:
                return nodeValue.equals(selectorPair.getKey());
        }
    }
}
