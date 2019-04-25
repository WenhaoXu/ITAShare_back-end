package com.oocl.demo.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Howells
 * @ClassName MessageSender.java
 * @Description TODO
 * @createTime 11/29/2018
 */

@Component
public class MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessageToTopic(String destination, String message) {
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.convertAndSend(destination, message);
    }
}
