package com.cgs.pro94tek.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.Ward;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.WardModal;

@Component
public interface IWardDataManagementService {
	
	public List<WardModal> fetchWardById(String wardId) throws PMSException;

	public WardModal fetchWardDetails(String wardId) throws PMSException;

	public Ward fetchWardByName(String wardName) throws PMSException;

	public void createOrUpdateWard(Ward wardEntity) throws PMSException;

	public boolean deleteWardById(String wardId) throws PMSException;

}
