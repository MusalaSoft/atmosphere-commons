package com.musala.atmosphere.commons.webview.selection;

/**
 * Enum containing the attributes by which a WebView can be selected.
 *
 * @author dimcho.nedev
 *
 */
public enum WebViewSelectionCriterion {
    /** Value denoting the 'url' web view attribute. Type of needed value String. */
    URL("url"),

    /** Value denoting the 'title' web view attribute. Type of needed value String. */
    TITLE("title"),

    /** Value denoting a child web element element on the web view. Type of needed value String. */
    CHILD_ELEMENT("child element");

    private String name;

    private WebViewSelectionCriterion(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
