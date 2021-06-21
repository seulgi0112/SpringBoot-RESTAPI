package com.demo.domain;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member3 {

	private String userId;
	private String password;
	
	@NotBlank
	@Size(max = 3)
	private String userName;
	
	private String email;
	
	private Address Address;
	
	private List<Card> cardList;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
}
