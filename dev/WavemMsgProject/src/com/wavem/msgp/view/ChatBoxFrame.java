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
import com.wavem.msgp.main.WaveMsgFrame;

/**
 * 대화내역 화면
 *
 * <pre>
 * 	ChatBoxFrame chatBoxFrame = new ChatBoxFrame();
 *  ChatBoxFrame.makeInitFrame(); // 실제 데이터를 호출하고 화면을 그리는 메서드
 * </pre>
 * 
 * @author 
 *
 */
public class ChatBoxFrame extends WaveMsgFrame {
	private static final long serialVersionUID = 3447984774238008875L;
	private File chatFile;

	@Override
	public void makeInitFrame() {

	}

	@Override
	public void close() {

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
}
