package com.rabitmq.listener.listener.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rabitmq.listener.listener.RabbitMQMessageListener;


@Configuration
public class RabbitMQConfig {

    private static final String MY_QUEUE = "MyQueue";


    @Bean
    Queue myQueue() {
        return new Queue(MY_QUEUE, true);
    }

    @Bean
    Exchange exchangeTopoic() {
        return ExchangeBuilder.topicExchange("MyTopicExchange")
                .durable(true)
                .build();
    }

    @Bean
    Binding binding() {
//        return new Binding(MY_QUEUE, Binding.DestinationType.QUEUE, "MyTopicExchange", "topic", null);
        return BindingBuilder.bind(myQueue())
                .to(exchangeTopoic())
                .with("topic")
                .noargs();
    }






    @Bean
    ConnectionFactory connectionFactory() {
        final CachingConnectionFactory factory = new CachingConnectionFactory("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        return factory;
    }


    @Bean
    MessageListenerContainer messageListenerContainer() {
        final SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory());
        listenerContainer.setQueues(myQueue());
        listenerContainer.setMessageListener(new RabbitMQMessageListener());
        return listenerContainer;
    }


}
