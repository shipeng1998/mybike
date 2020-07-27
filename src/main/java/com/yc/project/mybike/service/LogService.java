package com.yc.project.mybike.service;

public interface LogService {
	
	/**
	 * 保存操作日志
	 * @param log
	 */
	public void save(String log);
	/**
	 * 充值日志
	 * @param log
	 */
	public void savePayLog(String log);
	
	/**
	 * 报修日志
	 * @param log
	 */
	public void saveRepairLog(String log);
	/**
	 * 骑行日志
	 * @param log
	 */
	public void saveRideLog(String log);

}
