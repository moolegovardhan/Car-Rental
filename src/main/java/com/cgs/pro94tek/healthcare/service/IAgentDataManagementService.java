package com.cgs.pro94tek.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.Agent;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.AgentModal;

@Component
public interface IAgentDataManagementService {
	
	public List<AgentModal> fetchAgentById(String agentId) throws PMSException;

	public AgentModal fetchAgentDetails(String agentId) throws PMSException;

	public Agent fetchAgentByName(String agentName) throws PMSException;

	public void createOrUpdateAgent(Agent agentEntity) throws PMSException;

	public boolean deleteAgentById(String agentId) throws PMSException;


}
