/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : FileController.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.controller;

import java.util.ArrayList;
import java.util.List;

import com.wavem.msgp.dto.FileInfo;

/**
 * 파일 전송을 위한 컨트롤러
 * 
 * @author 
 * 
 */
public class FileController {

	/** 파일 상태 플러그 */
	private int fileStatus = 0;
	
	/** 전송 혹은 수신중인 파일 리스트 */
	private List<FileInfo> fileList = null;
	
	/**
	 * 파일 리스트를 받음 <br>
	 * 파일 상태를 받음 <br>
	 * 
	 * <pre>
	 * 	파일 업로드   : fileStatus = 1
	 *  파일 다운로드 : fileStatus = 2
	 * </pre>
	 * 
	 * @param fileStatus 파일 상태 (업로드 다운로드 구분)
	 * @param fileList 파일 리스트
	 */
	public FileController(int fileStatus, List<FileInfo> fileList) {
		this.fileList = fileList;
		this.fileStatus = fileStatus; 
	}

	/**
	 * 파일 업로드 관리
	 */
	public void uploadFile() {

	}

	/**
	 * 파일 다운로드 관리
	 */
	public void downloadFile() {

	}

	/**
	 * 파일 업로드를 위한 파일 정보 전송
	 */
	public void sendFileInfo() {

	}

	/**
	 * 파일 다운로드를 위한 파일 정보 수신
	 */
	public void receiveFileInfo() {

	}

	/**
	 * 파일 상태 플러그
	 * 
	 * @return 현재의 상태ㅑ 플러그 반환
	 */
	public int getFileStatus() {
		return fileStatus;
	}

	/**
	 * 전송 혹은 수신중인 파일 리스트를 반환
	 * 
	 * @return 전송 혹은 수신중인 파일 리스트
	 */
	public List getFileList() {
		return fileList;
	}
}
