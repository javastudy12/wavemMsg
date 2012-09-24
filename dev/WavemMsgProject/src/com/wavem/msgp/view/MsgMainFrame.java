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
 * �޽��� ���� ȭ�� <br>
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
	
	/** ���� �������� ����� ����Ʈ  */
	public List<UserInfo> userList = null;
	
	/** �޽��� ���� ȭ�� �ν��Ͻ� */
	private static MsgMainFrame msgMainFrame = null;
    
	/**	
	 * ����ȭ�� MsgMainFrame ������ <br>
	 * ���� userlist��ü ���� <br>
	 */
	private MsgMainFrame() {
		userList = new ArrayList<UserInfo>();
	}

	/**
	 * MsgMainFrame �ν��Ͻ� ���� �� ��ȯ
	 * 
	 * @return ���� Ȥ�� ������ ���� ȭ�� �ν��Ͻ�
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
		// TODO ���� ȭ�� ���� 
	}

	@Override
	public void close() {
		// TODO ȭ�� ���� 

	}

	/**
	 * ���� ȭ�� �ε� �� �ʱ� ������ ����
	 */
	public void invokeInitData() {

	}

	/**
	 * �α��� ȭ�� ���� <br>
	 * �������� ���� �� �α��� â ����
	 */
	public void makeLoginFrame() {

	}

	/**
	 * ������ ȭ�� ����
	 */
	public void makeMessageBoxFrame() {

	}

	/**
	 * �������� ȭ�� ����
	 */
	public void makeNoticeFrame() {

	}

	/**
	 * �׷� ȭ�� ����
	 */
	public void makeGroupFrame() {

	}

	/**
	 * ������ ȭ�� ����
	 */
	public void makeFileBoxFrame() {

	}

	/**
	 * ������ ȭ�� ����
	 */
	public void makeProfileFrame() {

	}

	/**
	 * ��ȭ�� ȭ�� ����
	 */
	public void makeChatBoxFrame() {

	}

	/**
	 * ȯ�漳�� ȭ�� ����
	 */
	public void makePropertiesFrame() {

	}

	/**
	 * ���� ȭ�� ����
	 */
	public void makeMessageFrame() {

	}

	/**
	 * ä��â ȭ�� ����
	 */
	public void makeChatFrame() {

	}

	/**
	 * ������ ����� ����Ʈ üũ
	 */
	public void userChkToServer() {

	}

	/**
	 * �����κ��� ����� ����Ʈ üũ ��û
	 */
	public void userChkFromServer() {

	}

	/**
	 * �α׾ƿ�
	 */
	public void logout() {

	}

}
