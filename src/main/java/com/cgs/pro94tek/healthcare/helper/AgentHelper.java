package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cgs.pro94tek.healthcare.bean.Agent;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.AgentModal;


public class AgentHelper {
	
	public List<AgentModal> createAgentModal(List<Agent> agent){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		List<AgentModal> AgentModals = new ArrayList<AgentModal>();
		for (Agent agentobj : agent) {
			AgentModal agentModal1 = new AgentModal();
			agentModal1.setId(agentobj.getId());
			agentModal1.setFname(agentobj.getFname());
			agentModal1.setMname(agentobj.getMname());
			agentModal1.setLname(agentobj.getLname());
			agentModal1.setName(agentobj.getFname() +" "+ agentobj.getLname()+" " + agentobj.getMname());
			agentModal1.setCorporateaddress(agentobj.getCorporateaddress());
			agentModal1.setMailingaddress(agentobj.getMailingaddress());
			agentModal1.setMobile(agentobj.getMobile());
			agentModal1.setState(agentobj.getState());
			agentModal1.setDistrict(agentobj.getDistrict());
			agentModal1.setCity(agentobj.getCity());
			agentModal1.setOfficeid(agentobj.getOfficeid());
			agentModal1.setCreateddate(df.format(agentobj.getCreateddate()));
			agentModal1.setCreatedby(agentobj.getCreatedby());
			agentModal1.setStatus(agentobj.getStatus());
			AgentModals.add(agentModal1);
		}
		
		return AgentModals;
	}

	public Agent createAgent(AgentModal agentModal) throws PMSException, ParseException{
		@SuppressWarnings("unused")
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Agent agent = new Agent();
		agent.setFname(agentModal.getFname());
		agent.setLname(agentModal.getLname());
		agent.setMname(agentModal.getMname());
		agent.setName(agentModal.getFname()+" " + agentModal.getLname()+" " + agentModal.getMname());
		agent.setCorporateaddress(agentModal.getCorporateaddress());
		agent.setMailingaddress(agentModal.getMailingaddress());
		agent.setMobile(agentModal.getMobile());
		agent.setState(agentModal.getState());
		agent.setDistrict(agentModal.getDistrict());
		agent.setCity(agentModal.getCity());
		agent.setOfficeid(agentModal.getOfficeid());;
		agent.setCreateddate(new Date());
		agent.setCreatedby(agentModal.getCreatedby());
		agent.setStatus(agentModal.getStatus());
		agent.setId(agentModal.getId());
		
		return agent;
	}
	
}
