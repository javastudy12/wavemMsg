/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : MessageBoxFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/


package com.wavem.msgp.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgFrame;

/**
 * 쪽지내역 화면
 * 
 * <pre>
 * 	MessageBoxFrame messageBoxFrame = new MessageBoxFrame();
 *  MessageBoxFrame.makeInitFrame(); // 실제 데이터를 호출하고 화면을 그리는 메서드
 * </pre>
 * 
 * @author 
 *
 */
public class MessageBoxFrame extends WaveMsgFrame{
	
	private static final long serialVersionUID = 2554647036331105004L;
	
	public MessageBoxFrame() {
		makeInitFrame();
	}

	@Override
	public void makeInitFrame() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new WaveMsgButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(0, 64, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(12, 113, 97, 23);
		getContentPane().add(btnNewButton_1);
	}
	
	@Override
	public void close() {
		
	}
	
	/**
	 * 쪽지 리스트 호출
	 */
	public void invokeMsgList() {
	
	}
	
	/**
	 * 쪽지 리스트에서 쪽지 선택 시
	 * 쪽지 화면 호출
	 */
	public void invokeMsg() {
	
	}
}
