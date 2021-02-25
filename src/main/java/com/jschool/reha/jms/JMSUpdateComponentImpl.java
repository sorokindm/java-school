package com.jschool.reha.jms;

import com.jschool.reha.dto.RestMedEventDto;
import com.jschool.reha.enums.MedEventStatus;
import com.jschool.reha.enums.MessageType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
@PropertySource("classpath:mq.properties")
public class JMSUpdateComponentImpl implements JMSUpdateComponent {

    private final Logger logger = LogManager.getLogger();
    private final Environment env;

    private ConnectionFactory connectionFactory;
    private JMSContext jmsContext;
    private JMSProducer sender;
    private Destination destination;

    public JMSUpdateComponentImpl(Environment env) {
        this.env = env;
    }

    @Override
    public void newMedEventMessage(RestMedEventDto dto) {
        try {
            createConnection();
        } catch (NamingException e) {
            logger.error("Failed to connect to remote MQ", e);
            return;
        }
        ObjectMessage message = jmsContext.createObjectMessage();

        try {
            message.setIntProperty("type", MessageType.NEW_MED_EVENT.ordinal());
            message.setIntProperty("medEventId", dto.getIdMedEvent());
            message.setStringProperty("patientName", dto.getPatientName());
            message.setStringProperty("patientLastName", dto.getPatientLastName());
            message.setStringProperty("nurseName", dto.getNurseName());
            message.setStringProperty("nurseLastName", dto.getNurseLastName());
            message.setStringProperty("status", dto.getStatus());
            message.setObject(dto.getStarts());
        } catch (JMSException e) {
            logger.error("Failed to create JMS Message:", e);
            return;
        }

        sender.send(destination, message);
        logger.info("Sent message to MQ: new med event");
    }

    @Override
    public void closedMedEventMessage(int medEventId, MedEventStatus status) {
        try {
            createConnection();
        } catch (NamingException e) {
            logger.error("Failed to connect to remote MQ", e);
            return;
        }
        Message message = jmsContext.createMessage();

        try {
            message.setIntProperty("type", MessageType.CLOSED_MED_EVENT.ordinal());
            message.setIntProperty("medEventId", medEventId);
            message.setStringProperty("status", status.toString());
        } catch (JMSException e) {
            logger.error("Failed to create JMS message, message not sent:", e);
            return;
        }

        sender.send(destination, message);
        logger.info("Sent message to MQ: closed med event");
    }

    private void createConnection() throws NamingException {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        props.put(Context.PROVIDER_URL, env.getProperty("mq.url"));
        props.put(Context.SECURITY_PRINCIPAL, env.getProperty("mq.user"));
        props.put(Context.SECURITY_AUTHENTICATION, env.getProperty("mq.password"));
        Context context = new InitialContext(props);

        connectionFactory = (ConnectionFactory) context.lookup(env.getProperty("mq.factory"));
        this.destination = (Destination) context.lookup(env.getProperty("mq.queue"));

        this.jmsContext = connectionFactory.createContext(env.getProperty("mq.user"), env.getProperty("mq.password"));
        this.sender = jmsContext.createProducer();
    }
}
