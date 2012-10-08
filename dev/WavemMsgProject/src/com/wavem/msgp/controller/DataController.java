/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : DataController.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.controller;

import com.wavem.msgp.comm.DataParser;
import com.wavem.msgp.comm.SocketMgr;
import com.wavem.msgp.comm.WaveMsgException;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.dto.DataInfoDto;
import com.wavem.msgp.dto.LoginParamInfo;
import com.wavem.msgp.main.MsgMain;

/**
 * 서버와 데이터 통신을 위한 컨트롤러 <br>
 * 기본적인 CRUD 인터페이스를 가지고 있다. <br>
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class DataController {
	
	/** 요청한 프레임 인스턴스 */
	private WaveMsgFrame frameObj = null;
	
	/** 데이터 인스턴스 */
	private DataInfoDto dataObj = null;
	
	/** 데이터 파싱을 위한 인스턴스 */
	private DataParser parser = null;
	
	/** 메인 소켓 */
	private SocketMgr socketMgr = MsgMain.socketMgr;
	
	/**
	 * 데이터 컨트롤러 생성자 <br>
	 * com.wavem.msgp.dto 패키지 내의 클래스를 파라미터로 받는다. <br>
	 * 
	 * @param obj 데이터 인스턴스 
	 */
	public DataController(WaveMsgFrame frameObj, DataInfoDto dataObj) {
		this.frameObj = frameObj;
		this.dataObj = dataObj;
	}
	
	/**
	 * 조회 요청 <br>
	 */
	public void selectData() throws WaveMsgException{

		String serviceID = dataObj.getServiceID(); // 서비스 ID
		String data = ""; // 결과 데이터
		
		// 객체가 없는 경우 예외 처리
		if (dataObj == null) {
			throw new WaveMsgException("생성시킬 객체가 없습니다.");
		}
		
		// 파싱 객체 생성
		parser = new DataParser(dataObj); 

		// 각 service id 별로 데이터 파싱 및 서버 요청
		if (serviceID.equals("W_M_I_1_01")) { // 로그인 요청
			
			data = parser.parseLoginToProtocol();
			socketMgr.startWriter(serviceID, this, data);
			
		} else {
			throw new WaveMsgException("매칭되는 클래스가 없습니다.");
		}
		
	}

	/**
	 * 수정
	 */
	public void updateData() {

	}

	/**
	 * 추가
	 */
	public void insertData() {

	}

	/**
	 * 삭제
	 */
	public void deleteData() {

	}
	
	public void returnToFrame(String data) {
		
	}
}
