package com.syslog.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

	private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);

	@RabbitListener(queues="${myqueue}")
	public void receiveMessage(String message) {
		log.info("Consumer> " + message);
	}
}
