package com.syslog.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

	@Value("${service.name}")
	private String serviceName;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "Hallo, Welt from " + serviceName + "!";
	}
}
