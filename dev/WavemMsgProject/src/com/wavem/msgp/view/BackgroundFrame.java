/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : BackgroundFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import com.wavem.msgp.comm.PropertiesInfo;
import com.wavem.msgp.component.WaveMsgFrame;

/**
 * 배경설정을 위한 화면
 * 
 * <pre>
 * 	BackgroundFrame backgroundFrame = new BackgroundFrame();
 * </pre>
 * 
 * @author 
 *
 */
public class BackgroundFrame extends WaveMsgFrame {

	private static final long serialVersionUID = -2400000915834485391L;
	
	private static BackgroundFrame frame = null;
	
	/** 환경설정 인스턴스 */
	private PropertiesInfo properties = PropertiesInfo.getInstance();

	/**
	 * 배경 설정 화면 생성자 <br>
	 * 최초에 makeInitFrame()호출 <br>
	 */
	private BackgroundFrame() {
		makeInitFrame();
	}
	
	/**
	 * 배경설정을 위한 인스턴스 반환
	 * 
	 * @return 배경설정을 위한 화면 인스턴스
	 */
	public static BackgroundFrame getInstance() {
		
		if (frame == null) {
			synchronized (BackgroundFrame.class) {
				if (frame == null) {
					frame = new BackgroundFrame();
				}
			}
		}
		
		return frame;
	}

	@Override
	public void makeInitFrame() {
		getContentPane().setLayout(null);
		
	}

	@Override
	public void close() {
		this.dispose();
	}
	
	/**
	 * 환경설정으로부터 현재의 배경화면 설정 로드
	 */
	public void loadBackgroundProperty() {
		
	}
	
	/**
	 * 현재 설정된 정보 환경설정에 저장
	 */
	public void saveBackgroundProperty() {
		
	}

	@Override
	public void callBackData() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
