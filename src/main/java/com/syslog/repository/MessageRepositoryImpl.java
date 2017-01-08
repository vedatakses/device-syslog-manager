package com.syslog.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.syslog.data.Message;

public class MessageRepositoryImpl implements MessageRepository {

	/** The constant KEY. */
	private static final String KEY = "Message";

	/** The redis template. */
	private RedisTemplate<String, Message> redisTemplate;

	@Autowired
	public MessageRepositoryImpl(RedisTemplate<String, Message> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public Message findMessage(String id) {
		return (Message) this.redisTemplate.opsForHash().get(KEY, id);
	}

	@Override
	public Map<Object, Object> findAllMessages() {
		return this.redisTemplate.opsForHash().entries(KEY);
	}

	@Override
	public void deleteMessage(String id) {
		this.redisTemplate.opsForHash().delete(KEY, id);
	}

	@Override
	public void saveMessage(Message message) {
		this.redisTemplate.opsForHash().put(KEY, message.getId(), message);
	}

	@Override
	public void updateMessage(Message message) {
		this.redisTemplate.opsForHash().put(KEY, message.getId(), message);
	}

	public RedisTemplate<String, Message> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Message> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

}
