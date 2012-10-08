/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : MsgMainFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JOptionPane;

import com.wavem.msgp.comm.PropertiesInfo;

/**
 * 다이얼로그 화면
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see JOptionPane
 */
public class WaveMsgDialogBox extends JOptionPane {

	private static final long serialVersionUID = -4157088065984252280L;

	/** 다이얼로그 타이틀 내용 */
	private String title = "";
	
	/** 다이얼로그 메시지 내용 */
	private String message = "";
	
	/** 다이얼로그 옵션 */
	private int jOption = 0;
	
	/** Component */
	private Component component = null;

	/** CONFIRM 실행 결과 */
	private int res = 0;
	
	/**
	 * 옵션없는 생성자를 사용하지 못하도록 막음
	 */
	private WaveMsgDialogBox() {
	}

	/**
	 * 다이얼로그 화면 생성자 <br>
	 * 
	 * <pre>
	 * jOption :
	 * 
	 *  - JOptionPane.INFORMATION_MESSAGE : 정보메시지 옵션
	 *  - JOptionPane.WARNING_MESSAGE     : 경고메시지 옵션
	 *  - JOptionPane.ERROR_MESSAGE       : 에러메시지 옵션
	 *  - JOptionPane.QUESTION_MESSAGE    : 질문메시지 옵션
	 *  - JOptionPane.PLAIN_MESSAGE       : 일반메시지 옵션
	 *  
	 * <pre>
	 * 
	 * @param title 타이틀
	 * @param message 메시지 내용
	 * @param jOption 옵션
	 * @see WaveMsgDialogBox#makeInitFrame()
	 * @see WaveMsgDialogBox#setProperties()
	 */
	public WaveMsgDialogBox(String title, String message, int jOption) {
		this.title = title;
		this.message = message;
		this.jOption = jOption;

		makeInitFrame();
		setProperties();
	}
	
	/**
	 * 다이얼로그 화면 생성자 <br>
	 * 
	 * <pre>
	 * jOption :
	 * 
	 *  - JOptionPane.YES_NO_OPTION         
	 *  - JOptionPane.YES_NO_CANCEL_OPTION 
	 *  - JOptionPane.DEFAULT_OPTION       
	 *  - JOptionPane.OK_CANCEL_OPTION     
	 *  
	 * <pre>
	 * 
	 * @param title 타이틀
	 * @param message 메시지 내용
	 * @param jOption 옵션
	 * @see WaveMsgDialogBox#makeInitComfirmFrame()
	 * @see WaveMsgDialogBox#setProperties()
	 */
	public WaveMsgDialogBox(Component component, String title, String message, int jOption) {
		this.component = component;
		this.title = title;
		this.message = message;
		this.jOption = jOption;

		makeInitComfirmFrame();
		setProperties();
	}

	/**
	 * 일반 메시지
	 */
	private void makeInitFrame() {
		showMessageDialog(this, message, title, jOption);
	}
	
	/**
	 * CONFIRM 메시지
	 */
	private void makeInitComfirmFrame() {
		this.res = showConfirmDialog(component, message, title, jOption);
	}
	
	/**
	 * CONFIRM일 경우 결과 반환 <br>
	 * 
	 * <pre>
	 * 0 : 예, 확인(YES, OK)
	 * 1 : 아니오(NO)
	 * 2 : 취소(CANCEL)
	 * </pre>
	 * 
	 * @return CONFIRM 결과
	 */
	public int getResult() {
		return this.res;
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
