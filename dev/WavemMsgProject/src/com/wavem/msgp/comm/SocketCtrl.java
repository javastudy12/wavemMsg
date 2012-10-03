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

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Map;

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
	private SelectionKey key = null;
	/** Charactor Set decoding */
	private CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
	Map<String, Object> map = null;
	private String data = "";
	private int flag = 0;
	private int res = 0;

	public SocketCtrl(SocketChannel sc, String data, Map<String, Object> map) {
		this.sc = sc;
		this.data = data;
		this.map = map;
	}
	
	public SocketCtrl(SocketChannel sc, SelectionKey key, Map<String, Object> map) {
		this.sc = sc;
		this.key = key;
		this.map = map;
		this.flag = 1;
	}

	@Override
	public void run() {
		if (flag == 0) {
			sendMsg();
		} else {
			receiveMsg();
		}
	}

	/**
	 * 메시지 전송
	 */
	private void sendMsg() {
		
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		System.out.println("request Data : " + data);
		
		// 전송할 데이터가 없는 경우
		if (data.trim().length() == 0) {
			new WaveMsgDialogBox("서버연결", "전송할 데이터가 없습니다.", JOptionPane.ERROR_MESSAGE);
		}
		
		// 데이터 전송
		try {
			buffer.clear();
			buffer.put(data.getBytes());
			buffer.flip();

			res = sc.write(buffer);
		} catch (Exception e) {
			new WaveMsgDialogBox("서버연결", "서버로 데이터 전송을 실패했습니다.", JOptionPane.ERROR_MESSAGE);
			res = -1;
		} finally {
			clearBuffer(buffer);
		}
	}
	
	private void receiveMsg() {
		
		// SelectionKey로 부터 소켓 채널을 얻어 옴
		SocketChannel sc = (SocketChannel) key.channel();
		System.out.println("소켓 채널 얻기 성공");
		
		// ByteBuffer를 생성함
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		
		int read = 0;

		try {
			// 요청한 클라이언트의 소켓 채널로 부터 데이터를 읽어 들임
			read = sc.read(buffer);
			System.out.println(read + " byte를 읽었습니다.");
		} catch (IOException e) {
			try {
				sc.close();
			} catch (IOException e1) {
			}
		}

		buffer.flip();
		
		String data = "";
		try {
			data = decoder.decode(buffer).toString();
			System.out.println("Message - " + data);
		} catch (CharacterCodingException e) {
			new WaveMsgDialogBox("서버연결", "read Error", JOptionPane.ERROR_MESSAGE);
		}

		DataParser parser = new DataParser(data);
		
		try {
			parser.parseToInstance();
		} catch (WaveMsgException e) {
			new WaveMsgDialogBox("서버연결", "응답데이터 파싱 에러", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		// 버퍼 메모리를 해제함
		clearBuffer(buffer);
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
