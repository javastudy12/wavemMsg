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
 * 초대 화면
 * @author HG01362
 *
 */
public class InviteFrame extends AbstractFrame{
	
	private static final long serialVersionUID = -8324014326166783001L;
	
	/** 현재 로그인 한 전체 사용자 리스트 */
	private List<UserInfo> allUserList = null;
	
	/** 채팅창에 접속중인 사용자 리스트 */
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
