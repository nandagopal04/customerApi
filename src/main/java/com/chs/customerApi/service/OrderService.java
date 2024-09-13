package com.chs.customerApi.service;

import java.util.List;

import com.chs.customerApi.dto.OrderDto;
import com.chs.customerApi.exception.InvalidCustomerIdException;
import com.chs.customerApi.exception.InvalidOrderIdException;

public interface OrderService {
	
	OrderDto saveOrderDto(OrderDto orderDto);
	OrderDto findOderDtoById(Long id) throws InvalidOrderIdException;
	OrderDto editOrderDto(OrderDto orderDto) throws InvalidOrderIdException;
	OrderDto deleteOrderDto(Long id) throws InvalidOrderIdException;
	List<OrderDto> getAllOrders();
	List<OrderDto> getAllOrdersOfCutomer(Long id) throws InvalidCustomerIdException;
	
}
