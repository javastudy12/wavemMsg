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

import com.wavem.msgp.component.WaveMsgFrame;

/**
 * 쪽지내역 화면
 * 
 * <pre>
 * 	MessageBoxFrame messageBoxFrame = new MessageBoxFrame();
 * </pre>
 * 
 * @author 
 *
 */
public class MessageBoxFrame extends WaveMsgFrame{
	
	private static final long serialVersionUID = 2554647036331105004L;
	
	/** 쪽지내역 화면 인스턴스 변수 */
	private static MessageBoxFrame frame = null;
	
	/**
	 * 쪽지내역 화면 생성자 <br>
	 * 최초 makeInitFrame()호출 <br>
	 */
	private MessageBoxFrame() {
		makeInitFrame();
	}

	/**
	 * 쪽지내역 화면을 위한 인스턴스 반환
	 * 
	 * @return 쪽지내역 화면을 위한 화면 인스턴스
	 */
	public static MessageBoxFrame getInstance() {
		
		if (frame == null) {
			synchronized (MessageBoxFrame.class) {
				if (frame == null) {
					frame = new MessageBoxFrame();
				}
			}
		}
		
		return frame;
	}
	
	@Override
	public void makeInitFrame() {
		getContentPane().setLayout(null);
		
	}
	
	@Override
	public void close() {
		this.dispose();
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
