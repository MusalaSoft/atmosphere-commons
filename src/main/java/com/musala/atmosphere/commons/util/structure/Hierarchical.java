package com.musala.atmosphere.commons.util.structure;

import java.util.Collection;

/**
 * Representation of a hierarchical structure of elements with single inheritance.
 * 
 * @author vassil.angelov
 *
 */
public interface Hierarchical {
    /**
     * Retrieve the {@link Hierarchical} parent element of this {@link Hierarchical} element.
     *
     * @param <T>
     *        - the element to retrieve the parent element of
     * @return - the parent {@link Hierarchical} element
     */
    <T extends Hierarchical> T getParent();

    /**
     * Retrieve the {@link Hierarchical} child elements of this {@link Hierarchical} element.
     * 
     * @param <T>
     *        - the element to retrieve the child elements of
     * @return - the list of the {@link Hierarchical} child elements
     */
    <T extends Hierarchical> Collection<T> getChildren();
}
