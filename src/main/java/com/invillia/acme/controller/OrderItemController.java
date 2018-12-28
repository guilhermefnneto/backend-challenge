package com.invillia.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.invillia.acme.model.Order;
import com.invillia.acme.model.OrderItem;
import com.invillia.acme.service.OrderItemService;
import com.invillia.acme.service.OrderService;

@Controller
@RequestMapping("/orderitem")
public class OrderItemController {

	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView create(@RequestParam("orderid") Long orderid, @RequestBody OrderItem pOrderItem) {
		ModelAndView mv = new ModelAndView();
		
		Order order = orderService.read(new Order(orderid));
		if (order != null) {
			pOrderItem.setOrder(order);
			boolean created = orderItemService.create(pOrderItem);
			mv.addObject("created", created);
		} else {
			mv.addObject("created", "order not found");
		}
		
		return mv;
	}
	
}
