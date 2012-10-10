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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.comm.PropertiesInfo;
import com.wavem.msgp.comm.WaveMsgException;
import com.wavem.msgp.component.WaveMsgBackImgInterface;
import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgDialogBox;
import com.wavem.msgp.component.WaveMsgFontInterface;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.component.WaveMsgList;
import com.wavem.msgp.component.WaveMsgPanel;
import com.wavem.msgp.component.WaveMsgScrollPane;
import com.wavem.msgp.component.WaveMsgTextArea;
import com.wavem.msgp.component.WaveMsgTextPane;
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
public class ChatFrame extends WaveMsgFrame implements WaveMsgFontInterface, WaveMsgBackImgInterface {
	
	private static final long serialVersionUID = 7546904889590160105L;
	
	/** 타이틀 */
	private String title = CommMsg.CHAT_FRAME_TITLE;
	
	private PropertiesInfo property = PropertiesInfo.getInstance();
	
	/**	채팅 내역 */
	private StringBuilder chatHistory = new StringBuilder();

	/** 생성된 채팅창 서비스ID */
	private String chatServiceId = "";
	
	/** 채팅창에 참여중인 사용자 리스트 */
	private List<UserInfo> userList = null;
	
	
	private WaveMsgTextPane textPane = null;
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
	
	/** 배경 설정 화면 */
	private BackgroundFrame backGFrame = null;
	
	/** 초대 화면 */
	private InviteFrame inviteFrame = null;
	
	/** 파일 다운로드 화면 */
	private FileDownloadFrame fdownFrame = null;
	
	/** 파일 업로드 화면 */
	private FileUploadFrame fupFrame = null;
	
	/** 폰트 및 색상 속성 */
	private StyleContext context = new StyleContext();
	private StyledDocument doc = new DefaultStyledDocument(context);
	private Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
	
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
		setBounds(100, 100, 500, 598); //598
		setTitle(this.title);
		
		/* *********************************************************
		 * 대화 내역 창 시작
		 * *********************************************************/
//		textArea = new WaveMsgTextArea();
//		textArea.setEditable(false);
//		textArea.setLineWrap(true);
		//getContentPane().add(textArea);
		
		textPane = new WaveMsgTextPane(doc);
		textPane.setEditable(false);
		//getContentPane().add(textPane);
		
		scrollPane = new WaveMsgScrollPane(textPane);
		scrollPane.setBounds(0, 0, 350, 400);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
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
		msgWriteArea.setLineWrap(true);
		msgWriteArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { //엔터키 입력 시
					//e.setKeyCode(KeyEvent.s)
					sendMsg();
				}
			}
		});
		msgWriteArea.setFont(new Font(property.getChatFont(), property.getChatFontStyle(), property.getChatFontSize()));
		msgWriteArea.setForeground(property.getChatColor());
		panel.add(msgWriteArea);
		
		writeScrollPane = new WaveMsgScrollPane(msgWriteArea);
		writeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		writeScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		writeScrollPane.setBounds(10, 0, 380, 90);
		panel.add(writeScrollPane);
		
		chatSendBtn = new WaveMsgButton("CHAT_SEND_BTN");
		chatSendBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sendMsg();
			}
		});
		chatSendBtn.setBounds(400, 0, 74, 90);
		panel.add(chatSendBtn);
		
		msgWriteArea.requestFocus(); // 최초 로딩시 메시지 입력할 수 있도록 강제지정
		
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
		
		// TODO : 임시로직 -> 추후 서버에 전송하여 받은 데이터를 화면에 그려주도록 한다.
		
		try {
			doc.insertString(doc.getLength(), "\n guest - "+msgWriteArea.getText().trim()
					, getChatAttr(property.getChatFont(), property.getChatFontStyle(), property.getChatFontSize(), property.getChatColor()));
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		
		msgWriteArea.setText(null);
	}

	/**
	 * 메시지 수신
	 */
	public void receiveMsg() {

	}

	/**
	 * 적용하기 위한 색상을 생성하여 반환
	 * 
	 * @param font
	 * @param fontStyle
	 * @param fontSize
	 * @param color
	 * @return 폰트 속성
	 */
	public SimpleAttributeSet getChatAttr(String font, int fontStyle, int fontSize, Color color) {
		
		// TODO : 추 후 서버에서 받은 데이터를 이용하여 메시지를 보내는 로직으로 대체
		//        현재는 임시로 설정이 변경되는 것을 확인하기 위한 로직이다.
		
		// 구간별 별도로 텍스트 변경하기 위한 설정 
		SimpleAttributeSet attr = new SimpleAttributeSet();
		
		attr.addAttribute(StyleConstants.CharacterConstants.Foreground, color); // 색 적용
		attr.addAttribute(StyleConstants.CharacterConstants.FontFamily, font); // 폰트 적용
		attr.addAttribute(StyleConstants.CharacterConstants.FontSize, fontSize); // 폰트 크기 적용
		
		// 폰트 스타일 적용
		if (fontStyle == Font.BOLD) {
			attr.addAttribute(StyleConstants.CharacterConstants.Bold, Boolean.TRUE);
			attr.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.FALSE);
		} else if (fontStyle == Font.ITALIC) {
			attr.addAttribute(StyleConstants.CharacterConstants.Bold, Boolean.FALSE);
			attr.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.TRUE);
		} else if (fontStyle == (Font.BOLD|Font.ITALIC)) {
			attr.addAttribute(StyleConstants.CharacterConstants.Bold, Boolean.TRUE);
			attr.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.TRUE);
		} else {
			attr.addAttribute(StyleConstants.CharacterConstants.Bold, Boolean.FALSE);
			attr.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.FALSE);
		}
		
		return attr;
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
			
			if (chatFontFrame == null) { // 설정창이 이미 생성된 경우 새로 생성하지 않는다.
				chatFontFrame = new ChatFontFrame(this);
				chatFontFrame.setVisible(true);
			} else {
				chatFontFrame.requestFocus();
			}
			
		} catch (WaveMsgException e) {
			e.printStackTrace();
			new WaveMsgDialogBox(this.title, CommMsg.LOAD_FRAME_ERROR, JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 배경 설정 화면 생성
	 */
	public void makeBackgroundFrame() {
		
		try {
			
			if (backGFrame == null) { // 설정창이 이미 생성된 경우 새로 생성하지 않는다.
				backGFrame = new BackgroundFrame(this);
				backGFrame.setVisible(true);
			} else {
				backGFrame.requestFocus();
			}
			
		} catch (WaveMsgException e) {
			e.printStackTrace();
			new WaveMsgDialogBox(this.title, CommMsg.LOAD_FRAME_ERROR, JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void setBackGround() {
		// TODO 배경 설정
		
	}
	
	/**
	 * 채팅 초대 화면 생성
	 */
	public void makeInviteFrame() {
		
		// TODO : 전체 리스트는 통신을 통해서 얻어와야 한다.
		
		try {
			
			if (inviteFrame == null) {
				inviteFrame = new InviteFrame(new ArrayList<UserInfo>(), this.userList);
				inviteFrame.setVisible(true);
			} else {
				inviteFrame.requestFocus();
			}
			
		} catch (WaveMsgException e) {
			e.printStackTrace();
			new WaveMsgDialogBox(this.title, CommMsg.LOAD_FRAME_ERROR, JOptionPane.ERROR_MESSAGE);
		} 
	}

	/**
	 * 파일 전송 화면 생성
	 */
	public void makeFileFrame() {
		
		// TODO : 현재 접속중인 사용자 중 한명 이상을 선택해야 파일을 전송할 수 있도록 한다.
		
		try {
			
			if (fupFrame == null) {
				fupFrame = new FileUploadFrame();
				fupFrame.setVisible(true);
			} else {
				fupFrame.requestFocus();
			}
			
		} catch (WaveMsgException e) {
			e.printStackTrace();
			new WaveMsgDialogBox(this.title, CommMsg.LOAD_FRAME_ERROR, JOptionPane.ERROR_MESSAGE);
		}
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
		return chatHistory.toString();
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




