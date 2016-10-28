package com.musala.atmosphere.commons.util.telephony;

/**
 * Enumeration indicating the current data connection state (cellular).
 * 
 * @author yordan.petrov
 * 
 */
public enum DataState {
    /*
     * Data connection state: Connected.
     */
    DATA_CONNECTED(0),

    /*
     * Data connection state: Currently setting up a data connection.
     */
    DATA_CONNECTING(1),

    /*
     * Data connection state: Disconnected.
     */
    DATA_DISCONNECTED(2),

    /*
     * Data connection state: Suspended.
     */
    DATA_SUSPENDED(3);

    private int dataStateId;

    private DataState(int dataStateId) {
        this.dataStateId = dataStateId;
    }

    public int getId() {
        return dataStateId;
    }

    public static DataState getById(int id) {
        DataState typeById = null;
        for (DataState currentState : DataState.values()) {
            if (currentState.getId() == id) {
                typeById = currentState;
                break;
            }
        }

        return typeById;
    }
}