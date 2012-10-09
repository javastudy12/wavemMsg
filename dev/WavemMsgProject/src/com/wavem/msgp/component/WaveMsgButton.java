/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgButton.java
 * Date       : 2012.09.25
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.wavem.msgp.comm.CommSet;
import com.wavem.msgp.comm.PropertiesInfo;
import com.wavem.msgp.view.MsgMainFrame;

/**
 * 버튼 <br>
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see JButton
 */
public class WaveMsgButton extends JButton {

	private static final long serialVersionUID = 5879808977099244368L;

	/** 
	 * 설정된 이미지 이름
	 * 확인버튼 이미지 이름으로 초기화됨
	 */
	private String imageName = "OK";
	
	/**
	 * 일반버튼
	 * 
	 * @see WaveMsgButton#setProperties()
	 */
	public WaveMsgButton() {
		super();
		setProperties();
	}
	
	/**
	 * 이미지 이름 선택 <br>
	 * 버튼 경로에 있는 이미지를 선택 <br>
	 * 
	 * @param imageName 이미지 이름
	 * @see WaveMsgButton#makeInitButton()
	 * @see WaveMsgButton#setProperties()
	 */
	public WaveMsgButton(String imageName) {
		this.imageName = imageName;
		makeInitButton(); // 이미지 이름이 있는 경우 자동 세팅
		setProperties();
	}
	
	/**
	 * 아이콘 설정 <br>
	 * 기본버튼 적용 안됨 <br>
	 * 
	 * @param icon 아이콘 이미지
	 * @see WaveMsgButton#setProperties()
	 */
	public WaveMsgButton(Icon icon) {
		super(icon);
		setProperties();
	}
	
	/**
	 * 버튼 설정
	 */
	private void makeInitButton() {
		
		// 버튼 크기
		setSize(60, 30);
		
		// 버튼 이미지 세팅
		//setIcon(new ImageIcon(MsgMainFrame.class.getResource("/com/wavem/resource/img/button/"+imageName+".png")));
		setIcon(CommSet.getButtonImgIcon(imageName));
		
		// 버튼 선택 시 이미지 세팅
		//setSelectedIcon(new ImageIcon(MsgMainFrame.class.getResource("/com/wavem/resource/img/button/"+imageName+"_F.png")));
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
