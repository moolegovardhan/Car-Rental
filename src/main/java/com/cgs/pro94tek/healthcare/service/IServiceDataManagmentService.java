package com.cgs.pro94tek.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.Service;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.ServiceModal;



@Component
public interface IServiceDataManagmentService {
	
	public List<ServiceModal> fetchServiceById(String serviceId) throws PMSException;

	public ServiceModal fetchServiceDetails(String taserviceIdxId) throws PMSException;

	public Service fetchServiceByName(String serviceName) throws PMSException;
	
	public void createOrUpdateService(Service serviceEntity) throws PMSException;

	public boolean deleteServiceById(String serviceId) throws PMSException;

}
