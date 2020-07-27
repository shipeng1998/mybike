package com.yc.project.mybike.bean;

import java.util.Map;

public class IdCardResponse {
	private int status;
	private String msg;
	@Override
	public String toString() {
		return "IdCardResponse [status=" + status + ", msg=" + msg + ", result=" + result + "]";
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, String> getResult() {
		return result;
	}
	public void setResult(Map<String, String> result) {
		this.result = result;
	}
	private Map<String,String> result;

}
