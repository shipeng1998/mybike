package com.yc.project.mybike.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.project.mybike.service.LogService;

@Controller
public class LogController {
	@Autowired
	private LogService logService;
	
	@PostMapping("/log/savelog")
	@ResponseBody
	public JsonModel ready(JsonModel jsonModel,@RequestBody String log){
		logService.save(log);
		jsonModel.setCode(1);
		return jsonModel;
	}
	
	@PostMapping("/log/addPayLog")
	@ResponseBody
	public JsonModel addPayLog(JsonModel jsonModel,@RequestBody String log){
		logService.savePayLog(log);
		jsonModel.setCode(1);
		return jsonModel;
	}
	
	@PostMapping("/log/repairLog")
	@ResponseBody
	public JsonModel repairLog(JsonModel jsonModel,@RequestBody String log){
		logService.saveRepairLog(log);
		jsonModel.setCode(1);
		return jsonModel;
	}
	
	@PostMapping("/log/rideLog")
	@ResponseBody
	public JsonModel rideLog(JsonModel jsonModel,@RequestBody String log){
		logService.saveRideLog(log);
		jsonModel.setCode(1);
		return jsonModel;
	}
	
	

}
