package com.musala.atmosphere.commons.util;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import android.content.Intent;

import com.musala.atmosphere.commons.exceptions.AndroidComponentUsageException;
import com.musala.atmosphere.commons.util.Pack.Accessor;

/**
 * Class utilizing the use of the Android Intent outside of android projects, providing easy transformation to an actual
 * Intent wherever possible.
 * 
 * @author vassil.angelov
 *
 */
public class AtmosphereIntent implements Serializable {
    private static final long serialVersionUID = -8999604134083037751L;

    private Pack extras;

    private Set<Integer> flags;

    private String action;

    private Set<String> categories;

    /**
     * Creates new empty intent.
     */
    public AtmosphereIntent() {
        extras = new Pack();
        flags = new HashSet<Integer>();
        categories = new HashSet<String>();
    }

    /**
     * Creates intent with the specified action.
     * 
     * @param action
     *        - the action for the intent
     */
    public AtmosphereIntent(String action) {
        this();
        this.action = action;
    }

    /**
     * Retrieve the set of categories that would be associated with the intent. Modifying the values in the set will
     * take effect, modifying the set itself, however, will not.
     * 
     * @return the set of categories
     */
    public Set<String> getCategories() {
        return new HashSet<String>(categories);
    }

    /**
     * Add a category to the intent.
     * 
     * @param category
     *        - the category to add
     * @see Intent#addCategory(String)
     */
    public void addCategory(String category) {
        categories.add(category);
    }

    /**
     * Retrieve the general action associated with the intent
     * 
     * @return the action of this intent or null if none is specified
     * 
     * @see Intent#getAction()
     */
    public String getAction() {
        return action;
    }

    /**
     * Set the general action associated with the intent.
     * 
     * @param action
     *        - the action name
     * @return the same AtmosphereIntent, for chaining multiple calls
     * @see Intent#setAction(String)
     */
    public AtmosphereIntent setAction(String action) {
        this.action = action;
        return this;
    }

    /**
     * Add a flag to the intent.
     * 
     * @param flag
     *        - the flag to add
     * @return the same AtmosphereIntent, for chaining multiple calls
     * @see Intent#addFlags(int)
     */
    public AtmosphereIntent addFlag(int flag) {
        flags.add(flag);
        return this;
    }

    /**
     * Retrieve the set of flags that would be associated with the intent. Modifying the values in the set will take
     * effect, modifying the set itself, however, will not.
     * 
     * @return the set of flags
     */
    public HashSet<Integer> getFlags() {
        return new HashSet<Integer>(flags);
    }

    /**
     * Remove all flags from the intent.
     */
    public void clearFlags() {
        flags.clear();
    }

    /**
     * Remove all extras from the intent.
     */
    public void clearExtras() {
        extras.clear();
    }

    /**
     * Add extended data to the intent.The name must include a package prefix, for example the app com.android.contacts
     * would use names like "com.android.contacts.ShowAll".
     * 
     * @param name
     *        - the extra`s name
     * @param value
     *        - the extra`s value
     * @return the same AtmosphereIntent, for chaining multiple calls
     * @see Intent#putExtra(String, boolean)
     */
    public AtmosphereIntent putExtra(String name, boolean value) {
        extras.putBoolean(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.The name must include a package prefix, for example the app com.android.contacts
     * would use names like "com.android.contacts.ShowAll".
     * 
     * @param name
     *        - the extra`s name
     * @param value
     *        - the extra`s value
     * @return the same AtmosphereIntent, for chaining multiple calls
     * @see Intent#putExtra(String, byte)
     */
    public AtmosphereIntent putExtra(String name, byte value) {
        extras.putByte(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.The name must include a package prefix, for example the app com.android.contacts
     * would use names like "com.android.contacts.ShowAll".
     * 
     * @param name
     *        - the extra`s name
     * @param value
     *        - the extra`s value
     * @return the same AtmosphereIntent, for chaining multiple calls
     * @see Intent#putExtra(String, char)
     */
    public AtmosphereIntent putExtra(String name, char value) {
        extras.putChar(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.The name must include a package prefix, for example the app com.android.contacts
     * would use names like "com.android.contacts.ShowAll".
     * 
     * @param name
     *        - the extra`s name
     * @param value
     *        - the extra`s value
     * @return the same AtmosphereIntent, for chaining multiple calls
     * @see Intent#putExtra(String, short)
     */
    public AtmosphereIntent putExtra(String name, short value) {
        extras.putShort(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.The name must include a package prefix, for example the app com.android.contacts
     * would use names like "com.android.contacts.ShowAll".
     * 
     * @param name
     *        - the extra`s name
     * @param value
     *        - the extra`s value
     * @return the same AtmosphereIntent, for chaining multiple calls
     * @see Intent#putExtra(String, int)
     */
    public AtmosphereIntent putExtra(String name, int value) {
        extras.putInt(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.The name must include a package prefix, for example the app com.android.contacts
     * would use names like "com.android.contacts.ShowAll".
     * 
     * @param name
     *        - the extra`s name
     * @param value
     *        - the extra`s value
     * @return the same AtmosphereIntent, for chaining multiple calls
     * @see Intent#putExtra(String, long)
     */
    public AtmosphereIntent putExtra(String name, long value) {
        extras.putLong(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.The name must include a package prefix, for example the app com.android.contacts
     * would use names like "com.android.contacts.ShowAll".
     * 
     * @param name
     *        - the extra`s name
     * @param value
     *        - the extra`s value
     * @return the same AtmosphereIntent, for chaining multiple calls
     * @see Intent#putExtra(String, float)
     */
    public AtmosphereIntent putExtra(String name, float value) {
        extras.putFloat(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.The name must include a package prefix, for example the app com.android.contacts
     * would use names like "com.android.contacts.ShowAll".
     * 
     * @param name
     *        - the extra`s name
     * @param value
     *        - the extra`s value
     * @return the same AtmosphereIntent, for chaining multiple calls
     * @see Intent#putExtra(String, double)
     */
    public AtmosphereIntent putExtra(String name, double value) {
        extras.putDouble(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.The name must include a package prefix, for example the app com.android.contacts
     * would use names like "com.android.contacts.ShowAll".
     * 
     * @param name
     *        - the extra`s name
     * @param value
     *        - the extra`s value
     * @return the same AtmosphereIntent, for chaining multiple calls
     * @see Intent#putExtra(String, String)
     */
    public AtmosphereIntent putExtra(String name, String value) {
        extras.putString(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.The name must include a package prefix, for example the app com.android.contacts
     * would use names like "com.android.contacts.ShowAll".
     * 
     * @param name
     *        - the extra`s name extra
     * @param value
     *        - the extra`s value
     * @return the same AtmosphereIntent, for chaining multiple calls
     * @see Intent#putExtra(String, Serializable)
     */
    public AtmosphereIntent putExtra(String name, Serializable value) {
        extras.putSerializable(name, value);
        return this;
    }

    /**
     * Retrieve the extra`s value by the extra`s name. If the extra does not exist for the current intent, the provided
     * default value is returned.
     * 
     * @param name
     *        - the name of the extra
     * @param defaultValue
     *        - the value to return if no such extra exists
     * @return the extra`s value or defaultValue
     */
    public boolean getBooleanExtra(String name, boolean defaultValue) {
        return extras.getBoolean(name, defaultValue);
    }

    /**
     * Retrieve the extra`s value by the extra`s name. If the extra does not exist for the current intent, the provided
     * default value is returned.
     * 
     * @param name
     *        - the name of the extra
     * @param defaultValue
     *        - the value to return if no such extra exists
     * @return the extra`s value or defaultValue
     */
    public byte getByteExtra(String name, byte defaultValue) {
        return extras.getByte(name, defaultValue);
    }

    /**
     * Retrieve the extra`s value by the extra`s name. If the extra does not exist for the current intent, the provided
     * default value is returned.
     * 
     * @param name
     *        - the name of the extra
     * @param defaultValue
     *        - the value to return if no such extra exists
     * @return the extra`s value or defaultValue
     */
    public char getCharExtra(String name, char defaultValue) {
        return extras.getChar(name, defaultValue);
    }

    /**
     * Retrieve the extra`s value by the extra`s name. If the extra does not exist for the current intent, the provided
     * default value is returned.
     * 
     * @param name
     *        - the name of the extra
     * @param defaultValue
     *        - the value to return if no such extra exists
     * @return the extra`s value or defaultValue
     */
    public short getShortExtra(String name, short defaultValue) {
        return extras.getShort(name, defaultValue);
    }

    /**
     * Retrieve the extra`s value by the extra`s name. If the extra does not exist for the current intent, the provided
     * default value is returned.
     * 
     * @param name
     *        - the name of the extra
     * @param defaultValue
     *        - the value to return if no such extra exists
     * @return The extra`s value or defaultValue
     */
    public int getIntExtra(String name, int defaultValue) {
        return extras.getInt(name, defaultValue);
    }

    /**
     * Retrieve the extra`s value by the extra`s name. If the extra does not exist for the current intent, the provided
     * default value is returned.
     * 
     * @param name
     *        - the name of the extra
     * @param defaultValue
     *        - the value to return if no such extra exists
     * @return the extra`s value or defaultValue
     */
    public long getLongExtra(String name, long defaultValue) {
        return extras.getLong(name, defaultValue);
    }

    /**
     * Retrieve the extra`s value by the extra`s name. If the extra does not exist for the current intent, the provided
     * default value is returned.
     * 
     * @param name
     *        - the name of the extra
     * @param defaultValue
     *        - the value to return if no such extra exists
     * @return the extra`s value or defaultValue
     */
    public float getFloatExtra(String name, float defaultValue) {
        return extras.getFloat(name, defaultValue);
    }

    /**
     * Retrieve the extra`s value by the extra`s name. If the extra does not exist for the current intent, the provided
     * default value is returned.
     * 
     * @param name
     *        - the name of the extra
     * @param defaultValue
     *        - the value to return if no such extra exists
     * @return the extra`s value or defaultValue
     */
    public double getDoubleExtra(String name, double defaultValue) {
        return extras.getDouble(name, defaultValue);
    }

    /**
     * Retrieve the extra`s value by the extra`s name. If the extra does not exist for the current intent, null is
     * returned.
     * 
     * @param name
     *        - the name of the extra
     * @return the extra`s value or null
     */
    public String getStringExtra(String name) {
        return extras.getString(name);
    }

    /**
     * Retrieve the extra`s value by the extra`s name. If the extra does not exist for the current intent, null is
     * returned.
     * 
     * @param name
     *        - the name of the extra
     * @return the extra`s value or null
     */
    public Serializable getSerializableExtra(String name) {
        return extras.getSerializable(name);
    }

    /**
     * Retrieve the {@link Intent} representation of the contents of this intent. Note that calling this method outside
     * of the android platform will cause an {@link AndroidComponentUsageException}.
     * 
     * @return the {@link Intent} representing the contents of this intent
     * 
     * @throws AndroidComponentUsageException
     *         - if the method is invoked outside of the android platform
     */
    public Intent toIntent() {
        try {
            final Intent intent = createIntent();
            exportCategories(intent);
            exportExtras(intent);
            exportFlags(intent);
            return intent;
        } catch (Exception e) {
            throw new AndroidComponentUsageException("Improper call to AtmosphereIntent.toIntent() outside the android platform",
                                                     e);
        }
    }

    private void exportFlags(Intent intent) {
        for (int flag : flags) {
            intent.addFlags(flag);
        }
    }

    private void exportExtras(final Intent intent) {
        extras.forEach(new Accessor() {

            @Override
            void entry(String key, boolean value) {
                intent.putExtra(key, value);
            }

            @Override
            void entry(String key, byte value) {
                intent.putExtra(key, value);
            }

            @Override
            void entry(String key, short value) {
                intent.putExtra(key, value);
            }

            @Override
            void entry(String key, char value) {
                intent.putExtra(key, value);
            }

            @Override
            void entry(String key, int value) {
                intent.putExtra(key, value);
            }

            @Override
            void entry(String key, long value) {
                intent.putExtra(key, value);
            }

            @Override
            void entry(String key, float value) {
                intent.putExtra(key, value);
            }

            @Override
            void entry(String key, double value) {
                intent.putExtra(key, value);
            }

            @Override
            void entry(String key, String value) {
                intent.putExtra(key, value);
            }

            @Override
            void entry(String key, Serializable value) {
                intent.putExtra(key, value);
            }

        });
    }

    private void exportCategories(final Intent intent) {
        for (String category : categories) {
            intent.addCategory(category);
        }
    }

    private Intent createIntent() {
        Intent intent;

        if (action != null) {
            intent = new Intent(action);
        } else {
            intent = new Intent();
        }

        return intent;
    }

}
