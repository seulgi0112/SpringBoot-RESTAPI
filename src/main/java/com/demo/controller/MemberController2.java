package com.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Member2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class MemberController2 {

	@PostMapping(value="", produces = "text/plain;charset=utf-8")
	public ResponseEntity<String> register(@Validated @RequestBody Member2 member, BindingResult result){
		log.info("regiser");
		
		if(result.hasErrors()) {
			ResponseEntity<String> entity = new ResponseEntity<String>(result.toString(), HttpStatus.BAD_REQUEST);
			return entity;
		}
		
		log.info("member.getUserId = " + member.getUserId() );
		log.info("member.getPassword = " + member.getPassword() );
		log.info("member.getUserName = " + member.getUserName());
		log.info("member.getEmail = " + member.getEmail());
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
}
