package com.syslog.repository;

import java.util.Map;

import com.syslog.data.Message;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessageRepository.
 */
public interface MessageRepository {

	/**
	 * Find message.
	 *
	 * @param id the id
	 * @return the message
	 */
	Message findMessage(String id);

	/**
	 * Find all messages.
	 *
	 * @return the map
	 */
	Map<Object, Object> findAllMessages();

	/**
	 * Delete message.
	 *
	 * @param id the id
	 */
	void deleteMessage(String id);

	/**
	 * Save message.
	 *
	 * @param message the message
	 * @return the message
	 */
	void saveMessage(Message message);

	/**
	 * Update message.
	 *
	 * @param message the message
	 * @return the message
	 */
	void updateMessage(Message message);
}
