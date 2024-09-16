package com.chs.customerApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chs.customerApi.dto.CustomerDto;
import com.chs.customerApi.exception.InvalidCustomerDetalisException;
import com.chs.customerApi.exception.InvalidCustomerIdException;
import com.chs.customerApi.serviceImpl.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerServiceImple;

	@PostMapping("/create")
	public ResponseEntity<CustomerDto> saveCutomerDto(@RequestBody CustomerDto customerDto){
		CustomerDto savedCustomerDto = customerServiceImple.saveCustomer(customerDto);
		return new ResponseEntity<CustomerDto>(savedCustomerDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CustomerDto> findCustomerDto(@PathVariable Long id) throws InvalidCustomerIdException{
		CustomerDto customerDto = customerServiceImple.findCustomerById(id);
		return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<List<CustomerDto>> findAllCustomerDtos(){
		List<CustomerDto> allCustomerDtos = customerServiceImple.getAllCustomers();
		return new ResponseEntity<List<CustomerDto>>(allCustomerDtos, HttpStatus.OK);		
	}
	
	@PutMapping("/update")
	public ResponseEntity<CustomerDto> editCustomerDto(@RequestBody CustomerDto customerDto) throws InvalidCustomerIdException{
		CustomerDto editedCustomerDto = customerServiceImple.editCustomer(customerDto);
		return new ResponseEntity<CustomerDto>(editedCustomerDto, HttpStatus.OK);
	}
	
	@PatchMapping("/edit")
	public ResponseEntity<CustomerDto> patchCustomerDto(@RequestBody CustomerDto customerDto) throws InvalidCustomerIdException{
		CustomerDto existingCustomerDto = customerServiceImple.findCustomerById(customerDto.getId());
		if(customerDto.getFirstName() != null) {
			existingCustomerDto.setFirstName(customerDto.getFirstName());
		}
		if(customerDto.getLastName() != null) {
			existingCustomerDto.setLastName(customerDto.getLastName());
		}
		if(customerDto.getPhoneNumber() != null) {
			existingCustomerDto.setPhoneNumber(customerDto.getPhoneNumber());
		}
		if(customerDto.getEmail() != null) {
			existingCustomerDto.setEmail(customerDto.getEmail());
		}
		existingCustomerDto = customerServiceImple.editCustomer(existingCustomerDto);
		return new ResponseEntity<CustomerDto>(existingCustomerDto, HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<CustomerDto> findCustomerByName(@RequestParam String firstName, @RequestParam String lastName) throws InvalidCustomerDetalisException{
		CustomerDto customerDto = customerServiceImple.findCustomerByFullName(firstName, lastName);
		return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CustomerDto> deleteCustomerDto(@PathVariable Long id) throws InvalidCustomerIdException{
		CustomerDto customerDto = customerServiceImple.deleteCustomer(id);
		return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.OK);
	}
	
}
