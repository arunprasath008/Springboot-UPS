package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner{
	@Autowired
	private ProductRepository productRepository;
	@Override
	public void run(String  ...args)throws Exception{
		if(productRepository.count()==0) {

			List<Product> products = Arrays.asList(
				    new Product("OPPO F21s Pro 5G", 245.67, "OPPO F21s Pro 5G is a powerful device with a RAM extension feature, that offers brilliant operational speed to users.", "Mobile Phones", "Amazon"),
				    new Product("WRISTIO HD, Bluetooth Calling Smart Watch", 150.32, "Minix watches are exclusively designed to fulfill the advanced tech needs of today’s generation.", "Accessories", "Flipkart"),
				    new Product("Dell Inspiron 3511 Laptop", 440.57, "Dell Inspiron 3511 11th Generation Intel Core i5-1135G7 Processor (8MB Cache, up to 4.2 GHz);Operating System: Windows 10 Home Single Language, English", "Laptops", "Ebay"),
				    new Product("Lenovo IdeaPad Slim 3 Laptop", 250.45, "Lenovo IdeaPad Slim 311th Gen Intel Core i5-1135G7 | Speed: 2.4 GHz (Base) - 4.2 GHz (Max) | 4 Cores | 8 Threads | 8 MB Cache", "Laptops", "Ebay"),
				    new Product("ASUS VivoBook 15 Laptop", 767.32, "ASUS VivoBook 15 15.6-inch (39.62 cm) HD, Dual Core Intel Celeron N4020, Thin and Light Laptop (4GB RAM/256GB SSD/Integrated Graphics/Windows 11 Home/Transparent Silver/1.8 Kg), X515MA-BR011W", "Laptops", "Ebay"),
				    new Product("PTron Newly Launched Tangent Sports, 60Hrs Playtime", 15.46, "Gigantic 60+ Hours of music playtime on a single charge; BT5.2 Wireless headphones with ENC (Environmental Noise Cancellation) Technology to enhance your voice quality over the voice calls", "Headphones", "Amazon"),
				    new Product("Campus Men's Maxico Running Shoes", 10.12, "The high raised back cover with extra padding.", "Sports", "Ebay")
				);
			
			productRepository.saveAll(products);
			System.out.println("DemoData seeded");
		
		}
		
	 
	}
}

