package com.chs.customerApi.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.chs.customerApi.dto.OrderDto;
import com.chs.customerApi.entity.Order;

@Configuration
public class OrderConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public OrderDto convertOrderToOrderDto(Order order) {
		return modelMapper.map(order, OrderDto.class);
	}
	
	public Order convertOrderDtoToOrder(OrderDto orderDto) {
		return modelMapper.map(orderDto, Order.class);
	}
	
}
