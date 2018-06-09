package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.Service;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IServiceDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("serviceDAO")
public class ServiceDAOImpl extends CustomHibernateDaoSupport implements IServiceDAO{

	@SuppressWarnings("unchecked")
	@Transactional
	public Service getServiceByName(String serviceName) throws DataAccessException {
		Service service = null;
		String queryServiceByName = "from Service where serviceName = :serviceName";
		Query query = getSession().createQuery(queryServiceByName);
		query.setParameter("serviceName", serviceName);
		List<Service> services = query.list();
		if (PmsUtil.isCollectionNotEmpty(services)) {
			service = services.get(0);
		}
		return service;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Service> fetchServiceById(String serviceId) throws DataAccessException {
		List<Service> service = new ArrayList<Service>();
			String queryServiceById  = "from Service where officeid = :serviceId";
			Query query = getSession().createQuery(queryServiceById);
			query.setParameter("serviceId", Long.parseLong(serviceId));
			List<Service> services = query.list();
			if (PmsUtil.isCollectionNotEmpty(services)) {
				return services;
			}else{
				return service;

	}
	}
	@Transactional
	public void createOrUpdateService(Service service) throws DataAccessException {
		getSession().saveOrUpdate(service);
		
	}

	@Transactional
	public boolean deleteServiceById(String serviceId) throws DataAccessException {
		String queryServiceId = " Delete from Service where id = :serviceId";
		Query query = getSession().createQuery(queryServiceId);
		query.setParameter("serviceId", Long.parseLong(serviceId));
		query.executeUpdate();
		return true;
	}

}
