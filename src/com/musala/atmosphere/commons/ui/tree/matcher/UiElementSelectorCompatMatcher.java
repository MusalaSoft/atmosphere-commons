package com.musala.atmosphere.commons.ui.tree.matcher;

import android.view.accessibility.AccessibilityNodeInfo;

import com.musala.atmosphere.commons.ui.selector.CssAttribute;
import com.musala.atmosphere.commons.ui.selector.UiElementSelector;

/**
 * Extends {@link UiElementSelectorMatcher} match function by adding ResourceId field to the matching dependencies, that
 * is added after Android API Level 18.
 * 
 * @author denis.bialev
 *
 */
public class UiElementSelectorCompatMatcher extends UiElementSelectorMatcher {

    @Override
    public boolean match(UiElementSelector selector, AccessibilityNodeInfo nodeInformation) {
        String selectorResourceId = selector.getStringValue(CssAttribute.RESOURCE_ID);

        if (selectorResourceId != null && !selectorResourceId.equals(nodeInformation.getViewIdResourceName())) {
            return false;
        }

        return super.match(selector, nodeInformation);
    }
}
