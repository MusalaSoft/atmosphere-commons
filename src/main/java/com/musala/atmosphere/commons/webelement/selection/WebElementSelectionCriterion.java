package com.musala.atmosphere.commons.webelement.selection;

/**
 * Enum containing the attributes by which a WebElement can be selected.
 * 
 * @author denis.bialev
 *
 */
public enum WebElementSelectionCriterion {
    /** Value denoting the 'class' attribute. Type of needed value String. */
    CLASS("class"),
    /** Value denoting the 'tag' attribute. Type of needed value String. */
    TAG("tag"),
    /** Value denoting the 'id' attribute. Type of needed value String. */
    ID("id"),
    /** Value denoting the 'CssSelector' attribute. Type of needed value CssQuery in String. */
    CSS_SELECTOR("css_selector"),
    /** Value denoting the 'xpath' attribute. Type of needed value Xpath query in string. */
    XPATH("xpath"),
    /** Value denoting the 'name' attribute. Type of needed value String. */
    NAME("name"),
    /** Value denoting the 'link' attribute. Type of needed value String. */
    LINK("href"),
    /** Value denoting the partial 'link' attribute. Type of needed value String. */
    PARTIAL_LINK("href");

    private String name;

    private WebElementSelectionCriterion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
