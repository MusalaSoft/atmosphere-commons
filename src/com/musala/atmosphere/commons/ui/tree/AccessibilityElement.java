package com.musala.atmosphere.commons.ui.tree;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.musala.atmosphere.commons.geometry.Bounds;
import com.musala.atmosphere.commons.ui.UiElementPropertiesContainer;
import com.musala.atmosphere.commons.ui.selector.CssAttribute;

/**
 * Serializable wrapper around the
 * <a href="http://developer.android.com/reference/android/view/accessibility/AccessibilityNodeInfo.html" >
 * AccessibilityNodeInfo</a>'s UI attributes.
 *
 * @author yordan.petrov
 *
 */
public class AccessibilityElement implements UiElementPropertiesContainer {
    private static final long serialVersionUID = -3060768747010930125L;

    /**
     * The separator used to separate the indexes in the element path obtained by {@link AccessibilityElement#getPath()}
     * .
     */
    public static final String PATH_SEPARATOR = ", ";

    private int index;

    private String className;

    private String packageName;

    private String contentDescriptor;

    private String text;

    private boolean checkable;

    private boolean checked;

    private boolean focusable;

    private boolean focused;

    private boolean enabled;

    private boolean clickable;

    private boolean scrollable;

    private boolean longClickable;

    private boolean selected;

    private boolean password;

    private Bounds bounds;

    private String resourceId;

    private String path;

    @Override
    public int getIndex() {
        return index;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    @Override
    public boolean isScrollable() {
        return scrollable;
    }

    public void setScrollable(boolean scrollable) {
        this.scrollable = scrollable;
    }

    @Override
    public boolean isLongClickable() {
        return longClickable;
    }

    public void setLongClickable(boolean longClickable) {
        this.longClickable = longClickable;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public boolean isPassword() {
        return password;
    }

    public void setPassword(boolean password) {
        this.password = password;
    }

    @Override
    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public void setCheckable(boolean checkable) {
        this.checkable = checkable;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String getContentDescriptor() {
        return contentDescriptor;
    }

    public void setContentDescriptor(String contentDescriptor) {
        this.contentDescriptor = contentDescriptor;
    }

    @Override
    public boolean isCheckable() {
        return checkable;
    }

    public void setChechkable(boolean checkable) {
        this.checkable = checkable;
    }

    @Override
    public boolean isChecked() {
        return checked;
    }

    public void setChechked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public boolean isFocusable() {
        return focusable;
    }

    public void setFocusable(boolean focusable) {
        this.focusable = focusable;
    }

    @Override
    public boolean isFocused() {
        return focused;
    }

    public void setFocused(boolean focused) {
        this.focused = focused;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Sets the string representation of the path to this element.
     *
     * @param path
     *        - string representation of the path to this element
     */
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String getResourceId() {
        return resourceId;
    }

    /**
     * Gets string representation of the path to this element.
     *
     * @return string representation of the path to this element
     */
    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                                                                        .append(CssAttribute.INDEX.toString(),
                                                                                getIndex())
                                                                        .append(CssAttribute.TEXT.toString(), getText())
                                                                        .append(CssAttribute.CLASS_NAME.toString(),
                                                                                getClassName())
                                                                        .append(CssAttribute.PACKAGE_NAME.toString(),
                                                                                getPackageName())
                                                                        .append(CssAttribute.CONTENT_DESCRIPTION.toString(),
                                                                                getContentDescriptor())
                                                                        .append(CssAttribute.BOUNDS.toString(),
                                                                                getBounds())
                                                                        .append(CssAttribute.CLICKABLE.toString(),
                                                                                isClickable())
                                                                        .append(CssAttribute.SCROLLABLE.toString(),
                                                                                isScrollable())
                                                                        .append(CssAttribute.LONG_CLICKABLE.toString(),
                                                                                isLongClickable())
                                                                        .append(CssAttribute.SELECTED.toString(),
                                                                                isSelected())
                                                                        .append(CssAttribute.PASSWORD.toString(),
                                                                                isPassword())
                                                                        .append(CssAttribute.CHECKABLE.toString(),
                                                                                isCheckable())
                                                                        .append(CssAttribute.CHECKED.toString(),
                                                                                isChecked())
                                                                        .append(CssAttribute.FOCUSABLE.toString(),
                                                                                isFocusable())
                                                                        .append(CssAttribute.FOCUSED.toString(),
                                                                                isFocused())
                                                                        .append(CssAttribute.ENABLED.toString(),
                                                                                isEnabled())
                                                                        .append(CssAttribute.RESOURCE_ID.toString(),
                                                                                getResourceId())
                                                                        .toString();
    }
}
