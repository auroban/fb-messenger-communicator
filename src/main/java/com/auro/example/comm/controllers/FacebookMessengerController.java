package com.auro.example.comm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auro.example.comm.configurations.facebook.FacebookConfigs;

@RestController
public class FacebookMessengerController {

	private final String MODE_REQUEST_PARAM_NAME = "hub.mode";
	private final String VERIFY_TOKEN_REQUEST_PARAM_NAME = "hub.verify_token";
	private final String CHALLENGE_REQUEST_PARAM_NAME = "hub.challenge";
	private final String SUBSCRIBE_MODE = "subscribe";

	private final Logger LOGGER = LoggerFactory.getLogger(FacebookMessengerController.class);
	
	@Autowired
	private FacebookConfigs facebookConfigs;

	@GetMapping(value = "/webhook")
	public ResponseEntity<String> verifyWebhook(@RequestParam(value = MODE_REQUEST_PARAM_NAME) final String mode,
			@RequestParam(value = VERIFY_TOKEN_REQUEST_PARAM_NAME) final String verifyToken,
			@RequestParam(value = CHALLENGE_REQUEST_PARAM_NAME) final String challenge) {
		LOGGER.info("Verifying webhook");
		LOGGER.debug("Received Mode:\t" + mode);
		LOGGER.debug("Received Verify Token:\t" + verifyToken);
		LOGGER.debug("Received Challenge:\t" + challenge);
		
		if (!StringUtils.isEmpty(mode) &&  !StringUtils.isEmpty(verifyToken)) {
			if (mode.equals(SUBSCRIBE_MODE) && verifyToken.equals(facebookConfigs.getMessenger().getVerifyToken())) {
				LOGGER.info("Webhook Verified");
				return new ResponseEntity<String>(challenge, HttpStatus.OK);
			}
		}
		LOGGER.error("Failed to verify Webhook");
		return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
	}

}
