package com.fuxi.dto;

import com.google.common.collect.Maps;
import java.util.Map;

public class ResultDto {
	
	private Map<String, Object> head = Maps.newHashMap();
	private Object body;
	
	public Map<String, Object> getHead() {
		return head;
	}
	public void setHead(Map<String, Object> head) {
		this.head = head;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	
}
