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
 * ���� ������ ���� ��Ʈ�ѷ�
 * 
 * @author 
 * 
 */
public class FileController {

	/** ���� ���� �÷��� */
	private int fileStatus = 0;
	
	/** ���� Ȥ�� �������� ���� ����Ʈ */
	private List<FileInfo> fileList = null;
	
	/**
	 * ���� ����Ʈ�� ���� <br>
	 * ���� ���¸� ���� <br>
	 * 
	 * <pre>
	 * 	���� ���ε�   : fileStatus = 1
	 *  ���� �ٿ�ε� : fileStatus = 2
	 * </pre>
	 * 
	 * @param fileStatus ���� ���� (���ε� �ٿ�ε� ����)
	 * @param fileList ���� ����Ʈ
	 */
	public FileController(int fileStatus, List<FileInfo> fileList) {
		this.fileList = fileList;
		this.fileStatus = fileStatus; 
	}

	/**
	 * ���� ���ε� ����
	 */
	public void uploadFile() {

	}

	/**
	 * ���� �ٿ�ε� ����
	 */
	public void downloadFile() {

	}

	/**
	 * ���� ���ε带 ���� ���� ���� ����
	 */
	public void sendFileInfo() {

	}

	/**
	 * ���� �ٿ�ε带 ���� ���� ���� ����
	 */
	public void receiveFileInfo() {

	}

	/**
	 * ���� ���� �÷���
	 * 
	 * @return ������ ���¤� �÷��� ��ȯ
	 */
	public int getFileStatus() {
		return fileStatus;
	}

	/**
	 * ���� Ȥ�� �������� ���� ����Ʈ�� ��ȯ
	 * 
	 * @return ���� Ȥ�� �������� ���� ����Ʈ
	 */
	public List getFileList() {
		return fileList;
	}
}
