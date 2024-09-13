package com.chs.customerApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chs.customerApi.entity.Customer;
import com.chs.customerApi.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findAllByCustomer(Customer customer);

}
