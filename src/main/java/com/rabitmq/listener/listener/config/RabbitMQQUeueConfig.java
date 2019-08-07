package com.rabitmq.listener.listener.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQQUeueConfig {


    @Bean
    Queue getQueue() {
       return QueueBuilder.durable("ExampleSecond")
               .autoDelete()
               .exclusive()
               .build();
    }
}
