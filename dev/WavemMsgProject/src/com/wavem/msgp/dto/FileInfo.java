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
 * ���� ���� Ŭ����
 * 
 * @author
 * 
 */
public class FileInfo implements Serializable {

	private static final long serialVersionUID = 6747870772102035017L;

	/** ���� ������ */
	private long fileSize = 0;

	/** ���� �̸� */
	private String fileName = "";

	/** ���� ��ġ (���) */
	private String filePath = "";

	/** ���� Ȯ���� */
	private String fileType = "";

	/** �۽��� ID */
	private String senderID = "";
	
	/** ������ ID */
	private String recipientID = "";
	
	/** ���� �۽� ���� */
	private int uploadStatus = 0;
	
	/** ���� ���� ���� */
	private int downloadStatus = 0;
	
	/** ���� �۽� �Ϸ� ��¥ */
	private String uploadDate = "";
	
	/** ���� ���� �Ϸ� ��¥ */
	private String downloadDate = "";
	
	/**
	 * ���� ���� �⺻ ������
	 */
	public FileInfo() {
		
	}
	
	/**
	 * ���� ���� ������
	 * 
	 * @param fileName ���� �̸�
	 * @param fileSize ���� ������
	 * @param fileType ���� Ȯ����
	 * @param filePath ���� ��ġ
	 * @param senderID �۽��� ID
	 * @param recipientID ������ ID
	 */
	public FileInfo(String fileName, long fileSize, String fileType, String filePath, String senderID, String recipientID ) {
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.filePath = filePath;
		this.senderID = senderID;
		this.recipientID = recipientID;
	}
	
	/**
	 * ���� ����� ��ȯ�Ѵ�.
	 * 
	 * @return ���� ������
	 */
	public long getFileSize() {
		return fileSize;
	}

	/**
	 * ���� ����� �����Ѵ�.
	 * 
	 * @param fileSize
	 *            ���� ������
	 */
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * ���� �̸��� ��ȯ�Ѵ�.
	 * 
	 * @return ���� �̸�
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * ���� �̸��� �����Ѵ�.
	 * 
	 * @param fileName
	 *            ���� �̸�
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * ������ ��ġ�� ��ȯ�Ѵ�.
	 * 
	 * @return ���� ���
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * ������ ��ġ�� �����Ѵ�.
	 * 
	 * @param filePath
	 *            ���� ���
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * ������ Ȯ���ڸ� ��ȯ�Ѵ�.
	 * 
	 * @return ���� Ȯ����
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * ������ Ȯ���ڸ� �����Ѵ�.
	 * 
	 * @param fileType
	 *            ���� Ȯ����
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * �۽��ڸ� ��ȯ�Ѵ�.
	 * @return �۽��� ID
	 */
	public String getSenderID() {
		return senderID;
	}

	/**
	 * �۽��ڸ� �����Ѵ�.
	 * @param sender �۽��� ID
	 */
	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	/**
	 * �����ڸ� ��ȯ�Ѵ�.
	 * @return ������ ID
	 */
	public String getRecipientID() {
		return recipientID;
	}

	/**
	 * �����ڸ� �����Ѵ�.
	 * @param recipient ������ ID
	 */
	public void setRecipientID(String recipientID) {
		this.recipientID = recipientID;
	}

	/**
	 * ���� �۽� ���¸� ��ȯ�Ѵ�.
	 * @return ���� �۽� ����
	 */
	public int getUploadStatus() {
		return uploadStatus;
	}

	/**
	 * ���� �۽� ���¸� �����Ѵ�.
	 * @param uploadStatus ���� �۽� ����
	 */
	public void setUploadStatus(int uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	/**
	 * ���� ���� ���¸� ��ȯ�Ѵ�.
	 * @return ���� ���� ����
	 */
	public int getDownloadStatus() {
		return downloadStatus;
	}

	/**
	 * ���� ���� ���¸� �����Ѵ�.
	 * @param downloadStatus ���� ���� ����
	 */
	public void setDownloadStatus(int downloadStatus) {
		this.downloadStatus = downloadStatus;
	}

	/**
	 * ���� �۽� �Ϸ� ��¥�� ��ȯ�Ѵ�.
	 * @return ���� �۽� �Ϸ� ��¥
	 */
	public String getUploadDate() {
		return uploadDate;
	}

	/**
	 * ���� �۽� �Ϸ� ��¥�� �����Ѵ�.
	 * @param uploadDate ���� �۽� �Ϸ� ��¥
	 */
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	/**
	 * ���� ���� �Ϸ� ��¥�� ��ȯ�Ѵ�.
	 * @return ���� ���� �Ϸ� ��¥
	 */
	public String getDownloadDate() {
		return downloadDate;
	}

	/**
	 * ���� ���� �Ϸ� ��¥�� �����Ѵ�.
	 * @param downloadDate ���� ���� �Ϸ� ��¥
	 */
	public void setDownloadDate(String downloadDate) {
		this.downloadDate = downloadDate;
	}

}
