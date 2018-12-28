package com.invillia.acme.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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
	
	
	private final String baseUrl = "http://localhost:9000/store/";
		
	
	// Create Store
    @Test
    public void testCreateStore() throws URISyntaxException {
    	RestTemplate rest = new RestTemplate();
    	
        URI uri = new URI(baseUrl + "create");
        
        Store store = new Store("Oficina Tavares", "R. Aldo Tavares, 12");
        
        HttpEntity<Store> request = new HttpEntity<>(store);
        
        ModelAndView mav = rest.postForObject(uri, request, ModelAndView.class);
        
        System.out.println(mav.getModel().get("created"));        
    }
    
    
    // Update Store
//    @Test
    public void testUpdateStore() throws URISyntaxException {
    	RestTemplate rest = new RestTemplate();
    	
        URI uri = new URI(baseUrl + "update/6");
        
        Store store = new Store("Oficina Sol", "R. Campos Sales, 323");
        
        HttpEntity<Store> request = new HttpEntity<>(store);
        
        rest.put(uri.toString(), request);
    }
    
    
    // Read Store by parameters
//    @Test
    public void testReadStoreByParameters() throws URISyntaxException {
    	RestTemplate rest = new RestTemplate();
    	    	
        URI uri = new URI(baseUrl + "read?name=Oficina%20Tavares");
        
        List<Store> stories = (List<Store>) rest.getForObject(uri, List.class);
        
        System.out.println(stories.size());
    }
    
	
}
