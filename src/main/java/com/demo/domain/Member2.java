package com.demo.domain;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member2 {

	//입력값 검증 규칙 지정
	@NotBlank (message = "Id를 입력해주세요.")
	private String userId;
	
	@NotBlank(message = "비밀번호를 입력해주세요.")
	private String password;
	
	//여러 개의 입력값 검증 규칙 가능
	@NotBlank
	@Size(max = 3)
	private String userName;
	
	@Email
	private String email;
	@NotNull
	private String gender;
	
	@Past
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
}
