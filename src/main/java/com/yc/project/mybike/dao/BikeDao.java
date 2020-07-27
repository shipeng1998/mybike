package com.yc.project.mybike.dao;

import java.util.List;

import com.yc.project.mybike.bean.Bike;

public interface BikeDao {
	/**
	 * 新增一个新车入库
	 * @param bike
	 * @return
	 */
	public Bike addBike(Bike bike);
	
	/**
	 * 更新（入库，解锁，）
	 * @param bike
	 */
	public void updateBike(Bike bike);
	
	/**
	 * （定位，查车）
	 * @param bid
	 * @return
	 */
	public Bike findBike(String bid);
	
	/**
	 * 查找所有的车
	 * @return
	 */
	public List<Bike> findBikeAll();

}
