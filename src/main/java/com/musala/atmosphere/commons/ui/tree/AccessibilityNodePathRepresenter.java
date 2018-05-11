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

package com.musala.atmosphere.commons.ui.tree;

import com.musala.atmosphere.commons.util.structure.PathBuilder;
import com.musala.atmosphere.commons.util.structure.PathBuilder.Representer;
import com.musala.atmosphere.commons.util.structure.tree.Node;

/**
 * Representer for {@link Node} of {@link AccessibilityElement}, using the indexes of the child elements as their
 * representation in the path formed by {@link PathBuilder}.
 * 
 * @author vassil.angelov
 *
 */
public class AccessibilityNodePathRepresenter implements Representer<Node<AccessibilityElement>> {

    @Override
    public String getPathRepresentation(Node<AccessibilityElement> element) {
        Node<AccessibilityElement> parent = element.getParent();
        if (parent != null) {
            return Integer.toString(parent.getChildren().indexOf(element));
        }
        return "";
    }

}
