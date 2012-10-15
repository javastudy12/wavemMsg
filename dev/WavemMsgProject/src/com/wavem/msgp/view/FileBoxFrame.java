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

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.component.WaveMsgException;
import com.wavem.msgp.component.WaveMsgFrame;

/**
 * 파일내역 화면 
 * 
 * <pre>
 * 	FileBoxFrame fileBoxFrame = new FileBoxFrame();
 * </pre>
 * 
 * @author 
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class FileBoxFrame extends WaveMsgFrame {
	
	private static final long serialVersionUID = 5683706633732766606L;

	/** 파일내역 화면 인스턴스 변수 */
	private static FileBoxFrame frame = null;
	
	/** 타이틀 */
	private String title = CommMsg.FILE_HISTORY_FRAME_TITLE;
	
	/**
	 * 파일내역 화면 생성자<br>
	 * 최조 makeInitFrame()호출<br>
	 * @throws WaveMsgException 
	 */
	private FileBoxFrame() throws WaveMsgException {
		super();
		makeInitFrame();
	}
	
	/**
	 * 파일내역 화면을 위한 인스턴스 반환
	 * 
	 * @return 파일내역 화면을 위한 화면 인스턴스
	 * @throws WaveMsgException 
	 */
	public static FileBoxFrame getInstance() throws WaveMsgException {
		
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
	public void makeInitFrame() throws WaveMsgException {
		getContentPane().setLayout(null);
		setTitle(this.title);
		setDefaultCloseOperation(WaveMsgFrame.DISPOSE_ON_CLOSE);
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
	public void callBackData() throws WaveMsgException {
		// TODO Auto-generated method stub
		
	}
}
