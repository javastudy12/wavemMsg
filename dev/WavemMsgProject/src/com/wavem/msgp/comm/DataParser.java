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

import com.wavem.msgp.dto.DataInfoDto;
import com.wavem.msgp.dto.LoginParamInfo;

/**
 * 프로토콜 파싱
 * 
 * @author 
 *
 */
public class DataParser {
	
	/** 프로토콜 생성을 위한 객체 */
	private DataInfoDto obj = null;
	
	/** 서버로부터 받은 데이터 */
	private String data = "";
	
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
	public DataParser(DataInfoDto obj) {
		this.obj = obj;
	}
	
	/** 
	 * 데이터 파서 생성자
	 * @param data 서버로부터 받은 데이터
	 * @param clazz 클래스 
	 */
	public DataParser(String data) {
		this.data = data;
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
	public void setObj(DataInfoDto obj) {
		this.obj = obj;
	}
	
	/**
	 * 클라이언트로부터 생성된 객체를 프로토콜 형식으로 변환 <br>
	 * 로그인 화면으로 부터 생성된 로그인 요청 데이터를 파싱한다. <br>
	 * 
	 * @return
	 * @throws WaveMsgException
	 */
	public String parseLoginToProtocol() throws WaveMsgException {
		
		LoginParamInfo login = (LoginParamInfo) obj;
		
		StringBuilder strBuilder = new StringBuilder();
		
		strBuilder.append(login.getServiceID());
		strBuilder.append("&");
		strBuilder.append(login.getUserId());
		strBuilder.append("&");
		strBuilder.append(login.getUserPw());
		strBuilder.append("!");
		
		return strBuilder.toString();
	}
	
	/**
	 * 서버로부터 응답받은 데이터를 객체로 변환 <br>
	 * 로그인 요청 후 그 결과를 응답받아 데이터를 파싱한다. <br>
	 * 
	 * @return 생성된 DataInfoDto 객체 반환
	 * @throws WaveMsgException
	 */
	public DataInfoDto parseToInstance() throws WaveMsgException {
		
		String[] parsedData = data.split("&");
		
		if (parsedData[0].equals("W_M_I_1_01")) {
			// 데이터 파싱하여 객체화 시킴
		}
		
		return null;
	}
	
}
