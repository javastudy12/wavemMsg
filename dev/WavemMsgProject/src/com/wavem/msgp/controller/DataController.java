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
import com.wavem.msgp.comm.WaveMsgException;
import com.wavem.msgp.dto.LoginParamInfo;

/**
 * 서버와 데이터 통신을 위한 컨트롤러 <br>
 * 기본적인 CRUD 인터페이스를 가지고 있다. <br>
 * 
 * @author HG01362
 *
 */
public class DataController {
	
	/** 데이터 인스턴스 */
	private Object obj = null;
	
	private DataParser parser = null;
	
	private int res = 0;
	
	/**
	 * 데이터 컨트롤러 생성자 <br>
	 * com.wavem.msgp.dto 패키지 내의 클래스를 파라미터로 받는다. <br>
	 * 
	 * @param obj 데이터 인스턴스 
	 */
	public DataController(Object obj) {
		this.obj = obj;
		this.parser = new DataParser();
	}
	
	/**
	 * 조회
	 */
	public void selectData() throws WaveMsgException{
		parser.setObj(this.obj);
		res = parser.parseClass();
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
	
	/**
	 * 결과 반환
	 * @return 결과
	 */
	public int getRes() {
		return this.res;
	}
}
