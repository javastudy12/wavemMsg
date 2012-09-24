/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : ChatFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.wavem.msgp.dto.UserInfo;
import com.wavem.msgp.main.WaveMsgFrame;

/**
 * 채팅 화면
 * 
 * <pre>
 * 	ChatFrame chatFrame = new ChatFrame("USERID201209241623");
 *  ChatFrame.makeInitFrame(); // 실제 데이터를 호출하고 화면을 그리는 메서드
 * </pre>
 * 
 * @author 
 *
 */
public class ChatFrame extends WaveMsgFrame {
	
	private static final long serialVersionUID = 7546904889590160105L;
	
	/**	채팅 내역 */
	private String chatHistory = "";

	/** 생성된 채팅창 서비스ID */
	private String chatServiceId = "";
	
	/** 채팅창에 참여중인 사용자 리스트 */
	private List<UserInfo> userList = null;
	
	/**
	 * 채팅창 생성자 <br>
	 * 생성자를 통해 서비스ID와 사용자 리스트 생성
	 * 
	 * @param chatServiceId 서비스 ID
	 */
	public ChatFrame(String chatServiceId) {
		this.chatServiceId = chatServiceId;
		this.userList = Collections.synchronizedList(new ArrayList<UserInfo>());
	}
	
	@Override
	public void makeInitFrame() {

	}

	@Override
	public void close() {

	}

	/**
	 * 최초 생성에 필요한 데이터 호출
	 */
	public void invokeChatInfo() {

	}

	/**
	 * 서버로부터 사용자 정보 호출
	 */
	public void invokeUserList() {

	}

	/**
	 * 메시지 전달
	 */
	public void sendMsg() {

	}

	/**
	 * 메시지 수신
	 */
	public void receiveMsg() {

	}

	/**
	 * 채팅창에서 나간 사용자 정보 수신
	 */
	public void receiveLeftUserInfo() {

	}

	/**
	 * 수신받은 사용자 정보를 새로 생성 <br>
	 * 사용자 정보 reset
	 */
	public void makeUserList() {

	}

	/**
	 * 폰트 및 생상 설정창 생성
	 */
	public void makeFontFrame() {

	}

	/**
	 * 배경 설정 화면 생성
	 */
	public void makeBackgroundFrame() {

	}

	/**
	 * 채팅 초대 화면 생성
	 */
	public void makeInviteFrame() {

	}

	/**
	 * 파일 전송 및 수신 화면 생성
	 */
	public void makeFileFrame() {

	}

	/**
	 * 대화 내역 저장
	 */
	public void saveChatHistory() {

	}

	/**
	 * 이모티콘 선택
	 */
	public void selectEmoticon() {

	}

	/**
	 * 서비스 ID 반환
	 * @return 서비스 ID
	 */
	public String getChatServiceId() {
		return this.chatServiceId;
	}

	/**
	 * 채팅 내역 반환
	 * @return 채팅 내역
	 */
	public String getChatHistory() {
		return chatHistory;
	}
	
	/**
	 * 현재 참여중인 사용자 리스트 반환
	 * @return 사용자 리스트
	 */
	public List<UserInfo> getUserList() {
		return userList;
	}

}
