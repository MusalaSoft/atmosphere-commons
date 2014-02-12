package com.musala.atmosphere.commons.util.telephony;

/**
 * Enumeration indicating the state of a device SIM card.
 * 
 * @author yordan.petrov
 * 
 */
public enum SimState
{
	/*
	 * SIM card state: no SIM card is available in the device
	 */
	SIM_STATE_ABSENT(0),

	/*
	 * SIM card state: Locked: requires a network PIN to unlock
	 */
	SIM_STATE_NETWORK_LOCKED(1),

	/*
	 * SIM card state: Locked: requires the user's SIM PIN to unlock
	 */
	SIM_STATE_PIN_REQUIRED(2),

	/*
	 * SIM card state: Locked: requires the user's SIM PUK to unlock
	 */
	SIM_STATE_PUK_REQUIRED(3),

	/*
	 * SIM card state: Ready
	 */
	SIM_STATE_READY(4),

	/*
	 * SIM card state: Unknown.
	 */
	SIM_STATE_UNKNOWN(5);

	private int simStateId;

	private SimState(int simStateId)
	{
		this.simStateId = simStateId;
	}

	public int getId()
	{
		return simStateId;
	}

	public static SimState getById(int id)
	{
		SimState typeById = null;
		for (SimState currentState : SimState.values())
		{
			if (currentState.getId() == id)
			{
				typeById = currentState;
				break;
			}
		}

		return typeById;
	}
}
