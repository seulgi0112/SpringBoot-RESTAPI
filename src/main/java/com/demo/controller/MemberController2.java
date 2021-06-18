package com.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
			log.info("result.hasErrors():"+result.hasErrors());
			
			//BindingResult에서 제공하는 메서드를 사용해 검사 결과를 확인
			List<ObjectError> allErrors = result.getAllErrors();
			List<ObjectError> globalErrors = result.getGlobalErrors();
			List<FieldError> fieldErrors = result.getFieldErrors();
			
			log.info("allErrors size: " +allErrors.size());
			log.info("globalErrors size: " +globalErrors.size());
			log.info("fieldErrors size: " +fieldErrors.size());
			
			for(ObjectError objectError : allErrors) {
				log.info("allError : "+objectError);
			}
			for(ObjectError objectError : globalErrors) {
				log.info("globalErrors : "+objectError);
			}
			for(FieldError fieldError : fieldErrors) {
				log.info("fieldError : "+fieldError);
				log.info("fieldMessage : "+fieldError.getDefaultMessage());
			}
			
			
			ResponseEntity<String> entity = new ResponseEntity<String>(result.toString(), HttpStatus.BAD_REQUEST);
			return entity;
		}
		
		log.info("member.getUserId = " + member.getUserId() );
		log.info("member.getPassword = " + member.getPassword() );
		log.info("member.getUserName = " + member.getUserName());
		log.info("member.getDateOfBirth = " + member.getDateOfBirth());
		log.info("member.getEmail = " + member.getEmail());
		log.info("member.getGender = " + member.getGender());
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
}
