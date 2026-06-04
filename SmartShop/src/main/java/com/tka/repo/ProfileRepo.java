package com.tka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.model.Customer;

@Repository
public interface ProfileRepo extends JpaRepository<Customer, Integer> {

}
