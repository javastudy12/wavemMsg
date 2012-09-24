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
 * ä�� ȭ��
 * 
 * <pre>
 * 	ChatFrame chatFrame = new ChatFrame("USERID201209241623");
 *  ChatFrame.makeInitFrame(); // ���� �����͸� ȣ���ϰ� ȭ���� �׸��� �޼���
 * </pre>
 * 
 * @author 
 *
 */
public class ChatFrame extends WaveMsgFrame {
	
	private static final long serialVersionUID = 7546904889590160105L;
	
	/**	ä�� ���� */
	private String chatHistory = "";

	/** ������ ä��â ����ID */
	private String chatServiceId = "";
	
	/** ä��â�� �������� ����� ����Ʈ */
	private List<UserInfo> userList = null;
	
	/**
	 * ä��â ������ <br>
	 * �����ڸ� ���� ����ID�� ����� ����Ʈ ����
	 * 
	 * @param chatServiceId ���� ID
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
	 * ���� ������ �ʿ��� ������ ȣ��
	 */
	public void invokeChatInfo() {

	}

	/**
	 * �����κ��� ����� ���� ȣ��
	 */
	public void invokeUserList() {

	}

	/**
	 * �޽��� ����
	 */
	public void sendMsg() {

	}

	/**
	 * �޽��� ����
	 */
	public void receiveMsg() {

	}

	/**
	 * ä��â���� ���� ����� ���� ����
	 */
	public void receiveLeftUserInfo() {

	}

	/**
	 * ���Ź��� ����� ������ ���� ���� <br>
	 * ����� ���� reset
	 */
	public void makeUserList() {

	}

	/**
	 * ��Ʈ �� ���� ����â ����
	 */
	public void makeFontFrame() {

	}

	/**
	 * ��� ���� ȭ�� ����
	 */
	public void makeBackgroundFrame() {

	}

	/**
	 * ä�� �ʴ� ȭ�� ����
	 */
	public void makeInviteFrame() {

	}

	/**
	 * ���� ���� �� ���� ȭ�� ����
	 */
	public void makeFileFrame() {

	}

	/**
	 * ��ȭ ���� ����
	 */
	public void saveChatHistory() {

	}

	/**
	 * �̸�Ƽ�� ����
	 */
	public void selectEmoticon() {

	}

	/**
	 * ���� ID ��ȯ
	 * @return ���� ID
	 */
	public String getChatServiceId() {
		return this.chatServiceId;
	}

	/**
	 * ä�� ���� ��ȯ
	 * @return ä�� ����
	 */
	public String getChatHistory() {
		return chatHistory;
	}
	
	/**
	 * ���� �������� ����� ����Ʈ ��ȯ
	 * @return ����� ����Ʈ
	 */
	public List<UserInfo> getUserList() {
		return userList;
	}

}
