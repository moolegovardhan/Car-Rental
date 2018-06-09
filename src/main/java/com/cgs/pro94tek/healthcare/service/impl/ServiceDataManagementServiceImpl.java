package com.cgs.pro94tek.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.dataaccess.dao.IServiceDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.ServiceHelper;
import com.cgs.pro94tek.healthcare.modal.ServiceModal;
import com.cgs.pro94tek.healthcare.service.IServiceDataManagmentService;

@Service("serviceDataManagementService")
public class ServiceDataManagementServiceImpl implements IServiceDataManagmentService{
	
	@Autowired
	private	IServiceDAO servicedao;

	@Override
	public List<ServiceModal> fetchServiceById(String serviceId) throws PMSException {
		List<com.cgs.pro94tek.healthcare.bean.Service> service = servicedao.fetchServiceById(serviceId);
		ServiceHelper servicehelper = new ServiceHelper();
		// convert tax object to taxmodal
		return servicehelper.createserviceModal(service);
	}

	@Override
	public ServiceModal fetchServiceDetails(String taserviceIdxId) throws PMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.cgs.pro94tek.healthcare.bean.Service fetchServiceByName(String serviceName) throws PMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOrUpdateService(com.cgs.pro94tek.healthcare.bean.Service serviceEntity) throws PMSException {
		servicedao.createOrUpdateService(serviceEntity);
		
	}

	@Override
	public boolean deleteServiceById(String serviceId) throws PMSException {
		return servicedao.deleteServiceById(serviceId);
	}
	

}
