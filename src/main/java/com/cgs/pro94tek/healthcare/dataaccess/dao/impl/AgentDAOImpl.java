package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.Agent;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IAgentDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("agentDAO")
public class AgentDAOImpl extends CustomHibernateDaoSupport implements IAgentDAO{

	@SuppressWarnings("unchecked")
	@Transactional
	public Agent getAgentByName(String agentName) throws DataAccessException {
		Agent agent = null;
		String AgentByName = "from Agent ag where ag.name = :agentName";
		Query query = getSession().createQuery(AgentByName);
		query.setParameter("agentName", agentName);
		List<Agent> agents = query.list();
		if (PmsUtil.isCollectionNotEmpty(agents)) {
			agent = agents.get(0);
		}
		return agent;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Agent> fetchAgentById(String agentId) throws DataAccessException {
		
		List<Agent> agent = new ArrayList<Agent>();
		 String AgentById  = "from Agent where officeid = :agentId";
			Query query = getSession().createQuery(AgentById);
			query.setParameter("agentId", Integer.parseInt(agentId));
			List<Agent> agents = query.list();
			if (PmsUtil.isCollectionNotEmpty(agents)) {
				return agents;
			}else{
				
				return agent;
			}
	}


	@Transactional
	public void createOrUpdateAgent(Agent agent) throws DataAccessException {
		getSession().saveOrUpdate(agent);
		
	}

	@Transactional
	public boolean deleteAgentById(String agentId) throws DataAccessException {
		
		System.out.println("delete agent...........:"+agentId);
		String queryAgentById = " Update Agent set status = :status "+" where id = agentId";
		Query query = getSession().createQuery(queryAgentById);
		query.setParameter("agentId", Long.parseLong(agentId));
		query.setParameter("status", "N");
		query.executeUpdate();
		return true;
	}

}
