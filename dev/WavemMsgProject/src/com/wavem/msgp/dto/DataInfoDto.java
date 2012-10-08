/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : DataInfoDto.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.dto;

import java.io.Serializable;

/**
 * 데이터의 고유 ID를 갖는 클래스
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class DataInfoDto implements Serializable {

	/** 서비스 ID */
	private String serviceID = "";

	/**
	 * 기본 생성자 <br>
	 * 생성 시 꼭 setServiceID() 메서드를 통해 서비스 ID를 초기화 해야 한다. <br>
	 * 
	 * @see DataInfoDto#setServiceID(String)
	 */
	public DataInfoDto() {

	}

	/**
	 * 서비스 ID 초기화하는 생성자
	 * 
	 * @param serviceID
	 */
	public DataInfoDto(String serviceID) {
		this.serviceID = serviceID;
	}

	/**
	 * 서비스 ID를 반환한다.
	 * 
	 * @return 서비스 ID
	 */
	public String getServiceID() {
		return serviceID;
	}

	/**
	 * 서비스 ID를 지정한다.
	 * 
	 * @param serviceID 서비스 ID
	 */
	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}

}
