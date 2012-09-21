/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : BackgroundFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import com.wavem.msgp.comm.PropertiesInfo;
import com.wavem.msgp.main.AbstractFrame;

/**
 * 배경설정을 위한 화면
 * 
 * @author 
 *
 */
public class BackgroundFrame extends AbstractFrame {

	private static final long serialVersionUID = -2400000915834485391L;
	
	/** 환경설정 인스턴스 */
	private PropertiesInfo properties = PropertiesInfo.getInstance();

	@Override
	public void makeInitFrame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 환경설정으로부터 현재의 배경화면 설정 로드
	 */
	public void loadBackgroundProperty() {
		
	}
	
	/**
	 * 현재 설정된 정보 환경설정에 저장
	 */
	public void saveBackgroundProperty() {
		
	}
}
