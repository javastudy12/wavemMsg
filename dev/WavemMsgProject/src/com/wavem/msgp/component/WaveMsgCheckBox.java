/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgCheckBox.java
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
import javax.swing.JCheckBox;

import com.wavem.msgp.comm.PropertiesInfo;

/**
 * 체크박스
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see JCheckBox
 */
public class WaveMsgCheckBox extends JCheckBox {

	private static final long serialVersionUID = -7409322588066842755L;

	/**
	 * 체크박스 기본 생성자
	 * 
	 * @see WaveMsgCheckBox#setProperties()
	 */
	public WaveMsgCheckBox() {
		super();
		setProperties();
	}
	
	/**
	 * 체크박스 생성자 <br>
	 * 엑션 리스너 관련 객체를 받아 생성한다. <br>
	 * 
	 * @param action 이벤트 리스너
	 * @see WaveMsgCheckBox#setProperties()
	 */
	public WaveMsgCheckBox(Action action) {
		super(action);
		setProperties();
	}
	
	/**
	 * 체크박스 생성자 <br>
	 * 아이콘 이미지를 받아 생성한다. <br>
	 * 
	 * @param icon 아이콘 이미지
	 * @see WaveMsgCheckBox#setProperties()
	 */
	public WaveMsgCheckBox(Icon icon) {
		super(icon);
		setProperties();
	}
	
	/**
	 * 체크박스 생성자 <br>
	 * 체크박스 설명 문자열을 받아 생성한다. <br>
	 * 
	 * @param str 설명
	 * @see WaveMsgCheckBox#setProperties()
	 */
	public WaveMsgCheckBox(String str) {
		super(str);
		setProperties();
	}
	
	/**
	 * 체크박스 생성자 <br>
	 * 아이콘 이미지와 선택 여부를 초기화한다. <br>
	 * 
	 * @param icon 아이콘 이미지
	 * @param b 선택 여부
	 * @see WaveMsgCheckBox#setProperties()
	 */
	public WaveMsgCheckBox(Icon icon, boolean b) {
		super(icon, b);
		setProperties();
	}
	
	/**
	 * 체크박스 생성자 <br>
	 * 설명 문자열과 선택 여부를 초기화한다. <br>
	 * 
	 * @param str 설명 문자열
	 * @param b 선택 여부
	 * @see WaveMsgCheckBox#setProperties()
	 */
	public WaveMsgCheckBox(String str, boolean b) {
		super(str, b);
		setProperties();
	}
	
	/**
	 * 체크박스 생성자 <br>
	 * 설명 문자열과 아이콘 이미지를 초기화한다. <br>
	 * 
	 * @param str 설명 문자열
	 * @param icon 아이콘 이미지
	 * @see WaveMsgCheckBox#setProperties()
	 */
	public WaveMsgCheckBox(String str, Icon icon) {
		super(str, icon);
		setProperties();
	}
	
	/**
	 * 체크박스 생성자 <br>
	 * 설명 문자열, 아이콘 이미지, 선택 여부를 초기화한다. <br>
	 * 
	 * @param str 설명 문자열
	 * @param icon 아이콘 이미지
	 * @param b 선택 여부
	 * @see WaveMsgCheckBox#setProperties()
	 */
	public WaveMsgCheckBox(String str, Icon icon, boolean b) {
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
