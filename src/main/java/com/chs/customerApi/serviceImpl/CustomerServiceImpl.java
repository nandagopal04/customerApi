package com.chs.customerApi.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chs.customerApi.converter.CustomerConverter;
import com.chs.customerApi.dto.CustomerDto;
import com.chs.customerApi.entity.Customer;
import com.chs.customerApi.exception.InvalidCustomerIdException;
import com.chs.customerApi.repository.CustomerRepository;
import com.chs.customerApi.service.CustomerService;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerConverter customerConverter;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional
	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		Customer customer = customerConverter.convertCustomerDtoToCustomer(customerDto);
		customer = customerRepository.save(customer);
		return customerConverter.convertCustomerToCustomerDto(customer);
	}

	@Override
	public CustomerDto findCustomerById(Long id) throws InvalidCustomerIdException {
		Optional<Customer> optCustomer = customerRepository.findById(id);
		if(!optCustomer.isPresent()) {
			throw new InvalidCustomerIdException("Customer ID: "+id+" is invalid. Please provide a valid ID");
		}
		return customerConverter.convertCustomerToCustomerDto(optCustomer.get());
	}

	@Transactional
	@Override
	public CustomerDto editCustomer(CustomerDto customerDto) throws InvalidCustomerIdException {
		findCustomerById(customerDto.getId());
		Customer customer = customerConverter.convertCustomerDtoToCustomer(customerDto);
		customer = customerRepository.save(customer);
		return customerConverter.convertCustomerToCustomerDto(customer);
	}

	@Transactional
	@Override
	public CustomerDto deleteCustomer(Long id) throws InvalidCustomerIdException {
		CustomerDto customerDto = findCustomerById(id);
		Customer customer = customerConverter.convertCustomerDtoToCustomer(customerDto);
		customerRepository.delete(customer);
		return customerConverter.convertCustomerToCustomerDto(customer);
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> allCustomers = customerRepository.findAll();
		return allCustomers
				.stream()
				.map(customerConverter::convertCustomerToCustomerDto)
				.collect(Collectors.toList());
	}
	
}
