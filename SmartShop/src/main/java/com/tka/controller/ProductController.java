package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tka.model.Product;
import com.tka.service.ProdectService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {

	@Autowired
	ProdectService prodectService;
	
	@GetMapping("/product")
	public String getProducts(Model model) {
		List<Product> product = prodectService.getProducts();
		model.addAttribute("product", product);
		return "product";
	}
	
	@GetMapping("/shop")
	public String getShopProducts(HttpSession session, Model model) {
		String username =(String) session.getAttribute("username");
		
		if(username == null) {
			model.addAttribute("msgs", "Login First");
			return "login";
		}
		List<Product> product = prodectService.getProducts();
		model.addAttribute("product", product);
		return "shop";
	}
}
