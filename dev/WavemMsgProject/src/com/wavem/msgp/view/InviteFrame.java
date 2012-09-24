/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : InviteFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/


package com.wavem.msgp.view;
import java.util.List;

import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.dto.UserInfo;

/**
 * �ʴ� ȭ��
 * 
 * <pre>
 * 	// �����ڿ� ��ü ����ڿ� ä��â ���� ����ڸ� �Ķ���ͷ� �ѱ��.
 * 	InviteFrame inviteFrame = new InviteFrame(new ArrayList<UserInfo>(), new ArrayList<UserInfo>());
 *  InviteFrame.makeInitFrame(); // ���� �����͸� ȣ���ϰ� ȭ���� �׸��� �޼���
 * </pre>
 * 
 * @author
 *
 */
public class InviteFrame extends WaveMsgFrame{
	
	private static final long serialVersionUID = -8324014326166783001L;
	
	/** ���� �α��� �� ��ü ����� ����Ʈ */
	private List<UserInfo> allUserList = null;
	
	/** ä��â�� �������� ����� ����Ʈ */
	private List<UserInfo> chatUserList = null;
	
	public InviteFrame(List<UserInfo> allUserList, List<UserInfo> chatUserList) {
		this.allUserList = allUserList;
		this.chatUserList = chatUserList;
	}
	
	@Override
	public void makeInitFrame() {
	
	}
	
	@Override
	public void close() {
		
	}
	
	/**
	 * ���� �α��� �� ��ü ����� ����Ʈ�� ȭ�鿡 ���
	 */
	public void makeAllUserList() {
	
	}
	
	/**
	 * ���� ä��â�� ������ ����� ����Ʈ�� ȭ�鿡 ��� 
	 */
	public void makechatUserList() {
	
	}
	
	/**
	 * ��ü ����� ����Ʈ���� ������ ����ڸ� �ʴ��� ����� ����Ʈ�� �̵� (�ʴ�)
	 */
	public void addChatUserList() {
	
	}
	
	/**
	 * �ʴ��� ����� ����Ʈ���� ������ ����ڤѤ� ��ü ����� ����Ʈ�� �̵� (����)
	 */
	public void deleteChatUserList() {
	
	}
	
	/**
	 * �ʴ��� ����� ����Ʈ�� ����ڸ� ���� ä��â���� �ʴ�
	 */
	public void inviteUser() {
	
	}
	
}
