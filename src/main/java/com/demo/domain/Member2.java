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

	//�Է°� ���� ��Ģ ����
	@NotBlank
	private String userId;
	private String password;
	
	//���� ���� �Է°� ���� ��Ģ ����
	@NotBlank
	@Size(max = 3)
	private String userName;
	
	private String email;
	private String gender;
}
