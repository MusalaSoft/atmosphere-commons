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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Representation of a mapping between String keys and values of various {@link Serializable} types.
 * 
 * @author vassil.angelov
 *
 */
public class Pack implements Serializable, Iterable<Object> {

    /**
     * Definitions of various accessor methods for iterating over specific value types in a pack.
     */
    public static abstract class Accessor {
        void entry(String key, boolean value) {
        };

        void entry(String key, byte value) {
        };

        void entry(String key, short value) {
        };

        void entry(String key, char value) {
        };

        void entry(String key, int value) {
        };

        void entry(String key, long value) {
        };

        void entry(String key, float value) {
        };

        void entry(String key, double value) {
        };

        void entry(String key, String value) {
        };

        void entry(String key, Serializable value) {
        };
    }

    public enum ValueType {
        BOOLEAN,
        BYTE,
        CHARACTER,
        SHORT,
        INTEGER,
        LONG,
        FLOAT,
        DOUBLE,
        STRING,
        SERIALIZABLE;
    }

    private static final long serialVersionUID = -3676581322243655907L;

    private HashMap<Pair<String, ValueType>, Object> contents;

    /**
     * Creates an empty pack.
     */
    public Pack() {
        contents = new HashMap<Pair<String, ValueType>, Object>();
    }

    @Override
    public Iterator<Object> iterator() {
        Collection<Object> values = contents.values();
        return values.iterator();
    }

    /**
     * Iterate over the values in the pack with the specified {@link Accessor}.
     * 
     * @param accessor
     *        - the {@link Accessor} to use for the iteration
     */
    public void forEach(Accessor accessor) {
        Set<Entry<Pair<String, ValueType>, Object>> entries = contents.entrySet();
        for (Entry<Pair<String, ValueType>, Object> entry : entries) {

            ValueType type = entry.getKey().getValue();
            String key = entry.getKey().getKey();

            switch (type) {
                case BOOLEAN:
                    accessor.entry(key, (Boolean) entry.getValue());
                    break;
                case BYTE:
                    accessor.entry(key, (Byte) entry.getValue());
                    break;
                case CHARACTER:
                    accessor.entry(key, (Character) entry.getValue());
                    break;
                case DOUBLE:
                    accessor.entry(key, (Double) entry.getValue());
                    break;
                case FLOAT:
                    accessor.entry(key, (Float) entry.getValue());
                    break;
                case INTEGER:
                    accessor.entry(key, (Integer) entry.getValue());
                    break;
                case LONG:
                    accessor.entry(key, (Long) entry.getValue());
                    break;
                case SERIALIZABLE:
                    accessor.entry(key, (Serializable) entry.getValue());
                    break;
                case SHORT:
                    accessor.entry(key, (Short) entry.getValue());
                    break;
                case STRING:
                    accessor.entry(key, (String) entry.getValue());
                    break;
                default:
                    break;

            }
        }
    }

    /**
     * Check whether a key is present in the current pack.
     * 
     * @param key
     *        - the key to search for
     * @return whether the specified key is contained in the pack
     */
    public boolean containsKey(String key) {
        Set<Pair<String, ValueType>> internalKeys = contents.keySet();

        for (Pair<String, ValueType> internalKey : internalKeys) {
            if (internalKey.getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Clear the contents of the pack.
     */
    public void clear() {
        contents.clear();
    }

    /**
     * Get the entries count of this pack.
     * 
     * @return the entries count
     */
    public int entriesCount() {
        return contents.size();
    }

    /**
     * Inserts a boolean value to the contents of this pack, associating it with the provided String key. If a value of
     * the same type has the provided key, the value is replaced with the one provided.
     * 
     * @param key
     *        - a String key
     * @param value
     *        - a boolean value
     */
    public void putBoolean(String key, boolean value) {
        put(ValueType.BOOLEAN, key, value);
    }

    /**
     * Inserts a byte value to the contents of this pack, associating it with the provided String key. If a value of the
     * same type has the provided key, the value is replaced with the one provided.
     * 
     * @param key
     *        - a String key
     * @param value
     *        - a byte value
     */
    public void putByte(String key, byte value) {
        put(ValueType.BYTE, key, value);
    }

    /**
     * Inserts a char value to the contents of this pack, associating it with the provided String key. If a value of the
     * same type has the provided key, the value is replaced with the one provided.
     * 
     * @param key
     *        - a String key
     * @param value
     *        - a char value
     */
    public void putChar(String key, char value) {
        put(ValueType.CHARACTER, key, value);
    }

    /**
     * Inserts a short value to the contents of this pack, associating it with the provided String key. If a value of
     * the same type has the provided key, the value is replaced with the one provided.
     * 
     * @param key
     *        - a String key
     * @param value
     *        - a short value
     */
    public void putShort(String key, short value) {
        put(ValueType.SHORT, key, value);
    }

    /**
     * Inserts an integer value to the contents of this pack, associating it with the provided String key. If a value of
     * the same type has the provided key, the value is replaced with the one provided.
     * 
     * @param key
     *        - a String key
     * @param value
     *        - an integer value
     */
    public void putInt(String key, int value) {
        put(ValueType.INTEGER, key, value);
    }

    /**
     * Inserts a long value to the contents of this pack, associating it with the provided String key. If a value of the
     * same type has the provided key, the value is replaced with the one provided.
     * 
     * @param key
     *        - a String key
     * @param value
     *        - a long value
     */
    public void putLong(String key, long value) {
        put(ValueType.LONG, key, value);
    }

    /**
     * Inserts a float value to the contents of this pack, associating it with the provided String key. If a value of
     * the same type has the provided key, the value is replaced with the one provided.
     * 
     * @param key
     *        - a String key
     * @param value
     *        - a float value
     */
    public void putFloat(String key, float value) {
        put(ValueType.FLOAT, key, value);
    }

    /**
     * Inserts a double value to the contents of this pack, associating it with the provided String key. If a value of
     * the same type has the provided key, the value is replaced with the one provided.
     * 
     * @param key
     *        - a String key
     * @param value
     *        - a double value
     */
    public void putDouble(String key, double value) {
        put(ValueType.DOUBLE, key, value);
    }

    /**
     * Inserts a String value to the contents of this pack, associating it with the provided String key. If a value of
     * the same type has the provided key, the value is replaced with the one provided.
     * 
     * @param key
     *        - a String key
     * @param value
     *        - a String value
     */
    public void putString(String key, String value) {
        put(ValueType.STRING, key, value);
    }

    /**
     * Inserts a Serializable value to the contents of this pack, associating it with the provided String key. If a
     * value of the same type has the provided key, the value is replaced with the one provided.
     * 
     * @param key
     *        - a String key
     * @param value
     *        - a Serializable value
     */
    public void putSerializable(String key, Serializable value) {
        put(ValueType.SERIALIZABLE, key, new Pair<String, Serializable>(value.getClass().getName(), value));
    }

    /**
     * Retrieve the value associated with the provided key. If no value is currently associated with this key, the
     * provided default value is returned.
     * 
     * @param key
     *        - a String key
     * @param defaultValue
     *        - the value to return if no mapping exists
     * @return the associated value or defaultValue
     */
    public boolean getBoolean(String key, boolean defaultValue) {
        return (Boolean) getValue(ValueType.BOOLEAN, key, defaultValue);
    }

    /**
     * Retrieve the value associated with the provided key. If no value is currently associated with this key, the
     * provided default value is returned.
     * 
     * @param key
     *        - a String key
     * @param defaultValue
     *        - the value to return if no mapping exists
     * @return the associated value or defaultValue
     */
    public byte getByte(String key, byte defaultValue) {
        return (Byte) getValue(ValueType.BYTE, key, defaultValue);
    }

    /**
     * Retrieve the value associated with the provided key. If no value is currently associated with this key, the
     * provided default values is returned.
     * 
     * @param key
     *        - a String key
     * @param defaultValue
     *        - the value to return if no mapping exists
     * @return the associated value or defaultValue
     */
    public char getChar(String key, char defaultValue) {
        return (Character) getValue(ValueType.CHARACTER, key, defaultValue);
    }

    /**
     * Retrieve the value associated with the provided key. If no value is currently associated with this key, the
     * provided default values is returned.
     * 
     * @param key
     *        - a String key
     * @param defaultValue
     *        - the value to return if no mapping exists
     * @return the associated value or defaultValue
     */
    public short getShort(String key, short defaultValue) {
        return (Short) getValue(ValueType.SHORT, key, defaultValue);
    }

    /**
     * Retrieve the value associated with the provided key. If no value is currently associated with this key, the
     * provided default values is returned.
     * 
     * @param key
     *        - a String key
     * @param defaultValue
     *        - the value to return if no mapping exists
     * @return the associated value or defaultValue
     */
    public int getInt(String key, int defaultValue) {
        return (Integer) getValue(ValueType.INTEGER, key, defaultValue);
    }

    /**
     * Retrieve the value associated with the provided key. If no value is currently associated with this key, the
     * provided default values is returned.
     * 
     * @param key
     *        - a String key
     * @param defaultValue
     *        - the value to return if no mapping exists
     * @return the associated value or defaultValue
     */
    public long getLong(String key, long defaultValue) {
        return (Long) getValue(ValueType.LONG, key, defaultValue);
    }

    /**
     * Retrieve the value associated with the provided key. If no value is currently associated with this key, the
     * provided default values is returned.
     * 
     * @param key
     *        - a String key
     * @param defaultValue
     *        - the value to return if no mapping exists
     * @return the associated value or defaultValue
     */
    public float getFloat(String key, float defaultValue) {
        return (Float) getValue(ValueType.FLOAT, key, defaultValue);
    }

    /**
     * Retrieve the value associated with the provided key. If no value is currently associated with this key, the
     * provided default values is returned.
     * 
     * @param key
     *        - a String key
     * @param defaultValue
     *        - the value to return if no mapping exists
     * @return the associated value or defaultValue
     */
    public double getDouble(String key, double defaultValue) {
        return (Double) getValue(ValueType.DOUBLE, key, defaultValue);
    }

    /**
     * Retrieve the value associated with the provided key. If no value is currently associated with this key, null is
     * returned.
     * 
     * @param key
     *        - a String key
     * @return the associated value or null
     */
    public String getString(String key) {
        return (String) getValue(ValueType.STRING, key, null);
    }

    /**
     * Retrieve the value associated with the provided key. If no value is currently associated with this key, null is
     * returned.
     * 
     * @param key
     *        - a String key
     * @return the associated value or null
     */
    @SuppressWarnings("unchecked")
    public Serializable getSerializable(String key) {
        Pair<String, Serializable> pair = (Pair<String, Serializable>) getValue(ValueType.SERIALIZABLE, key, null);
        
        return (Serializable) pair.getValue();
    }

    private Object getValue(ValueType type, String key, Object defaultValue) {
        Pair<String, ValueType> internalKey = new Pair<String, Pack.ValueType>(key, type);

        if (contents.containsKey(internalKey)) {
            return contents.get(internalKey);
        } else {
            return defaultValue;
        }
    }

    private void put(ValueType type, String key, Object value) {
        Pair<String, ValueType> internalKey = new Pair<String, Pack.ValueType>(key, type);

        contents.put(internalKey, value);
    }
    
    public boolean isEmpty() {
        return contents.isEmpty();
    }

}
