package com.yc.project.mybike.web.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.project.mybike.bean.Bike;
import com.yc.project.mybike.bean.User;
import com.yc.project.mybike.service.BikeService;
import com.yc.project.mybike.service.UserService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@Api(value="小辰出行单车信息操作接口",tags={"单车信息","控制层"})
public class BikeController {
	
	private Logger logger=LogManager.getLogger();
	@Autowired
	private BikeService bikeService;
	@Autowired
	private UserService userService;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	// 报修
		@PostMapping("/repair")
		public @ResponseBody JsonModel repair(JsonModel jm, Bike bike) {
			try {
				this.bikeService.reportMantinant(bike);
				jm.setCode(1);
			} catch (Exception e) {
				e.printStackTrace();
				jm.setCode(0);
				jm.setMsg(e.getMessage());
			}
			return jm;
		}
		
		@PostMapping("/findBikeAll")
		public @ResponseBody List<Bike> findBikeAll(JsonModel jm) {
			List<Bike> list=bikeService.findAll();
			return list;
		}
		
		@PostMapping("/findAllusers")
		public @ResponseBody List<User> findAllusers(JsonModel jm) {
			List<User> list=userService.findAllusers();
                
			return list;
		}
		
		@PostMapping("/findAllrepair")
		public @ResponseBody List<Bike> findAllrepair(JsonModel jm) {
			List<Bike> list=mongoTemplate.findAll(Bike.class, "torepairbikes");
                
			return list;
		}
	
	
	
	
	/**
	 * 扫码开锁
	 * @param jsonModel
	 * @param bike
	 * @return
	 */
	@RequestMapping(value="/open",method={RequestMethod.POST})
	@ApiOperation(value="扫码开锁",notes="根据单车编号,经度，纬度完成开锁操作")
//	@ApiImplicitParams({@ApiImplicitParam(name="bid",value="单车编号",required=true),
//		@ApiImplicitParam(name="latitude",value="经度",required=true),
//		@ApiImplicitParam(name="longitude",value="纬度",required=true)})
	public @ResponseBody JsonModel open(@ApiIgnore JsonModel jsonModel,@RequestBody Bike bike){
		logger.info("请求参数："+bike);
		try {
			
			bikeService.open(bike);
			jsonModel.setCode(1);
		} catch (Exception e) {
			
			e.printStackTrace();
			jsonModel.setCode(0);
			jsonModel.setMsg(e.getMessage());
		}
		return jsonModel;
	}
	@RequestMapping(value="/findNearAll",method={RequestMethod.POST})
	@ApiOperation(value="查找最近的单车",notes="查找最近的40部单车")
	public @ResponseBody JsonModel findNearAll(@ApiIgnore JsonModel jm,@RequestBody Bike bike){
		List<Bike> list=bikeService.findNear(bike);
		jm.setCode(1);
		jm.setObj(list);
		
		return jm;
	}

}
