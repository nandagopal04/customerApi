package com.chs.customerApi.dto;

import org.springframework.stereotype.Component;

import com.chs.customerApi.entity.Customer;

import lombok.Data;

@Data
@Component
public class OrderDto {
	
	Long id;
	String name;
	Double cost;
	Customer customer;
	
}
