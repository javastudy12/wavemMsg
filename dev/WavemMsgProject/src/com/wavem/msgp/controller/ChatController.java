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
 * ä�� �� ���� ���� ��Ʈ�ѷ�
 * 
 * @author
 *
 */
public class ChatController {
	
	/** ������ ä�� �ν��Ͻ����� Map */
	public static Map<String, ChatFrame> chatInstanceMap = Collections.synchronizedMap(new HashMap<String, ChatFrame>());

	/**
	 * Ȱ��ȭ �� ä��â �� Ư�� â ��ȯ
	 * 
	 * @param chatUseID Map�� ����� ä��â �ν��Ͻ� ID
	 * @return �ش��ϴ� ä�� ȭ�� ��ȯ
	 */
	public ChatFrame findChatInstance(String chatUseID) {
	
		return null;
	}
	
	/**
	 * ä�� ȭ�� ����
	 */
	public void makeChatFrame() {
	
	}
	
	/**
	 * �����κ��� ���޹��� �޽����� ä��â�� ����
	 */
	public void writeMsgToChatFrame() {
	
	}
	
	/**
	 * ä��â���κ��� ���޹��� �޽����� ������ ����
	 */
	public void sendMsgToServer() {
	
	}
	
	/**
	 * ����â���κ��� ���޹��� �޽����� ������ ����
	 */
	public void sendMessage() {
	
	}
	
	/**
	 * �����κ��� ���޹��� �޽����� ����ȭ������ �����Ͽ� ���� ������ ����
	 */
	public void receiveMessage() {
	
	}
	
	/**
	 * �ֱ������� ä��â�� �����ִ� ����� üũ (������ ����ȭ �۾�)
	 */
	public void checkUserList() {
	
	}
}
