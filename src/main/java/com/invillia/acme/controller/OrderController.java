package com.invillia.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public ModelAndView read(@RequestParam("id") Long id) {
		ModelAndView mv = new ModelAndView();
		
		Order rOrder = orderService.read(new Order(id));
		if (rOrder != null) {			
			mv.addObject("read", rOrder);
		} else {
			mv.addObject("read", "order not found");
		}
		
		return mv;
	}
	
	
	@RequestMapping(value="/refund/{id}", method=RequestMethod.PUT)
	public ModelAndView refund(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		
		Order rOrder = orderService.read(new Order(id));
		if (rOrder != null) {
			boolean refunded = orderService.refund(rOrder);
			mv.addObject("refund", refunded);
		} else {
			mv.addObject("refund", "order not found");
		}
		
		return mv;
	}
	
}
