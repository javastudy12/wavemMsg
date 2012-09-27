/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : ProfileFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.dto.UserInfo;

/**
 * 프로필 설정 화면
 * 
 * <pre>
 * 	ProfileFrame profileFrame = new ProfileFrame();
 * </pre>
 * 
 * @author 
 *
 */
public class ProfileFrame extends WaveMsgFrame {

	private static final long serialVersionUID = 5045138939543198397L;

	/** 프로필 설정 화면 인스턴스 변수 */
	private static ProfileFrame frame = null;
	
	/** 사용자 정보를 담고 있는 UserInfo 인스턴스 변수 */
	private UserInfo userInfo = null;
	
	/**
	 * 프로필 설정 생성자 <br>
	 * 최초 makeInitFrame() 호출 <br>
	 */
	private ProfileFrame(UserInfo userInfo) {
		this.userInfo = userInfo;
		makeInitFrame();
	}
	
	/**
	 * 프로필 설정 화면을 위한 인스턴스 반환
	 * 
	 * @return 프로필 설정 화면을 위한 화면 인스턴스
	 */
	public static ProfileFrame getInstance(UserInfo userInfo) {
		
		if (frame == null) { // 생성된 인스턴스가 없는 경우 새로 생성
			synchronized (ProfileFrame.class) {
				if (frame == null) {
					frame = new ProfileFrame(userInfo);
				}
			}
		} 
		
		return frame;
	}
	
	@Override
	public void makeInitFrame() {
		getContentPane().setLayout(null);
	}

	@Override
	public void close() {
		this.dispose();
	}

	/**
	 * 사용자 프로필 호출
	 */
	public void invokeProfileInfo() {

	}

	/**
	 * 사용자 프로필 수정
	 */
	public void modifyProfileInfo() {

	}
}
