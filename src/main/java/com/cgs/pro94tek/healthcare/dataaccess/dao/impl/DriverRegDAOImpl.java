package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.Driver;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IDriverRegDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("driverRegDAO")
public class DriverRegDAOImpl extends CustomHibernateDaoSupport implements IDriverRegDAO{

	@Transactional
	public Driver getDriverByName(String driverName) throws DataAccessException {
		Driver driverreg = null;
		String DriverByName = "from diverregistration dr where dr.name = :driverName";
		Query query = getSession().createQuery(DriverByName);
		query.setParameter("driverName", driverName);
		List<Driver> drivers = query.list();
		if (PmsUtil.isCollectionNotEmpty(drivers)) {
			driverreg = drivers.get(0);
		}
		return driverreg;
	
	}

	@Transactional
	public List<Driver> fetchDriverById(String driverId) throws DataAccessException {
		List<Driver> driver = new ArrayList<Driver>();
		 String DriverById = "from diverregistration where id = :driverId";
			Query query = getSession().createQuery(DriverById);
			List<Driver> driverregs = query.list();
			if (PmsUtil.isCollectionNotEmpty(driverregs)) {
				return driverregs;
			}else{
				
				return driver;
			}
			
	}

	@Transactional
	public void createOrUpdateDriver(Driver driver) throws DataAccessException {
		getSession().saveOrUpdate(driver);
		
	}

	@Transactional
	public boolean deleteDriverById(String driverId) throws DataAccessException {
		System.out.println(driverId);
		String querydriverId = " Update diverregistration set status =:status \" + \" where id =:driverId";
		Query query = getSession().createQuery(querydriverId);
		query.setParameter("driverId",Long.parseLong(driverId));
		query.setParameter("status", "n");
		query.executeUpdate();
		return true;

}

}
