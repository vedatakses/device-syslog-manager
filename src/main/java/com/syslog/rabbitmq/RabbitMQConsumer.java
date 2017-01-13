package com.syslog.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.syslog.data.Message;
import com.syslog.repository.MessageRepository;

/**
 * The Class RabbitMQConsumer.
 */
@Component
public class RabbitMQConsumer {

	/** The Constant logger. */
	private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);

	/** The repository. */
	@Autowired
	MessageRepository repository;

	/**
	 * Receive message.
	 *
	 * @param message the message
	 */
	@RabbitListener(queues="${service.rabbitmq.queue}")
	public void receiveMessage(Message message) {
		log.info("Got a new message: " + message);
		repository.saveMessage(message);
	}
}
