package com.univesre.onlineshop.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.univesre.onlineshop.domain.SalesItem;
import com.univesre.onlineshop.domain.ShoppingCart;
import com.univesre.onlineshop.service.OnlineshopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class SalesItemController {
	
	
	@Autowired
	@Qualifier("onlineshopService")
	private OnlineshopService onlineshopService;
	
	@RequestMapping(value="/mainpage")
	public String selectSalesItem(@ModelAttribute SalesItem salesItem, Model model) {

		// 创建对象列表(集合);
		List<SalesItem> salesItems = onlineshopService.showItems();
		model.addAttribute("salesItems", salesItems);

		return "customer_sales/session_test";
	}

	@RequestMapping(value="/shoppingcart", method=RequestMethod.GET)
	public String shoppingCart(@ModelAttribute ShoppingCart shoppingCart, HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {	// @RequestParam("demo_1") Integer int1,
		//@ModelAttribute SalesItem salesItem, Model model
		
//		System.out.println(request.getParameter("demo_1"));
//		request.getParameterValues(arg0);
//		用request.getParameterNames();
		
		HashMap<String, Integer> itemsInCart = new HashMap<String, Integer>();
		Enumeration<String> enu = request.getParameterNames();
		while(enu.hasMoreElements()) {  
			String paraName = (String) enu.nextElement();
			itemsInCart.put(paraName, Integer.valueOf(request.getParameter(paraName)));
			System.out.println(paraName + ":" + request.getParameter(paraName));  
		}
		model.addAttribute("cartItems", itemsInCart);	// 会自动将"cartItems"加入到requestScope中;
		
		return "customer_sales/shoppingcart";
	}
	
//	@RequestMapping(value="/shoppingcart")
//	public ModelAndView showShoppingCart(HttpServletRequest request) {
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("shoppingcart");
//		
//		HashMap<String, Integer> itemsInCart = new HashMap<String, Integer>();
//		Enumeration<String> enu=request.getParameterNames();
//		while(enu.hasMoreElements()) {  
//			String paraName = (String) enu.nextElement();
//			itemsInCart.put(paraName, Integer.valueOf(request.getParameter(paraName)));
//			System.out.println(paraName + ": " + request.getParameter(paraName));  
//		}
//		
//		mav.addObject("itemsInCart", itemsInCart);
//		
//		return mav;
//	}
	
	
	
}
