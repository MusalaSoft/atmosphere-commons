package com.musala.atmosphere.commons.webelement.selection;

/**
 * Enum containing the attributes by which a {@link WebElement} can be selected.
 * 
 * @author denis.bialev
 *
 */
public enum WebElementSelectionCriterion {
    /** Value denoting the 'class' attribute. Type of needed value String. */
    CLASS,
    /** Value denoting the 'tag' attribute. Type of needed value String. */
    TAG,
    /** Value denoting the 'id' attribute. Type of needed value String. */
    ID,
    /** Value denoting the 'CssSelector' attribute. Type of needed value CssQuery in String. */
    CSS_SELECTOR,
    /** Value denoting the 'xpath' attribute. Type of needed value Xpath query in string. */
    XPATH,
    /** Value denoting the 'name' attribute. Type of needed value String. */
    NAME,
    /** Value denoting the 'link' attribute. Type of needed value String. */
    LINK,
    /** Value denoting the partial 'link' attribute. Type of needed value String. */
    PARTIAL_LINK;
}
