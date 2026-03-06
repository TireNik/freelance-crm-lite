package com.kika.customerservice.repository;

import com.kika.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Override
    @EntityGraph(attributePaths = "owner")
    List<Customer> findAll();

    @EntityGraph(attributePaths = "owner")
    Customer save(Customer customer);
}