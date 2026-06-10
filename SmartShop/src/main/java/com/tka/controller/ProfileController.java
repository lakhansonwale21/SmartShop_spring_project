package com.tka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tka.model.Customer;
import com.tka.service.CustomerService;
import com.tka.service.ProfileService;

import jakarta.servlet.http.HttpSession;

@Component
@Controller
public class ProfileController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/profile")
	public String getProfile(HttpSession session, Model model) {
		
		String username =(String) session.getAttribute("username");
		if(username == null) {
			model.addAttribute("msg", "Please Login First");
			return "login";
		}

		Customer customer = customerService.getcustomerByUsername(username);
		
		model.addAttribute("customer", customer);
		return "profile";
	}
}
