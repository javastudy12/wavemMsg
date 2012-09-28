/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : PropertyFrame.java
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
 * 환경설정 화면
 * 
 * <pre>
 * 	PropertyFrame propertyFrame = new PropertyFrame();
 * </pre>
 * 
 * @author 
 *
 */
public class PropertyFrame extends WaveMsgFrame {
	
	private static final long serialVersionUID = 8935617435151137888L;
	
	/** 환경설정 인스턴스 변수 */
	private PropertiesInfo properties = null;

	/** 환경설정 화면 인스턴스 변수 */
	private static PropertyFrame frame = null;
	
	/**
	 * 환경설정 화면 생성자 <br>
	 * 최초 환경설정 관련 인스턴스 획득 <br>
	 * 최초 makeInitFrame() 호출 <br>
	 */
	private PropertyFrame() {
		this.properties = PropertiesInfo.getInstance();
		makeInitFrame();
	}
	
	/**
	 * 환경설정 화면을 위한 인스턴스 반환
	 * 
	 * @return 환경설정 화면을 위한 화면 인스턴스
	 */
	public static PropertyFrame getInstance() {
		
		if (frame == null) {
			synchronized (PropertyFrame.class) {
				if (frame == null) {
					frame = new PropertyFrame();
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
	 * 환경설정 로딩 (로컬)
	 */
	public void loadPropertyInfo() {
		properties.loadPropertiesFile();
	}

	/**
	 * 환경설정 저장 (로컬)
	 */
	public void savePropertyInfo() {
		properties.savePropertiesFile();
	}

	@Override
	public void callBackData() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
