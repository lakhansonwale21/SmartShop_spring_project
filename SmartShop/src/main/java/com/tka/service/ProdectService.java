package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.model.Product;
import com.tka.repo.ProductRepo;

@Service
public class ProdectService {

	@Autowired
	ProductRepo productRepo;
	
	public List<Product> getProducts() {
		
		List<Product> product = productRepo.findAll();
		
		return product;
	}

}
