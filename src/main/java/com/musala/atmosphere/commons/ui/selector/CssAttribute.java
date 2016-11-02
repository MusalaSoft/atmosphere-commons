package com.musala.atmosphere.commons.ui.selector;

import com.musala.atmosphere.commons.geometry.Bounds;

/**
 * Lists all the CSS attributes the system currently supports.
 * <p>
 * If you need to add a new attribute, you just need to add its value and specify the corresponding data type in the
 * enum.
 * 
 * @author boris.strandjev
 */
public enum CssAttribute {
    /** Value denoting the CSS 'bounds' attribute. Type of needed value {@link Bounds}. */
    BOUNDS(Bounds.class, "bounds"),
    /** Value denoting the CSS 'checkable' attribute. Type of needed value Boolean. */
    CHECKABLE(Boolean.class, "checkable"),
    /** Value denoting the CSS 'checked' attribute. Type of needed value Boolean. */
    CHECKED(Boolean.class, "checked"),
    /** Value denoting the CSS 'class' attribute. Type of needed value String. */
    CLASS_NAME(String.class, "class"),
    /** Value denoting the CSS 'clickable' attribute. Type of needed value Boolean. */
    CLICKABLE(Boolean.class, "clickable"),
    /** Value denoting the CSS 'content-desc' attribute. Type of needed value String. */
    CONTENT_DESCRIPTION(String.class, "content-desc"),
    /** Value denoting the CSS 'enabled' attribute. Type of needed value Boolean. */
    ENABLED(Boolean.class, "enabled"),
    /** Value denoting the CSS 'focusable' attribute. Type of needed value Boolean. */
    FOCUSABLE(Boolean.class, "focusable"),
    /** Value denoting the CSS 'focused' attribute. Type of needed value Boolean. */
    FOCUSED(Boolean.class, "focused"),
    /** Value denoting the CSS 'index' attribute. Type of needed value Integer. */
    INDEX(Integer.class, "index"),
    /** Value denoting the CSS 'long-clickable' attribute. Type of needed value Boolean. */
    LONG_CLICKABLE(Boolean.class, "long-clickable"),
    /** Value denoting the CSS 'package' attribute. Type of needed value String. */
    PACKAGE_NAME(String.class, "package"),
    /** Value denoting the CSS 'password' attribute. Type of needed value Boolean. */
    PASSWORD(Boolean.class, "password"),
    /** Value denoting the CSS 'resource-id' attribute. Type of needed value String. */
    RESOURCE_ID(String.class, "resource-id"),
    /** Value denoting the CSS 'scrollable' attribute. Type of needed value Boolean. */
    SCROLLABLE(Boolean.class, "scrollable"),
    /** Value denoting the CSS 'selected' attribute. Type of needed value Boolean. */
    SELECTED(Boolean.class, "selected"),
    /** Value denoting the CSS 'text' attribute. Type of needed value String. */
    TEXT(String.class, "text");

    /** The attribute values will be checked against this type and in case of discrepancy an exception will be thrown */
    private Class<?> attributeType;

    /** The name of the html attribute corresponding to this attribute. */
    private String htmlAttributeName;

    private CssAttribute(Class<?> attributeType, String htmlAttributeName) {
        this.attributeType = attributeType;
        this.htmlAttributeName = htmlAttributeName;
    }

    /**
     * Checks if the given value is appropriate for the given ui attribute value.
     *
     * @param object
     *        - the object to be checked
     *
     * @return <code>true</code> if the value is appropriate, <code>false</code> otherwise
     */
    public boolean isObjectOfAppropriateType(Object object) {
        return object == null || attributeType.isInstance(object);
    }

    /** This method is intentionally package protected. */
    String getHtmlAttributeName() {
        return htmlAttributeName;
    }

    /** This method is intentionally package protected. */
    Class<?> getAttributeType() {
        return attributeType;
    }
}
