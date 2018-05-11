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

package com.musala.atmosphere.commons.util.structure;

import org.junit.Test;

import static org.junit.Assert.*;

import com.musala.atmosphere.commons.ui.tree.AccessibilityElement;
import com.musala.atmosphere.commons.ui.tree.AccessibilityNodePathRepresenter;
import com.musala.atmosphere.commons.util.structure.PathBuilder.Representer;
import com.musala.atmosphere.commons.util.structure.tree.Node;

/**
 * 
 * @author vassil.angelov
 *
 */
public class PathBuilderTest {

    @Test
    public void testSimpleNodes() {
        Node<String> rootNode = new Node<String>("root");
        Node<String> parentNode = new Node<String>("elem1");
        rootNode.addChild(parentNode);
        Node<String> childNode = new Node<String>("elem2");
        parentNode.addChild(childNode);

        PathBuilder<Node<String>> pathBuilder = new PathBuilder<Node<String>>(new Representer<Node<String>>() {

            public String getPathRepresentation(Node<String> element) {
                return element.getData();
            };
        });

        String path = pathBuilder.getPath(childNode);
        String pathElements[] = path.split(pathBuilder.getDelimiter());

        assertEquals(3, pathElements.length);
        assertEquals(pathElements[1], parentNode.getData());
        assertEquals(pathElements[2], childNode.getData());
    }

    @Test
    public void testAccessibilityNodePath() {
        Node<AccessibilityElement> root = new Node<AccessibilityElement>(new AccessibilityElement());
        Node<AccessibilityElement> parent = new Node<AccessibilityElement>(new AccessibilityElement());
        root.addChild(parent);
        Node<AccessibilityElement> child1 = new Node<AccessibilityElement>(new AccessibilityElement());
        parent.addChild(child1);
        Node<AccessibilityElement> child2 = new Node<AccessibilityElement>(new AccessibilityElement());
        parent.addChild(child2);

        // The AccessibilityNodePathRepresenter uses the indexes of the elements in the path
        PathBuilder<Node<AccessibilityElement>> pathBuilder = new PathBuilder<Node<AccessibilityElement>>(new AccessibilityNodePathRepresenter());

        String path = pathBuilder.getPath(child2);
        String pathElements[] = path.split(pathBuilder.getDelimiter());

        assertEquals(3, pathElements.length);
        assertEquals(pathElements[1], Integer.toString(root.getChildren().indexOf(parent)));
        assertEquals(pathElements[2], Integer.toString(parent.getChildren().indexOf(child2)));
    }
}
