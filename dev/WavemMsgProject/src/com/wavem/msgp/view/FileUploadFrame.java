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
 * ���� ���ε� ȭ��
 * 
 * <pre>
 * 	FileDownloadFrame fileDownloadFrame = new FileDownloadFrame();
 *  FileDownloadFrame.makeInitFrame(); // ���� �����͸� ȣ���ϰ� ȭ���� �׸��� �޼���
 * </pre>
 * 
 * @author 
 *
 */
public class FileUploadFrame extends WaveMsgFrame {
	
	private static final long serialVersionUID = 1783253655922461926L;
	
	/** ���� ���ε� ����Ʈ */
	private List<FileInfo> fileList = null;
	
	/**
	 * ���� ���ε� ȭ�� ������ <br>
	 * ���� ����Ʈ ���� 
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
	 * ���� ���� (���� ��� ����)
	 */
	public void openFile() {

	}

	/**
	 * ���� ���ε�
	 */
	public void uploadFile() {

	}
}
