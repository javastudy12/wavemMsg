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
 * ȯ�漳�� ȭ��
 * 
 * <pre>
 * 	PropertyFrame propertyFrame = new PropertyFrame();
 *  PropertyFrame.makeInitFrame(); // ���� �����͸� ȣ���ϰ� ȭ���� �׸��� �޼���
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
	 * ȯ�漳�� �ε� (����)
	 */
	public void loadPropertyInfo() {
		properties.loadPropertiesFile();
	}

	/**
	 * ȯ�漳�� ���� (����)
	 */
	public void savePropertyInfo() {
		properties.savePropertiesFile();
	}
}
