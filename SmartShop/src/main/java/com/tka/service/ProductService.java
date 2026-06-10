package com.tka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.model.Product;
import com.tka.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;
	
	List<Product> cartProduct;
	
	public ProductService() {
		if(cartProduct == null)
			cartProduct = new ArrayList<>();
	}
	
	public List<Product> getProducts() {
		
		List<Product> product = productRepo.findAll();
		
		return product;
	}
	
public Product getProductById(int pid) {
		return productRepo.findById(pid).orElse(null);
		
	}
	
public List<Product> getCartProducts() {
		
		return cartProduct;
	}

	public Product addProductToCart(int pid) {
		
		Product product = getProductById(pid);
		cartProduct.add(product);
		return product;
		
	}

	public void removeFromCart(int pid) {
		cartProduct.removeIf(product -> product.getPid() == pid);
		
	}

	public List<Product> getProductBill() {
		return cartProduct;
	}

	public double getCartTotalAmount() {
		 double total = 0;
		 for(Product product : cartProduct) {
			 total += product.getPrice();
		 }
		return total;
	}

}
