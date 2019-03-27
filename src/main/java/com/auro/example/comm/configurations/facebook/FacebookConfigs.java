package com.auro.example.comm.configurations.facebook;

import javax.validation.Valid;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "facebook")
@Validated
public class FacebookConfigs {

	@Valid
	@Getter
	@Setter
	private App app;

	@Valid
	@Getter
	@Setter
	private Messenger messenger;
}
