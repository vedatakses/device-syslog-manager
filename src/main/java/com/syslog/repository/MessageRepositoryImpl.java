package com.syslog.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.syslog.data.Message;

public class MessageRepositoryImpl implements MessageRepository {

	private static final Logger log = LoggerFactory.getLogger(MessageRepositoryImpl.class);

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
	public List<Message> findAllMessages() {
		List<Message> messages = new ArrayList<>();

		Map<Object, Object> map = redisTemplate.opsForHash().entries(KEY);
		for (Entry<Object, Object> entry : map.entrySet()) {
		    messages.add((Message) entry.getValue());
		}

		return messages;
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
