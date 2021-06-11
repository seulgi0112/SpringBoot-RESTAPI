package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

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
}
