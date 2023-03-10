package com.example.salesInventory.repository;

import com.example.salesInventory.model.Customer;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
public interface CustomerRepository extends JpaRepository<Long, Customer> {
}
