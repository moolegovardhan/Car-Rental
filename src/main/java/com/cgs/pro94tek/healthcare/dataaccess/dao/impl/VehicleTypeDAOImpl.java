package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.VehicleType;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IVehicleTypeDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("vehicleTypeDAO")
public class VehicleTypeDAOImpl extends CustomHibernateDaoSupport implements IVehicleTypeDAO{

	@Override
	@Transactional
	public List<VehicleType> fetchVehicleTypeById(String vehicletypeId) throws DataAccessException {

		List<VehicleType> vehicletype = null;
		 String queryVehicleTypeById = "from VehicleType where officeid = :vehicletypeId";
			Query query = getSession().createQuery(queryVehicleTypeById);
			query.setParameter("vehicletypeId", vehicletypeId);
			List<VehicleType> vehicletypes = query.list();
			if (PmsUtil.isCollectionNotEmpty(vehicletypes)) {
				return vehicletypes; 
			}else{
				return vehicletype;
			}
			
	}

	@Override
	@Transactional
	public void createOrUpdateVehicleType(VehicleType vehicletype) throws DataAccessException {
		getSession().saveOrUpdate(vehicletype);
		
	}

	@Override
	@Transactional
	public boolean deletevehicleById(String vehicletypeId) throws DataAccessException {
	String queryVehicleTypeById = "update VehicleType set  status = :status "+" where id = :vehicletypeId";
		
		Query query = getSession().createQuery(queryVehicleTypeById);
		query.setParameter("vehicletypeId", Long.parseLong(vehicletypeId));
		query.setParameter("status", "N");
		query.executeUpdate();
		return true;
	}

	


}
