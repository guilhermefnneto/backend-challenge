package com.invillia.acme.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.invillia.acme.model.Store;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreControllerTest {
		
	
	// Create Store
//    @Test
    public void testCreateStore() throws URISyntaxException {
    	RestTemplate rest = new RestTemplate();
    	
    	final String baseUrl = "http://localhost:9000/store/create";
        URI uri = new URI(baseUrl);
        
        Store store = new Store("Oficina Tavares", "R. Aldo Tavares, 12");
        
        HttpEntity<Store> request = new HttpEntity<>(store);
        
        ModelAndView mav = rest.postForObject(uri, request, ModelAndView.class);
        
        System.out.println(mav.getModel().get("created"));        
    }
    
    
    // Update Store
//    @Test
    public void testUpdateStore() throws URISyntaxException {
    	RestTemplate rest = new RestTemplate();
    	
    	final String baseUrl = "http://localhost:9000/store/update/6";
        URI uri = new URI(baseUrl);
        
        Store store = new Store("Oficina Sol", "R. Campos Sales, 323");
        
        HttpEntity<Store> request = new HttpEntity<>(store);
        
        rest.put(uri.toString(), request);
    }
    
    
    // Read Store by parameters
    @Test
    public void testReadStoreByParameters() throws URISyntaxException {
    	RestTemplate rest = new RestTemplate();
    	
    	final String baseUrl = new String("http://localhost:9000/store/read?name=Oficina%20Tavares");
    	
        URI uri = new URI(baseUrl);
        
        List<Store> stories = (List<Store>) rest.getForObject(uri, List.class);
        
        System.out.println(stories.size());
    }
    
	
}
