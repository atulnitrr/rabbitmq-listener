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

    @Bean
    Exchange newEx() {
        return ExchangeBuilder.topicExchange("TopicTextExchange")
                .autoDelete()
                .durable(true)
                .internal()
                .build();
    }

    @Bean
    Exchange fanEx() {
        return ExchangeBuilder.fanoutExchange("FanoutExchange")
                .autoDelete()
                .internal()
                .durable(true)
                .build();
    }

    @Bean
    Exchange headerEx() {
        return ExchangeBuilder.headersExchange("HeaderExchange")
                .ignoreDeclarationExceptions()
                .internal()
                .durable(true)
                .build();
    }


}
