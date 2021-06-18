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

	//�Է°� ���� ��Ģ ����
	@NotBlank (message = "Id�� �Է����ּ���.")
	private String userId;
	
	@NotBlank(message = "��й�ȣ�� �Է����ּ���.")
	private String password;
	
	//���� ���� �Է°� ���� ��Ģ ����
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
