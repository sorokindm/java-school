package com.jschool.reha.jms;

import com.jschool.reha.dto.RestMedEventDto;
import com.jschool.reha.enums.MedEventStatus;

/**
 * JMS message handling component. Sends messages to remote MQ of client screen app.
 */
public interface JMSUpdateComponent {
    /**
     * Sends message to MQ with new event dto
     * @param dto - new event dto
     */
    void newMedEventMessage(RestMedEventDto dto);

    /**
     * Sends message with if of recently closed medEvent
     * @param medEventId - if of closed medEvent
     */
    void closedMedEventMessage(int medEventId, MedEventStatus status);
}
