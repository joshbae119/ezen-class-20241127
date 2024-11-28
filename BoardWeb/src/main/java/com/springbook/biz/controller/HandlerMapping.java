package com.springbook.biz.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	
	private Map<String, Controller> mapping;
	
	public HandlerMapping() {
		mapping = new HashMap<String, Controller>();
		
		
	}
	
	public Controller getController(String path) {
		return mapping.get(path);
	}

}
