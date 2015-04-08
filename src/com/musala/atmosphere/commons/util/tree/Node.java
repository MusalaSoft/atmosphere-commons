package com.musala.atmosphere.commons.util.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A generic serializable node representation. The node is represented by a data, parent node and a list of children.
 * 
 * @author yordan.petrov
 * 
 * @param <T>
 *        - a class that specifies the generic data
 */
public class Node<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = -7376384070663720379L;

    protected T data;

    protected Node<T> parent;

    protected List<Node<T>> children;

    /**
     * Initializes a {@link Node node} with the given data, no parent and no children.
     * 
     * @param data
     *        - the node's data
     */
    public Node(T data) {
        this(data, null);
    }

    /**
     * Initializes a {@link Node node} with the given data and parent, and no children.
     * 
     * @param data
     *        - the node's data
     * @param parent
     *        - the node's parent
     */
    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
        this.children = new ArrayList<Node<T>>();
    }

    /**
     * Initializes a {@link Node node} with the given data, parent and children.
     * 
     * @param data
     *        - the node's data
     * @param parent
     *        - the node's parent
     * @param children
     *        - the node's children
     */
    public Node(T data, Node<T> parent, List<Node<T>> children) {
        this(data, parent);
        this.children.addAll(children);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return new ArrayList<Node<T>>(children);
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }

    /**
     * Returns the number of {@link Node node} children.
     * 
     * @return the number of {@link Node node} children
     */
    public int getChildCount() {
        return children.size();
    }

    /**
     * Adds a child {@link Node node} to the list of children.
     * 
     * @param child
     *        - the child {@link Node node} to be added
     */
    public void addChild(Node<T> child) {
        children.add(child);
    }

    /**
     * Gets the child {@link Node node} with the given index.
     * 
     * @param index
     *        - index of the child {@link Node node} to be obtained
     * @return the child {@link Node node} with the given index or <code>null</code> if the index is out of bounds
     */
    public Node<T> getChild(int index) {
        if (index < 0 || index >= children.size()) {
            return null;
        }

        return children.get(index);
    }

    /**
     * Removes the child {@link Node node} with the given index.</br> <b>NOTE:</b> The indexes of the next {@link Node
     * nodes} will be shifted left.
     * 
     * @param index
     *        - index of the child {@link Node node} to be removed
     * @return the removed child {@link Node node} or <code>null</code> if the index is out of bounds
     */
    public Node<T> removeChild(int index) {
        if (index < 0 || index >= children.size()) {
            return null;
        }

        return children.remove(index);
    }

    /**
     * Clears the list of child {@link Node nodes}.
     */
    public void clearChildren() {
        children.clear();
    }
}
