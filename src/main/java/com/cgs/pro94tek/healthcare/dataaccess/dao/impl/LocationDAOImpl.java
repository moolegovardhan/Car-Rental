package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.Location;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ILocationDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("locationDAO")
public class LocationDAOImpl extends CustomHibernateDaoSupport implements ILocationDAO{


	@Override
	@Transactional
	public List<Location> fetchLocationBylocationName(String locationName) throws DataAccessException {
		List<Location> location = new ArrayList<Location>();

		String hql = "from Location where location like :locationName";

		String keyword = "New";
		Query query = getSession().createQuery(hql);
		query.setParameter("locationName", "%" + locationName + "%");

		System.out.println("Location query  "+query);
		List<Location> listlocation = query.list();

		System.out.println("Location List value  "+listlocation); 

		return listlocation;
	}


	//	@Override
	//	@Transactional
	//	public List<Location> fetchLocationById(String locationId) throws DataAccessException {
	//		
	//		List<Location> location = new ArrayList<Location>();
	//		
	//		String locationById = "from Location where id = :locationId";
	//		Query query = getSession().createQuery(locationById);
	//		query.setParameter("locationId", (locationId));
	//		List<Location> locations = query.list();
	//		if (PmsUtil.isCollectionEmpty(locations)) {
	//			return locations;
	//		}
	//		return location;
	//	}


	@Override
	@Transactional
	public void createOrUpdateLocation(Location locationEntity) throws DataAccessException {
		getSession().saveOrUpdate(locationEntity);

	}

	@Override
	@Transactional
	public boolean deleteLocationByName(String locationName) throws DataAccessException {
		System.out.println("Lcoation daoimple.............:"+locationName);
		Location location = new Location();
		String querylocationId = " Update Location set status =:status " + " where location =:locationName";
		Query query = getSession().createQuery(querylocationId);
		query.setParameter("locationName", locationName);
		query.setParameter("status", "n");
		query.executeUpdate();
		return true;
	}

	@Override
	@Transactional
	public List<Location> fetchAllLocartionModal(Location locationEntity) throws PMSException {
		List<Location> location=new ArrayList<Location>();
		String sqlquery  = "from Location ";
		Query query = getSession().createQuery(sqlquery);
		List<Location> locations = query.list();
		if (PmsUtil.isCollectionNotEmpty(locations)) {
			return locations;
		}else{
			return location;

		}
	}

	@Override
	@Transactional
	public boolean deleteLocationById(String locationId) throws DataAccessException {
		System.out.println(locationId);
		String querylocationId = " Update Location set status =:status " + " where id =:locationId";
		Query query = getSession().createQuery(querylocationId);
		query.setParameter("locationId",Long.parseLong(locationId));
		query.setParameter("status", "n");
		query.executeUpdate();
		return true;
	}



}
