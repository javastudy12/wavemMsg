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

import com.wavem.msgp.main.WaveMsgFrame;

/**
 * ���� ȭ��
 * 
 * <pre>
 * 	MessageFrame messageFrame = new MessageFrame(); // �⺻���� ���� ���� â ����
 *  MessageFrame.makeInitFrame(); // ���� �����͸� ȣ���ϰ� ȭ���� �׸��� �޼���
 *  
 *  MessageFrame messageFrame = new MessageFrame(false); // ���� ����â �Ǵ� �������� â ���� ����
 *  MessageFrame.makeInitFrame(); // ���� �����͸� ȣ���ϰ� ȭ���� �׸��� �޼���
 * </pre>
 * 
 * @author 
 *
 */
public class MessageFrame extends WaveMsgFrame{
	private static final long serialVersionUID = 4637357102247158992L;
	
	/**
	 * ����â ���� <br>
	 * true : ���� ���� <br>
	 * false : ���� ���� <br>
	 */
	private boolean convertingFlag = true;
	
	/**
	 * ����â ������ <br>
	 * ���� �� �ڵ����� ���� ����â ����
	 */
	public MessageFrame(){
		
	}
	
	/**
	 * ����â ������ <br>
	 * ���� �� ���� �÷��� ����
	 * @param convertingFlag
	 */
	public MessageFrame(boolean convertingFlag) {
		this.convertingFlag = convertingFlag;
	}
	
	@Override
	public void makeInitFrame() {
	
	}
	
	@Override
	public void close() {
		
	}
	
	/**
	 * convertingFlag�� ���� ���� ȭ�� ����
	 */
	public void convertFrame() {
	
		if (convertingFlag) {
			
		} else {
			
		}
	}
	
	/**
	 * ���� ����
	 */
	public void sendMsg() {
	
	}
	
	/**
	 * ���� ����
	 */
	public void replyMsg() {
	
	}
	
	/**
	 * ����â ���� <br>
	 * true : ���� ���� <br>
	 * false : ���� ���� <br>
	 * 
	 * @param convertingFlag ����ȭ�� ������
	 */
	public void setConvertingFlag(boolean convertingFlag) {
		this.convertingFlag = convertingFlag;
	}
}
