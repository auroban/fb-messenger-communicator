package com.auro.example.comm.configurations.facebook;

import javax.validation.constraints.NotEmpty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties
public class App {

	@NotEmpty
	@Getter
	@Setter
	private String id;

	@NotEmpty
	@Getter
	@Setter
	private String secret;
}
