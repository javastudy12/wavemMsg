/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgLabel.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * 라벨
 * 
 * @author 정재요
 *
 */
public class WaveMsgLabel extends JLabel {

	private static final long serialVersionUID = -7529662727466178324L;

	/**
	 * 
	 */
	public WaveMsgLabel() {
		super();
	}

	/**
	 * 
	 * @param icon
	 */
	public WaveMsgLabel(Icon icon) {
		super(icon);
	}

	/**
	 * 
	 * @param str
	 */
	public WaveMsgLabel(String str) {
		super(str);
	}

	/**
	 * 
	 * @param icon
	 * @param i
	 */
	public WaveMsgLabel(Icon icon, int i) {
		super(icon, i);
	}

	/**
	 * 
	 * @param str
	 * @param i
	 */
	public WaveMsgLabel(String str, int i) {
		super(str, i);
	}

	/**
	 * 
	 * @param str
	 * @param icon
	 * @param i
	 */
	public WaveMsgLabel(String str, Icon icon, int i) {
		super(str, icon, i);
	}

}
