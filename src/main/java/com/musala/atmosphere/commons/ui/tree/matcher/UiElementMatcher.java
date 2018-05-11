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
