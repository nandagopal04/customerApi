package com.chs.customerApi.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chs.customerApi.converter.OrderConverter;
import com.chs.customerApi.dto.OrderDto;
import com.chs.customerApi.entity.Customer;
import com.chs.customerApi.entity.Order;
import com.chs.customerApi.exception.InvalidCustomerIdException;
import com.chs.customerApi.exception.InvalidOrderIdException;
import com.chs.customerApi.repository.CustomerRepository;
import com.chs.customerApi.repository.OrderRepository;
import com.chs.customerApi.service.OrderService;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderConverter orderConverter;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional
	@Override
	public OrderDto saveOrderDto(OrderDto orderDto) {
		Order order = orderConverter.convertOrderDtoToOrder(orderDto);
		order = orderRepository.save(order);
		return orderConverter.convertOrderToOrderDto(order);
	}

	@Override
	public OrderDto findOderDtoById(Long id) throws InvalidOrderIdException {
		Optional<Order> optOrder = orderRepository.findById(id);
		if(!optOrder.isPresent()) {
			throw new InvalidOrderIdException();
		}
		return orderConverter.convertOrderToOrderDto(optOrder.get());
	}

	@Transactional
	@Override
	public OrderDto editOrderDto(OrderDto orderDto) throws InvalidOrderIdException {
		Order order = orderConverter.convertOrderDtoToOrder(orderDto);
		orderDto = findOderDtoById(order.getId());
		order = orderRepository.save(order);
		return orderConverter.convertOrderToOrderDto(order);
	}

	@Transactional
	@Override
	public OrderDto deleteOrderDto(Long id) throws InvalidOrderIdException {
		OrderDto orderDto = findOderDtoById(id);
		Order order = orderConverter.convertOrderDtoToOrder(orderDto);
		orderRepository.delete(order);
		return orderConverter.convertOrderToOrderDto(order);
	}

	@Override
	public List<OrderDto> getAllOrders() {
		List<Order> allOrders = orderRepository.findAll();
		return convertOrdersToOrderDtos(allOrders);
	}

	@Override
	public List<OrderDto> getAllOrdersOfCutomer(Long id) throws InvalidCustomerIdException {
		Optional<Customer> optCustomer = customerRepository.findById(id);
		if(!optCustomer.isPresent()) {
			throw new InvalidCustomerIdException("Invlid Customer ID: "+id);
		}
		
		List<Order> allOrdersOfCustomer = orderRepository.findAllByCustomer(optCustomer.get());
		return convertOrdersToOrderDtos(allOrdersOfCustomer);
	}
	
	private List<OrderDto> convertOrdersToOrderDtos(List<Order> allOrders){
		return allOrders.stream().map(orderConverter::convertOrderToOrderDto).collect(Collectors.toList());
	}

}
