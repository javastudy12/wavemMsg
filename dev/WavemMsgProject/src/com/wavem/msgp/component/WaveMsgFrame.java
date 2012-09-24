/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : AbstractFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import javax.swing.JFrame;

/**
 * ������(ȭ��) ���� �߻�Ŭ����
 * 
 * @author
 * 
 */
public abstract class WaveMsgFrame extends JFrame {

	/**
	 * ȭ�� �ε�
	 */
	public abstract void makeInitFrame();

	/**
	 * ȭ�� ����
	 */
	public abstract void close();

}
