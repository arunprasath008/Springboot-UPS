package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
	
}