/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : FontFrame.java
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
 * 파일 폰트 및 색상 설정 화면
 * @author 
 *
 */
public class FontFrame extends AbstractFrame{
	
	private static final long serialVersionUID = 7117625848207442204L;

	/** 환경설정 인스턴스 */
	private PropertiesInfo properties = PropertiesInfo.getInstance();
	
	@Override
	public void makeInitFrame() {
	
	}
	
	@Override
	public void close() {
		
	}
	
	
	/**
	 * 기존에 설정된 폰트 로드
	 */
	public void loadFont() {
	
	}
	
	/**
	 * 기존에 설정된 색상 로드
	 */
	public void loadColor() {
	
	}
	
	/**
	 * 현재 설정한 폰트 및 색상 저장
	 */
	public void saveFontNColor() {
	
	}
}
