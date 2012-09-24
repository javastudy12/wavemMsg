/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : MsgMainFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import java.util.ArrayList;
import java.util.List;

import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.dto.UserInfo;

/**
 * 메신저 메인 화면 <br>
 * 
 * <pre>
 * 	MsgMainFrame msgMain = MsgMainFrame.getInstance();
 * </pre>
 * 
 * @author
 * 
 */
public class MsgMainFrame extends WaveMsgFrame {

	private static final long serialVersionUID = -4042584463931283068L;
	
	/** 현재 접속중인 사용자 리스트  */
	public List<UserInfo> userList = null;
	
	/** 메신저 메일 화면 인스턴스 */
	private static MsgMainFrame msgMainFrame = null;
    
	/**	
	 * 메인화면 MsgMainFrame 생성자 <br>
	 * 최초 userlist객체 생성 <br>
	 */
	private MsgMainFrame() {
		userList = new ArrayList<UserInfo>();
	}

	/**
	 * MsgMainFrame 인스턴스 생성 및 반환
	 * 
	 * @return 기존 혹은 생성된 메일 화면 인스턴스
	 */
	public static MsgMainFrame getInstance() {
		if (msgMainFrame == null) {
			synchronized (MsgMainFrame.class) {
				if (msgMainFrame == null) {
					msgMainFrame = new MsgMainFrame();
				}
			}
		}

		return msgMainFrame;
	}
	
	@Override
	public void makeInitFrame() {
		// TODO 메인 화면 관련 
	}

	@Override
	public void close() {
		// TODO 화면 종료 

	}

	/**
	 * 최초 화면 로딩 시 초기 데이터 생성
	 */
	public void invokeInitData() {

	}

	/**
	 * 로그인 화면 생성 <br>
	 * 세션정보 없을 시 로그인 창 생성
	 */
	public void makeLoginFrame() {

	}

	/**
	 * 쪽지함 화면 생성
	 */
	public void makeMessageBoxFrame() {

	}

	/**
	 * 공지사항 화면 생성
	 */
	public void makeNoticeFrame() {

	}

	/**
	 * 그룹 화면 생성
	 */
	public void makeGroupFrame() {

	}

	/**
	 * 파일함 화면 생성
	 */
	public void makeFileBoxFrame() {

	}

	/**
	 * 프로필 화면 생성
	 */
	public void makeProfileFrame() {

	}

	/**
	 * 대화함 화면 생성
	 */
	public void makeChatBoxFrame() {

	}

	/**
	 * 환경설정 화면 생성
	 */
	public void makePropertiesFrame() {

	}

	/**
	 * 쪽지 화면 생성
	 */
	public void makeMessageFrame() {

	}

	/**
	 * 채팅창 화면 생성
	 */
	public void makeChatFrame() {

	}

	/**
	 * 서버의 사용자 리스트 체크
	 */
	public void userChkToServer() {

	}

	/**
	 * 서버로부터 사용자 리스트 체크 요청
	 */
	public void userChkFromServer() {

	}

	/**
	 * 로그아웃
	 */
	public void logout() {

	}

}
