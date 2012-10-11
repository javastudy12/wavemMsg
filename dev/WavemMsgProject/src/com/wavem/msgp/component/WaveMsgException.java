/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgException.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.util.ArrayList;
import java.util.List;

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
	
	/** 예외 발생 리스트 */
	private List<WaveMsgExeptionModel> excpList = new ArrayList<WaveMsgExeptionModel>();
	
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
	
	
	public WaveMsgException(Object obj) {
		System.out.println(obj.getClass().getName());
	}
	
	
	
	
	
	/* **************************************************************************************
	 * 예외처리는 아직 구상중
	 * **************************************************************************************/
	public void add(String message) {
		
		WaveMsgExeptionModel model = new WaveMsgExeptionModel();
		model.setMessage(message);
		
		excpList.add(model);
	}
	
	
	
	
	
	
	/**
	 * 예외처리 데이터를 담기 위한 객체 모델
	 * @author 정재요
	 *
	 */
	class WaveMsgExeptionModel {
		
		private String message = "";

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
	}
}

