/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgSpinner.java
 * Date       : 2012.09.25
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.awt.Font;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

import com.wavem.msgp.comm.PropertiesInfo;

/**
 * Spinner
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see JSpinner
 */
public class WaveMsgSpinner extends JSpinner {

	private static final long serialVersionUID = -5680637066404174575L;

	/**
	 * 스피너 기본 생성자
	 * 
	 * @see WaveMsgSpinner#setProperties()
	 */
	public WaveMsgSpinner() {
		super();
		setProperties();
	}
	
	/**
	 * 스피너 생성자 <br>
	 * 내용에 관련된 Model 객체 초기화 <br>
	 * 
	 * @param spinnerModel 모델
	 * @see WaveMsgSpinner#setProperties()
	 */
	public WaveMsgSpinner(SpinnerModel spinnerModel) {
		super(spinnerModel);
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
