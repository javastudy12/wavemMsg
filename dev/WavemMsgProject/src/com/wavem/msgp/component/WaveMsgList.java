/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgList.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListModel;

import com.wavem.msgp.comm.PropertiesInfo;

/**
 * 리스트
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see JList
 */
public class WaveMsgList extends JList {

	private static final long serialVersionUID = 2324822370093906088L;

	/**
	 * 리스트 기본 생성자
	 * 
	 * @see WaveMsgList#setProperties()
	 */
	public WaveMsgList() {
		super();
		setProperties();
	}

	/**
	 * 리스트 생성자 <br>
	 * ListModel 객체 초기화 <br>
	 * 
	 * @param listModel 리스트
	 * @see WaveMsgList#setProperties()
	 */
	public WaveMsgList(ListModel<String> listModel) {
		super(listModel);
		setProperties();
	}

	/**
	 * 리스트 생성자 <br>
	 * 모든 객체 배열 초기화 <br>
	 * 
	 * @param array 배열
	 * @see WaveMsgList#setProperties()
	 */
	public WaveMsgList(Object[] array) {
		super(array);
		setProperties();
	}

	/**
	 * 리스트 생성자 <br>
	 * Vector 객체 초기화 <br>
	 * 
	 * @param vector 리스트
	 * @see WaveMsgList#setProperties()
	 */
	public WaveMsgList(Vector<String> vector) {
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
		
		// 색상 설정
		setForeground(property.getColor());
	}

}
