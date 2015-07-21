package com.musala.atmosphere.commons.ui.selector;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.log4j.Logger;

import com.musala.atmosphere.commons.geometry.Bounds;
import com.musala.atmosphere.commons.ui.UiElementPropertiesContainer;
import com.musala.atmosphere.commons.util.Pair;

/**
 * Selector class for screen UI elements, used to search for a specific element with given attributes.
 * 
 * @author georgi.gaydarov
 * 
 */
public class UiElementSelector implements UiElementPropertiesContainer {
    private static final Logger LOGGER = Logger.getLogger(UiElementSelector.class);

    private Map<CssAttribute, Pair<Object, UiElementSelectionOption>> attributeProjectionMap;

    public UiElementSelector() {
        this.attributeProjectionMap = new HashMap<CssAttribute, Pair<Object, UiElementSelectionOption>>();
    }

    /**
     * Constructs ui element selector out of node attribute map.
     * 
     * This is auxiliary constructor needed for some parts of the system. PLease prefer to use
     * {@link #UiElementSelector()}.
     * 
     * @param nodeAttributeMap
     *        a map between the html attribute names and their corresponding values
     * @throws IllegalArgumentException
     *         In case the node attribute map contains an entry with no matching {@link CssAttribute} or if the matching
     *         attribute is of type not handled in {@link #determineAttributeValue(CssAttribute, String)}.
     */
    public UiElementSelector(Map<String, String> nodeAttributeMap) throws IllegalArgumentException {
        this();

        for (Entry<String, String> nodeAttributeEntry : nodeAttributeMap.entrySet()) {
            boolean attributeFound = false;
            for (CssAttribute cssAttribute : CssAttribute.values()) {
                if (nodeAttributeEntry.getKey().equalsIgnoreCase("NAF")) {
                    attributeFound = true;
                }
                if (cssAttribute.getHtmlAttributeName().equals(nodeAttributeEntry.getKey())) {
                    Object attributeValue = determineAttributeValue(cssAttribute, nodeAttributeEntry.getValue());
                    if (!shouldSkipAttribute(cssAttribute, attributeValue)) {
                        addSelectionAttribute(cssAttribute, UiElementSelectionOption.EQUALS, attributeValue);
                    }
                    attributeFound = true;
                    break;
                }

            }
            if (!attributeFound) {
                String message = "Unsupported attribute passed in to UI element selector constructor";
                LOGGER.error(message);
                throw new IllegalArgumentException(message);
            }
        }
    }

    /**
     * Adds new selection argument for this ui element selector
     * <p>
     * Example usage would be:
     * <p>
     * <code>
     * uiElementSelector.addSelectionAttribute(SupportedCssAttribute.CHECKABLE, UiElementSelectionOption.EQUALS, true);
     * </code>
     * 
     * @param attribute
     *        The attribute for which to add selection expression. If selection expression already existed for the
     *        attribute it will be replaced.
     * @param selectionOption
     *        The selection option. One of the {@link UiElementSelectionOption}.
     * @param value
     *        The value to be used in the selection expression. Empty strings will not be added as expressions.
     * @throws IllegalArgumentException
     *         In case the supplied value does not match the type of the specified attribute.
     */
    public void addSelectionAttribute(CssAttribute attribute, UiElementSelectionOption selectionOption, Object value)
        throws IllegalArgumentException {
        if (!attribute.isObjectOfAppropriateType(value)) {
            String message = String.format("Invalid attributes value for attributes: %s. Expected %s but was %s .",
                                           attribute,
                                           attribute.getAttributeType(),
                                           value.getClass());
            LOGGER.error(message);
            throw new IllegalArgumentException(message);
        }
        if (!shouldSkipAttribute(attribute, value)) {
            attributeProjectionMap.put(attribute, new Pair<Object, UiElementSelectionOption>(value, selectionOption));
        }
    }

    /**
     * Adds new selection argument for this ui element selector with selection option that is
     * {@link UiElementSelectionOption#EQUALS}.
     * <p>
     * Example usage would be:
     * <p>
     * <code>
     * uiElementSelector.addSelectionAttribute(SupportedCssAttribute.CHECKABLE, true);
     * </code>
     * 
     * @param attribute
     *        The attribute for which to add selection expression. If selection expression already existed for the
     *        attribute it will be replaced.
     * @param value
     *        The value to be used in the selection expression. Empty strings will not be added as expressions.
     * @throws IllegalArgumentException
     *         In case the supplied value does not match the type of the specified attribute.
     */
    public void addSelectionAttribute(CssAttribute attribute, Object value) {
        addSelectionAttribute(attribute, UiElementSelectionOption.EQUALS, value);
    }

    /**
     * Use the method to get the value of boolean attribute selection argument
     * 
     * @param attribute
     *        The attribute for which to get the selection argument
     * @return The boolean value or null if no selection was specified.
     * @throws IllegalArgumentException
     *         If the attribute selection requested is not for boolean attribute.
     */
    public Boolean getBooleanValue(CssAttribute attribute) {
        return (Boolean) getGenericValue(attribute, Boolean.class);
    }

    /**
     * Use the method to get the value of string attribute selection argument
     * 
     * @param attribute
     *        The attribute for which to get the selection argument
     * @return The string value or null if no selection was specified.
     * @throws IllegalArgumentException
     *         If the attribute selection requested is not for string attribute.
     */
    public String getStringValue(CssAttribute attribute) {
        return (String) getGenericValue(attribute, String.class);
    }

    /**
     * Use the method to get the value of integer attribute selection argument
     * 
     * @param attribute
     *        The attribute for which to get the selection argument
     * @return The integer value or null if no selection was specified.
     * @throws IllegalArgumentException
     *         If the attribute selection requested is not for integer attribute.
     */
    public Integer getIntegerValue(CssAttribute attribute) {
        return (Integer) getGenericValue(attribute, Integer.class);
    }

    /**
     * Use the method to get the value of {@link Bounds} attribute selection argument
     * 
     * @param attribute
     *        The attribute for which to get the selection argument
     * @return The {@link Bounds} value or null if no selection was specified.
     * @throws IllegalArgumentException
     *         If the attribute selection requested is not for {@link Bounds} attribute.
     */
    public Bounds getBoundsValue(CssAttribute attribute) {
        return (Bounds) getGenericValue(attribute, Bounds.class);
    }

    /**
     * Builds a CSS select element query based on the contents of this selector.
     * 
     * @return the built CSS query.
     */
    public String buildCssQuery() {
        StringBuilder builder = new StringBuilder();

        for (Entry<CssAttribute, Pair<Object, UiElementSelectionOption>> attributeProjectionMapEntry : attributeProjectionMap.entrySet()) {
            Object selectionExpression = attributeProjectionMapEntry.getValue().getKey();
            if (selectionExpression != null) {
                CssAttribute attribute = attributeProjectionMapEntry.getKey();
                UiElementSelectionOption selectionOption = attributeProjectionMapEntry.getValue().getValue();
                builder.append(selectionOption.constructAttributeSelector(attribute, selectionExpression));
            }
        }

        return builder.toString();
    }

    private boolean shouldSkipAttribute(CssAttribute attribute, Object value) {
        // Apparently empty strings cause crashes
        return attribute.getAttributeType().equals(String.class) && ((String) value).isEmpty();
    }

    private Object getGenericValue(CssAttribute attribute, Class<?> clazz) {
        if (!attributeProjectionMap.containsKey(attribute)) {
            return null;
        }
        if (attribute.getAttributeType().equals(clazz)) {
            return attributeProjectionMap.get(attribute).getKey();
        } else {
            throw new IllegalArgumentException("Trying to get boolean value of non-boolean attribute " + attribute);
        }
    }

    private Object determineAttributeValue(CssAttribute cssAttribute, String value) {
        if (cssAttribute.getAttributeType().equals(String.class)) {
            return value;
        }
        if (cssAttribute.getAttributeType().equals(Integer.class)) {
            return Integer.parseInt(value);
        }
        if (cssAttribute.getAttributeType().equals(Boolean.class)) {
            return value.equals("true");
        }
        if (cssAttribute.getAttributeType().equals(Bounds.class)) {
            return UiElementBoundsParser.parse(value);
        }
        String message = String.format("Constructing UI element selector with attribute of unsupported type %s .",
                                       cssAttribute.getAttributeType());
        LOGGER.error(message);
        throw new IllegalArgumentException(message);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }

        UiElementSelector uiElementSelector = (UiElementSelector) object;

        return new EqualsBuilder().append(attributeProjectionMap, uiElementSelector.attributeProjectionMap).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(attributeProjectionMap).toHashCode();
    }

    @Override
    public int getIndex() {
        return getIntegerValue(CssAttribute.INDEX);
    }

    @Override
    public String getText() {
        return getStringValue(CssAttribute.TEXT);
    }

    @Override
    public boolean isClickable() {
        return getBooleanValue(CssAttribute.CLICKABLE);
    }

    @Override
    public boolean isScrollable() {
        return getBooleanValue(CssAttribute.SCROLLABLE);
    }

    @Override
    public boolean isLongClickable() {
        return getBooleanValue(CssAttribute.LONG_CLICKABLE);
    }

    @Override
    public boolean isSelected() {
        return getBooleanValue(CssAttribute.SELECTED);
    }

    @Override
    public boolean isPassword() {
        return getBooleanValue(CssAttribute.PASSWORD);
    }

    @Override
    public Bounds getBounds() {
        return getBoundsValue(CssAttribute.BOUNDS);
    }

    @Override
    public String getClassName() {
        return getStringValue(CssAttribute.CLASS_NAME);
    }

    @Override
    public String getPackageName() {
        return getStringValue(CssAttribute.PACKAGE_NAME);
    }

    @Override
    public String getContentDescriptor() {
        return getStringValue(CssAttribute.CONTENT_DESCRIPTION);
    }

    @Override
    public boolean isCheckable() {
        return getBooleanValue(CssAttribute.CHECKABLE);
    }

    @Override
    public boolean isChecked() {
        return getBooleanValue(CssAttribute.CHECKED);
    }

    @Override
    public boolean isFocusable() {
        return getBooleanValue(CssAttribute.FOCUSED);
    }

    @Override
    public boolean isFocused() {
        return getBooleanValue(CssAttribute.FOCUSED);
    }

    @Override
    public boolean isEnabled() {
        return getBooleanValue(CssAttribute.ENABLED);
    }

    @Override
    public String getResourceId() {
        return getStringValue(CssAttribute.RESOURCE_ID);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append(CssAttribute.INDEX.toString(),
                                                                                getIntegerValue(CssAttribute.INDEX))
                                                                        .append(CssAttribute.TEXT.toString(),
                                                                                getStringValue(CssAttribute.TEXT))
                                                                        .append(CssAttribute.CLASS_NAME.toString(),
                                                                                getStringValue(CssAttribute.CLASS_NAME))
                                                                        .append(CssAttribute.PACKAGE_NAME.toString(),
                                                                                getStringValue(CssAttribute.PACKAGE_NAME))
                                                                        .append(CssAttribute.CONTENT_DESCRIPTION.toString(),
                                                                                getStringValue(CssAttribute.CONTENT_DESCRIPTION))
                                                                        .append(CssAttribute.BOUNDS.toString(),
                                                                                getBoundsValue(CssAttribute.BOUNDS))
                                                                        .append(CssAttribute.CLICKABLE.toString(),
                                                                                getBooleanValue(CssAttribute.CLICKABLE))
                                                                        .append(CssAttribute.SCROLLABLE.toString(),
                                                                                getBooleanValue(CssAttribute.SCROLLABLE))
                                                                        .append(CssAttribute.LONG_CLICKABLE.toString(),
                                                                                getBooleanValue(CssAttribute.LONG_CLICKABLE))
                                                                        .append(CssAttribute.SELECTED.toString(),
                                                                                getBooleanValue(CssAttribute.SELECTED))
                                                                        .append(CssAttribute.PASSWORD.toString(),
                                                                                getBooleanValue(CssAttribute.PASSWORD))
                                                                        .append(CssAttribute.CHECKABLE.toString(),
                                                                                getBooleanValue(CssAttribute.CHECKABLE))
                                                                        .append(CssAttribute.CHECKED.toString(),
                                                                                getBooleanValue(CssAttribute.CHECKED))
                                                                        .append(CssAttribute.FOCUSABLE.toString(),
                                                                                getBooleanValue(CssAttribute.FOCUSABLE))
                                                                        .append(CssAttribute.FOCUSED.toString(),
                                                                                getBooleanValue(CssAttribute.FOCUSED))
                                                                        .append(CssAttribute.ENABLED.toString(),
                                                                                getBooleanValue(CssAttribute.ENABLED))
                                                                        .append(CssAttribute.RESOURCE_ID.toString(),
                                                                                getStringValue(CssAttribute.RESOURCE_ID))
                                                                        .toString();
    }
}
