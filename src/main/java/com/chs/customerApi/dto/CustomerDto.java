package com.chs.customerApi.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CustomerDto {

	Long id;
	String firstName;
	String LastName;
	Long phoneNumber;
	String email;
	
}
