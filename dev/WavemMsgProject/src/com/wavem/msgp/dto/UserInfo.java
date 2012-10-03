/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : UserInfo.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.dto;


/**
 * 사용자 정보 클래스
 * 
 * @author 
 *
 */
public class UserInfo extends DataInfoDto{

	private static final long serialVersionUID = 1832993226207023300L;
	
	private String userId = null;
	
	public UserInfo() {
		
	}
	
	public UserInfo(String serviceId) {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
