/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : ChatDetailFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.component.WaveMsgException;
import com.wavem.msgp.component.WaveMsgFrame;

/**
 * 대화내역 상세보기 화면
 * 
 * <pre>
 * 	ChatDetailFrame chatDetailFrame = new ChatDetailFrame("fileName");
 * </pre>
 * 
 * @author 
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class ChatDetailFrame extends WaveMsgFrame {
	
	private static final long serialVersionUID = -1320842590690967600L;
	
	/** 타이틀 */
	private String title = CommMsg.CHAT_DETAIL_FRAME_TITLE;
	
	/** 저장한 대화 내역을 위한 File field */
	private FileReader chatFileReader = null;
	
	/** 읽어야 할 파일 경로 및 이름 */
	private String fileName = "";
	
	/** 
	 * 대화내역 상세보기 생성자<br>
	 * 최초 FileReader인스턴스 생성 및 makeInitFrame()호출<br>
	 * @throws WaveMsgException 
	 */
	public ChatDetailFrame(String fileName) throws WaveMsgException {
		super();
		this.fileName = fileName;
		
		makeInitFrame();
		
		try {
			this.chatFileReader = new FileReader(this.fileName);
		} catch (FileNotFoundException e) {
			// TODO 에러 출력 메시지 박스 호출로직 필요
			e.printStackTrace();
		}
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
	 * 로컬에서 대화 내역 로드
	 */
	public void loadChatData() {

	}

	@Override
	public void callBackData() throws WaveMsgException {
		// TODO Auto-generated method stub
		
	}
}
