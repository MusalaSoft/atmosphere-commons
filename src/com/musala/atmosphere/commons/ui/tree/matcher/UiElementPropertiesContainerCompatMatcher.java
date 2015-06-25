package com.musala.atmosphere.commons.ui.tree.matcher;

import android.view.accessibility.AccessibilityNodeInfo;

import com.musala.atmosphere.commons.ui.UiElementPropertiesContainer;

/**
 * Extends {@link UiElementPropertiesContainerMatcher} match function by adding ResourceId field to the matching
 * dependencies, that is added after Android API Level 18.
 * 
 * @author denis.bialev
 *
 */
public class UiElementPropertiesContainerCompatMatcher extends UiElementPropertiesContainerMatcher {

    @Override
    public boolean match(UiElementPropertiesContainer propertiesContainer, AccessibilityNodeInfo nodeInformation) {

        if (propertiesContainer.getResourceId() != null
                && !propertiesContainer.getResourceId().equals(nodeInformation.getViewIdResourceName())) {
            return false;
        }

        return super.match(propertiesContainer, nodeInformation);
    }
}
