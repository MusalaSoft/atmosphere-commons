package com.musala.atmosphere.commons.ui;

import java.io.Serializable;

import com.musala.atmosphere.commons.geometry.Bounds;

/**
 * Defines {@link Serializable} wrapper around the <a
 * href="http://developer.android.com/reference/android/view/accessibility/AccessibilityNodeInfo.html"
 * >AccessibilityNodeInfo</a>'s UI attributes.
 * 
 * @author vassil.angelov
 *
 */
public interface UiElementPropertiesContainer extends Serializable {
    int getIndex();

    String getText();

    boolean isClickable();

    boolean isScrollable();

    boolean isLongClickable();

    boolean isSelected();

    boolean isPassword();

    Bounds getBounds();

    String getClassName();

    String getPackageName();

    public String getContentDescriptor();

    boolean isCheckable();

    boolean isChecked();

    boolean isFocusable();

    boolean isFocused();

    boolean isEnabled();

}