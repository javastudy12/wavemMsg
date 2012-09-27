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

import com.wavem.msgp.component.WaveMsgFrame;

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
	
	/**
	 * 쪽지창 생성자 <br>
	 * 생성 시 자동으로 쪽지 쓰기창 생성 <br>
	 * 최초 makeInitFrame()호출 <br>
	 */
	public MessageFrame(){
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
}
