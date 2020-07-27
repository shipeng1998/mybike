package com.yc.project.mybike.bean;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.data.annotation.Id;

public class Bike implements Serializable{
	@Override
	public String toString() {
		return "Bike [bid=" + bid + ", status=" + status + ", qrcode=" + qrcode + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", loc=" + Arrays.toString(loc) + ", id=" + id + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bid;
	private int status;
	private String qrcode;
	private Double latitude;
	private Double longitude;
	
	public static final int UNACTIVE=0;//未使用
	public static final int LOCK=1;// 锁定
	public static final int USING=2;//解锁
	public static final int INTROUBLE=3;//报修
	
	
	
	private Double[] loc;
	
	@Id // 对应到mongo _id
	private String id;
	
	private String phoneNum;
	private String[] types;
	private String openid;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Double[] getLoc() {
		return loc;
	}
	public void setLoc(Double[] loc) {
		this.loc = loc;
	}
	

	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
