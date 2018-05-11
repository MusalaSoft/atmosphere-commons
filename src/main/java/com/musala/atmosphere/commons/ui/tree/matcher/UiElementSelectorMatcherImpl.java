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

import com.musala.atmosphere.commons.ui.selector.CssAttribute;
import com.musala.atmosphere.commons.ui.selector.UiElementSelector;

import android.view.accessibility.AccessibilityNodeInfo;

/**
 * Concrete {@link UiElementMatcher matcher} that extends {@link UiElementSelectorMatcherCompat} match function by
 * adding ResourceId field to the matching dependencies, that is added after <b>Android API Level 18</b>.<br>
 * For API 17 use {@link UiElementSelectorMatcherCompat}.
 *
 * @author denis.bialev
 *
 */
public class UiElementSelectorMatcherImpl extends UiElementSelectorMatcherCompat {
    @Override
    public boolean match(UiElementSelector selector, AccessibilityNodeInfo nodeInformation) {
        String selectorResourceId = selector.getStringValue(CssAttribute.RESOURCE_ID);

        if (selectorResourceId != null && !selectorResourceId.equals(nodeInformation.getViewIdResourceName())) {
            return false;
        }

        return super.match(selector, nodeInformation);
    }
}
