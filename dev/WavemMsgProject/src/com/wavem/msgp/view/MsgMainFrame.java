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

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.comm.CommSet;
import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgDialogBox;
import com.wavem.msgp.component.WaveMsgException;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.component.WaveMsgLabel;
import com.wavem.msgp.component.WaveMsgPanel;
import com.wavem.msgp.dto.UserInfo;

/**
 * 메신저 메인 화면 <br>
 * 
 * <pre>
 * 	MsgMainFrame msgMain = MsgMainFrame.getInstance();
 * </pre>
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class MsgMainFrame extends WaveMsgFrame {

	private static final long serialVersionUID = -4042584463931283068L;
	
	/** 타이틀 */
	private String title = CommMsg.MSGMAIN_FRAME_TITLE;
	
	/** 로그인된 사용자 정보 인스턴스 변수 */
	private static UserInfo loginUser = null;
	
	/** 메신저 메일 화면 인스턴스 변수 */
	private static MsgMainFrame msgMainFrame = null;

	/** 현재 접속중인 사용자 리스트 변수 */
	public List<UserInfo> userList = null;
    
	/** 상단의 top패널 인스턴스 변수 */
	private WaveMsgPanel topPanel = null;
	
	/** 옆의 side패널 인스턴스 변수 */
	private WaveMsgPanel sidePanel = null;
	
	/** main패널 인스턴스 변수 */
	private WaveMsgPanel mainPanel = null;
	
	/** footer패널 인스턴스 변수 */
	private WaveMsgPanel footerPanel = null;
	
	/**	
	 * 메인화면 MsgMainFrame 생성자 <br>
	 * 최초 userlist객체 생성 <br>
	 * 최초 makeInitFrame()호출 <br>
	 * 
	 * @throws WaveMsgException 
	 */
	private MsgMainFrame() throws WaveMsgException {
		super();
		makeInitFrame();
	}

	/**
	 * MsgMainFrame 인스턴스 생성 및 반환
	 * 
	 * @return 기존 혹은 생성된 메일 화면 인스턴스
	 * @throws WaveMsgException 
	 */
	public static MsgMainFrame getInstance() throws WaveMsgException {
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
	public void makeInitFrame() throws WaveMsgException {
		
		// 로그인 체크
		if (MsgMainFrame.loginUser == null) {
			makeLoginFrame();
			return;
		} 
		
		// 타이틀 설정
		setTitle(this.title + " - " + MsgMainFrame.loginUser.getUserId());
		
		// 메인 패널 설정
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(MsgMainFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 738);
		
		/* ********************************************************************
		 * 상단의 TOP 패널 시작
		 * ********************************************************************/
		
		// 상단의 TOP 패널 생성
		topPanel = new WaveMsgPanel();
		topPanel.setImage(CommSet.getPaneImage("TOP")); 
		topPanel.setBounds(0, 0, 450, 100); // 상단 TOP 패널 부분의 위치 및 크기 지정
		topPanel.setLayout(null);
		getContentPane().add(topPanel); // 메인 패널에 추가
		
		// 프로필 설정 버튼
		WaveMsgButton profileBtn = new WaveMsgButton();
		profileBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				makeProfileFrame();
			}
		});
		profileBtn.setIcon(new ImageIcon(MsgMainFrame.class.getResource("/com/wavem/resource/img/button/PROFILE.png"))); // TODO : 추후 서버로부터 이미지 받음
		profileBtn.setBounds(12, 10, 100, 80);
		topPanel.add(profileBtn);
		
		WaveMsgLabel idNameInfo = new WaveMsgLabel();
		idNameInfo.setBounds(124, 10, 200, 40);
		topPanel.add(idNameInfo);
		
		/* ********************************************************************
		 * 상단의 TOP 패널 끝
		 * ********************************************************************/
		
		
		
		/* ********************************************************************
		 * 옆 side 패널 시작
		 * ********************************************************************/
		
		// 옆 (side) 패널 생성
		sidePanel = new WaveMsgPanel();
		sidePanel.setImage(CommSet.getPaneImage("SIDE"));
		sidePanel.setBounds(0, 100, 100, 500);
		getContentPane().add(sidePanel);
		sidePanel.setLayout(null);
		
		// 쪽지 쓰기 버튼
		WaveMsgButton msgBtn = new WaveMsgButton("MSG_MAIN");
		msgBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				makeMessageFrame(); // 최초 쪽지 쓰기창 실행
			}
		});
		msgBtn.setBounds(12, 10, 76, 60);
		sidePanel.add(msgBtn);
		
		// 채팅 버튼
		WaveMsgButton chatBtn = new WaveMsgButton("CHAT_MAIN");
		chatBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				makeChatFrame(); // 채팅창 실행
			}
		});
		chatBtn.setBounds(12, 80, 76, 60);
		sidePanel.add(chatBtn);
		
		// 그룹설정 버튼
		WaveMsgButton groupBtn = new WaveMsgButton("GROUP_MAIN");
		groupBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				makeGroupFrame(); // 그룹 설정창 실행
			}
		});
		groupBtn.setBounds(12, 150, 76, 60);
		sidePanel.add(groupBtn);
		
		// 공지사항 버튼
		WaveMsgButton noticeBtn = new WaveMsgButton("NOTICE_MAIN");
		noticeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				makeNoticeFrame(); // 공지사항 확인창 실행
			}
		});
		noticeBtn.setBounds(12, 220, 76, 60);
		sidePanel.add(noticeBtn);
		
		// 파일 보내기 버튼
		WaveMsgButton fileBtn = new WaveMsgButton("FILEUP_MAIN");
		fileBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				makeFileUploadFrame();
			}
		});
		fileBtn.setBounds(12, 290, 76, 60);
		sidePanel.add(fileBtn);
		
		/* ********************************************************************
		 * 옆 side 패널 끝
		 * ********************************************************************/
		
		
		
		/* ********************************************************************
		 * 메인 패널 시작
		 * ********************************************************************/
		
		// 메인 패널 생성
		mainPanel = new WaveMsgPanel();
		mainPanel.setImage(CommSet.getPaneImage("MAIN"));
		mainPanel.setBounds(100, 100, 350, 500);
		getContentPane().add(mainPanel);
		
		/* ********************************************************************
		 * 메인 패널 끝
		 * ********************************************************************/
		
		
		/* ********************************************************************
		 * 바닥 footer 패널 시작
		 * ********************************************************************/
		
		footerPanel = new WaveMsgPanel();
		footerPanel.setImage(CommSet.getPaneImage("FOOTER"));
		footerPanel.setBounds(0, 600, 450, 100);
		getContentPane().add(footerPanel);
		footerPanel.setLayout(null);
		
		// 쪽지내역 버튼
		WaveMsgButton msgBoxBtn = new WaveMsgButton("MSG_FOOTER");
		msgBoxBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				makeMessageBoxFrame(); 
			}
		});
		msgBoxBtn.setBounds(12, 10, 75, 80);
		footerPanel.add(msgBoxBtn);
		
		// 대화내역 버튼
		WaveMsgButton chatBoxBtn = new WaveMsgButton("CHAT_FOOTER");
		chatBoxBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				makeChatBoxFrame();
			}
		});
		chatBoxBtn.setBounds(99, 10, 75, 80);
		footerPanel.add(chatBoxBtn);
		
		// 파일내역 버튼
		WaveMsgButton fileBoxBtn = new WaveMsgButton("FILE_FOOTER");
		fileBoxBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				makeFileBoxFrame();
			}
		});
		fileBoxBtn.setBounds(186, 10, 75, 80);
		footerPanel.add(fileBoxBtn);
		
		// 환경설정 버튼
		WaveMsgButton propertyBtn = new WaveMsgButton("PROPERTY_FOOTER");
		propertyBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				makePropertiesFrame();
			}
		});
		propertyBtn.setBounds(273, 10, 75, 80);
		footerPanel.add(propertyBtn);
		
		// 로그아웃 버튼
		WaveMsgButton logoutBtn = new WaveMsgButton("LOGOUT_FOOTER");
		logoutBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logout();
			}
		});
		logoutBtn.setBounds(360, 10, 75, 80);
		footerPanel.add(logoutBtn);
		
		
		/* ********************************************************************
		 * 바닥 footer 패널 끝
		 * ********************************************************************/
		
	}

	@Override
	public void close() {
		this.dispose();
		MsgMainFrame.msgMainFrame = null;
	}

	/**
	 * 최초 화면 로딩 시 초기 데이터 생성
	 */
	public void invokeInitData() {

	}

	/**
	 * 로그인 화면 생성 <br>
	 * 세션정보 없을 시 로그인 창 생성
	 */
	public void makeLoginFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					new WaveMsgDialogBox(title, e.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * 쪽지내역 화면 생성
	 */
	public void makeMessageBoxFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageBoxFrame frame = MessageBoxFrame.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					new WaveMsgDialogBox(title, e.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * 공지사항 화면 생성
	 */
	public void makeNoticeFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoticeFrame frame = NoticeFrame.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					new WaveMsgDialogBox(title, e.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * 그룹 화면 생성
	 */
	public void makeGroupFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupFrame frame = GroupFrame.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					new WaveMsgDialogBox(title, e.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	/**
	 * 파일 보내기 화면 생성
	 */
	public void makeFileUploadFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileUploadFrame frame = new FileUploadFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					new WaveMsgDialogBox(title, e.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	/**
	 * 파일 받기 화면 생성
	 */
	public void makeFileDownloadFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileDownloadFrame frame = new FileDownloadFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					new WaveMsgDialogBox(title, e.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * 파일내역 화면 생성
	 */
	public void makeFileBoxFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileBoxFrame frame = FileBoxFrame.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					new WaveMsgDialogBox(title, e.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * 프로필 화면 생성
	 */
	public void makeProfileFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileFrame frame = ProfileFrame.getInstance(loginUser);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					new WaveMsgDialogBox(title, e.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * 대화함 화면 생성
	 */
	public void makeChatBoxFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatBoxFrame frame = ChatBoxFrame.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					new WaveMsgDialogBox(title, e.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * 환경설정 화면 생성
	 */
	public void makePropertiesFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PropertyFrame frame = PropertyFrame.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					new WaveMsgDialogBox(title, e.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * 쪽지 화면 생성
	 */
	public void makeMessageFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageFrame frame = new MessageFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					new WaveMsgDialogBox(title, e.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * 채팅창 화면 생성
	 */
	public void makeChatFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatFrame frame = new ChatFrame("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					new WaveMsgDialogBox(title, e.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * 서버의 사용자 리스트 체크
	 */
	public void userChkToServer() {

	}

	/**
	 * 서버로부터 사용자 리스트 체크 요청
	 */
	public void userChkFromServer() {

	}

	/**
	 * 로그아웃
	 */
	public void logout() {
		
		WaveMsgDialogBox box = new WaveMsgDialogBox(this, CommMsg.LOGOUT_TITLE, CommMsg.LOGOUT_Q_MSG, JOptionPane.YES_NO_CANCEL_OPTION);

		if (box.getResult() == 0) {
			// TODO : 로그아웃 실행
		} else {
			// TODO : 로그아웃 취소
		}
		
	}

	/**
	 * 현재 로그인된 사용자 정보 반환
	 * 
	 * @return 로그인 사용자 정보
	 */
	public static UserInfo getLoginUser() {
		return loginUser;
	}
	
	/**
	 * 현재 로그인된 사용자 정보 세팅
	 * 
	 * @return 로그인 사용자 정보
	 */
	public static final void setLoginUser(UserInfo loginUser) {
		MsgMainFrame.loginUser = loginUser;
	}

	@Override
	public void callBackData() throws WaveMsgException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] sd) throws WaveMsgException {
		MsgMainFrame frame = MsgMainFrame.getInstance();
		frame.setVisible(true);
	}
	
}
