package com.wavem.msgp.dto;

import java.io.Serializable;

/**
 * 로그인 폼
 * 
 * @author 
 *
 */
public class LoginParamInfo implements Serializable {

	private static final long serialVersionUID = 7926402335493132974L;

	/** 사용자 ID */
	private String userId = "";
	
	/** 사용자 비밀번호 */
	private String userPw = "";

	/**
	 * 사용자 ID 반환
	 * 
	 * @return 사용자 ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 사용자 ID 저장
	 * 
	 * @param userId 사용자 ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 사용자 비밀번호 반한
	 * 
	 * @return 사용자 비밀번호
	 */
	public String getUserPw() {
		return userPw;
	}

	/**
	 * 사용자 비밀번호 저장
	 * 
	 * @param userPw 사용자 비밀번호
	 */
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

}
