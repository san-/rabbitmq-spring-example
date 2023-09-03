package br.eti.save.rabbitpoc.producer;

import br.eti.save.rabbitpoc.application.RabbitConfiguration;
import br.eti.save.rabbitpoc.model.UserData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(UserData user){
        rabbitTemplate.convertAndSend(RabbitConfiguration.POC_EXCHANGE, RabbitConfiguration.POC_ROUTING_KEY, user);
    }

}
