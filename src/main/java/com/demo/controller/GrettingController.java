package com.demo.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/greetings")
public class GrettingController {

	private final MessageSource messageSource;
	
	@GetMapping(value = "/welcome", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> welcome(){
		String[] args = {"홍길동"};
		
		String message = messageSource.getMessage("welcome.message", args,Locale.KOREAN);
		
		log.info("Welcome message : " + message);
	
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping(value = "/welcome2", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> welcome2(){
		
		String message = messageSource.getMessage("welcome.message2",null ,Locale.KOREAN);
		
		log.info("Welcome message : " + message);
	
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
}
