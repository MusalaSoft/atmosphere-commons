package com.musala.atmosphere.commons.ui.tree.matcher;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

import com.musala.atmosphere.commons.geometry.Bounds;
import com.musala.atmosphere.commons.geometry.Point;
import com.musala.atmosphere.commons.ui.UiElementPropertiesContainer;

/**
 * Concrete {@link UiElementMatcher matcher} that determines whether a match between {@link AccessibilityNodeInfo
 * accessibility node information} and element from type {@link UiElementPropertiesContainer
 * UiElementPropertiesContainer} exists.
 * 
 * @author filareta.yordanova
 *
 */
public class UiElementPropertiesContainerMatcher implements UiElementMatcher<UiElementPropertiesContainer> {

    @Override
    public boolean match(UiElementPropertiesContainer propertiesContainer, AccessibilityNodeInfo nodeInformation) {
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

        String nodeContentDescription = nodeInformation.getContentDescription() != null ? nodeInformation.getContentDescription()
                                                                                                         .toString()
                : null;
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
