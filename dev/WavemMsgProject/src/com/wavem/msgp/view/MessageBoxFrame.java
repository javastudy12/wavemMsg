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
 * �������� ȭ��
 * 
 * <pre>
 * 	MessageBoxFrame messageBoxFrame = new MessageBoxFrame();
 *  MessageBoxFrame.makeInitFrame(); // ���� �����͸� ȣ���ϰ� ȭ���� �׸��� �޼���
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
	 * ���� ����Ʈ ȣ��
	 */
	public void invokeMsgList() {
	
	}
	
	/**
	 * ���� ����Ʈ���� ���� ���� ��
	 * ���� ȭ�� ȣ��
	 */
	public void invokeMsg() {
	
	}
}
