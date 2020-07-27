package com.yc.project.mybike.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.project.mybike.bean.PayModel;
import com.yc.project.mybike.service.BikeService;
import com.yc.project.mybike.service.PayService;
import com.yc.project.mybike.service.UserService;

import io.swagger.annotations.Api;

@Controller
@Api(value = "结算操作接口", tags = { "账单" })
public class PayController {
	@Autowired
	private UserService userService;
	@Autowired
	private BikeService bikeService;
	@Autowired
	private PayService payService;
	
	@PostMapping("/payMoney")
	public @ResponseBody JsonModel payMoney(JsonModel jm,PayModel pm) {
		try {
			payService.pay(  pm );     
			jm.setCode(1);
		} catch (Exception e) {
			e.printStackTrace();
			jm.setCode(0);
			jm.setMsg(  e.getMessage());
		}
		return jm;
	}
}