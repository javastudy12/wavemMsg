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
 *  PropertyFrame.makeInitFrame(); // 실제 데이터를 호출하고 화면을 그리는 메서드
 * </pre>
 * 
 * @author 
 *
 */
public class PropertyFrame extends WaveMsgFrame {
	
	private static final long serialVersionUID = 8935617435151137888L;
	
	private PropertiesInfo properties = PropertiesInfo.getInstance();

	@Override
	public void makeInitFrame() {

	}

	@Override
	public void close() {
		
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
}
