package com.chs.customerApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chs.customerApi.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
