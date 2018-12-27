package com.invillia.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.invillia.acme.model.OrderItem;
import com.invillia.acme.service.OrderItemService;

@Controller
@RequestMapping(name="/orderitem")
public class OrderItemController {

	
	@Autowired
	private OrderItemService orderItemService;
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView create(@RequestParam("orderid") Long orderid, @RequestBody OrderItem pOrderItem) {
		System.out.println("orderid="+orderid);
		
		return null;
	}
	
}
