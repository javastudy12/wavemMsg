/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : FileInfo.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.dto;

import java.io.Serializable;

/**
 * 파일 정보 클래스
 * 
 * @author
 * 
 */
public class FileInfo extends DataInfoDto {

	private static final long serialVersionUID = 6747870772102035017L;

	/** 파일 사이즈 */
	private long fileSize = 0;

	/** 파일 이름 */
	private String fileName = "";

	/** 파일 위치 (경로) */
	private String filePath = "";

	/** 파일 확장자 */
	private String fileType = "";

	/** 송신자 ID */
	private String senderID = "";
	
	/** 수신자 ID */
	private String recipientID = "";
	
	/** 파일 송신 상태 */
	private int uploadStatus = 0;
	
	/** 파일 수신 상태 */
	private int downloadStatus = 0;
	
	/** 파일 송신 완료 일짜 */
	private String uploadDate = "";
	
	/** 파일 수신 완료 일짜 */
	private String downloadDate = "";
	
	/**
	 * 파일 정보 기본 생성자
	 */
	public FileInfo() {
		
	}
	
	/**
	 * 파일 정보 기본 생성자
	 * 
	 * @param serviceID 서비스 ID
	 */
	public FileInfo(String serviceID) {
		super(serviceID);
	}
	
	/**
	 * 파일 정보 생성자
	 * 
	 * @param serviceID 서비스 ID
	 * @param fileName 파일 이름
	 * @param fileSize 파일 사이즈
	 * @param fileType 파일 확장자
	 * @param filePath 파일 위치
	 * @param senderID 송신자 ID
	 * @param recipientID 수신자 ID
	 */
	public FileInfo(String serviceID, String fileName, long fileSize, String fileType, String filePath, String senderID, String recipientID ) {
		super(serviceID);
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.filePath = filePath;
		this.senderID = senderID;
		this.recipientID = recipientID;
	}
	
	/**
	 * 파일 사이즈를 반환한다.
	 * 
	 * @return 파일 사이즈
	 */
	public long getFileSize() {
		return fileSize;
	}

	/**
	 * 파일 사이즈를 저장한다.
	 * 
	 * @param fileSize
	 *            파일 사이즈
	 */
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * 파일 이름을 반환한다.
	 * 
	 * @return 파일 이름
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 파일 이름을 저장한다.
	 * 
	 * @param fileName
	 *            파일 이름
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 파일의 위치를 반환한다.
	 * 
	 * @return 파일 경로
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * 파일의 위치를 저장한다.
	 * 
	 * @param filePath
	 *            파일 경로
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * 파일의 확장자를 반환한다.
	 * 
	 * @return 파일 확장자
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * 파일의 확장자를 저장한다.
	 * 
	 * @param fileType
	 *            파일 확장자
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * 송신자를 반환한다.
	 * @return 송신자 ID
	 */
	public String getSenderID() {
		return senderID;
	}

	/**
	 * 송신자를 저장한다.
	 * @param sender 송신자 ID
	 */
	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	/**
	 * 수신자를 반환한다.
	 * @return 수신자 ID
	 */
	public String getRecipientID() {
		return recipientID;
	}

	/**
	 * 수신자를 저장한다.
	 * @param recipient 수신자 ID
	 */
	public void setRecipientID(String recipientID) {
		this.recipientID = recipientID;
	}

	/**
	 * 파일 송신 상태를 반환한다.
	 * @return 파일 송신 상태
	 */
	public int getUploadStatus() {
		return uploadStatus;
	}

	/**
	 * 파일 송신 상태를 저장한다.
	 * @param uploadStatus 파일 송신 상태
	 */
	public void setUploadStatus(int uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	/**
	 * 파일 수신 상태를 반환한다.
	 * @return 파일 수신 상태
	 */
	public int getDownloadStatus() {
		return downloadStatus;
	}

	/**
	 * 파일 수신 상태를 저장한다.
	 * @param downloadStatus 파일 수신 상태
	 */
	public void setDownloadStatus(int downloadStatus) {
		this.downloadStatus = downloadStatus;
	}

	/**
	 * 파일 송신 완료 일짜를 반환한다.
	 * @return 파일 송신 완료 일짜
	 */
	public String getUploadDate() {
		return uploadDate;
	}

	/**
	 * 파일 송신 완료 일짜를 저장한다.
	 * @param uploadDate 파일 송신 완료 일짜
	 */
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	/**
	 * 파일 수신 완료 일짜를 반환한다.
	 * @return 파일 수신 완료 일짜
	 */
	public String getDownloadDate() {
		return downloadDate;
	}

	/**
	 * 파일 수신 완료 일짜를 저장한다.
	 * @param downloadDate 파일 수신 완료 일짜
	 */
	public void setDownloadDate(String downloadDate) {
		this.downloadDate = downloadDate;
	}

}
