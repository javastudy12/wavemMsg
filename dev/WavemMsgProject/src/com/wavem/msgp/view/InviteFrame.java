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

import java.awt.Color;
import java.util.List;

import javax.swing.JButton;

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgException;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.component.WaveMsgLabel;
import com.wavem.msgp.component.WaveMsgList;
import com.wavem.msgp.component.WaveMsgScrollPane;
import com.wavem.msgp.dto.UserInfo;

/**
 * 초대 화면
 * 
 * <pre>
 * 	// 생성자에 전체 사용자와 채팅창 접속 사용자를 파라미터로 넘긴다.
 * 	InviteFrame inviteFrame = new InviteFrame(new ArrayList<UserInfo>(), new ArrayList<UserInfo>());
 * </pre>
 * 
 * @author
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class InviteFrame extends WaveMsgFrame{
	
	private static final long serialVersionUID = -8324014326166783001L;
	
	/** 초대 화면 인스턴스 변수 */
//	private static InviteFrame frame = null;

	/** 타이틀 */
	private String title = CommMsg.INVITE_FRAME_TITLE;
	
	/** 현재 로그인 한 전체 사용자 리스트 */
	private List<UserInfo> allUserList = null;
	
	/** 채팅창에 접속중인 사용자 리스트 */
	private List<UserInfo> chatUserList = null;
	
	
	/** 전체 사용자 */
	private WaveMsgList allUserListPane = null;
	/** 참여중인 사용자 */
	private WaveMsgList chatUserListPane = null;
	
	
	
	/**
	 * 초대화면 생성자 <br>
	 * 최초에 makeInitFrame()호출 <br>
	 * 
	 * @param allUserList 로그인한 전체 사용자
	 * @param chatUserList 현재 참여한 사용자
	 * @throws WaveMsgException 
	 */
	public InviteFrame(List<UserInfo> allUserList, List<UserInfo> chatUserList) throws WaveMsgException {
		super();
		this.allUserList = allUserList;
		this.chatUserList = chatUserList;
		makeInitFrame();
	}
	
	@Override
	public void makeInitFrame() throws WaveMsgException {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setTitle(this.title);
		setDefaultCloseOperation(WaveMsgFrame.DISPOSE_ON_CLOSE);

		
		
		WaveMsgLabel allUserLbl = new WaveMsgLabel("전체 사용자");
		allUserLbl.setBounds(12, 20, 118, 15);
		getContentPane().add(allUserLbl);
		
		WaveMsgLabel chatUserLbl = new WaveMsgLabel("참여중인 사용자");
		chatUserLbl.setBounds(305, 20, 118, 15);
		getContentPane().add(chatUserLbl);
		
		
		// 전체 사용자 리스트
		allUserListPane = new WaveMsgList();
		
		WaveMsgScrollPane allScroll = new WaveMsgScrollPane(allUserListPane);
		allScroll.setBounds(12, 52, 232, 433);
		getContentPane().add(allScroll);
		
		
		// 참여중인 사용자 리스트
		chatUserListPane = new WaveMsgList();
		
		WaveMsgScrollPane chatScroll = new WaveMsgScrollPane(chatUserListPane);
		chatScroll.setBounds(305, 52, 232, 433);
		getContentPane().add(chatScroll);
		
		
		
		
		
		WaveMsgButton okBtn = new WaveMsgButton("OK");
		okBtn.setBounds(405, 511, 60, 23);
		getContentPane().add(okBtn);
		
		WaveMsgButton closeBtn = new WaveMsgButton("CLOSE");
		closeBtn.setBounds(477, 511, 60, 23);
		getContentPane().add(closeBtn);
		
		
		
		
		
		
		WaveMsgButton inviteBtn = new WaveMsgButton();
		inviteBtn.setBounds(256, 175, 38, 54);
		getContentPane().add(inviteBtn);
		
		WaveMsgButton deleteBtn = new WaveMsgButton();
		deleteBtn.setBounds(256, 257, 38, 54);
		getContentPane().add(deleteBtn);
		
		
		
		
		
	}
	
	@Override
	public void close() {
		this.dispose();
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

	@Override
	public void callBackData() throws WaveMsgException {
		// TODO Auto-generated method stub
		
	}
}
