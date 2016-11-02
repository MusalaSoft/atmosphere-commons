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
