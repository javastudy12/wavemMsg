/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgRadioButton.java
 * Date       : 2012.09.25
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.awt.Font;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JRadioButton;

import com.wavem.msgp.comm.PropertiesInfo;

/**
 * 라디오 버튼 
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see JRadioButton
 */
public class WaveMsgRadioButton extends JRadioButton {

	private static final long serialVersionUID = -7548730826847401830L;

	/**
	 * 라디오 버튼 기본 생성자
	 * 
	 * @see WaveMsgRadioButton#setProperties()
	 */
	public WaveMsgRadioButton() {
		super();
		setProperties();
	}

	/**
	 * 라디오 버튼 생성자 <br>
	 * 이벤트 리스너 객체 초기화 <br>
	 * 
	 * @param action 이벤트 리스너
	 * @see WaveMsgRadioButton#setProperties()
	 */
	public WaveMsgRadioButton(Action action) {
		super(action);
		setProperties();
	}

	/**
	 * 라디오 버튼 생성자 <br>
	 * 아이콘 이미지 초기화 <br>
	 * 
	 * @param icon 아이콘 이미지
	 * @see WaveMsgRadioButton#setProperties()
	 */
	public WaveMsgRadioButton(Icon icon) {
		super(icon);
		setProperties();
	}

	/**
	 * 라디오 버튼 생성자 <br>
	 * 라디오 버튼 문자열 초기화 <br>
	 * 
	 * @param str 문자열
	 * @see WaveMsgRadioButton#setProperties()
	 */
	public WaveMsgRadioButton(String str) {
		super(str);
		setProperties();
	}

	/**
	 * 라디오 버튼 생성자 <br>
	 * 아이콘 이미지와 선택 유무 초기화 <br>
	 * 
	 * @param icon 아이콘 이미지
	 * @param b 선택 유무
	 * @see WaveMsgRadioButton#setProperties()
	 */
	public WaveMsgRadioButton(Icon icon, boolean b) {
		super(icon, b);
		setProperties();
	}

	/**
	 * 라디오 버튼 생성자 <br>
	 * 라디오 버튼 문자열과 선택 유무 초기화 <br>
	 * 
	 * @param str 문자열
	 * @param b 선택 유무
	 * @see WaveMsgRadioButton#setProperties()
	 */
	public WaveMsgRadioButton(String str, boolean b) {
		super(str, b);
		setProperties();
	}

	/**
	 * 라디오 버튼 생성자 <br>
	 * 라디오 버튼 문자열과 아이콘 이미지 초기화 <br>
	 * 
	 * @param str 문자열
	 * @param icon 아이콘 이미지
	 * @see WaveMsgRadioButton#setProperties()
	 */
	public WaveMsgRadioButton(String str, Icon icon) {
		super(str, icon);
		setProperties();
	}

	/**
	 * 라디오 버튼 생성자 <br>
	 * 문자열, 아이콘 이미지, 선택 유무 초기화 <br>
	 * 
	 * @param str 문자열
	 * @param icon 아이콘 이미지
	 * @param b 선택 유무
	 * @see WaveMsgRadioButton#setProperties()
	 */
	public WaveMsgRadioButton(String str, Icon icon, boolean b) {
		super(str, icon, b);
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
