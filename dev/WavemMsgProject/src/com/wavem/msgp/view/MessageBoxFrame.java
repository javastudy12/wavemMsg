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

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.comm.WaveMsgException;
import com.wavem.msgp.component.WaveMsgFrame;

/**
 * 쪽지내역 화면
 * 
 * <pre>
 * 	MessageBoxFrame messageBoxFrame = new MessageBoxFrame();
 * </pre>
 * 
 * @author 
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class MessageBoxFrame extends WaveMsgFrame{
	
	private static final long serialVersionUID = 2554647036331105004L;
	
	/** 쪽지내역 화면 인스턴스 변수 */
	private static MessageBoxFrame frame = null;

	/** 타이틀 */
	private String title = CommMsg.MSG_HISTORY_FRAME_TITLE;
	
	/**
	 * 쪽지내역 화면 생성자 <br>
	 * 최초 makeInitFrame()호출 <br>
	 * 
	 * @throws WaveMsgException 
	 */
	private MessageBoxFrame() throws WaveMsgException {
		makeInitFrame();
	}

	/**
	 * 쪽지내역 화면을 위한 인스턴스 반환
	 * 
	 * @return 쪽지내역 화면을 위한 화면 인스턴스
	 * @throws WaveMsgException 
	 */
	public static MessageBoxFrame getInstance() throws WaveMsgException {
		
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
	public void makeInitFrame() throws WaveMsgException {
		getContentPane().setLayout(null);
		setTitle(this.title);
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

	@Override
	public void callBackData() throws WaveMsgException {
		// TODO Auto-generated method stub
		
	}
}
