package com.demo.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member2 {

	//입력값 검증 규칙 지정
	@NotBlank
	private String userId;
	private String password;
	
	//여러 개의 입력값 검증 규칙 가능
	@NotBlank
	@Size(max = 3)
	private String userName;
	
	private String email;
	private String gender;
}
