package com.example.demo;

import java.util.Map;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product")
@SpringBootApplication
public class ProductController {
	private ProductService ps;
//	@GetMapping("/products")
	
//	public List<Map<String, Object>> getAllProducts(){
//		return Arrays.asList(
//				Map.of("name","product","price",234),
//				Map.of("name","product","price",134));
		
//	}
	@Autowired
	public ProductController(ProductService ps) {
		this.ps = ps;
	}
	public List<Product> getAllProducts(){
		return ps.getAllProducts();
	}
	@GetMapping("/product/category")
	public List<Map<String,Object>> getCategory(){
		return Arrays.asList(
				Map.of("name","product","price",234),
				Map.of("name","product","price",134)
				);
	}
}


