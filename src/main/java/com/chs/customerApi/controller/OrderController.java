package com.chs.customerApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chs.customerApi.dto.OrderDto;
import com.chs.customerApi.exception.InvalidCustomerIdException;
import com.chs.customerApi.exception.InvalidOrderIdException;
import com.chs.customerApi.serviceImpl.OrderServiceImpl;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@PostMapping("/create")
	public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDto orderDto){
		OrderDto savedOrderDto = orderServiceImpl.saveOrderDto(orderDto);
		return new ResponseEntity<OrderDto>(savedOrderDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<OrderDto> findOrderDto(@PathVariable Long id) throws InvalidOrderIdException{
		OrderDto orderDto = orderServiceImpl.findOderDtoById(id);
		return new ResponseEntity<OrderDto>(orderDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<List<OrderDto>> findAllOrders(){
		List<OrderDto> allOrderDtos = orderServiceImpl.getAllOrders();
		return new ResponseEntity<List<OrderDto>>(allOrderDtos, HttpStatus.OK);
	}
	
	@GetMapping("/get/customer/{id}")
	public ResponseEntity<List<OrderDto>> findAllOrderDtosOfCustomer(@PathVariable Long id) throws InvalidCustomerIdException{
		List<OrderDto> allOrderDtosOfCustomer = orderServiceImpl.getAllOrdersOfCutomer(id);
		return new ResponseEntity<List<OrderDto>>(allOrderDtosOfCustomer, HttpStatus.OK);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<OrderDto> editOrderDto(@RequestBody OrderDto orderDto) throws InvalidOrderIdException{
		OrderDto editedOrderDto = orderServiceImpl.editOrderDto(orderDto);
		return new ResponseEntity<OrderDto>(editedOrderDto, HttpStatus.OK);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<OrderDto> patchOrderDto(@RequestBody OrderDto orderDto) throws InvalidOrderIdException{
		OrderDto existingOrderDto = orderServiceImpl.findOderDtoById(orderDto.getId());
		if(orderDto.getName() != null) {
			existingOrderDto.setName(orderDto.getName());
		}
		if(orderDto.getCost() != null) {
			existingOrderDto.setCost(orderDto.getCost());
		}
		if(orderDto.getCustomer() != null) {
			existingOrderDto.setCustomer(orderDto.getCustomer());
		}
		existingOrderDto = orderServiceImpl.editOrderDto(existingOrderDto);
		return new ResponseEntity<OrderDto>(existingOrderDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<OrderDto> deleteOrderDto(@PathVariable Long id) throws InvalidOrderIdException{
		OrderDto deletedOrderDto = orderServiceImpl.deleteOrderDto(id);
		return new ResponseEntity<OrderDto>(deletedOrderDto, HttpStatus.OK);
	}

}
