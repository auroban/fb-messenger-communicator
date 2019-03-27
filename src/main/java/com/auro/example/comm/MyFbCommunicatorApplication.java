package com.auro.example.comm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.auro.example.comm.configurations.facebook.FacebookConfigs;
import com.auro.example.comm.configurations.server.ServerConfigs;

@SpringBootApplication
public class MyFbCommunicatorApplication {	

	private static final Logger LOGGER = LoggerFactory.getLogger(MyFbCommunicatorApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Facebook Communicator starting up.....");
		SpringApplication.run(MyFbCommunicatorApplication.class, args);
		LOGGER.info("Facebook Communicator running.......");
	}

}
