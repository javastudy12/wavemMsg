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
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.comm.PropertiesInfo;
import com.wavem.msgp.comm.WaveMsgException;
import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgDialogBox;
import com.wavem.msgp.component.WaveMsgFontInterface;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.component.WaveMsgList;
import com.wavem.msgp.component.WaveMsgPanel;
import com.wavem.msgp.component.WaveMsgScrollPane;
import com.wavem.msgp.component.WaveMsgTextArea;
import com.wavem.msgp.dto.UserInfo;

/**
 * 채팅 화면
 * 
 * <pre>
 * 	ChatFrame chatFrame = new ChatFrame("USERID201209241623");
 * </pre>
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class ChatFrame extends WaveMsgFrame implements WaveMsgFontInterface {
	
	private static final long serialVersionUID = 7546904889590160105L;
	
	/** 타이틀 */
	private String title = CommMsg.CHAT_FRAME_TITLE;
	
	private PropertiesInfo property = PropertiesInfo.getInstance();
	
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
	
	/** 메시지 작성 공간 */
	private WaveMsgTextArea msgWriteArea = null;
	
	/** 스크롤 패널 */
	private WaveMsgScrollPane writeScrollPane = null;
	
			
	
	/** 폰트 설정 버튼 */
	private WaveMsgButton fontSetBtn = null;		
		
	/** 배경 설정 버튼 */
	private WaveMsgButton backgroundSetBtn = null;
			
	/** 초대 버튼 */
	private WaveMsgButton inviteBtn = null;
	
	/** 파일 전송 버튼 */
	private WaveMsgButton fileUpBtn = null;
	
	/** 대화 내역 저장 버튼 */
	private WaveMsgButton chatHistorySaveBtn = null;
	
	/** 이모티콘 버튼 */
	private WaveMsgButton emoticonBtn = null;
	
	/** 나가기 버튼 */
	private WaveMsgButton chatOutBtn = null;
	
	/** 메시지 보내기 버튼 */
	private WaveMsgButton chatSendBtn = null;
	
	
	/** 폰트 및 색상 설정 화면 */
	private ChatFontFrame chatFontFrame = null;
	
	
	
	/**
	 * 채팅창 생성자 <br>
	 * 생성자를 통해 서비스ID와 사용자 리스트 생성<br>
	 * 
	 * @param chatServiceId 서비스 ID
	 * @throws WaveMsgException 
	 */
	public ChatFrame(String chatServiceId) throws WaveMsgException {
		this.chatServiceId = chatServiceId;
		this.userList = Collections.synchronizedList(new ArrayList<UserInfo>());
		makeInitFrame();
	}
	
	@Override
	public void makeInitFrame() throws WaveMsgException {
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 598);
		setTitle(this.title);
		
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
		actionBtnPane.setLayout(null);
		getContentPane().add(actionBtnPane);
		
		fontSetBtn = new WaveMsgButton("FONTSET");
		fontSetBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				makeFontFrame();
			}
		});
		fontSetBtn.setBounds(12, 10, 50, 40);
		actionBtnPane.add(fontSetBtn);
		
		backgroundSetBtn = new WaveMsgButton("BACKGROUNDSET");
		backgroundSetBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				makeBackgroundFrame();
			}
		});
		backgroundSetBtn.setBounds(74, 10, 50, 40);
		actionBtnPane.add(backgroundSetBtn);
		
		inviteBtn = new WaveMsgButton("INVITE");
		inviteBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				makeInviteFrame();
			}
		});
		inviteBtn.setBounds(136, 10, 50, 40);
		actionBtnPane.add(inviteBtn);
		
		fileUpBtn = new WaveMsgButton("FILEUP");
		fileUpBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				makeFileFrame();
			}
		});
		fileUpBtn.setBounds(198, 10, 50, 40);
		actionBtnPane.add(fileUpBtn);
		
		chatHistorySaveBtn = new WaveMsgButton("CHATHISTORY");
		chatHistorySaveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saveChatHistory();
			}
		});
		chatHistorySaveBtn.setBounds(260, 10, 50, 40);
		actionBtnPane.add(chatHistorySaveBtn);
		
		emoticonBtn = new WaveMsgButton("EMOTICON");
		emoticonBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectEmoticon();
			}
		});
		emoticonBtn.setBounds(322, 10, 50, 40);
		actionBtnPane.add(emoticonBtn);
		
		chatOutBtn = new WaveMsgButton("CHATOUT");
		chatOutBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		chatOutBtn.setBounds(384, 10, 50, 40);
		actionBtnPane.add(chatOutBtn);
		
		
		/* *********************************************************
		 * 기능 버튼 패널 끝
		 * *********************************************************/
		
		
		
		/* *********************************************************
		 * 메시지 작성
		 * *********************************************************/
		WaveMsgPanel panel = new WaveMsgPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 460, 484, 100);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		msgWriteArea = new WaveMsgTextArea();
		msgWriteArea.setFont(new Font(property.getChatFont(), property.getChatFontStyle(), property.getChatFontSize()));
		msgWriteArea.setForeground(property.getChatColor());
		panel.add(msgWriteArea);
		
		writeScrollPane = new WaveMsgScrollPane(msgWriteArea);
		writeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		writeScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		writeScrollPane.setBounds(10, 0, 380, 90);
		panel.add(writeScrollPane);
		
		chatSendBtn = new WaveMsgButton("CHAT_SEND_BTN");
		chatOutBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sendMsg();
			}
		});
		chatSendBtn.setBounds(400, 0, 74, 90);
		panel.add(chatSendBtn);
		
		
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
		try {
			chatFontFrame = ChatFontFrame.getInstance(this);
			chatFontFrame.setVisible(true);
		} catch (WaveMsgException e) {
			e.printStackTrace();
			new WaveMsgDialogBox(this.title, CommMsg.LOAD_FRAME_ERROR, JOptionPane.ERROR_MESSAGE);
		}
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
	 * 채팅방 나가기
	 */
	public void outChat() {

		// 저장 할 것인지 질문 메시지
		WaveMsgDialogBox box = new WaveMsgDialogBox(this, this.title, CommMsg.OUTCHAT_Q_MSG, JOptionPane.OK_CANCEL_OPTION);
		
		if (box.getResult() == 0) close(); // 임시
		/* *************************************************************
		 * TODO : 나가기를 선택하였을 경우 서버에 알리고 종료한다.
		 * *************************************************************/
	}

	@Override
	public void setFrameFont() {
		msgWriteArea.setFont(new Font(chatFontFrame.getChatFont(), chatFontFrame.getChatFontStyle(), chatFontFrame.getChatFontSize()));
	}

	@Override
	public void setFrameColor() {
		msgWriteArea.setForeground(chatFontFrame.getChatColor());
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
	public void callBackData() throws WaveMsgException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] sd) throws WaveMsgException {
		ChatFrame frame = new ChatFrame("asdf");
		frame.setVisible(true);
	}

}
