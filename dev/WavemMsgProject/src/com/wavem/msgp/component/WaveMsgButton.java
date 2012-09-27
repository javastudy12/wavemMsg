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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.wavem.msgp.view.MsgMainFrame;

/**
 * 
 * 웨이브엠 공통 컴포넌트 <br>
 * 
 * 버튼 <br>
 * 
 * @author 정재요
 *
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
	 */
	public WaveMsgButton() {
		super();
	}
	
	/**
	 * 이미지 이름 선택 <br>
	 * 버튼 경로에 있는 이미지를 선택 <br>
	 * 
	 * @param imageName 이미지 이름
	 */
	public WaveMsgButton(String imageName) {
		this.imageName = imageName;
		makeInitButton(); // 이미지 이름이 있는 경우 자동 세팅
	}
	
	/**
	 * 아이콘 설정 <br>
	 * 기본버튼 적용 안됨 <br>
	 * 
	 * @param icon
	 */
	public WaveMsgButton(Icon icon) {
		super(icon);
	}
	
	/**
	 * 버튼 설정
	 */
	private void makeInitButton() {
		
		// 버튼 크기
		setSize(60, 30);
		
		// 버튼 이미지 세팅
		setIcon(new ImageIcon(MsgMainFrame.class.getResource("/com/wavem/resource/img/button/"+imageName+".png")));
		
		// 버튼 선택 시 이미지 세팅
		//setSelectedIcon(new ImageIcon(MsgMainFrame.class.getResource("/com/wavem/resource/img/button/"+imageName+"_F.png")));
	}
}
