/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgTextArea.java
 * Date       : 2012.09.25
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.awt.Font;

import javax.swing.JTextArea;

import com.wavem.msgp.comm.PropertiesInfo;

/**
 * 텍스트 에어리어 
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see JTextArea
 */
public class WaveMsgTextArea extends JTextArea {
	
	private static final long serialVersionUID = 4459394725215879128L;

	/**
	 * 텍스트 에어리어 기본 생성자
	 * 
	 * @see WaveMsgTextArea#setProperties()
	 */
	public WaveMsgTextArea() {
		super();
		setProperties();
	}
	
	/**
	 * 텍스트 에어리어 생성자 <br> 
	 * 열과 행 값 초기화 <br>
	 * 
	 * @param row 행
	 * @param col 열
	 * @see WaveMsgTextArea#setProperties()
	 */
	public WaveMsgTextArea(int row, int col) {
		super(row, col);
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
