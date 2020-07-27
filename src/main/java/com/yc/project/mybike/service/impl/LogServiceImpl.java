package com.yc.project.mybike.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.yc.project.mybike.service.LogService;
@Service
public class LogServiceImpl implements LogService {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void save(String log) {
		// 相当于  sql ：insert into logs values(log);
       mongoTemplate.save(log,"logs");
	}

	@Override
	public void savePayLog(String log) {
		
		 mongoTemplate.save(log,"payLogs");
	}

	@Override
	public void saveRepairLog(String log) {
		 mongoTemplate.save(log,"repairLogs");
		
	}
	@Override
	public void saveRideLog(String log) {
		 mongoTemplate.save(log,"rideLogs");
		
	}

}
