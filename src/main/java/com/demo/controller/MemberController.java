package com.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MemberController {
	//void Type
	@GetMapping("/register01")
	public void register01() {
		log.info("register01");
	}
	
	//String Type
	@GetMapping("/register02")
	public String register02() {
		log.info("register02");
		return "HELLO";
	}
	
	//Java Beans Class Type
	@GetMapping(value="/register03", produces="application/json")
		public Member register03() {
			log.info("register03");
			Member member = Member.builder()
					.userId("id1")
					.password("pass")
					.userName("Name1")
					.build();
			return member;
		}
	
	//Collection List Type
	@GetMapping(value="/register04")
	public List<Member> register04() {
		log.info("register04");
		Member member1 = Member.builder()
				.userId("id1")
				.password("pass")
				.userName("Name1")
				.build();
		
		Member member2 = Member.builder()
				.userId("id2")
				.password("pass2")
				.userName("Name2")
				.build();
		
		List<Member> list = new ArrayList<Member>();
		list.add(member1);
		list.add(member2);
		
		return list;
	}	
	
	
	//Collection Map Type
		@GetMapping(value="/register05")
		public Map<String, Member> register05() {
			log.info("register05");
			
			Map<String, Member> map = new HashMap<String, Member>();
			
			Member member1 = Member.builder()
					.userId("id1")
					.password("pass")
					.userName("Name1")
					.build();
			map.put("key1",member1);
			
			Member member2 = Member.builder()
					.userId("id2")
					.password("pass2")
					.userName("Name2")
					.build();
			map.put("key2",member2);
			
			return map;
		}	
		
		
		//Response Entity<Void> Type : response 시 http 헤더와 내용 가공
			@GetMapping(value="/register06")
			public ResponseEntity<Void> register06() {
				log.info("register06");
				return new ResponseEntity<Void>(HttpStatus.OK);
			}	
			
			//Response Entity<String> Type : response 시 http 헤더와 문자열 데이터 전달
			@GetMapping(value="/register07")
			public ResponseEntity<String> register07() {
				log.info("register07");
				return new ResponseEntity<String>("HELLO",HttpStatus.OK);
			}	
			
			//Response Entity<Class> Type : response 시 http 헤더와 객체 데이터 전달
			@GetMapping(value="/register08")
			public ResponseEntity<Member> register08() {
				log.info("register08");
				
				Member member1 = Member.builder()
						.userId("id1")
						.password("pass")
						.userName("Name1")
						.build();
				return new ResponseEntity<Member>(member1,HttpStatus.OK);
			}	
}
