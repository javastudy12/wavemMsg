package com.wavem.msgp.dto;

import java.io.Serializable;

public class DataInfoDto  implements Serializable {
	
	private String serviceID = "";
	
	public DataInfoDto() {
		
	}
	
	public DataInfoDto(String serviceID) {
		this.serviceID = serviceID;
	}

	public String getServiceID() {
		return serviceID;
	}

}
