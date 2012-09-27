/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : SocketCtrl.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.comm;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import javax.swing.JOptionPane;

import com.wavem.msgp.component.WaveMsgDialogBox;

/**
 * 소켓 통신
 * 
 * @author
 * 
 */
public class SocketCtrl extends Thread {
	
	private SocketChannel sc = null;
	private String data = "";
	private int res = 0;

	public SocketCtrl(SocketChannel sc, String data) {
		this.sc = sc;
		this.data = data;
	}

	@Override
	public void run() {
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		
		try {
			buffer.clear();
			buffer.put(data.getBytes());
			buffer.flip();

			res = sc.write(buffer);
		} catch (Exception e) {
			new WaveMsgDialogBox("서버연결 - ERROR", e.getMessage(), JOptionPane.ERROR_MESSAGE);
		} finally {
			clearBuffer(buffer);
		}
	}

	private void clearBuffer(ByteBuffer buffer) {
		if (buffer != null) {
			buffer.clear();
			buffer = null;
		}
	}
	
	public int getRes() {
		return this.res;
	}
}
