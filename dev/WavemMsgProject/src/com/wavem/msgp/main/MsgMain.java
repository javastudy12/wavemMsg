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

import com.wavem.msgp.view.MsgMainFrame;

/**
 * 최초 시작점
 * 
 * @author 
 *
 */
public class MsgMain {

	public static void main(String[] args) {
		// TODO 세션체크 후 로그인 화면 호출 및 메인 화면 호출
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
