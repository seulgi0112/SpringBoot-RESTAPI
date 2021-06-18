package com.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Collection;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;

import com.demo.domain.Member2;

class MemberTests {

		
	@Test
	void memberValidateTest() {
		//given
		Member2 member = new Member2();
		member.setUserName("sss");
		member.setUserId("");
		member.setPassword("password");
		member.setEmail("sdf@dndnd.com");
		member.setGender(null);
		
		//when 
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Collection<ConstraintViolation<Member2>> constraintViolations = validator.validate(member);
		
		//Then
		assertEquals("Id를 입력해주세요.", constraintViolations.iterator().next().getMessage());
	}

}
