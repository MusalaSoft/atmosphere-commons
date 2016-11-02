package com.musala.atmosphere.commons.ui.tree.matcher;

import com.musala.atmosphere.commons.ui.UiElementPropertiesContainer;

import android.view.accessibility.AccessibilityNodeInfo;

/**
 * Concrete {@link UiElementMatcher matcher} that extends {@link UiElementPropertiesContainerMatcherCompat} match
 * function by adding resource Id field to the matching dependencies, that is added after <b>Android API Level 18</b>.
 * <br>
 * For API 17 use {@link UiElementPropertiesContainerMatcherCompat}.
 *
 * @author denis.bialev
 *
 */
public class UiElementPropertiesContainerMatcherImpl extends UiElementPropertiesContainerMatcherCompat {
    @Override
    public boolean match(UiElementPropertiesContainer propertiesContainer, AccessibilityNodeInfo nodeInformation) {

        if (propertiesContainer.getResourceId() != null
                && !propertiesContainer.getResourceId().equals(nodeInformation.getViewIdResourceName())) {
            return false;
        }

        return super.match(propertiesContainer, nodeInformation);
    }
}
