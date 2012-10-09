/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : FileUploadFrame.java
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
 * 파일 업로드 화면
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
public class FileUploadFrame extends WaveMsgFrame {
	
	private static final long serialVersionUID = 1783253655922461926L;
	
	/** 타이틀 */
	private String title = CommMsg.FILE_UP_FRAME_TITLE;
	
	/** 파일 업로드 리스트 */
	private List<FileInfo> fileList = null;
	
	/**
	 * 파일 업로드 화면 생성자 <br>
	 * 파일 리스트 생성 <br>
	 * 최초에 makeInitFrame()호출 <br>
	 * 
	 * @throws WaveMsgException 
	 */
	public FileUploadFrame() throws WaveMsgException {
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
	 * 파일 오픈 (파일 경로 설정)
	 */
	public void openFile() {

	}

	/**
	 * 파일 업로드
	 */
	public void uploadFile() {

	}

	@Override
	public void callBackData() throws WaveMsgException {
		// TODO Auto-generated method stub
		
	}
}
