package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.Vehicle;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IVehicleDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;


@Repository("vehicleDAO")
public class VehicleDAOImpl extends CustomHibernateDaoSupport implements IVehicleDAO{

	@SuppressWarnings("unchecked")
	@Transactional
	public Vehicle getVehicleDetailsByNumber(String vehicleNumber) throws DataAccessException {
	
		Vehicle vehicle = null;
		String queryVehicleByName = "from Vehicle where vehicleNumber = :vehicleNumber";
		Query query = getSession().createQuery(queryVehicleByName);
		query.setParameter("vehicleNumber", vehicleNumber);
		List<Vehicle> vehicles = query.list();
		if (PmsUtil.isCollectionNotEmpty(vehicles)) {
			vehicle = vehicles.get(0);
		}
		return vehicle;
		
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Vehicle> fetchvehicleById(String vehicleId) throws DataAccessException {
		 List<Vehicle> vehicle = new ArrayList<Vehicle>();
		 
			String queryVehicleById  = "from Vehicle where officeid = :vehicleId";
			
			Query query = getSession().createQuery(queryVehicleById);
			query.setParameter("vehicleId", Integer.parseInt(vehicleId));
			List<Vehicle> vehicles = query.list();
			if (PmsUtil.isCollectionNotEmpty(vehicles)) {
				return vehicles; 
			}else{
				return vehicle;
			}
				
	}

	@Transactional
	public void createOrUpdateVehicle(Vehicle vehicle) throws DataAccessException {
		getSession().saveOrUpdate(vehicle);
		
	}

	@Transactional
	public boolean deleteVehicleById(String vehicleId) throws DataAccessException {
		String queryVehicleId = "update Vehicle set  status = :status "+" where id = :vehicleId";
		
		Query query = getSession().createQuery(queryVehicleId);
		query.setParameter("vehicleId", Long.parseLong(vehicleId));
		query.setParameter("status", "N");
		query.executeUpdate();
		return true;
	}

}
