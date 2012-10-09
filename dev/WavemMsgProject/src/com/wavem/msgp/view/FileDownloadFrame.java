/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : FileDownloadFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import java.util.ArrayList;
import java.util.List;

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.comm.WaveMsgException;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.dto.FileInfo;

/**
 * 파일 다운로드 화면
 * 
 * <pre>
 * 	FileDownloadFrame fileDownloadFrame = new FileDownloadFrame();
 * </pre>
 * 
 * @author
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class FileDownloadFrame extends WaveMsgFrame {
	
	private static final long serialVersionUID = -1993710934142869249L;
	
	/** 타이틀 */
	private String title = CommMsg.FILE_DOWN_FRAME_TITLE;
	
	/** 파일 다운로드 리스트 */
	private List<FileInfo> fileList = null;
	
	/**
	 * 파일 다운로드 화면 생성자 <br>
	 * 파일 리스트 생성 <br>
	 * 최초에 makeInitFrame()호출 <br>
	 * 
	 * @throws WaveMsgException 
	 */
	public FileDownloadFrame() throws WaveMsgException {
		fileList = new ArrayList<FileInfo>();
		makeInitFrame();
	}
	
	@Override
	public void makeInitFrame() throws WaveMsgException {
		getContentPane().setLayout(null);
		setTitle(this.title);
	}

	@Override
	public void close() {
		this.dispose();
	}

	/**
	 * 파일 다운로드 경로 설정
	 */
	public void savePath() {

	}

	/**
	 * 파일 다운로드
	 */
	public void downloadFile() {

	}

	@Override
	public void callBackData() throws WaveMsgException {
		// TODO Auto-generated method stub
		
	}

}
