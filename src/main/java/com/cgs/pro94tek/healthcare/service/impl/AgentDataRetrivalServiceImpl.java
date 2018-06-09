package com.cgs.pro94tek.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.Agent;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IAgentDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.AgentHelper;
import com.cgs.pro94tek.healthcare.modal.AgentModal;
import com.cgs.pro94tek.healthcare.service.IAgentDataManagementService;

@Service("agentDataManagementService")
public class AgentDataRetrivalServiceImpl implements IAgentDataManagementService{

	@Autowired
	private IAgentDAO agentdao;
	
	@Override
	public List<AgentModal> fetchAgentById(String agentId) throws PMSException {
		List<Agent> agent = agentdao.fetchAgentById(agentId);
		AgentHelper agentHelper = new AgentHelper();
		return agentHelper.createAgentModal(agent);
	}

	@Override
	public AgentModal fetchAgentDetails(String agentId) throws PMSException {
		return null;
	}

	@Override
	public Agent fetchAgentByName(String agentName) throws PMSException {
	
		return agentdao.getAgentByName(agentName);
	}

	@Override
	public void createOrUpdateAgent(Agent agentEntity) throws PMSException {
		agentdao.createOrUpdateAgent(agentEntity);
		
	}

	@Override
	public boolean deleteAgentById(String agentId) throws PMSException {
	
		return agentdao.deleteAgentById(agentId);
	}

}
