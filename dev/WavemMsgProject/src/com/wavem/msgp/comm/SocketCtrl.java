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
 * 소켓 통신 <br>
 * 
 * <pre>
 * 
 * 1. 데이터 전송을 위한 인스턴스 생성
 * 	SocketCtrl socketCtrl = new SocketCtrl(sc, data, map);
 * 	sc : 소켓 채널 (SocketChannel)
 * 	data :  보낼 데이터 (String)
 * 	map : 컨트롤러객체 저장 map (HashMap)
 * 
 * 2. 데이터 수신을 위한 인스턴스 생성 
 * 	SocketCtrl socketCtrl = new SocketCtrl(sc, key, map);
 * 	sc : 소켓 채널 (SocketChannel)
 * 	key : 이벤트 검색을 위한 key (SelectionKey)
 * 	map : 컨트롤러객체 저장 map (HashMap)
 * </pre>
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 */
public class SocketCtrl extends Thread {
	
	/** 연결되어있는 채널 */
	private SocketChannel sc = null;
	
	/** 채널속의 key를 통해서 응답메시지 처리 위한 인스턴스 */
	private SelectionKey key = null;
	
	/** Charactor Set decoding - UTF-8*/
	private CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
	
	/** 소켓통신 요청한 컨트롤러 객체를 저장하기 위한 map인스턴스 */
	private Map<String, Object> map = null;
	
	/** 서버에 전송할 데이터 */
	private String data = "";
	
	/** 
	 * 송신 및 수신 플러그 <br>
	 * true  : 송신 <br>
	 * false : 수신 <br>
	 */
	private int flag = 0;
	
	/** 결과 */
	private int res = 0;

	/**
	 * 소켓 전송 컨트롤러 생성자 <br>
	 * 
	 * flag = true <br>
	 * 
	 * @param sc 현재 연결된 소켓 채널
	 * @param data 전송하려는 데이터
	 * @param map 컨트롤러 객체를 저장한 map (현재 사용 안함)
	 */
	public SocketCtrl(SocketChannel sc, String data, Map<String, Object> map) {
		this.sc = sc;
		this.data = data;
		this.map = map;
	}
	
	/**
	 * 소켓 수신 컨트롤러 생성자 <br>
	 * 
	 * flag = false <br>
	 * 
	 * @param sc 현재 연결된 소켓 채널
	 * @param key 서버로부터 이벤트를 확인하기 위한 key
	 * @param map 이벤트가 발생되었을 때 응답하기 위해 컨트롤러 객체를 찾기 위한 map
	 */
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
	
	/**
	 * 서버로부터 메시지를 받는다. <br>
	 * 
	 * 서버로부터 받은 메시지로부터 serviceID값을 추출하여 해당하는 컨트롤러객체를 map에서 검색한다. <br>
	 * 요청한 데이터 컨트롤러는 저장된 프레임 및 목적지에 데이터를 적용한다.<br>
	 */
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
	
	/**
	 * buffer 클리어
	 * 
	 * @param buffer
	 */
	private void clearBuffer(ByteBuffer buffer) {
		if (buffer != null) {
			buffer.clear();
			buffer = null;
		}
	}
	
	/**
	 * 서버로부터 응답
	 * 
	 * @return 응답
	 */
	public int getRes() {
		return this.res;
	}
}
