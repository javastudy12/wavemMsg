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

import com.wavem.msgp.dto.UserInfo;
import com.wavem.msgp.main.AbstractFrame;

/**
 * �ʴ� ȭ��
 * @author HG01362
 *
 */
public class InviteFrame extends AbstractFrame{
	
	private static final long serialVersionUID = -8324014326166783001L;
	
	/** ���� �α��� �� ��ü ����� ����Ʈ */
	private List<UserInfo> allUserList = null;
	
	/** ä��â�� �������� ����� ����Ʈ */
	private List<UserInfo> chatUserList = null;
	
	public InviteFrame(List<UserInfo> allUserList, List<UserInfo> chatUserList) {
		this.allUserList = allUserList;
		this.chatUserList = chatUserList;
	}
	
	public void makeInitFrame() {
	
	}
	
	public void makeAllUserList() {
	
	}
	
	public void makechatUserList() {
	
	}
	
	public void addChatUserList() {
	
	}
	
	public void deleteChatUserList() {
	
	}
	
	public void inviteUser() {
	
	}
	
	public void close() {
	
	}
}
