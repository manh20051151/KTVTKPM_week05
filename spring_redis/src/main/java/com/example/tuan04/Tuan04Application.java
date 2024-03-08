package com.example.tuan04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Product;
import respository.ProductDao;

@SpringBootApplication
@RestController
@RequestMapping("/product")
@ComponentScan(basePackages = {"respository"})
public class Tuan04Application {
	@Autowired
	private ProductDao dao;
	
	@PostMapping
	public Product save(@RequestBody Product product) {
		return dao.save(product);
	}
	@GetMapping
	public List<Product> getAllProduct(){
		return dao.findAll();
	}
	
	@GetMapping("/{id}")
	public Product findP(@PathVariable int id) {
		return dao.findPById(id);
	}
	
	@DeleteMapping("/{id}")
	public String remote(@PathVariable int id) {
		return dao.delete(id);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Tuan04Application.class, args);
	}

}
