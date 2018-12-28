package com.invillia.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.invillia.acme.model.Order;
import com.invillia.acme.model.Payment;
import com.invillia.acme.service.OrderService;
import com.invillia.acme.service.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentController {

	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private PaymentService paymentService;
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView create(@RequestParam("orderid") Long orderid, @RequestBody Payment pPayment) {
		ModelAndView mv = new ModelAndView();
		
		Order rOrder = orderService.read(new Order(orderid));
		if (rOrder != null) {
			pPayment.setOrder(rOrder);
			rOrder.setPayment(pPayment);
			boolean created = paymentService.create(pPayment);
			mv.addObject("created", created);
		} else {
			mv.addObject("created", "order not found");
		}
		
		return mv;
	}
	
}
