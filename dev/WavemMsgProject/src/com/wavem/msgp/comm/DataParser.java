/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : DataParser.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.comm;

import com.wavem.msgp.dto.LoginParamInfo;
import com.wavem.msgp.main.MsgMain;

/**
 * 프로토콜 파싱
 * 
 * @author 
 *
 */
public class DataParser {
	
	/** 프로토콜 생성을 위한 객체 */
	private Object obj = null;
	
	/** 데이터를 객체화 시키기 위한 클래스 정보값 */
	private Class clazz = null;
	
	/** 서버로부터 받은 데이터 */
	private String data = "";
	
	/** 메인 소켓 */
	private SocketMgr socketMgr = MsgMain.socketMgr;
	
	/**
	 * 데이터 파서 생성자 <br>  
	 * setObj()를 통해서 객체를 등록해야 한다. <br>
	 */
	public DataParser() {
		
	}
	
	/**
	 * 데이터 파서 생성자 <br>
	 * 
	 * @param obj 프로토콜 생성을 위한 객체
	 */
	public DataParser(Object obj) {
		this.obj = obj;
	}
	
	/** 
	 * 데이터 파서 생성자
	 * @param data 서버로부터 받은 데이터
	 * @param clazz 클래스 
	 */
	public DataParser(String data, Class clazz) {
		this.data = data;
		this.clazz = clazz;
	}

	/** 
	 * 객체 반환
	 * 
	 * @return 객체
	 */
	public Object getObj() {
		return obj;
	}

	/**
	 * 객체 저장
	 * 
	 * @param obj 객체
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	/**
	 * 객체를 프로토콜 형식으로 변경
	 */
	public int parseClass() throws WaveMsgException {
		
		int res = 0;
		
		if (obj == null) {
			throw new WaveMsgException("생성시킬 객체가 없습니다.");
		}
		
		if (obj.getClass() == LoginParamInfo.class) {
			
			LoginParamInfo loginParam = (LoginParamInfo)obj;
			String data = loginParam.getUserId() + "&" + loginParam.getUserPw();
			
			res = socketMgr.startWriter(data);
			
		} else {
			throw new WaveMsgException("매칭되는 클래스가 없습니다.");
		}
		
		return res;
		
	}
	
}
