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