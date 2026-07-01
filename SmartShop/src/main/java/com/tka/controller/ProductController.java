package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tka.model.Product;
import com.tka.service.ProductService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@Controller
public class ProductController {

	private final Product product;
	@Autowired
	ProductService productService;

	ProductController(Product product) {
		this.product = product;
	}
	
	@GetMapping("/product")
	public String getProducts(Model model) {
		List<Product> product = productService.getProducts();
		model.addAttribute("product", product);
		return "product";
	}
	
	@GetMapping("/shop")
	public String getShopProducts(HttpSession session, Model model) {
		String username =(String) session.getAttribute("username");
		if(username == null) {
			model.addAttribute("msg", "Please Login First");
			return "login";
		}

		List<Product> product = productService.getProducts();
		model.addAttribute("product", product);
		return "shop";
	}
	
	@PostMapping("/add-to-cart/{pid}")
	public String addProductToCart(@PathVariable int pid, Model model) {
		Product cartProduct = productService.addProductToCart(pid);
		List<Product> shopProduct = productService.getProducts();
		model.addAttribute("product", shopProduct);
		model.addAttribute("mesag", cartProduct.getProductname()+"is added to cart");

		return "shop";
	}
	
	@GetMapping("/cart")
	public String getCart(HttpSession session, Model model) {
			String username =(String) session.getAttribute("username");
			if(username == null) {
				model.addAttribute("msg", "Please Login First");
				return "login";
			}
		List<Product> cartProduct = productService.getCartProducts();
		 
		if ( cartProduct.isEmpty()) {
	        model.addAttribute("msg", "Cart is Empty! Add products.");
	        return "cart";
	    }
		model.addAttribute("cartproduct", cartProduct);
		 double totalAmount = productService.getCartTotalAmount();
			model.addAttribute("totalAmount", totalAmount);
		
		return "cart";
		
	}
	
	@PostMapping("/remove-from-cart/{pid}")
	public String removeFromCart(@PathVariable int pid, Model model) {

	    productService.removeFromCart(pid);

      List<Product> cartProduct = productService.getCartProducts();
      if ( cartProduct.isEmpty()) {
	        model.addAttribute("msg", "Cart is Empty! Add products.");
	        return "cart";
	    }
     
		model.addAttribute("cartproduct", cartProduct);
		 double totalAmount = productService.getCartTotalAmount();
		model.addAttribute("totalAmount", totalAmount);

	    return "cart";
	}
	
	@GetMapping("/shop-now")
	public String getBill(Model model) {
			
			Object billProducts = productService.getProductBill();
			model.addAttribute("billProduct", billProducts);
			model.addAttribute("totalAmount", productService.getCartTotalAmount());
			
			return "bill";
			
		
	}
	
	@GetMapping("/bill")
	public String getBill(HttpSession session, Model model) {
			String username =(String) session.getAttribute("username");
			if(username == null) {
				model.addAttribute("msg", "Please Login First");
				return "login";
			}
			List<Product> billProducts = productService.getProductBill();
			model.addAttribute("billProduct", billProducts);
			model.addAttribute("totalAmount", productService.getCartTotalAmount());

			return "bill";
			
		
	}
	
	@PostMapping("/order")
	public String getorderpage() {
		return "Gretting";
	}
}
