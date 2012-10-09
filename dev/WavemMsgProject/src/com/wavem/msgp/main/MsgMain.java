/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : MsgMain.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.main;

import java.awt.EventQueue;

import com.wavem.msgp.comm.PropertiesInfo;
import com.wavem.msgp.comm.SocketMgr;
import com.wavem.msgp.view.MsgMainFrame;

/**
 * 최초 시작점
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see PropertiesInfo
 * @see SocketMgr
 * @see MsgMainFrame
 */
public class MsgMain {
	
	/** 메인 소켓 */
	private static SocketMgr socketMgr = null;
	
	/**
	 * 소켓 연결 클래스
	 * 
	 * @return
	 */
	public static SocketMgr getSocketMgr() {
		
		if (socketMgr == null) {
			synchronized (SocketMgr.class) {
				if (socketMgr == null) {
					socketMgr = new SocketMgr();
				}
			}
		}
		
		return socketMgr;
	}

	public static void main(String[] args) {

		// 환경설정 로드
		PropertiesInfo property = PropertiesInfo.getInstance();
		
		// 서버와 소켓 최초 생성
		SocketMgr socketMgr = getSocketMgr();
		socketMgr.start();
		
		// 메인에 현재의 소켓 메니저 등록
		MsgMain.socketMgr = socketMgr;

		// 화면 실행
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MsgMainFrame frame = MsgMainFrame.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
