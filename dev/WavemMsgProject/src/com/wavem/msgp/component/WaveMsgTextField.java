package com.wavem.msgp.component;

import javax.swing.JTextField;
import javax.swing.text.Document;

public class WaveMsgTextField extends JTextField {

	private static final long serialVersionUID = -6996038169410735037L;

	public WaveMsgTextField() {
		super();
	}

	public WaveMsgTextField(int i) {
		super(i);
	}

	public WaveMsgTextField(String str) {
		super(str);
	}

	public WaveMsgTextField(String str, int i) {
		super(str, i);
	}

	public WaveMsgTextField(Document doc, String str, int i) {
		super(doc, str, i);
	}

}
