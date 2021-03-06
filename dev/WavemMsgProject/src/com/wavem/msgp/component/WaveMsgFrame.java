/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : AbstractFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import javax.swing.JFrame;


/**
 * 프레임(화면) 구성 추상클래스
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see JFrame
 */
public abstract class WaveMsgFrame extends JFrame {

	/**
	 * 프레임 기본 생성자 <br>
	 * 프레임 공통 설정 포함 <br>
	 */
	public WaveMsgFrame() {
		super();
		//setUndecorated(true);
		//pack();
		setResizable(false); // 크기조종 제한
	}
	
	/**
	 * 화면 로딩을 위한 메서드 <br>
	 * 화면을 위한 컴포넌트와 이벤트를 모두 처리한다. <br>
	 * 화면 로드 예외 발생 시 WaveMsgException 발생 <br>
	 * 
	 * @throws Exception 화면 로드 예외
	 */
	public abstract void makeInitFrame() throws WaveMsgException ;
	
	/**
	 * 데이터 요청 후 응답 처리 메서드 <br>
	 * 데이터 응답 예외 발생 시 WaveMsgException 발생 <br>
	 * 
	 * @throws Exception 데이터 로드 예외
	 */
	public abstract void callBackData() throws WaveMsgException ;

	/**
	 * 화면 종료
	 */
	public abstract void close();

}
