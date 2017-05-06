package com.musala.atmosphere.commons.websocket.message;

import com.musala.atmosphere.commons.RoutingAction;

/**
 * Represents the abstract WebSocket message properties.
 *
 * @author dimcho.nedev
 *
 */
public abstract class Message {
    protected MessageAction messageAction;

    protected RoutingAction routingAction;

    protected String sessionId;

    protected String agentId;

    public Message(String sessionId, MessageAction messageAction, RoutingAction routingAction) {
        this.sessionId = sessionId;
        this.messageAction = messageAction;
        this.routingAction = routingAction;
    }

    public Message(MessageAction messageAction, RoutingAction routingAction) {
        this(null, messageAction, routingAction);
    }

    public Message(MessageAction messageAction) {
        this(null, messageAction, null);
    }

    /**
     * Gets the {@link MessageAction action} of the message.
     *
     * @return {@link MessageAction message action}
     */
    public MessageAction getMessageAction() {
        return messageAction;
    }

    /**
     * Gets the Session identifier.
     *
     * @return Session identifier
     */
    public String getSessionId() {
        return this.sessionId;
    }

    /**
     * Sets an identifier of the Session
     * 
     * @param sessionId
     *        - identifier of the Session
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * Gets a {@link RoutingAction routing action}
     *
     * @return {@link RoutingAction routing action}
     */
    public RoutingAction getRoutingAction() {
        return routingAction;
    }

    /**
     * Sets a {@link RoutingAction routing action}
     *
     * @param routingAction
     *        - {@link RoutingAction routing action}
     */
    public void setRoutingAction(RoutingAction routingAction) {
        this.routingAction = routingAction;
    }

    /**
     * Sets an agent identifier.
     *
     * @param agentId
     *        - agent identifier
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    /**
     * Gets an identifier of the agent
     * 
     * @return agent identifier
     */
    public String getAgentId() {
        return this.agentId;
    }

}
