/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgComboBox.java
 * Date       : 2012.09.25
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.awt.Font;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

import com.wavem.msgp.comm.PropertiesInfo;

/**
 * 콤보박스
 * 
 * @author 정재요
 *
 */
public class WaveMsgComboBox extends JComboBox {

	private static final long serialVersionUID = -3852595989966048881L;

	/**
	 * 콤보박스 기본 생성자
	 */
	public WaveMsgComboBox() {
		super();
		setProperties();
	}

	/**
	 * 콤보박스 생성자 <br>
	 * 콤보박스 리스트 데이터 ComboBoxModel객체를 초기화한다. <br>
	 * 
	 * @param combox list model
	 */
	public WaveMsgComboBox(ComboBoxModel<String> combox) {
		super(combox);
		setProperties();
	}
	
	/**
	 * 콤보박스 생성자 <br>
	 * 모든 타입의 배열을 받아 초기화한다. <br>
	 * 
	 * @param array 배열
	 */
	public WaveMsgComboBox(Object[] array) {
		super(array);
		setProperties();
	}

	/**
	 * 콤보박스 생성자 <br>
	 * Vector 객체를 받아 초기화한다. <br>
	 * 
	 * @param vector 콤보 리스트
	 */
	public WaveMsgComboBox(Vector<String> vector) {
		super(vector);
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
