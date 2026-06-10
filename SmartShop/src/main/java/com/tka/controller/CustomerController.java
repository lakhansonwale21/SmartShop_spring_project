package com.tka.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.Response.ApiResponse;
import com.tka.model.Customer;
import com.tka.model.LogoutRequest;
import com.tka.service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Component
@Controller

public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/verify-customer")
	public String checkLogin(String username, String password, HttpSession session, Model model) {

		Customer customer = customerService.getcustomerByUsername(username);
		if (customer != null) {
			System.err.println("Username is Matched...");
			session.setAttribute("username", username);
			if (password.equals(customer.getPassword())) {
				System.err.println("And Password is also matched");
				return "home";
			}
		}
		model.addAttribute("msg", "Customer Login Failed.....");
		return "register";
	}

	@PostMapping("/add-customer")
	public String addCustomer(@ModelAttribute Customer customer, Model model) {

		boolean isAdded = customerService.addCustomer(customer);

		if (isAdded) {
			model.addAttribute("msg", " Registration Successful.....");
			return "login";
		}

		model.addAttribute("msg", "Registration Failed.....");
		return "register";
	}

	@PostMapping("/logout")
	public ApiResponse<LogoutRequest> logoutApi(@RequestBody LogoutRequest req) {
		return customerService.logoutService(req);
	}

}