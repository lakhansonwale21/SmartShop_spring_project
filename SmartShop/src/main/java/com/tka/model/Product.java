package com.tka.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Component
@Entity
public class Product {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int pid;
	String productname;
	double price;
	String imagepath;
	
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", productname=" + productname + ", price=" + price + ", imagepath=" + imagepath
				+ "]";
	}
	
	
}
