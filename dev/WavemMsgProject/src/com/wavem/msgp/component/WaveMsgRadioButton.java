package com.wavem.msgp.component;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JRadioButton;

public class WaveMsgRadioButton extends JRadioButton {

	private static final long serialVersionUID = -7548730826847401830L;

	public WaveMsgRadioButton() {
		super();
	}

	public WaveMsgRadioButton(Action action) {
		super(action);
	}

	public WaveMsgRadioButton(Icon icon) {
		super(icon);
	}

	public WaveMsgRadioButton(String str) {
		super(str);
	}

	public WaveMsgRadioButton(Icon icon, boolean b) {
		super(icon, b);
	}

	public WaveMsgRadioButton(String str, boolean b) {
		super(str, b);
	}

	public WaveMsgRadioButton(String str, Icon icon) {
		super(str, icon);
	}

	public WaveMsgRadioButton(String str, Icon icon, boolean b) {
		super(str, icon, b);
	}

}
