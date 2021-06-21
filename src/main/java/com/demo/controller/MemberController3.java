package com.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Address;
import com.demo.domain.Card;
import com.demo.domain.Member3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users3")
public class MemberController3 {

	@PostMapping(value = "", produces = "text/plain;charset=utf-8")
	public ResponseEntity<String> register(@Validated @RequestBody Member3 member, BindingResult result){
		log.info("member.getUserId = " + member.getUserId() );
		log.info("member.getPassword = " + member.getPassword() );
		log.info("member.getUserName = " + member.getUserName());
		log.info("member.getEmail = " + member.getEmail());
		
		Address address = member.getAddress();
		
		if(address != null) {
			log.info("address != null address.getPostCode() : "+ address.getPostCode());
			log.info("address != null address.getLocation() : " + address.getLocation() ); 
		}
		else {
			log.info("address ==null");
		}
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null) {
			log.info("cardList!=null" + cardList.size());
			
			for(Card card : cardList) {
				log.info("card.getNo() = " + card.getNo());
				log.info("card.getVaildMonth = " + card.getVaildMonth() );
			}
		}
		else {
			log.info("cardList = null");
		}
		
		if(result.hasErrors()) {
			ResponseEntity<String> entity = new ResponseEntity<String>(result.toString(), HttpStatus.BAD_REQUEST);
			
			return entity;
		}
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		return entity;
		
	}
}
