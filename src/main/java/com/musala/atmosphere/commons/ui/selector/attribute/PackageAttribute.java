package com.musala.atmosphere.commons.ui.selector.attribute;

import com.musala.atmosphere.commons.ui.selector.CssAttribute;

/**
 * Helper class to make a {@link CssAttribute#PACKAGE_NAME} and value pair easier to create and manage.
 *
 */
public class PackageAttribute extends SelectionAttribute {
    public PackageAttribute(String packageName) {
        super(CssAttribute.PACKAGE_NAME, packageName);
    }
}
