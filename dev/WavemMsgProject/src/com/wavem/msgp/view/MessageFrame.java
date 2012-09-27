/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : MessageFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/


package com.wavem.msgp.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.component.WaveMsgLabel;
import com.wavem.msgp.component.WaveMsgPanel;
import com.wavem.msgp.component.WaveMsgTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 * 쪽지 화면
 * 
 * <pre>
 * 	MessageFrame messageFrame = new MessageFrame(); // 기본으로 쪽지 쓰기 창 생성
 *  
 *  MessageFrame messageFrame = new MessageFrame(false); // 쪽지 쓰기창 또는 받은쪽지 창 선택 생성
 * </pre>
 * 
 * @author 
 *
 */
public class MessageFrame extends WaveMsgFrame{
	private static final long serialVersionUID = 4637357102247158992L;
	
	/**
	 * 쪽지창 상태 <br>
	 * true : 쪽지 쓰기 <br>
	 * false : 받은 쪽지 <br>
	 */
	private boolean convertingFlag = true;
	
	/** 받는사람 또는 보낸사람 저장 */
	private StringBuilder topText = new StringBuilder();
	
	/** 상단 패널 */
	private WaveMsgPanel topPanel = null;
	
	/** 받는사람 라벨 */
	private WaveMsgLabel recipientValue = null;
	
	/** 사용자 추가 */
	private WaveMsgButton addUserBtn = null;
	
	/** 받은 날짜 */
	private WaveMsgLabel receiveDate = null;
	
	/** 메시지 입력창 */
	private WaveMsgTextArea msgArea = null;
	
	/** 스크롤 패널 */
	private JScrollPane scrollPane = null;
	
	/**
	 * 쪽지창 생성자 <br>
	 * 생성 시 자동으로 쪽지 쓰기창 생성 <br>
	 * 최초 makeInitFrame()호출 <br>
	 */
	public MessageFrame(){
		getContentPane().setBackground(Color.WHITE);
		makeInitFrame();
	}
	
	/**
	 * 쪽지창 생성자 <br>
	 * 생성 시 쪽지 플래그 설정 <br>
	 * 최초 makeInitFrame()호출 <br>
	 * 
	 * @param convertingFlag
	 */
	public MessageFrame(boolean convertingFlag) {
		this.convertingFlag = convertingFlag;
		makeInitFrame();
	}
	
	@Override
	public void makeInitFrame() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 367, 343);
		
		/* ********************************************************************
		 * TOP 패널
		 * 보낸 사람 및 받는 사람 설정
		 * ********************************************************************/
		topPanel = new WaveMsgPanel();
		topPanel.setBackground(Color.WHITE);
		if (convertingFlag) {
			topPanel.setBounds(0, 0, 350, 50);
		} else {
			topPanel.setBounds(0, 0, 350, 70);
		}
		getContentPane().add(topPanel);
		topPanel.setLayout(null);
		
		// 이름 및 ID 표시 라벨
		String name = "";
		if (convertingFlag) { 
			name = "TO. ";
		} else {
			name = "FROM. ";
		}
		recipientValue = new WaveMsgLabel(name);
		recipientValue.setBounds(12, 10, 243, 30);
		topPanel.add(recipientValue);
		
		// 사용자 추가 버튼
		addUserBtn = new WaveMsgButton("ADD");
		addUserBtn.setLocation(278, 10);
		if (!convertingFlag) {
			addUserBtn.setVisible(false);
		}
		topPanel.add(addUserBtn);
		
		// 받은날짜
		receiveDate = new WaveMsgLabel("2012.09.27 12:24:11");
		receiveDate.setForeground(Color.ORANGE);
		receiveDate.setBounds(12, 45, 213, 15);
		if (convertingFlag) {
			receiveDate.setVisible(false);
		} 
		topPanel.add(receiveDate);
		
		// 메시지 입력창
		msgArea = new WaveMsgTextArea(10, 20);
		msgArea.setToolTipText("메시지 입력");
		msgArea.setTabSize(4);
		msgArea.setBackground(Color.WHITE);
		msgArea.setLineWrap(true);
		
		// 메시지 입력 스크롤 패널
		scrollPane = new JScrollPane(msgArea);
		if (convertingFlag) {
			scrollPane.setBounds(0, 50, 350, 200);
		} else {
			scrollPane.setBounds(0, 70, 350, 180);
		}
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollPane);
		
		JPanel footerPanel = new JPanel();
		footerPanel.setBounds(0, 250, 350, 55);
		getContentPane().add(footerPanel);
		
		// 닫기 버튼
		WaveMsgButton waveMsgButton = new WaveMsgButton("CLOSE");
		waveMsgButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
		footerPanel.add(waveMsgButton);
		
		// 보내기 버튼
		WaveMsgButton waveMsgButton_1 = new WaveMsgButton("SEND");
		waveMsgButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (convertingFlag) {
					sendMsg();
				} else {
					replyMsg();
				}
			}
		});
		footerPanel.add(waveMsgButton_1);
		
		
		
	}
	
	@Override
	public void close() {
		this.dispose();
	}
	
	/**
	 * convertingFlag에 따른 쪽지 화면 설정
	 */
	public void convertFrame() {
	
		if (convertingFlag) {
			
		} else {
			
		}
	}
	
	/**
	 * 쪽지 쓰기
	 */
	public void sendMsg() {
	
	}
	
	/**
	 * 쪽지 답장
	 */
	public void replyMsg() {
	
	}
	
	/**
	 * 쪽지창 설정 <br>
	 * true : 쪽지 쓰기 <br>
	 * false : 받은 쪽지 <br>
	 * 
	 * @param convertingFlag 쪽지화면 설정값
	 */
	public void setConvertingFlag(boolean convertingFlag) {
		this.convertingFlag = convertingFlag;
	}
	
	
	public static void main(String[] a) {
		MessageFrame frame = new MessageFrame(true);
		frame.setVisible(true);
	}
}
