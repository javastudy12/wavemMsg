package com.wavem.msgp.component;

import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class WaveMsgComboBox extends JComboBox {

	private static final long serialVersionUID = -3852595989966048881L;

	public WaveMsgComboBox() {
		super();
	}

	public WaveMsgComboBox(ComboBoxModel combox) {
		super(combox);
	}

	public WaveMsgComboBox(Object[] obj) {
		super(obj);
	}

	public WaveMsgComboBox(Vector vector) {
		super(vector);
	}
}
