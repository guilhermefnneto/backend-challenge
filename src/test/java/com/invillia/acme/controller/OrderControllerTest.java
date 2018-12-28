package com.invillia.acme.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.invillia.acme.model.Order;
import com.invillia.acme.model.OrderItem;
import com.invillia.acme.model.OrderStatus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerTest {
	
	private final String baseUrl = "http://localhost:9000/order/";

	
//	@Test
	public void testCreateOrder() throws URISyntaxException {
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI(baseUrl + "create?storeid=1");

		Order order = new Order();
		order.setAddress("R. Alameda Vinte, 321");
		order.setConfirmation(Calendar.getInstance());
		order.setStatus(OrderStatus.OPENED);
				
		HttpEntity<Order> request = new HttpEntity<>(order);
		
        ModelAndView mav = rest.postForObject(uri, request, ModelAndView.class);
        
        System.out.println(mav.getModel().get("created"));        
	}
	
	
//	@Test
	public void testReadOrderByParameters() throws URISyntaxException {
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI(baseUrl + "read?id=1");
		
		ResponseEntity<ModelAndView> response = rest.getForEntity(uri, ModelAndView.class);
				
		System.out.println(response.getStatusCode());
	}
	
	
	@Test
	public void testRefundOrder() throws URISyntaxException {
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI(baseUrl + "refund/1");
		
		HttpEntity<Order> request = new HttpEntity<>(new Order());
		
		rest.put(uri, request);		
	}
	
	
}
