package com.yc.project.mybike.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")  //对应的mongo中的一条记录
public class User implements Serializable {

	private static final long serialVersionUID = 6232279366258848032L;
	private int status; //用户的状态
	//@Indexed(unique=true)
	private String phoneNum;//电话号码  唯一
	private String name;//用户名
	private String idNum;//身份证
	private Double deposit;//押金
	private Double balance;//余额
	@Transient //瞬态化 在数据库中不存储
	private String verifyCode;
	@Indexed(unique=true)
   private String openId;
   private String uuid;
   
   private  String sex;//身份证中获取的性别
   private String birth;//身份证中获取的出身年月
   private String city;//身份证中获取的市
   private String town;//身份证中获取的县
   private String area;//身份证中获取的区域信息
	
	public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getBirth() {
	return birth;
}
public void setBirth(String birth) {
	this.birth = birth;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getTown() {
	return town;
}
public void setTown(String town) {
	this.town = town;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
	public String getOpenId() {
	return openId;
}
public void setOpenId(String openId) {
	this.openId = openId;
}
public String getUuid() {
	return uuid;
}
public void setUuid(String uuid) {
	this.uuid = uuid;
}
	
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public Double getDeposit() {
		return deposit;
	}
	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	@Override
	public String toString() {
		return "User [status=" + status + ", phoneNum=" + phoneNum + ", name=" + name + ", idNum=" + idNum
				+ ", deposit=" + deposit + ", balance=" + balance + ", verifyCode=" + verifyCode + "]";
	}
	
	

}
