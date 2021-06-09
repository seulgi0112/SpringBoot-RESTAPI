package com.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

//@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@ToString
@Builder
public class Member {

	private String userId;
	private String password;
	private String userName;
	
	public static void main(String[] args) {
		Member member = Member.builder()
				.userId("id1")
				.password("pass")
				.userName("Name1")
				.build();
		
		System.out.println(member);
	}

}

