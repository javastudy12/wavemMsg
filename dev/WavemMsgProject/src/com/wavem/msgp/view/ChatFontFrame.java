/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : FontFrame.java
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
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.comm.PropertiesInfo;
import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgDialogBox;
import com.wavem.msgp.component.WaveMsgException;
import com.wavem.msgp.component.WaveMsgFontInterface;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.component.WaveMsgLabel;

/**
 * 채팅 폰트 및 색상 설정 화면
 * 
 * <pre>
 * 	FontFrame fontFrame = new FontFrame();
 * </pre>
 * 
 * @author 
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class ChatFontFrame extends WaveMsgFrame implements WaveMsgFontInterface{
	
	private static final long serialVersionUID = 7117625848207442204L;

	private WaveMsgFontInterface chatFrame = null;
	
	/** 환경설정 인스턴스 */
	private PropertiesInfo properties = PropertiesInfo.getInstance();
	
	/** 타이틀 */
	private String title = CommMsg.FONT_FRAME_TITLE;
	
	/** 미리보기 */
	private JEditorPane previewTxtPane = null;
	
	/**  폰트 설정창 */
	private WaveMsgFontFrame fontFrame = null;
	/** 색상 설정창 */
	private WaveMsgColorChooser colorFrame = null;
	
	/** 폰트 */
	private String chatFont = "";
	private int chatFontStyle = 0;
	private int chatFontSize = 12;
	
	/** 색상 */
	private Color chatColor = null;
	
	/**
	 * 채팅 폰트 및 색상 설정 화면 <br>
	 * 최초 makeInitFrame()호출 <br>
	 * 
	 * @throws WaveMsgException 
	 */
	public ChatFontFrame(WaveMsgFontInterface chatFrame) throws WaveMsgException {
		
		this.chatFrame = chatFrame;
		
		getContentPane().setBackground(Color.WHITE);
		makeInitFrame();
	}
	
	/**
	 * 채팅 폰트 및 색상 설정 화면을 위한 인스턴스 반환
	 * 
	 * @return 채팅 폰트 및 색상 설정 화면을 위한 화면 인스턴스
	 * @throws WaveMsgException 
	 */
//	public static ChatFontFrame getInstance(WaveMsgFontInterface chatFrame) throws WaveMsgException {
//		
//		if (frame == null) {
//			synchronized (ChatFontFrame.class) {
//				if (frame == null) {
//					frame = new ChatFontFrame(chatFrame);
//				}
//			}
//		}
//		
//		return frame;
//	}
	
	@Override
	public void makeInitFrame() throws WaveMsgException {
		
		this.chatFont = properties.getChatFont();
		this.chatFontStyle = properties.getChatFontStyle();
		this.chatFontSize = properties.getChatFontSize();
		
		this.chatColor = properties.getChatColor();
		
		
		getContentPane().setLayout(null);
		setBounds(10, 10, 416, 200);
		setTitle(this.title);
		setDefaultCloseOperation(WaveMsgFrame.DISPOSE_ON_CLOSE);
		
		WaveMsgLabel fontSetLbl = new WaveMsgLabel("폰트 설정");
		fontSetLbl.setBounds(12, 22, 72, 15);
		getContentPane().add(fontSetLbl);
		
		WaveMsgLabel colorSetLbl = new WaveMsgLabel("색상 설정");
		colorSetLbl.setBounds(12, 92, 72, 15);
		getContentPane().add(colorSetLbl);
		
		WaveMsgButton fontSetBtn = new WaveMsgButton("SETTING");
		fontSetBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				makeFontFrame();
			}
		});
		fontSetBtn.setBounds(83, 18, 60, 23);
		getContentPane().add(fontSetBtn);
		
		WaveMsgButton colorSetBtn = new WaveMsgButton("SETTING");
		colorSetBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				makeColorFrame();
			}
		});
		colorSetBtn.setBounds(83, 88, 60, 23);
		getContentPane().add(colorSetBtn);
		
		JPanel previewPane = new JPanel();
		previewPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		previewPane.setBackground(Color.WHITE);
		previewPane.setBounds(173, 22, 195, 89);
		getContentPane().add(previewPane);
		previewPane.setLayout(null);
		
		previewTxtPane = new JEditorPane();
		previewTxtPane.setText("가나다라...\r\nAa Bb Cc...");
		previewTxtPane.setBounds(63, 24, 106, 44);
		previewTxtPane.setFont(new Font(this.chatFont, this.chatFontStyle, this.chatFontSize));
		previewTxtPane.setForeground(properties.getChatColor());
		previewPane.add(previewTxtPane);
		
		WaveMsgButton closeBtn = new WaveMsgButton("CLOSE");
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
		closeBtn.setBounds(308, 121, 60, 23);
		getContentPane().add(closeBtn);
		
		WaveMsgButton okBtn = new WaveMsgButton("OK");
		okBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saveFontNColor();
			}
		});
		okBtn.setBounds(236, 121, 60, 23);
		getContentPane().add(okBtn);
		
		
		
		
	}
	
	@Override
	public void close() {
		this.dispose();
	}
	
	@Override
	public void setFrameFont() {
		
		 this.chatFont = fontFrame.getFontPreview(); // 폰트
		 this.chatFontStyle = fontFrame.getStylePreview(); // 스타일
		 this.chatFontSize = fontFrame.getSizePreview(); // 크기
		 
		 // 미리보기에 폰트 설정
		 previewTxtPane.setFont(new Font(this.chatFont, this.chatFontStyle, this.chatFontSize));
		 
	}
	
	@Override
	public void setFrameColor() {
		
		this.chatColor = colorFrame.getSettingColor(); // 색상
		
		// 미리보기에 폰트 설정
		previewTxtPane.setForeground(this.chatColor);
	}

	/**
	 * 폰트 설정 화면 생성
	 */
	public void makeFontFrame() {
		
		try {
			fontFrame = new WaveMsgFontFrame(this, this.chatFont, this.chatFontStyle, this.chatFontSize);
			fontFrame.setVisible(true);
		} catch (WaveMsgException e) {
			e.printStackTrace();
			new WaveMsgDialogBox(this.title, e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * 색상 설정 화면 생성
	 */
	public void makeColorFrame() {
		
		try {
			colorFrame = new WaveMsgColorChooser(this, this.chatColor);
			colorFrame.setVisible(true);
		} catch (WaveMsgException e) {
			e.printStackTrace();
			new WaveMsgDialogBox(this.title, e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * 채팅 적용 위한 폰트 반환
	 * 
	 * @return 폰트
	 */
	public String getChatFont() {
		return this.chatFont;
	}

	/**
	 * 채팅 적용 위한 폰트 스타일 반환
	 * 
	 * @return 폰트 스타일
	 */
	public int getChatFontStyle() {
		return this.chatFontStyle;
	}

	/**
	 * 채팅 적용 위한 폰트 크기 반환
	 * 
	 * @return 폰트 크기
	 */
	public int getChatFontSize() {
		return this.chatFontSize;
	}
	
	/**
	 * 채팅 적용 위한 폰트 색상 반환
	 * 
	 * @return 폰트 색상
	 */
	public Color getChatColor() {
		return this.chatColor;
	}

	/** 
	 * 설정한 폰트 및 색상 저장
	 */
	public void saveFontNColor() {
		
		// 저장 할 것인지 질문 메시지
		WaveMsgDialogBox confirm = new WaveMsgDialogBox(this, this.title, CommMsg.SAVE_Q_MSG, JOptionPane.OK_CANCEL_OPTION);
		
		if (confirm.getResult() > 0) { // 승인거부
			return;
		}
		
		// 프로퍼티에 설정 저장
		properties.setChatFont(this.chatFont);
		properties.setChatFontStyle(this.chatFontStyle);
		properties.setChatFontSize(this.chatFontSize);
		properties.setChatColor(this.chatColor);
		
		try {
			properties.savePropertiesFile();// 설정 저장
			
			chatFrame.setFrameFont();
			chatFrame.setFrameColor();
			
			new WaveMsgDialogBox(this.title, CommMsg.SAVE_MSG, JOptionPane.INFORMATION_MESSAGE); // 저장 완료 메시지
			
		} catch (IOException e) {
			e.printStackTrace();
			new WaveMsgDialogBox(this.title, CommMsg.PROPERTY_SAVE_ERROR, JOptionPane.ERROR_MESSAGE);
		} finally {
			close();
		}
	}
	
	@Override
	public void callBackData() throws WaveMsgException {
		// 서버와 통신 없음
		
	}
	
	
	public static void main(String[] sfd) throws WaveMsgException {
		ChatFontFrame frame = new ChatFontFrame(new WaveMsgFontInterface() {
			
			@Override
			public void setFrameFont() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setFrameColor() {
				// TODO Auto-generated method stub
				
			}
		});
		frame.setVisible(true);
	}

}
