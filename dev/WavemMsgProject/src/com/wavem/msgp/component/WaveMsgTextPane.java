package com.wavem.msgp.component;

import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class WaveMsgTextPane extends JTextPane {

	private static final long serialVersionUID = 206754192314054348L;

	public WaveMsgTextPane() {
		super();
	}

	public WaveMsgTextPane(StyledDocument doc) {
		super(doc);
	}

}
