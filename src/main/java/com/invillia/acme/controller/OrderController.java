package com.invillia.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.invillia.acme.model.Order;
import com.invillia.acme.model.Store;
import com.invillia.acme.service.OrderService;
import com.invillia.acme.service.StoreService;

@Controller
@RequestMapping("/order")
public class OrderController {

	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView create(@RequestParam("storeid") Long storeid, @RequestBody Order pOrder) {
		ModelAndView mv = new ModelAndView();
		
		Store rStore = storeService.read(new Store(storeid));
		if (rStore != null) {
			pOrder.setStore(rStore);
			boolean created = orderService.create(pOrder);			
			mv.addObject("created", created);		
		} else {
			mv.addObject("created", "store not found");
		}
		
		return mv;
	}
	
	
//	@RequestMapping(name="/{orderid}/additem", method=RequestMethod.POST)
//	public ModelAndView addItem(@PathVariable("orderid") Long orderid, @RequestBody OrderItem pOrderItem) {
//		ModelAndView mv = new ModelAndView();
//		
//		Order rOrder = orderService.read(new Order(orderid));
//		if (rOrder != null) {
//			boolean added = orderService.addItem(rOrder, pOrderItem);
//			mv.addObject("addeditem", added);
//		} else {
//			mv.addObject("addeditem", "order not found");
//		}
//		
//		return mv;
//	}
	
}
