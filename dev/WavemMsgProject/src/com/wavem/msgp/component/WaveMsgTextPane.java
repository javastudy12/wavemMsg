/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgTextPane.java
 * Date       : 2012.09.25
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

import com.wavem.msgp.comm.PropertiesInfo;

/**
 * 텍스트 패널
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see JTextPane
 */
public class WaveMsgTextPane extends JTextPane {

	private static final long serialVersionUID = 206754192314054348L;

	/**
	 * 텍스트 패널 기본 생성자 <br>
	 * 
	 * @see WaveMsgTextPane#setProperties()
	 */
	public WaveMsgTextPane() {
		super();
		setProperties();
	}

	/**
	 * 텍스트 패널 생성자 <br>
	 * 문서양식 초기화 <br>
	 * 
	 * @param doc
	 * @see WaveMsgTextPane#setProperties()
	 */
	public WaveMsgTextPane(StyledDocument doc) {
		super(doc);
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
