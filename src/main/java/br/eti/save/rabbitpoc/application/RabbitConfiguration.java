package br.eti.save.rabbitpoc.application;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    public static final String POC_FILA = "poc-fila";
    public static final String POC_EXCHANGE = "poc-exchange";
    public static final String POC_ROUTING_KEY = "poc-routing";

    @Bean
    public Queue queue(){
        return new Queue(POC_FILA, true, false, false);
    }

    @Bean
    public Exchange exchange(){
        return new TopicExchange(POC_EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(POC_ROUTING_KEY);
    }

}
