/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgTextField.java
 * Date       : 2012.09.25
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.text.Document;

import com.wavem.msgp.comm.PropertiesInfo;

/**
 * 텍스트 필드
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see JTextField
 */
public class WaveMsgTextField extends JTextField {

	private static final long serialVersionUID = -6996038169410735037L;

	/**
	 * 텍스트 필드 기본 생성자
	 * 
	 * @see WaveMsgTextField#setProperties()
	 */
	public WaveMsgTextField() {
		super();
		setProperties();
	}

	/**
	 * 텍스트 필드 생성자 <br>
	 * 열 초기화 <br>
	 * 
	 * @param columns 열
	 * @see WaveMsgTextField#setProperties()
	 */
	public WaveMsgTextField(int columns) {
		super(columns);
	}

	/**
	 * 텍스트 필드 생성자 <br>
	 * 텍스트 필드 문자열 초기화 <br>
	 * 
	 * @param text 문자열
	 * @see WaveMsgTextField#setProperties()
	 */
	public WaveMsgTextField(String text) {
		super(text);
		setProperties();
	}

	/**
	 * 텍스트 필드 생성자 <br>
	 * 텍스트 필드 문자열과 열 초기화 <br>
	 * 
	 * @param text 문자열
	 * @param columns 열
	 * @see WaveMsgTextField#setProperties()
	 */
	public WaveMsgTextField(String text, int columns) {
		super(text, columns);
		setProperties();
	}

	/**
	 * 텍스트 필드 생성자 <br>
	 * 텍스트 필드 생성모델을 위한 Document와 문자열, 열 초기화 <br>
	 *  
	 * @param doc 모델
	 * @param text 무자열
	 * @param columns 열
	 * @see WaveMsgTextField#setProperties()
	 */
	public WaveMsgTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		setProperties();
	}

	/**
	 * 환경설정에 의한 설정 적용
	 */
	public void setProperties() {
		
		PropertiesInfo property = PropertiesInfo.getInstance();
		
		// 폰트 설정
		setFont(new Font(property.getFont(), property.getFontStyle(), property.getFontSize()));
		
		// 색상 설정
		setForeground(property.getColor());
	}
}
