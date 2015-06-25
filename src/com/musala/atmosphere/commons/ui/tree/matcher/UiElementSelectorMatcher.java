package com.musala.atmosphere.commons.ui.tree.matcher;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

import com.musala.atmosphere.commons.geometry.Bounds;
import com.musala.atmosphere.commons.geometry.Point;
import com.musala.atmosphere.commons.ui.selector.CssAttribute;
import com.musala.atmosphere.commons.ui.selector.UiElementSelector;

/**
 * Concrete {@link UiElementMatcher matcher} that determines whether a match between {@link AccessibilityNodeInfo
 * accessibility node information} and {@link UiElementSelector UI element selector} exists.
 * 
 * @author filareta.yordanova
 * 
 */
public class UiElementSelectorMatcher implements UiElementMatcher<UiElementSelector> {

    @Override
    public boolean match(UiElementSelector selector, AccessibilityNodeInfo nodeInformation) {
        // TODO Improve the logic for matching components
        Bounds selectorBounds = selector.getBoundsValue(CssAttribute.BOUNDS);
        String selectorClass = selector.getStringValue(CssAttribute.CLASS_NAME);
        String selectorPackage = selector.getStringValue(CssAttribute.PACKAGE_NAME);
        String selectorText = selector.getStringValue(CssAttribute.TEXT);
        String selectorDescription = selector.getStringValue(CssAttribute.CONTENT_DESCRIPTION);
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

            if ((nodeBounds.height() != selectorBounds.getHeight())
                    || (nodeBounds.width() != selectorBounds.getWidth())
                    || (selectorBoundsUpperCorner.getX() != nodeBounds.left)
                    || (selectorBoundsUpperCorner.getY() != nodeBounds.top)) {
                return false;
            }
        }

        if (selectorClass != null && nodeInformation.getClassName() != null
                && !selectorClass.equals(nodeInformation.getClassName().toString())) {
            return false;
        }

        if (selectorPackage != null && nodeInformation.getPackageName() != null
                && !selectorPackage.equals(nodeInformation.getPackageName().toString())) {
            return false;
        }

        String nodeContentDescription = nodeInformation.getContentDescription() != null ? nodeInformation.getContentDescription()
                                                                                                         .toString()
                : null;
        if (selectorDescription != null && !selectorDescription.equals(nodeContentDescription)) {
            return false;
        }

        String nodeText = nodeInformation.getText() != null ? nodeInformation.getText().toString() : null;
        if (selectorText != null && !selectorText.equals(nodeText)) {
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
}
