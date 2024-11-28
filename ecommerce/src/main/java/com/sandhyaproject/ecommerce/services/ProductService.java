package com.sandhyaproject.ecommerce.services;
import org.springframework.data.domain.Sort;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandhyaproject.ecommerce.models.Product;
import com.sandhyaproject.ecommerce.repositories.ProductRepository;

@Service
public class ProductService {

@Autowired
private ProductRepository productRepository;

public List<Product>getAllProducts(){
	return productRepository.findAll();	
}
public List<Product>getProducts(){
	List<Product> products = productRepository.findAll(Sort.by(Sort.Direction.ASC, "stock"));	
	return products;
}
}
