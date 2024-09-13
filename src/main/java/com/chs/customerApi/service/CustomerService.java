package com.chs.customerApi.service;

import java.util.List;

import com.chs.customerApi.dto.CustomerDto;
import com.chs.customerApi.exception.InvalidCustomerIdException;

public interface CustomerService {
	
	CustomerDto saveCustomer(CustomerDto customerDto);
	CustomerDto findCustomerById(Long id) throws InvalidCustomerIdException;
	CustomerDto editCustomer(CustomerDto customerDto) throws InvalidCustomerIdException;
	CustomerDto deleteCustomer(Long id) throws InvalidCustomerIdException;
	List<CustomerDto> getAllCustomers();
}
