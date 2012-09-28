/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : FileBoxFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import com.wavem.msgp.component.WaveMsgFrame;

/**
 * 파일내역 화면 
 * 
 * <pre>
 * 	FileBoxFrame fileBoxFrame = new FileBoxFrame();
 * </pre>
 * 
 * @author 
 *
 */
public class FileBoxFrame extends WaveMsgFrame {
	
	private static final long serialVersionUID = 5683706633732766606L;

	/** 파일내역 화면 인스턴스 변수 */
	private static FileBoxFrame frame = null;
	
	/**
	 * 파일내역 화면 생성자<br>
	 * 최조 makeInitFrame()호출<br>
	 */
	private FileBoxFrame() {
		makeInitFrame();
	}
	
	/**
	 * 파일내역 화면을 위한 인스턴스 반환
	 * 
	 * @return 파일내역 화면을 위한 화면 인스턴스
	 */
	public static FileBoxFrame getInstance() {
		
		if (frame == null) {
			synchronized (FileBoxFrame.class) {
				if (frame == null) {
					frame = new FileBoxFrame();
				}
			}
		}
		
		return frame;
	}
	
	@Override
	public void makeInitFrame() {
		getContentPane().setLayout(null);
	}

	@Override
	public void close() {
		this.dispose();
	}
	
	/**
	 * 파일 리스트 호출
	 */
	public void invokeFileHistoryList() {

	}

	@Override
	public void callBackData() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
