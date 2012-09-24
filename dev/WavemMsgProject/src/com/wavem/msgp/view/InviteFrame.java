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
 * 초대 화면
 * 
 * <pre>
 * 	// 생성자에 전체 사용자와 채팅창 접속 사용자를 파라미터로 넘긴다.
 * 	InviteFrame inviteFrame = new InviteFrame(new ArrayList<UserInfo>(), new ArrayList<UserInfo>());
 *  InviteFrame.makeInitFrame(); // 실제 데이터를 호출하고 화면을 그리는 메서드
 * </pre>
 * 
 * @author
 *
 */
public class InviteFrame extends WaveMsgFrame{
	
	private static final long serialVersionUID = -8324014326166783001L;
	
	/** 현재 로그인 한 전체 사용자 리스트 */
	private List<UserInfo> allUserList = null;
	
	/** 채팅창에 접속중인 사용자 리스트 */
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
	 * 현재 로그인 된 전체 사용자 리스트를 화면에 출력
	 */
	public void makeAllUserList() {
	
	}
	
	/**
	 * 현재 채팅창에 접속한 사용자 리스트를 화면에 출력 
	 */
	public void makechatUserList() {
	
	}
	
	/**
	 * 전체 사용자 리스트에서 선택한 사용자를 초대할 사용자 리스트로 이동 (초대)
	 */
	public void addChatUserList() {
	
	}
	
	/**
	 * 초대할 사용자 리스트에서 선택한 사용자ㅡㄹ 전체 사용자 리스트로 이동 (삭제)
	 */
	public void deleteChatUserList() {
	
	}
	
	/**
	 * 초대할 사용자 리스트의 사용자를 현재 채팅창으로 초대
	 */
	public void inviteUser() {
	
	}
	
}
