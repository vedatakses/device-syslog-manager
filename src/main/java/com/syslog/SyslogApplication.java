package com.syslog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.syslog.data.Message;
import com.syslog.repository.MessageRepository;
import com.syslog.repository.MessageRepositoryImpl;

@EnableScheduling
@SpringBootApplication
public class SyslogApplication {

	/** The Constant logger. */
	private static final Logger log = LoggerFactory.getLogger(SyslogApplication.class);

	@Autowired
	RedisTemplate<String, Message> redisTemplate;

	@Bean
	MessageRepository repository() {
		return new MessageRepositoryImpl(redisTemplate);
	}

	public static void main(String[] args) {
		SpringApplication.run(SyslogApplication.class, args);
	}
}
