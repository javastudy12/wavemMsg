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

import java.awt.Image;

/**
 * 사용자 정보 클래스
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class UserInfo extends DataInfoDto{

	private static final long serialVersionUID = 1832993226207023300L;
	
	/** 프로필사진 */
	private Image profileImg = null;
	
	/** 이미지 설정 */
	private boolean imgSet = true;
	
	/** 사용자 이름 */
	private String userName = "";
	
	/** 사용자 ID */
	private String userId = "";
	
	/** 직급 */
	private String rank = "";
	
	/** 생년월일 */
	private String birth = "";
	
	/** 상태메시지 */
	private String stateMessage = "";
	
	/** e-mail */
	private String email = "";
	
	/** 핸드폰번호 */
	private String phone = "";
	
	/** 집전화번호 */
	private String home = "";
	
	/** 주소 */
	private String addr = "";
	
	/** 
	 * 사용자 정보 생성자
	 */
	public UserInfo() {
		
	}
	
	/**
	 * 서비스 ID
	 * 
	 * @param serviceId 서비스ID
	 */
	public UserInfo(String serviceId) {
		
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
	 * 사용자 프로필 사진 반환
	 * 
	 * @return 사용자 프로필 사진
	 */
	public Image getProfileImg() {
		return profileImg;
	}

	/**
	 * 사용자 프로필 사진 반환
	 * 
	 * @param profileImg 사용자 프로필 사진
	 */
	public void setProfileImg(Image profileImg) {
		this.profileImg = profileImg;
	}

	/**
	 * 프로필 사진 설정 방법 반환 <br>
	 *  
	 * true : 기본 이미지 <br>
	 * false : 사용자 이미지 <br>
	 * 
	 * @return 프로필 사진 설정 유무
	 */
	public boolean isImgSet() {
		return imgSet;
	}

	/**
	 * 프로필 사진 설정 방법 설정 <br>
	 * 
	 * true : 기본 이미지 <br>
	 * false : 사용자 이미지 <br>
	 *  
	 * @param imgSet 프로필 사진 설정 유무
	 */
	public void setImgSet(boolean imgSet) {
		this.imgSet = imgSet;
	}

	/**
	 * 사용자 이름 반환
	 * 
	 * @return 사용자 이름
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 사용자 이름 저장
	 * 
	 * @param userName 사용자 이름
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 사용자 직급 반환
	 * 
	 * @return 사용자 직급
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * 사용자 직급 저장
	 * 
	 * @param rank 사용자 직급
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * 생년월일 반환
	 * 
	 * @return 생년월일
	 */
	public String getBirth() {
		return birth;
	}

	/**
	 * 생년월일 저장
	 * 
	 * @param birth 생년월일
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}

	/**
	 * 상태 메시지 반환
	 * 
	 * @return 상태 메시지
	 */
	public String getStateMessage() {
		return stateMessage;
	}

	/**
	 * 상태 메시지 저장
	 * 
	 * @param stateMessage 상태 메시지
	 */
	public void setStateMessage(String stateMessage) {
		this.stateMessage = stateMessage;
	}

	/**
	 * e-mail 반환
	 * 
	 * @return e-mail
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * e-mail 저장
	 * 
	 * @param email e-mail
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 핸드폰 번호 반환
	 * 
	 * @return 핸드폰 번호
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 핸드폰 번호 저장
	 * 
	 * @param phone 핸드폰 번호
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 집전화 번호 반환
	 * 
	 * @return 집전화 번호
	 */
	public String getHome() {
		return home;
	}

	/**
	 * 집전화 번호 저장
	 * 
	 * @param home 집전화 번호
	 */
	public void setHome(String home) {
		this.home = home;
	}

	/**
	 * 주소 반환
	 * 
	 * @return 주소
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * 주소 저장
	 * 
	 * @param addr 주소
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
