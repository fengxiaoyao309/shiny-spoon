package com.hnit.shopping.vo;


public class ResultVO {
	private int code;
	private String msg;
	private Object data;
	
	public ResultVO(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
		
	}
	public ResultVO(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
