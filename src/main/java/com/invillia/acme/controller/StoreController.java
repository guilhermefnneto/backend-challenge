package com.invillia.acme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.invillia.acme.model.Store;
import com.invillia.acme.service.StoreService;

@Controller
@RequestMapping("/store")
public class StoreController {
	
	
	@Autowired
	private StoreService storeService;
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView create(@RequestBody Store pStore) {
		boolean created = storeService.create(pStore);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("created", created);
		
		return mv;
	}
	
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public ModelAndView read(@RequestParam("name") String name) {
		System.out.println("read by name: " + name);
		List<Store> stories = storeService.readByName(name);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("stories", stories);
		
		System.out.println("size: " + stories.size());
		
		return mv;
	}
	
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public ModelAndView update(@PathVariable("id") Long id, @RequestBody Store pStore) {
		boolean updated = storeService.update(id, pStore);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("updated", updated);
		
		return mv;
	}
	
}
