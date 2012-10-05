/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgLabel.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;

import com.wavem.msgp.comm.PropertiesInfo;

/**
 * 라벨
 * 
 * @author 정재요
 *
 */
public class WaveMsgLabel extends JLabel {

	private static final long serialVersionUID = -7529662727466178324L;

	/**
	 * 라벨 기본 생성자
	 */
	public WaveMsgLabel() {
		super();
		setProperties();
	}

	/**
	 * 라벨 생성자 <br>
	 * 이미지 아이콘 초기화 <br>
	 * 
	 * @param icon 아이콘 이미지
	 */
	public WaveMsgLabel(Icon icon) {
		super(icon);
		setProperties();
	}

	/**
	 * 라벨 생성자 <br>
	 * 라벨 텍스트 초기화 <br>
	 * 
	 * @param str 라벨 텍스트
	 */
	public WaveMsgLabel(String str) {
		super(str);
		setProperties();
	}

	/**
	 * 라벨 생성자 <br>
	 * 라벨 아이콘 이미지와 정렬 값 초기화 <br>
	 * 
	 * @param icon 아이콘 이미지
	 * @param i 정렬
	 */
	public WaveMsgLabel(Icon icon, int i) {
		super(icon, i);
		setProperties();
	}

	/**
	 * 라벨 생성자 <br>
	 * 라벨 텍스트와 정렬 값 초기화 <br>
	 * 
	 * @param str 라벨 텍스트
	 * @param i 정렬
	 */
	public WaveMsgLabel(String str, int i) {
		super(str, i);
		setProperties();
	}

	/**
	 * 라벨 생성자 <br>
	 * 라벨 텍스트, 아이콘 이미지, 정렬 값 초기화 <br>
	 * 
	 * @param str 라벨 텍스트
	 * @param icon 아이콘 이미지
	 * @param i 정렬
	 */
	public WaveMsgLabel(String str, Icon icon, int i) {
		super(str, icon, i);
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
