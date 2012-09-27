/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : ChatController.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.wavem.msgp.view.ChatFrame;

/**
 * 채팅 및 쪽지 관련 컨트롤러
 * 
 * @author
 *
 */
public class ChatController {
	
	/** 생성된 채팅 인스턴스관리 Map */
	public static Map<String, ChatFrame> chatInstanceMap = Collections.synchronizedMap(new HashMap<String, ChatFrame>());

	/**
	 * 활성화 된 채팅창 중 특정 창 반환
	 * 
	 * @param chatUseID Map에 저장된 채팅창 인스턴스 ID
	 * @return 해당하는 채팅 화면 반환
	 */
	public ChatFrame findChatInstance(String chatUseID) {
	
		return null;
	}
	
	/**
	 * 채팅 화면 생성
	 */
	public void makeChatFrame() {
	
	}
	
	/**
	 * 서버로부터 전달받은 메시지를 채팅창에 전달
	 */
	public void writeMsgToChatFrame() {
	
	}
	
	/**
	 * 채팅창으로부터 전달받은 메시지를 서버로 전달
	 */
	public void sendMsgToServer() {
	
	}
	
	/**
	 * 쪽지창으로부터 전달받은 메시지를 서버로 전달
	 */
	public void sendMessage() {
	
	}
	
	/**
	 * 서버로부터 전달받은 메시지를 메인화면으로 전달하여 받은 쪽지함 생성
	 */
	public void receiveMessage() {
	
	}
	
	/**
	 * 주기적으로 채팅창에 남아있는 사용자 체크 (서버와 동기화 작업)
	 */
	public void checkUserList() {
	
	}
}
