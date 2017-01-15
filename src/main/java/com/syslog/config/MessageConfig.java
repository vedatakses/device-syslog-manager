package com.syslog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

import com.syslog.data.Message;
import com.syslog.repository.MessageRepository;
import com.syslog.repository.MessageRepositoryImpl;

/**
 * The Class MessageConfig.
 */
public class MessageConfig {
	
	/** The redis template. */
	@Autowired
	RedisTemplate<String, Message> redisTemplate;

	/**
	 * Repository.
	 *
	 * @return the message repository
	 */
	@Bean
	MessageRepository repository() {
		return new MessageRepositoryImpl(redisTemplate);
	}
}
