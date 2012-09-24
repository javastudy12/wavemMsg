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

import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.dto.FileInfo;

/**
 * 파일 업로드 화면
 * 
 * <pre>
 * 	FileDownloadFrame fileDownloadFrame = new FileDownloadFrame();
 *  FileDownloadFrame.makeInitFrame(); // 실제 데이터를 호출하고 화면을 그리는 메서드
 * </pre>
 * 
 * @author 
 *
 */
public class FileUploadFrame extends WaveMsgFrame {
	
	private static final long serialVersionUID = 1783253655922461926L;
	
	/** 파일 업로드 리스트 */
	private List<FileInfo> fileList = null;
	
	/**
	 * 파일 업로드 화면 생성자 <br>
	 * 파일 리스트 생성 
	 */
	public FileUploadFrame() {
		fileList = new ArrayList<FileInfo>();
	}
	
	@Override
	public void makeInitFrame() {

	}

	@Override
	public void close() {

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
}
