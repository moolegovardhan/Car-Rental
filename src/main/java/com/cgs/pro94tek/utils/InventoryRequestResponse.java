package com.cgs.pro94tek.utils;

import java.io.Serializable;

public class InventoryRequestResponse implements Serializable {


	private static final long serialVersionUID = -1253175369970525557L;

	private String status;
	private String responseMessage;
	private String recordCount;
	private String comments;
	private Object data; // this can be any type of object like UserModel etc
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public String getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	@Override
	public String toString() {
		return "ResponseMessage [status=" + status + ", responseMessage=" + responseMessage
				+ ", recordCount=" + recordCount + ", comments=" + comments+", data=" + data.toString()+"]";
	}

}
