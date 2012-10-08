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

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ScrollPaneConstants;

import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.component.WaveMsgList;
import com.wavem.msgp.component.WaveMsgPanel;
import com.wavem.msgp.component.WaveMsgScrollPane;
import com.wavem.msgp.component.WaveMsgTextArea;
import com.wavem.msgp.dto.UserInfo;
import javax.swing.JPanel;

/**
 * 채팅 화면
 * 
 * <pre>
 * 	ChatFrame chatFrame = new ChatFrame("USERID201209241623");
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
	
	
	
	private WaveMsgTextArea textArea = null;
	private WaveMsgScrollPane scrollPane = null;
	
	private WaveMsgList withUserList = null;
	private WaveMsgScrollPane withUserlPane = null;
	
	private WaveMsgPanel actionBtnPane = null;
	
	/**
	 * 채팅창 생성자 <br>
	 * 생성자를 통해 서비스ID와 사용자 리스트 생성<br>
	 * 
	 * @param chatServiceId 서비스 ID
	 */
	public ChatFrame(String chatServiceId) {
		this.chatServiceId = chatServiceId;
		this.userList = Collections.synchronizedList(new ArrayList<UserInfo>());
		makeInitFrame();
	}
	
	@Override
	public void makeInitFrame() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 598);
		setTitle("채팅");
		
		/* *********************************************************
		 * 대화 내역 창 시작
		 * *********************************************************/
		textArea = new WaveMsgTextArea();
		getContentPane().add(textArea);
		
		scrollPane = new WaveMsgScrollPane(textArea);
		scrollPane.setBounds(0, 0, 350, 400);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollPane);
		
		/* *********************************************************
		 * 대화 내역 창 끝
		 * *********************************************************/
		
		
		
		/* *********************************************************
		 * 참여자 시작
		 * *********************************************************/
		withUserList = new WaveMsgList();
		
		withUserlPane = new WaveMsgScrollPane(withUserList);
		withUserlPane.setBounds(350, 0, 134, 400);
		getContentPane().add(withUserlPane);
		
		/* *********************************************************
		 * 참여자 끝
		 * *********************************************************/
		
		
		
		/* *********************************************************
		 * 기능 버튼 패널 시작
		 * *********************************************************/
		actionBtnPane = new WaveMsgPanel();
		actionBtnPane.setBackground(Color.WHITE);
		actionBtnPane.setBounds(0, 400, 484, 60);
		getContentPane().add(actionBtnPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 460, 484, 100);
		getContentPane().add(panel);
		
		
		
		
		/* *********************************************************
		 * 기능 버튼 패널 끝
		 * *********************************************************/
		
	}

	@Override
	public void close() {
		this.dispose();
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

	@Override
	public void callBackData() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
