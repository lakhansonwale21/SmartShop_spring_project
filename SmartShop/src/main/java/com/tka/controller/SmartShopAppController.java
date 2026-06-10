package com.tka.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Component
@Controller
public class SmartShopAppController {

	
	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	@GetMapping("/home")
	public String getHomePage(HttpSession session, Model model) {
		String username =(String) session.getAttribute("username");
		if(username == null) {
			model.addAttribute("msg", "Please Login First");
			return "login";
		}
		return "home";
	}
	
	@GetMapping("/register")
	public String getRegisterPage() {
		return "register";
	}
	
	@GetMapping("/logout")
	public String getLoggedOut(HttpSession session, Model model) {
		String username =(String) session.getAttribute("username");
		if(username == null) {
			model.addAttribute("msg", "Please Login First");
			return "login";
		}

		session.invalidate();
		return "index";
	}
}
