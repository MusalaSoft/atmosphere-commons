package com.musala.atmosphere.commons.util.telephony;

/**
 * Enumeration indicating the call state (cellular) on a device.
 * 
 * @author yordan.petrov
 * 
 */
public enum CallState {
    /*
     * Device call state: No activity.
     */
    CALL_STATE_IDLE(0),

    /*
     * Device call state: Off-hook.
     */
    CALL_STATE_OFFHOOK(1),

    /*
     * Device call state: Ringing.
     */
    CALL_STATE_RINGING(2);

    private int callStateId;

    private CallState(int callStateId) {
        this.callStateId = callStateId;
    }

    public int getId() {
        return callStateId;
    }

    public static CallState getById(int id) {
        CallState typeById = null;
        for (CallState currentState : CallState.values()) {
            if (currentState.getId() == id) {
                typeById = currentState;
                break;
            }
        }

        return typeById;
    }
}
