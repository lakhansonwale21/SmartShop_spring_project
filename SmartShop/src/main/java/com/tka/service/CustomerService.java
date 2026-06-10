package com.tka.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Response.ApiResponse;
import com.tka.model.Customer;
import com.tka.model.LogoutRequest;
import com.tka.repo.CustomerRepo;

@Service
public class CustomerService {

	private final ProductService prodectService;
	@Autowired
	CustomerRepo customerRepo;

	CustomerService(ProductService prodectService) {
		this.prodectService = prodectService;
	}

	public boolean checkLogin(String username, String password) {
		Customer customer = customerRepo.findByUsername(username);

		if (customer != null) {
			System.err.println("Username is Matched...");
			if (password.equals(customer.getPassword())) {
				System.err.println("And Password is also matched");
				return true;
			}
		}
		return true;
	}

	public boolean addCustomer(Customer customer) {
		Customer save = customerRepo.save(customer);

		if (save != null)
			return true;

		return false;
	}

	public Customer getcustomerByUsername(String username) {
		return customerRepo.findByUsername(username);
	}

	public ApiResponse<LogoutRequest> logoutService(LogoutRequest request) {
		ApiResponse<LogoutRequest> response = new ApiResponse<>();
		response.setServerTime(LocalDateTime.now().toString());
		try {
		 
			Customer customer = customerRepo.findById(request.getId()).orElse(null);
			if(request.getId()==null|| request.getCustomerName()==null) {
				response.setShResult(415);
				response.setMessage("Please check the Requets");
				return response;
			}
			if (customer == null) {
				response.setShResult(117);
				response.setMessage("User Not Found Please check the ID");

				return response;

			}
			if (!customer.getUsername().equals(request.getCustomerName())) {
				response.setShResult(100);
				response.setMessage("Logout Successfully");
				return response;

			}

		}
		 catch (Exception e) {
			response.setShResult(401);
			response.setMessage("Invalid Token  OR Expired ");
			return response;

 		}
		return response;

	}
}
