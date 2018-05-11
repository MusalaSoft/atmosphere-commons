// This file is part of the ATMOSPHERE mobile testing framework.
// Copyright (C) 2016 MusalaSoft
//
// ATMOSPHERE is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ATMOSPHERE is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with ATMOSPHERE.  If not, see <http://www.gnu.org/licenses/>.

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
