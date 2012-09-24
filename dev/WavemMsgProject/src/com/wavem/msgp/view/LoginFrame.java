/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : LoginFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/


package com.wavem.msgp.view;

import com.wavem.msgp.component.WaveMsgFrame;

/**
 * 로그인 화면
 * 
 * <pre>
 * 	LoginFrame loginFrame = new LoginFrame();
 *  LoginFrame.makeInitFrame(); // 실제 데이터를 호출하고 화면을 그리는 메서드
 * </pre>
 * 
 * @author 
 *
 */
public class LoginFrame extends WaveMsgFrame{
	
	private static final long serialVersionUID = -4114307065580336554L;

	@Override
	public void makeInitFrame() {
	
	}
	
	@Override
	public void close() {
		
	}
	
	/**
	 * 로그인 <br>
	 * 사용자 인증 및 메인화면 활성화 <br>
	 * 만약 첫 로그인 사용자일 경우 regPasswordInfo() 호출
	 */
	public void login() {
	
	}
	
	/**
	 * 첫 로그인 사용자만 해당 <br>
	 * 비밀번호 재등록 화면 호출
	 */
	public void regPasswordInfo() {
	
	}
}
