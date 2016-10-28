package com.musala.atmosphere.commons.ui.tree.matcher;

import android.view.accessibility.AccessibilityNodeInfo;

/**
 * Interface that provides method for comparing {@link AccessibilityNodeInfo accessibility node information} with object
 * from a generic type T.
 * 
 * @author filareta.yordanova
 * 
 * @param <T>
 *        - type of the object compared to {@link AccessibilityNodeInfo accessibility node information}
 */
public interface UiElementMatcher<T> {
    /**
     * Compares {@link AccessibilityNodeInfo accessibility node information} to the given object from generic type
     * <code>T</code>.
     * 
     * @param selector
     *        - object from generic type <code>T</code> used for matching the {@link AccessibilityNodeInfo accessibility
     *        node information}
     * @param nodeInformation
     *        - {@link AccessibilityNodeInfo accessibility node information} instance
     * @return <code>true</code> if the {@link AccessibilityNodeInfo node} matches the given object from type
     *         <code>T</code>, <code>false</code> otherwise
     */
    boolean match(T selector, AccessibilityNodeInfo nodeInformation);
}
