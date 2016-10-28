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
