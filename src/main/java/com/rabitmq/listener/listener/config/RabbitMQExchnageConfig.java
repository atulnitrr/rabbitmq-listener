package com.rabitmq.listener.listener.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQExchnageConfig {


    @Bean
    Exchange exchange() {
        return new TopicExchange("ExampleExchange");
    }

    @Bean
    Exchange exchangeByBuilder() {
        return ExchangeBuilder.directExchange("ExampleExchange22")
                .autoDelete()
                .internal()
                .build();
    }
}
