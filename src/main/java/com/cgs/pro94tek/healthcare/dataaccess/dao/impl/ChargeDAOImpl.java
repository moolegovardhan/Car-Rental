package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.Charge;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IChargeDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("chargesDAO")
public class ChargeDAOImpl extends CustomHibernateDaoSupport implements IChargeDAO{

	@SuppressWarnings("unchecked")
	@Transactional
	public Charge getChargeByName(String ChargeName) throws DataAccessException {
		Charge charge = null;
		String queryChargeByName = "from Charge where chargeName = :chargeName";
		Query query = getSession().createQuery(queryChargeByName);
		query.setParameter("chargeName", ChargeName);
		List<Charge> Charges = query.list();
		if (PmsUtil.isCollectionNotEmpty(Charges)) {
			charge = Charges.get(0);
		}
		return charge;
	}

	@Transactional
	public List<Charge> fetchChargeById(String chargeId) throws DataAccessException {
		 List<Charge> charge = new ArrayList<Charge>();
			String querychargeById  = "from Charge where officeId = :chargeId";
			Query query = getSession().createQuery(querychargeById);
			query.setParameter("chargeId", Long.parseLong(chargeId));
			List<Charge> charges = query.list();
			if (PmsUtil.isCollectionNotEmpty(charges)) {
				return charges;
			}else{
				return charge;
			}
	}

	@Transactional
	public void createOrUpdateCharge(Charge charge) throws DataAccessException {
		getSession().saveOrUpdate(charge);

	}

	@Transactional
	public boolean deleteChargeById(String chargeId) throws DataAccessException {
		String querychargeId = " Delete from Charge where id = :chargeId";
		Query query = getSession().createQuery(querychargeId);
		query.setParameter("chargeId", Long.parseLong(chargeId));
		query.executeUpdate();
		return true;
	}

}
