package com.invillia.acme.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.invillia.acme.model.OrderItem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderItemControllerTest {

	
	private final String baseUrl = "http://localhost:9000/orderitem/";
	
	
	@Test
	public void testCreateOrderItem() throws URISyntaxException {
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI(baseUrl + "create?orderid=1");

		OrderItem orderItem = new OrderItem("Macaco", new BigDecimal(150.00), new BigInteger("1"));
		
		HttpEntity<OrderItem> request = new HttpEntity<>(orderItem);
		
        ModelAndView mav = rest.postForObject(uri, request, ModelAndView.class);
        
        System.out.println(mav.getModel().get("created")); 
	}
	
}
