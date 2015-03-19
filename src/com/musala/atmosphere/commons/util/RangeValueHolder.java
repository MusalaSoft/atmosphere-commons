package com.musala.atmosphere.commons.util;

/**
 * Holder for a generic range value, represented as {@link Pair pair}.
 *
 * @author vassil.angelov
 *
 * @param <T>
 *        - the type of the range values
 */
public class RangeValueHolder<T> extends ValueHolder<Pair<T, T>> {

    /**
     * Creates a RangeValueHolder with the specified {@link Pair pair}.
     *
     * @param range
     *        - the {@link Pair pair} representing the range. The first value is considered as the minimum and the
     *        second value - the maximum.
     */
    public RangeValueHolder(Pair<T, T> range) {
        super(range);
    }

    /**
     * Creates a RangeValueHolder with the specified values formed as range.
     *
     * @param minValue
     *        - the minimum of the range
     * @param maxValue
     *        - the maximum of the range
     */
    public RangeValueHolder(T minValue, T maxValue) {
        super(new Pair<T, T>(minValue, maxValue));
    }
}
