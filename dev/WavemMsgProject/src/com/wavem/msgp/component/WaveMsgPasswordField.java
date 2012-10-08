/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgPasswordField.java
 * Date       : 2012.09.25
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.text.Document;

import com.wavem.msgp.comm.PropertiesInfo;

/**
 * 패스워드 텍스트 필드
 * 
 * @author 정재요
 *
 */
public class WaveMsgPasswordField extends JPasswordField {

	private static final long serialVersionUID = -8594427702295945496L;

	/**
	 * 패스워드 필드 기본 생성자
	 */
	public WaveMsgPasswordField() {
		super();
		setProperties();
	}
	
	/**
	 * 패스워드 필드 생성자 <br>
	 * 필드의 컬럼 수 지정 <br>
	 * 
	 * @param columns 필드 컬럼
	 */
	public WaveMsgPasswordField(int columns) {
		super(columns);
		setProperties();
	}
	
	/**
	 * 패스워드 필드 생성자 <br>
	 * 패스워드 문자열 초기화 <br>
	 * 
	 * @param text 문자열
	 */
	public WaveMsgPasswordField(String text) {
		super(text);
		setProperties();
	}
	
	/**
	 * 패스워드 필드 생성자 <br>
	 * 패스워드 문자열 및 컬럼 수 초기화 <br>
	 * 
	 * @param text 문자열
	 * @param columns 필드 컬럼
	 */
	public WaveMsgPasswordField(String text, int columns) {
		super(text, columns);
		setProperties();
	}
	
	/**
	 * 패스워드 필드 생성자 <br>
	 * 텍스트 저장소, 문자열, 필드 컬럼 초기화 <br>
	 * 
	 * @param doc 텍스트 저장소
	 * @param txt 문자열
	 * @param columns 필드 컬럼
	 */
	public WaveMsgPasswordField(Document doc, String txt, int columns) {
		super(doc, txt, columns);
		setProperties();
	}
	
	/**
	 * 환경설정에 의한 설정 적용
	 */
	public void setProperties() {
		
		PropertiesInfo property = PropertiesInfo.getInstance();
		
		// 폰트 설정
		setFont(new Font(property.getFont(), property.getFontStyle(), property.getFontSize()));
	}
	
}
