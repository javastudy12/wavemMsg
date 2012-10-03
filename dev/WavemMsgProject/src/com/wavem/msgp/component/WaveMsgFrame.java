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
 * @author
 * 
 */
public abstract class WaveMsgFrame extends JFrame {

	/**
	 * 화면 로딩
	 */
	public abstract void makeInitFrame() throws Exception ;
	
	public abstract void callBackData() throws Exception ;

	/**
	 * 화면 종료
	 */
	public abstract void close();

}
