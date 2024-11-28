package com.springbook.biz.controller;

public class ViewResolver {
	
	public String prefix;
	public String suffix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewname) {
		return prefix + viewname + suffix;
	}
	
	
	

}
