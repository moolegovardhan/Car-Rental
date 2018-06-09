package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.Service;

public interface IServiceDAO {
	
	public Service getServiceByName(String serviceName) throws DataAccessException;
	public List<Service> fetchServiceById(String serviceId)throws DataAccessException;
	public void createOrUpdateService(Service service)throws DataAccessException;
	public boolean deleteServiceById(String serviceId) throws DataAccessException;
	
	

	

}
