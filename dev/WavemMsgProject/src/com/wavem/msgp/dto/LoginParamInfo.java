package com.wavem.msgp.dto;


/**
 * 로그인 폼
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class LoginParamInfo extends DataInfoDto {

	private static final long serialVersionUID = 7926402335493132974L;

	/** 사용자 ID */
	private String userId = "";
	
	/** 사용자 비밀번호 */
	private String userPw = "";

	/**
	 * 요청 서비스 ID없이 객체 생성
	 */
	public LoginParamInfo() {
		super();
	}
	
	/**
	 * 요청 서비스 ID를 입력하여 객체 생성
	 * 
	 * @param serviceID 서비스ID
	 */
	public LoginParamInfo(String serviceID) {
		super(serviceID);
	}
	
	/**
	 * 요청 서비스 ID를 입력하여 객체 생성
	 * 
	 * @param serviceID 서비스 ID
	 * @param userId 사용자 ID
	 * @param userPw 사용자 비밀번호
	 */
	public LoginParamInfo(String serviceID, String userId, String userPw) {
		super(serviceID);
		this.userId = userId;
		this.userPw = userPw;
	}
	
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
