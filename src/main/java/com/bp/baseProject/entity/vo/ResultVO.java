package com.bp.baseProject.entity.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultVO<T> {
	

//	private int currentPage;
//	private int pageSize;
//	private int totalPage;
//	private int count;
	private String code = "001";
	private String message = "success";
//	private String remark;
//	private List<T> list;
//	private T t;
	
	private Map<String , Object> data = new HashMap<String , Object>();
	
	
	
	public ResultVO(List<T> list, int count, double pageSize){
		this.data.put("list", list);
		this.data.put("count", count);
		this.data.put("pageSize", (int)Math.ceil(count/pageSize));
	}
	public ResultVO(List<T> list){
		this.data.put("list", list);
	}
	
	
	public ResultVO(T t){
		this.data.put("vo", t);
	}
	
	public ResultVO(String code , String message){
		this.code = code;
		this.message = message;
	}
	
	public ResultVO(Map<String , Object> data , String code , String message) {
		this.data = data;
		this.code = code;
		this.message = message;
	}
	
	public ResultVO() {
	}

	
	

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	
	

}
