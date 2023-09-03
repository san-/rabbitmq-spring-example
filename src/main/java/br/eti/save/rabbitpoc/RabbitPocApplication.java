package br.eti.save.rabbitpoc;

import br.eti.save.rabbitpoc.model.UserData;
import br.eti.save.rabbitpoc.producer.RabbitProducer;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitPocApplication implements CommandLineRunner {

	@Autowired
	private RabbitProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(RabbitPocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.send(new UserData(01, "Fulano de tal"));
		System.out.println("Mensagem enviada.");
	}
}
