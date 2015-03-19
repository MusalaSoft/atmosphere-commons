package com.musala.atmosphere.commons.util;

/**
 * Holder for a single generic value.
 *
 * @author vassil.angelov
 *
 * @param <T>
 *        - the type of the contained value
 */
public class ValueHolder<T> {

    /**
     * The value contained in this holder
     */
    public T value;

    /**
     * Creates a ValueHolder with the specified value.
     *
     * @param value
     *        - the value to be contained in this holder
     */
    public ValueHolder(T value) {
        this.value = value;
    }
}
