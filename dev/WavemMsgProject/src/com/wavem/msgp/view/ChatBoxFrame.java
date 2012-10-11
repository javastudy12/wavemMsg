/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : ChatBoxFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import java.io.File;

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.comm.PropertiesInfo;
import com.wavem.msgp.component.WaveMsgException;
import com.wavem.msgp.component.WaveMsgFrame;

/**
 * 대화내역 화면
 *
 * <pre>
 * 	ChatBoxFrame chatBoxFrame = new ChatBoxFrame();
 * </pre>
 * 
 * @author 
 * @since jdk 1.6
 * @version 1.0
 * @see 
 */
public class ChatBoxFrame extends WaveMsgFrame {
	
	private static final long serialVersionUID = 3447984774238008875L;

	/** 타이틀 */
	private String title = CommMsg.CHAT_HISTORY_FRAME_TITLE;
	
	/** 저장한 대화 내역을 위한 File field */
	private File chatFile = null;

	/** 대화내역 화면 인스턴스 */
	private static ChatBoxFrame frame = null;
	
	/**
	 * 대화내역 화면 생성자<br>
	 * 최초 실행 시 File인스턴스 생성 및 makeInitFrame() 호출<br>
	 * @throws WaveMsgException 
	 * 
	 * @see PropertiesInfo#getInstance()
	 * @see PropertiesInfo#getChatSavePath()
	 * @see ChatBoxFrame#makeInitFrame()
	 */
	private ChatBoxFrame() throws WaveMsgException {
		PropertiesInfo properties = PropertiesInfo.getInstance(); // 대화저장 경로를 가져오기 위한 설정 인스턴스 획득
		String filePath = properties.getChatSavePath(); // 설정되어있는 파일 경로
		
		chatFile = new File(filePath); // 환경설정에 저장되어있는 대화 저장 경로로 File인스턴스 생성
		makeInitFrame();
	}
	
	/**
	 * 대화내역 화면을 위한 인스턴스 반환
	 * 
	 * @return 대화내역 화면을 위한 화면 인스턴스
	 * @throws WaveMsgException 
	 */
	public static ChatBoxFrame getInstance() throws WaveMsgException {
		
		if (frame == null) {
			synchronized (ChatBoxFrame.class) {
				if (frame == null) {
					frame = new ChatBoxFrame();
				}
			}
		}
		
		return frame;
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
	 * 로컬에 저장된 파일 리스트 로드
	 */
	public void loadChatList() {

	}

	/**
	 * 선택한 파일 리스트를 로드
	 */
	public void loadChatInfo() {

	}

	@Override
	public void callBackData() throws WaveMsgException {
		// TODO Auto-generated method stub
		
	}
}
