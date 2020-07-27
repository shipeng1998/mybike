package com.yc.project.mybike.service;

import java.util.List;

import com.yc.project.mybike.bean.Bike;



//业务层

public interface BikeService {
	/**
	 * 报修
	 * @param bike
	 */
	public void reportMantinant(Bike bike);
	
	/**
	 * 开锁
	 * 1.bid 必须 ，看车的状态
	 * @param bike
	 */
	public void open(Bike bike);
		
	
	
	/**
	 * 查车
	 * @param bid
	 * @return
	 */
	public Bike findByBid(String bid);
	
	
	
	/**
	 * 添加一个新车
	 * @param bike
	 * @return
	 */
	public Bike addNewBike(Bike bike);
	
	
	public List<Bike> findNear(Bike bike);
	
	/**
	 * 查询所有的车
	 * @return
	 */
	public List<Bike> findAll();
		
	
	
	

}
