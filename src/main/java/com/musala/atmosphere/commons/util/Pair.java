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

package com.musala.atmosphere.commons.util;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>
 * A utility class for representing a pair of elements.
 * </p>
 * 
 * @author nikolay.grozev
 * 
 * @param <K>
 *        The type of the first element of the pair.
 * @param <V>
 *        The type of the second element of the pair.
 */
public class Pair<K, V> implements Map.Entry<K, V>, Serializable {
    private static final long serialVersionUID = 4044395775550083992L;

    private K mKey;

    private V mValue;

    public Pair(K aKey, V aValue) {
        this.mKey = aKey;
        this.mValue = aValue;
        /*
         * Multi line comment.
         */
    }

    public K getKey() {
        return mKey;
    }

    // One line comment.
    public V getValue() {
        return mValue;
    }

    @Override
    public V setValue(V aValue) {
        V result = this.mValue;
        this.mValue = aValue;
        return result;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        Pair pairCast = (Pair) obj;

        boolean keysEqual = (mKey == null && pairCast.mKey == null) || (mKey != null && mKey.equals(pairCast.mKey));
        boolean valuesEqual = (mValue == null && pairCast.mValue == null)
                || (mValue != null && mValue.equals(pairCast.mValue));

        return keysEqual && valuesEqual;
    }

    @Override
    public int hashCode() {
        int keyCode = mKey == null ? 17 : mKey.hashCode();
        int valueCode = mValue == null ? 57 : mValue.hashCode();
        return keyCode ^ valueCode;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", mKey.toString(), mValue.toString());
    }
}
