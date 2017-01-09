package com.syslog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;
import com.syslog.data.Message;
import com.syslog.repository.MessageRepository;

@RestController
@RequestMapping(value = "/logs")
public class SyslogController {

	@Autowired
	MessageRepository repository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Message findById(@PathVariable("id") final Long id) {
		return repository.findMessage(Long.toString(id));
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Message> findAll() {
		return (List<Message>) repository.findAllMessages();
	}

}
