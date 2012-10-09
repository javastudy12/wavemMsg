/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgFontInterface.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

/**
 * 폰트 설정 창으로부터 폰트 데이터를 받기 위한 인터페이스
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 */
public interface WaveMsgFontInterface {
	
	/**  
	 * 폰트 설정 화면에서 호출 <br>
	 * 폰트 미리보기 설정 및 데이터 설정 <br>
	 */
	public void setFrameFont();
	
	/**  
	 * 폰트 설정 화면에서 호출 <br>
	 * 컬러 미리보기 설정 및 데이터 설정 <br>
	 */
	public void setFrameColor();
}
