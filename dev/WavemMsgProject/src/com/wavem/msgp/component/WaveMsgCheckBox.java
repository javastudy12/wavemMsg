package com.wavem.msgp.component;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBox;

public class WaveMsgCheckBox extends JCheckBox {

	private static final long serialVersionUID = -7409322588066842755L;

	public WaveMsgCheckBox() {
		super();
	}
	
	public WaveMsgCheckBox(Action action) {
		super(action);
	}
	
	public WaveMsgCheckBox(Icon icon) {
		super(icon);
	}
	
	public WaveMsgCheckBox(String str) {
		super(str);
	}
	
	public WaveMsgCheckBox(Icon icon, boolean b) {
		super(icon, b);
	}
	
	public WaveMsgCheckBox(String str, boolean b) {
		super(str, b);
	}
	
	public WaveMsgCheckBox(String str, Icon icon) {
		super(str, icon);
	}
	
	public WaveMsgCheckBox(String str, Icon icon, boolean b) {
		super(str, icon, b);
	}
	
}
