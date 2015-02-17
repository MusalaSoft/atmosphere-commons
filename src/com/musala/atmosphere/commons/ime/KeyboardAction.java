package com.musala.atmosphere.commons.ime;

/**
 * Keyboard action enumeration. This enumeration contains custom keyboard intent actions and identifiers.
 * 
 * @author yavor.stankov
 * 
 */
public enum KeyboardAction {
    INPUT_TEXT("atmosphere.intent.ime.action.INPUT", android.R.id.input),
    SELECT_ALL("atmosphere.intent.ime.action.SELECTALL", android.R.id.selectAll),
    DELETE_ALL("atmosphere.intent.ime.action.DELETE", 1),
    PASTE_TEXT("atmosphere.intent.ime.action.PASTE", android.R.id.paste);

    public static final String INTENT_EXTRA_TEXT = "text";

    public static final String INTENT_EXTRA_INPUT_SPEED = "input_speed";

    public static final String INTENT_EXTRA_SELECTION = "selection";

    public final String intentAction;

    public final int id;

    private KeyboardAction(String action, int id) {
        this.intentAction = action;
        this.id = id;
    }

    public static KeyboardAction fromAction(String action) {
        for (KeyboardAction keyboardAction : values()) {
            if (keyboardAction.intentAction.equals(action)) {
                return keyboardAction;
            }
        }

        return null;
    }

}
