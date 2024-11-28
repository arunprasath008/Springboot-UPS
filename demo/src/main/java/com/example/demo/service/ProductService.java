package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository pR;
	public List<Product>getAllProducts(){
		return pR.findAll();
	}

}
