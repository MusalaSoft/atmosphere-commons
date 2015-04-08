package com.musala.atmosphere.commons.util.tree;

import java.io.Serializable;

/**
 * A serializable tree representation. The tree is represented by a generic root {@link Node node}.
 * 
 * @author yordan.petrov
 * 
 * @param <T>
 *        - a class that specifies the generic data of the node
 */
public class Tree<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = -6345462724031897482L;

    protected Node<T> root;

    /**
     * Initializes a {@link Tree tree} by a given root data. The data will be used to initialize a root {@link Node
     * node}.
     * 
     * @param rootData
     *        - data for the root {@link Node node}
     */
    public Tree(T rootData) {
        root = new Node<T>(rootData);
    }

    /**
     * Initializes a {@link Tree tree} by a given root {@link Node node}.
     * 
     * @param root
     *        - the root {@link Node node} of the tree.
     */
    public Tree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
}
