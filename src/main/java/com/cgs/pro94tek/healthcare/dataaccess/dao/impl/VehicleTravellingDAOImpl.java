package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.VehicleTravelling;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IVehicleTravellingDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("vehicleTravelDAO")
public class VehicleTravellingDAOImpl extends CustomHibernateDaoSupport implements IVehicleTravellingDAO{

	@SuppressWarnings("unchecked")
	@Transactional
	public VehicleTravelling getVehicleTravelDetailsByNumber(String vehicleNumber) throws DataAccessException {
		VehicleTravelling vehicletravel = null;
		String queryVehicletravelByName = "from VehicleTravelling where vehicleNumber = :vehicleNumber";
		Query query = getSession().createQuery(queryVehicletravelByName);
		query.setParameter("vehicleNumber", vehicleNumber);
		List<VehicleTravelling> vehicletravels = query.list();
		if (PmsUtil.isCollectionNotEmpty(vehicletravels)) {
			vehicletravel = vehicletravels.get(0);
		}
		return vehicletravel;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<VehicleTravelling> fetchvehicleTravellingById(String travelId) throws DataAccessException {
		List<VehicleTravelling> vehicletravel = new ArrayList<VehicleTravelling>();
		
		String vehicletravelById = "from VehicleTravelling where officeid = :travelId";
		Query query = getSession().createQuery(vehicletravelById);
		query.setParameter("travelId", (travelId));
		List<VehicleTravelling> vehicletravels = query.list();
		if (PmsUtil.isCollectionEmpty(vehicletravels)) {
			return vehicletravels;
		}
		return vehicletravel;
	
	}

	@Transactional
	public void createOrUpdateVehicleDetails(VehicleTravelling vehicletravelling) throws DataAccessException {
		getSession().saveOrUpdate(vehicletravelling);
		
	}

	@Transactional
	public boolean deleteVehicletravellingById(String travelId) throws DataAccessException {
		System.out.println("delete Journey id...........:"+travelId);
		String querytravelId = "Update VehicleTravelling set status = :status "+" where id = travelId";
		Query query = getSession().createQuery(querytravelId);
		query.setParameter("travelId", travelId);
		query.setParameter("status", "N");
		query.executeUpdate();
		return false;
	}

}
