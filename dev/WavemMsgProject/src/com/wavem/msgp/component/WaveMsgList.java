package com.wavem.msgp.component;

import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListModel;

public class WaveMsgList extends JList {

	private static final long serialVersionUID = 2324822370093906088L;

	public WaveMsgList() {
		super();
	}

	public WaveMsgList(ListModel listModel) {
		super(listModel);
	}

	public WaveMsgList(Object[] obj) {
		super(obj);
	}

	public WaveMsgList(Vector vector) {
		super(vector);
	}

}
