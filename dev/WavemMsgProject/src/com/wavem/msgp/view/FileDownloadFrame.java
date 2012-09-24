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

import com.wavem.msgp.dto.FileInfo;
import com.wavem.msgp.main.WaveMsgFrame;

/**
 * ���� �ٿ�ε� ȭ��
 * 
 * <pre>
 * 	FileDownloadFrame fileDownloadFrame = new FileDownloadFrame();
 *  FileDownloadFrame.makeInitFrame(); // ���� �����͸� ȣ���ϰ� ȭ���� �׸��� �޼���
 * </pre>
 * 
 * @author
 *
 */
public class FileDownloadFrame extends WaveMsgFrame {
	
	private static final long serialVersionUID = -1993710934142869249L;
	
	/** ���� �ٿ�ε� ����Ʈ */
	private List<FileInfo> fileList = null;
	
	/**
	 * ���� �ٿ�ε� ȭ�� ������ <br>
	 * ���� ����Ʈ ���� 
	 */
	public FileDownloadFrame() {
		fileList = new ArrayList<FileInfo>();
	}
	
	@Override
	public void makeInitFrame() {

	}

	@Override
	public void close() {

	}

	/**
	 * ���� �ٿ�ε� ��� ����
	 */
	public void savePath() {

	}

	/**
	 * ���� �ٿ�ε�
	 */
	public void downloadFile() {

	}

}
