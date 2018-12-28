package com.invillia.acme.controller;

import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.invillia.acme.model.Payment;
import com.invillia.acme.model.PaymentStatus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentControllerTest {

	
	private final String baseUrl = "http://localhost:9000/payment/";
	
	
	@Test
	public void testCreatePaymentForOrder() throws URISyntaxException {
		RestTemplate rest = new RestTemplate();
		URI uri = new URI(baseUrl+"create?orderid=1");
		
		Payment payment = new Payment();
		payment.setCredCardNumber(new BigInteger("4003214568718"));
		payment.setDate(Calendar.getInstance());
		payment.setStatus(PaymentStatus.PAID);
		
		HttpEntity<Payment> request = new HttpEntity<Payment>(payment);
		
		ResponseEntity<ModelAndView> response = rest.postForEntity(uri, request, ModelAndView.class);
		
		System.out.println(response.getBody().getModel().get("created"));
	}
	
}
