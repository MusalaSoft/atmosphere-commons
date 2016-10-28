package com.musala.atmosphere.commons.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.musala.atmosphere.commons.ime.KeyboardAction;

/**
 * Intent command building utility class.
 * 
 * @author georgi.gaydarov
 * 
 */
public class IntentBuilder {
    // intent command format
    /*
     * <INTENT> specifications include these flags and arguments: [-a <ACTION>] [-d <DATA_URI>] [-t <MIME_TYPE>] [-c
     * <CATEGORY> [-c <CATEGORY>] ...] [-e|--es <EXTRA_KEY> <EXTRA_STRING_VALUE> ...] [--esn <EXTRA_KEY> ...] [--ez
     * <EXTRA_KEY> <EXTRA_BOOLEAN_VALUE> ...] [--ei <EXTRA_KEY> <EXTRA_INT_VALUE> ...] [--el <EXTRA_KEY>
     * <EXTRA_LONG_VALUE> ...] [--ef <EXTRA_KEY> <EXTRA_FLOAT_VALUE> ...] [--eu <EXTRA_KEY> <EXTRA_URI_VALUE> ...]
     * [--ecn <EXTRA_KEY> <EXTRA_COMPONENT_NAME_VALUE>] [--eia <EXTRA_KEY> <EXTRA_INT_VALUE>[,<EXTRA_INT_VALUE...]]
     * [--ela <EXTRA_KEY> <EXTRA_LONG_VALUE>[,<EXTRA_LONG_VALUE...]] [--efa <EXTRA_KEY>
     * <EXTRA_FLOAT_VALUE>[,<EXTRA_FLOAT_VALUE...]] [-n <COMPONENT>] [-f <FLAGS>] [--grant-read-uri-permission]
     * [--grant-write-uri-permission] [--debug-log-resolution] [--exclude-stopped-packages] [--include-stopped-packages]
     * [--activity-brought-to-front] [--activity-clear-top] [--activity-clear-when-task-reset]
     * [--activity-exclude-from-recents] [--activity-launched-from-history] [--activity-multiple-task]
     * [--activity-no-animation] [--activity-no-history] [--activity-no-user-action] [--activity-previous-is-top]
     * [--activity-reorder-to-front] [--activity-reset-task-if-needed] [--activity-single-top] [--activity-clear-task]
     * [--activity-task-on-home] [--receiver-registered-only] [--receiver-replace-pending] [--selector] [<URI> |
     * <PACKAGE> | <COMPONENT>]
     */

    /**
     * Intent actions enumeration.
     * 
     * @author georgi.gaydarov
     * 
     */
    public enum IntentAction {
        START_COMPONENT(null, "start"),
        ATMOSPHERE_TEXT_INPUT(KeyboardAction.INPUT_TEXT.intentAction, "broadcast"),
        ATMOSPHERE_CLEAR_TEXT(KeyboardAction.DELETE_ALL.intentAction, "broadcast"),
        ATMOSPHERE_SELECT_ALL_TEXT(KeyboardAction.SELECT_ALL.intentAction, "broadcast"),
        ATMOSPHERE_PASTE_TEXT(KeyboardAction.PASTE_TEXT.intentAction, "broadcast"),
        ATMOSPHERE_COPY_TEXT(KeyboardAction.COPY_TEXT.intentAction, "broadcast"),
        ATMOSPHERE_CUT_TEXT(KeyboardAction.CUT_TEXT.intentAction, "broadcast"),
        AIRPLANE_MODE_NOTIFICATION("android.intent.action.AIRPLANE_MODE", "broadcast"),
        BATTERY_LOW("android.intent.action.BATTERY_LOW", "broadcast"),
        BATTERY_OKAY("android.intent.action.BATTERY_OKAY", "broadcast"),
        BATTERY_CHANGED("android.intent.action.BATTERY_CHANGED", "broadcast"),
        ACTION_POWER_CONNECTED("android.intent.action.ACTION_POWER_CONNECTED", "broadcast"),
        ACTION_POWER_DISCONNECTED("android.intent.action.ACTION_POWER_DISCONNECTED", "broadcast"),
        START_ATMOSPHERE_SERVICE(null, "startservice"),
        ATMOSPHERE_SERVICE_CONTROL("com.musala.atmosphere.service.SERVICE_CONTROL", "broadcast");

        private String value;

        private String type;

        private IntentAction(String value, String type) {
            this.value = value;
            this.type = type;
        }

        public String getIntentString() {
            return value;
        }

        public String getTypeString() {
            return type;
        }
    }

    private IntentAction action;

    private String component;

    private Integer userId;

    private Integer flags;

    private Map<String, String> extraStrings = new HashMap<String, String>();

    private Map<String, Boolean> extraBooleans = new HashMap<String, Boolean>();

    private Map<String, Integer> extraInts = new HashMap<String, Integer>();

    private Map<String, Long> extraLongs = new HashMap<String, Long>();

    private Map<String, Float> extraFloats = new HashMap<String, Float>();

    private Map<String, List<Integer>> extraIntList = new HashMap<String, List<Integer>>();

    private Map<String, List<Long>> extraLongList = new HashMap<String, List<Long>>();

    private Map<String, List<Float>> extraFloatList = new HashMap<String, List<Float>>();

    public IntentBuilder(IntentAction action) {
        this.action = action;
    }

    public IntentBuilder putExtraString(String key, String value) {
        extraStrings.put(key, value);
        return this;
    }

    public IntentBuilder removeExtraString(String key) {
        if (extraStrings.containsKey(key)) {
            extraStrings.remove(key);
        }
        return this;
    }

    public IntentBuilder setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public IntentBuilder setFlags(Integer flags) {
        this.flags = flags;
        return this;
    }

    public IntentBuilder putExtraBoolean(String key, boolean value) {
        extraBooleans.put(key, value);
        return this;
    }

    public IntentBuilder removeExtraBoolean(String key) {
        if (extraBooleans.containsKey(key)) {
            extraBooleans.remove(key);
        }
        return this;
    }

    public IntentBuilder putExtraInteger(String key, int value) {
        extraInts.put(key, value);
        return this;
    }

    public IntentBuilder removeExtraInteger(String key) {
        if (extraInts.containsKey(key)) {
            extraInts.remove(key);
        }
        return this;
    }

    public IntentBuilder putExtraLong(String key, long value) {
        extraLongs.put(key, value);
        return this;
    }

    public IntentBuilder removeExtraLong(String key) {
        if (extraLongs.containsKey(key)) {
            extraLongs.remove(key);
        }
        return this;
    }

    public IntentBuilder putExtraFloat(String key, float value) {
        extraFloats.put(key, value);
        return this;
    }

    public IntentBuilder removeExtraFloat(String key) {
        if (extraFloats.containsKey(key)) {
            extraFloats.remove(key);
        }
        return this;
    }

    public IntentBuilder putExtraIntegerList(String key, List<Integer> value) {
        extraIntList.put(key, value);
        return this;
    }

    public IntentBuilder removeExtraIntegerList(String key) {
        if (extraIntList.containsKey(key)) {
            extraIntList.remove(key);
        }
        return this;
    }

    public IntentBuilder putExtraLongList(String key, List<Long> value) {
        extraLongList.put(key, value);
        return this;
    }

    public IntentBuilder removeExtraLongList(String key) {
        if (extraLongList.containsKey(key)) {
            extraLongList.remove(key);
        }
        return this;
    }

    public IntentBuilder putExtraFloatList(String key, List<Float> value) {
        extraFloatList.put(key, value);
        return this;
    }

    public IntentBuilder removeExtraFloatList(String key) {
        if (extraFloatList.containsKey(key)) {
            extraFloatList.remove(key);
        }
        return this;
    }

    public IntentBuilder putComponent(String component) {
        this.component = component;
        return this;
    }

    /**
     * Builds the intent sending command based on all set variables. The command is to be executed in a device shell.
     * 
     * @return the built command.
     */
    public String buildIntentCommand() {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("am ");

        String type = action.getTypeString();
        queryBuilder.append(type);
        queryBuilder.append(" ");

        if (userId != null) {
            queryBuilder.append("--user ");
            queryBuilder.append(userId);
            queryBuilder.append(" ");
        }

        String actionString = action.getIntentString();
        if (actionString != null) {
            queryBuilder.append("-a ");
            queryBuilder.append(actionString);
            queryBuilder.append(" ");
        }

        if (flags != null) {
            queryBuilder.append("-f ");
            queryBuilder.append(flags);
            queryBuilder.append(" ");
        }

        for (Entry<String, String> entry : extraStrings.entrySet()) {
            queryBuilder.append("--es " + entry.getKey() + " " + entry.getValue() + " ");
        }

        for (Entry<String, Boolean> entry : extraBooleans.entrySet()) {
            queryBuilder.append("--ez " + entry.getKey() + " " + entry.getValue() + " ");
        }

        for (Entry<String, Integer> entry : extraInts.entrySet()) {
            queryBuilder.append("--ei " + entry.getKey() + " " + entry.getValue() + " ");
        }

        for (Entry<String, Long> entry : extraLongs.entrySet()) {
            queryBuilder.append("--el " + entry.getKey() + " " + entry.getValue() + " ");
        }

        for (Entry<String, Float> entry : extraFloats.entrySet()) {
            queryBuilder.append("--ef " + entry.getKey() + " " + entry.getValue() + " ");
        }

        for (Entry<String, List<Integer>> entry : extraIntList.entrySet()) {
            List<Integer> values = entry.getValue();
            StringBuilder arrayRepresentation = new StringBuilder();
            if (values.size() > 0) {
                arrayRepresentation.append(values.get(0));
                for (int i = 1; i < values.size(); i++) {
                    arrayRepresentation.append("," + values.get(i));
                }
            }
            queryBuilder.append("--eia " + entry.getKey() + " " + arrayRepresentation.toString() + " ");
        }

        for (Entry<String, List<Long>> entry : extraLongList.entrySet()) {
            List<Long> values = entry.getValue();
            StringBuilder arrayRepresentation = new StringBuilder();
            if (values.size() > 0) {
                arrayRepresentation.append(values.get(0));
                for (int i = 1; i < values.size(); i++) {
                    arrayRepresentation.append("," + values.get(i));
                }
            }
            queryBuilder.append("--ela " + entry.getKey() + " " + arrayRepresentation.toString() + " ");
        }

        for (Entry<String, List<Float>> entry : extraFloatList.entrySet()) {
            List<Float> values = entry.getValue();
            StringBuilder arrayRepresentation = new StringBuilder();
            if (values.size() > 0) {
                arrayRepresentation.append(values.get(0));
                for (int i = 1; i < values.size(); i++) {
                    arrayRepresentation.append("," + values.get(i));
                }
            }
            queryBuilder.append("--efa " + entry.getKey() + " " + arrayRepresentation.toString() + " ");
        }

        if (component != null) {
            queryBuilder.append("-n ");
            queryBuilder.append(component);
            queryBuilder.append(" ");
        }

        String query = queryBuilder.toString();
        return query;
    }
}
