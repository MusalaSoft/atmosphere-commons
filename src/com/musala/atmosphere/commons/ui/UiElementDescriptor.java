package com.musala.atmosphere.commons.ui;

import java.io.Serializable;

/**
 * Data container used for selecting elements in the UiAutomator on-device component.
 * 
 * @author georgi.gaydarov
 * 
 */
public class UiElementDescriptor implements Serializable {
    /**
     * auto-generated serialization id
     */
    private static final long serialVersionUID = -7522476787885264568L;

    private Boolean selected;

    private Boolean longClickable;

    private Boolean scrollable;

    private Boolean focused;

    private Boolean focusable;

    private Boolean enabled;

    private Boolean clickable;

    private Boolean checked;

    private Boolean checkable;

    private String contentDescription;

    private String packageName;

    private String className;

    private String text;

    private Integer index;

    private String resourceId;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Boolean isSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean isLongClickable() {
        return longClickable;
    }

    public void setLongClickable(Boolean longClickable) {
        this.longClickable = longClickable;
    }

    public Boolean isScrollable() {
        return scrollable;
    }

    public void setScrollable(Boolean scrollable) {
        this.scrollable = scrollable;
    }

    public Boolean isFocused() {
        return focused;
    }

    public void setFocused(Boolean focused) {
        this.focused = focused;
    }

    public Boolean isFocusable() {
        return focusable;
    }

    public void setFocusable(Boolean focusable) {
        this.focusable = focusable;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean isClickable() {
        return clickable;
    }

    public void setClickable(Boolean clickable) {
        this.clickable = clickable;
    }

    public Boolean isChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean isCheckable() {
        return checkable;
    }

    public void setCheckable(Boolean checkable) {
        this.checkable = checkable;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
