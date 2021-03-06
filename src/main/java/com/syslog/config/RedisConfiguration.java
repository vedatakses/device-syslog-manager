package com.syslog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.syslog.data.Message;

@Configuration
public class RedisConfiguration {

	/**
	 * Jedis connection factory.
	 *
	 * @return the jedis connection factory
	 */
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		connectionFactory.setHostName("localhost");
		connectionFactory.setPort(6379);
		return connectionFactory;
	}

	/**
	 * Redis template.
	 *
	 * @return the redis template
	 */
	@Bean
	public RedisTemplate<String, Message> redisTemplate() {
		RedisTemplate<String, Message> template = new RedisTemplate<String, Message>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		return template;
	}
}
