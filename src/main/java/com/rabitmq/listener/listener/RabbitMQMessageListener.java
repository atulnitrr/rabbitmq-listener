package com.rabitmq.listener.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;


public class RabbitMQMessageListener implements MessageListener {

    @Override
    public void onMessage(final Message message) {

        System.out.println("message = [" + new String(message.getBody()) + "]");

    }
}
