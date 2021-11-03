package com.kakaofriends.front.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@GetMapping(value = "/_hcheck.hdn")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("HealthCheck OK", HttpStatus.OK);
	}

	@GetMapping(value = "/favicon.ico")
	public ResponseEntity<String> favicon() {
		return new ResponseEntity<>("/resources/images/favicon.ico", HttpStatus.OK);
	}
}