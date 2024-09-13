package com.chs.customerApi.service;

import java.util.List;

import com.chs.customerApi.dto.CustomerDto;
import com.chs.customerApi.exception.InvalidCustomerIdException;

public interface CustomerService {
	
	CustomerDto saveCustomerDto(CustomerDto customerDto);
	CustomerDto findCustomerDtoById(Long id) throws InvalidCustomerIdException;
	CustomerDto editCustomerDto(CustomerDto customerDto) throws InvalidCustomerIdException;
	CustomerDto deleteCustomerDto(Long id) throws InvalidCustomerIdException;
	List<CustomerDto> getAllCustomers();
}
