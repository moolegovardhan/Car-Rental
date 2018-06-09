package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cgs.pro94tek.healthcare.bean.Service;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.ServiceModal;

public class ServiceHelper {

	/**
	 * This method will convert Service Object to ServiceModal object
	 * @param service
	 * @return
	 */
	public List<ServiceModal> createserviceModal(List<Service> service){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		List<ServiceModal> serviceModals = new ArrayList<ServiceModal>();
		for (Service serviceobj : service) {
			ServiceModal serviceModal1 = new ServiceModal();
			serviceModal1.setServicename(serviceobj.getServicename());
			serviceModal1.setPatientname(serviceobj.getPatientname());
			serviceModal1.setMobile(serviceobj.getMobile());
			serviceModal1.setAddress(serviceobj.getAddress());
			serviceModal1.setRequestdate(serviceobj.getRequestdate());
			serviceModal1.setRequestserved(serviceobj.getRequestserved());
			serviceModal1.setAttendername(serviceobj.getAttendername());
			serviceModal1.setInsttype(serviceobj.getInsttype());
			serviceModal1.setInstid(serviceobj.getInstid());
			serviceModal1.setRecieptid(serviceobj.getReceieptid());
			serviceModal1.setAssigneddate(serviceobj.getAssigneddate());
			serviceModal1.setPatientid(serviceobj.getPatientid());
			serviceModal1.setComments(serviceobj.getComments());
			serviceModal1.setAppointmentid(serviceobj.getAppointmentid());
			serviceModal1.setLabid(serviceobj.getLabid());
			serviceModal1.setHospitalid(serviceobj.getHospitalid());
			serviceModal1.setHospitalcomments(serviceobj.getHospitalcomments());
			serviceModal1.setUpdateddate(serviceobj.getUpdatedate());
			serviceModal1.setCreatedDate(df.format(serviceobj.getCreatedDate()));
			serviceModal1.setCreatedBy(serviceobj.getCreatedBy());
			serviceModal1.setStatus(serviceobj.getStatus());
			serviceModal1.setId(serviceobj.getId());
			serviceModals.add(serviceModal1);
		}
		

		return serviceModals;
	}

	/**
	 * here this method will convert serviceModal to service
	 * @param service
	 * @return
	 * @throws PMSException
	 * @throws ParseException
	 */
	public Service createService(ServiceModal serviceModal) throws PMSException, ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Service service = new Service();
		service.setServicename(serviceModal.getServicename());
		service.setPatientname(serviceModal.getPatientname());
		service.setMobile(serviceModal.getMobile());
		service.setAddress(serviceModal.getAddress());
		service.setRequestdate(serviceModal.getRequestdate());
		service.setRequestserved(serviceModal.getRequestserved());
		service.setAttendername(serviceModal.getAttendername());
		service.setInsttype(serviceModal.getInsttype());
		service.setInstid(serviceModal.getInstid());
		service.setReceiptid(serviceModal.getRecieptid());
		service.setAssigneddate(serviceModal.getAssigneddate());
		service.setPatientid(serviceModal.getPatientid());
		service.setComments(serviceModal.getComments());
		service.setAppointmentid(serviceModal.getAppointmentid());
		service.setLabid(serviceModal.getLabid());
		service.setHospitalid(serviceModal.getHospitalid());
		service.setHospitalcomments(serviceModal.getHospitalcomments());
		service.setUpdatedate(serviceModal.getUpdateddate());
		service.setCreatedDate(new Date());
		service.setCreatedBy(serviceModal.getCreatedBy());
		service.setStatus(serviceModal.getStatus());
		service.setId(serviceModal.getId());
		
		return service;
	}

}
