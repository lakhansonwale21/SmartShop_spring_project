package com.tka.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;


@Aspect
@Component
public class MyAspect {
	
	@Before("execution(* com.tka.controller.ProductController.getShopProducts(..)) ||"+
			"execution(* com.tka.controller.ProductController.getCart(..)) ||"+
			"execution(* com.tka.controller.ProfileController.getProfile(..)) ||"+
			"execution(* com.tka.controller.SmartShopAppController.getLoggedOut(..)) ||")
	public String triggerLogin(HttpSession session, Model model) {
		String username =(String) session.getAttribute("username");
		if(username == null) {
			model.addAttribute("msg", "Please Login First");
			return "login";
		}
		return null;
	}
}
