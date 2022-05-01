package org.grocery.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SellerController {

	@GetMapping("/sellerlist")
	public String  findAllSeller()
	{
		return "admin/seller-list";
	}
	
	@GetMapping("/addseller")
	public String addSeller()
	{
		return "admin/add-seller";
		
	}
	
	@GetMapping("/updateseller/{sellerId}")
	public ModelAndView updateSeller (@PathVariable("sellerId") long sellerId)  
	{
		Map<String,Integer> model=new HashMap<String,Integer>();
		model.put("sellerId",(int) sellerId);
		return new ModelAndView("admin/update-seller",model);	
		
	
	}
	
	
}
