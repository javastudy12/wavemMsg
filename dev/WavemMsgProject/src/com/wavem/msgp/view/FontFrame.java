/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : FontFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import com.wavem.msgp.comm.PropertiesInfo;
import com.wavem.msgp.comm.WaveMsgException;
import com.wavem.msgp.component.WaveMsgFrame;

/**
 * 채팅 폰트 및 색상 설정 화면
 * 
 * <pre>
 * 	FontFrame fontFrame = new FontFrame();
 * </pre>
 * 
 * @author 
 * @since jdk 1.6
 * @version 1.0
 * @see
 * @deprecated 사용하는 프레임 변경 {@link WaveMsgFontFrame}
 */
public class FontFrame extends WaveMsgFrame{
	
	private static final long serialVersionUID = 7117625848207442204L;

	/** 환경설정 인스턴스 */
	private PropertiesInfo properties = PropertiesInfo.getInstance();
	
	/** 채팅 폰트 및 색상 설정 화면 인스턴스 변수 */
	private static FontFrame frame = null;
	
	/**
	 * 채팅 폰트 및 색상 설정 화면 <br>
	 * 최초 makeInitFrame()호출 <br>
	 * 
	 * @throws WaveMsgException 
	 */
	private FontFrame() throws WaveMsgException {
		makeInitFrame();
	}
	
	/**
	 * 채팅 폰트 및 색상 설정 화면을 위한 인스턴스 반환
	 * 
	 * @return 채팅 폰트 및 색상 설정 화면을 위한 화면 인스턴스
	 * @throws WaveMsgException 
	 */
	public static FontFrame getInstance() throws WaveMsgException {
		
		if (frame == null) {
			synchronized (FontFrame.class) {
				if (frame == null) {
					frame = new FontFrame();
				}
			}
		}
		
		return frame;
	}
	
	@Override
	public void makeInitFrame() throws WaveMsgException {
		getContentPane().setLayout(null);
	}
	
	@Override
	public void close() {
		this.dispose();
	}
	
	
	/**
	 * 기존에 설정된 폰트 로드
	 */
	public void loadFont() {
	
	}
	
	/**
	 * 기존에 설정된 색상 로드
	 */
	public void loadColor() {
	
	}
	
	/**
	 * 현재 설정한 폰트 및 색상 저장
	 */
	public void saveFontNColor() {
	
	}

	@Override
	public void callBackData() throws WaveMsgException {
		// TODO Auto-generated method stub
		
	}
}
