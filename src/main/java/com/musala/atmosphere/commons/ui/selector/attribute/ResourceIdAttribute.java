package com.musala.atmosphere.commons.ui.selector.attribute;

import com.musala.atmosphere.commons.ui.selector.CssAttribute;

/**
 * Helper class to make a {@link CssAttribute#RESOURCE_ID} and value pair easier to create and manage.
 *
 */
public class ResourceIdAttribute extends SelectionAttribute {
    public ResourceIdAttribute(CssAttribute cssAttribute, Object attributeValue) {
        super(cssAttribute, attributeValue);
    }
}
