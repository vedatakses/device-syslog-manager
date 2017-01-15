package com.syslog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
public class SyslogApplication {

	/** The Constant logger. */
	private static final Logger log = LoggerFactory.getLogger(SyslogApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SyslogApplication.class, args);
	}
}
