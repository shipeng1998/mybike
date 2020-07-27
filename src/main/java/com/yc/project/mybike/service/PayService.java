package com.yc.project.mybike.service;

import com.yc.project.mybike.bean.PayModel;

public interface PayService {
	
	/**
	 * 1. 计算金额
	 * 2. 将数据保存到mongo的  payLog      (  uuid,phoneNum,openId, 结账时间(年月日小时)  起(经纬),时间, 止(经纬) ,时间, 花费)
	 * 3. 修改单车的经纬度, 状态为1
	 * 4. 用户态: status    , balance-花费.   
	 * @param payModel
	 */
	public void pay(  PayModel payModel);
}