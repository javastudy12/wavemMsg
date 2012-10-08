/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgException.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.comm;

/**
 * 메신저 예외
 * 
 * <pre>
 * throw new WaveMsgException(&quot;message&quot;);
 * </pre>
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 */
public class WaveMsgException extends Exception {

	private static final long serialVersionUID = 2981994190499623353L;
	
	/**
	 * 웨이브엠 메신저 예외 기본 생성자
	 */
	public WaveMsgException() {
		super();
	}
	
	/**
	 * 웨이브엠 메신저 예외 생성자 <br>
	 * 메시지 추가 <br> 
	 * 
	 * @param msg 예외 메시지
	 */
	public WaveMsgException(String msg) {
		super(msg);
	}
	
}
