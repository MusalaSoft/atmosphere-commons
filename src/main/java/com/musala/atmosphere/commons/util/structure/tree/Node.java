package com.musala.atmosphere.commons.util.structure.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.musala.atmosphere.commons.util.structure.Hierarchical;

/**
 * A generic serializable node representation. The node is represented by a data, parent node and a list of children.
 * 
 * @author yordan.petrov
 * 
 * @param <T>
 *        - a class that specifies the generic data
 */
public class Node<T extends Serializable> implements Serializable, Hierarchical {
    private static final long serialVersionUID = -7376384070663720379L;

    protected T data;

    protected Node<T> parent;

    protected List<Node<T>> children;

    /**
     * Initializes a {@link Node node} with the given data and no children.
     * 
     * @param data
     *        - the node's data
     */
    public Node(T data) {
        this.data = data;
        this.children = new ArrayList<Node<T>>();
    }

    /**
     * Initializes a {@link Node node} with the given data and children.
     * 
     * @param data
     *        - the node's data
     * @param children
     *        - the node's children
     */
    public Node(T data, List<Node<T>> children) {
        this(data);
        addChildren(children);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Node<T> getParent() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Node<T>> getChildren() {
        return new ArrayList<Node<T>>(children);
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
        child.parent = this;
    }

    /**
     * Adds all child {@link Node nodes} to the list of children.
     * 
     * @param children
     *        - the child {@link Node nodes} to be added
     */
    public void addChildren(List<Node<T>> children) {
        for (Node<T> child : children) {
            addChild(child);
        }
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

        Node<T> obsoleteChild = children.remove(index);
        obsoleteChild.parent = null;

        return obsoleteChild;
    }

    /**
     * Clears the list of child {@link Node nodes}.
     */
    public void clearChildren() {
        int childCount = children.size();
        for (int i = 0; i < childCount; i++) {
            removeChild(i);
        }
    }

}
