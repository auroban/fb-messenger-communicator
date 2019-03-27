package com.auro.example.comm.configurations.server;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "server")
@Validated
public class ServerConfigs {

	@NotNull
	@Getter
	@Setter
	private int port;
}
