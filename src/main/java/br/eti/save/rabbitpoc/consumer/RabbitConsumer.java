package br.eti.save.rabbitpoc.consumer;

import br.eti.save.rabbitpoc.application.RabbitConfiguration;
import br.eti.save.rabbitpoc.model.UserData;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConfiguration.POC_FILA)
public class RabbitConsumer {

    @RabbitHandler
    public void receiveMessage(UserData message){
        System.out.println("=> Mensagem recebida: " + message);
    }

}
