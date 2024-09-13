package com.chs.customerApi.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.chs.customerApi.dto.CustomerDto;
import com.chs.customerApi.entity.Customer;

@Configuration
public class CustomerConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public CustomerDto convertCustomerToCustomerDto(Customer customer) {
		return modelMapper.map(customer, CustomerDto.class);
	}
	
	public Customer convertCustomerDtoToCustomer(CustomerDto customerDto) {
		return modelMapper.map(customerDto, Customer.class);
	}

}
