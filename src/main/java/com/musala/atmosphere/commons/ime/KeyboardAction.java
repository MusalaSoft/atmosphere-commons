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
    PASTE_TEXT("atmosphere.intent.ime.action.PASTE", android.R.id.paste),
    COPY_TEXT("atmosphere.intent.ime.action.COPY", android.R.id.copy),
    CUT_TEXT("atmosphere.intent.ime.action.CUT", android.R.id.cut);

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
