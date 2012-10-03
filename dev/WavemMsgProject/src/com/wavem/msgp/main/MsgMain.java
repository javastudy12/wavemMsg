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
 * @author 
 *
 */
public class MsgMain {
	
	/** 메인 소켓 */
	public static SocketMgr socketMgr = null;

	public static void main(String[] args) {

		// 환경설정 로드
		PropertiesInfo property = PropertiesInfo.getInstance();
		property.loadPropertiesFile();
		
		// 서버와 소켓 최초 생성
		SocketMgr socketMgr = new SocketMgr();
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
