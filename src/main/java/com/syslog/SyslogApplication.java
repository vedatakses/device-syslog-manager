package com.syslog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SyslogApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SyslogApplication.class);
	
	@Value("${myqueue}")
	private String queue;
	
	@Bean
	Queue queue() {
		return new Queue(queue, false);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SyslogApplication.class, args);
	}
}
