package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.Agent;

public interface IAgentDAO {

	   
	   public Agent getAgentByName(String agentName) throws DataAccessException;
		public List<Agent> fetchAgentById(String agentId)throws DataAccessException;
		public void createOrUpdateAgent(Agent agent)throws DataAccessException;
		public boolean deleteAgentById(String agentId) throws DataAccessException;
		
		

}
