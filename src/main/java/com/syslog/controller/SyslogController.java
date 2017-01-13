package com.syslog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.syslog.data.Message;
import com.syslog.repository.MessageRepository;

@RestController
@RequestMapping(value = "/logs")
public class SyslogController {

	private static final Logger log = LoggerFactory.getLogger(SyslogController.class);

	@Autowired
	MessageRepository repository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Message findById(@PathVariable("id") final Long id) {
		log.info("log - findById: " + id);
		return repository.findMessage(Long.toString(id));
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Message> findAll() {
		log.info("log - findAll");
		return repository.findAllMessages();
	}

}
