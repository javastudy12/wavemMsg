package com.wavem.msgp.component;

import javax.swing.Icon;
import javax.swing.JLabel;

public class WaveMsgLabel extends JLabel {

	private static final long serialVersionUID = -7529662727466178324L;

	public WaveMsgLabel() {
		super();
	}

	public WaveMsgLabel(Icon icon) {
		super(icon);
	}

	public WaveMsgLabel(String str) {
		super(str);
	}

	public WaveMsgLabel(Icon icon, int i) {
		super(icon, i);
	}

	public WaveMsgLabel(String str, int i) {
		super(str, i);
	}

	public WaveMsgLabel(String str, Icon icon, int i) {
		super(str, icon, i);
	}

}
