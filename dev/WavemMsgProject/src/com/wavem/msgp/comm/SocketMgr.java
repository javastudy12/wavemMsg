/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : SocketMgr.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.comm;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wavem.msgp.component.WaveMsgDialogBox;

/**
 * 소켓 통신 연결 관리 connection, disconnection 연결시간초과, 연결시도 횟수 체크 <br>
 * 
 * 비동기 통신이기에 결과 값은 startReader()값을 통해서 얻을 수 있다. <br>
 * 
 * <pre>
 * SocketMgr socketMgr = new SocketMgr();
 * socketMgr.run();
 * socketMgr.startWriter(String data); // 전송할 데이터
 * </pre>
 * 
 * @author
 * 
 */
public class SocketMgr extends Thread{

	/** 소켓 채널 등록 */
	private Selector selector = null;
	
	/** 소켓채널 */
	private SocketChannel socketChannel = null;

	/** 데이터 Charactor Set 설정 인스턴스 */
	private Charset charset = null;
	
	/** Charactor Set decoding */
	private CharsetDecoder decoder = null;

	/** 환경설정 */
	private PropertiesInfo property = PropertiesInfo.getInstance();
	
	private boolean socketConChk = true;
	
	@Override
	public void run() {
		initServer(property.getHost(), property.getPort()); // 서버소켓 초기화
		startReader();
	}
	
	/**
	 * 서버 연결 초기화
	 * 
	 * @param host 서버 HOST
	 * @param port 서버 PORT
	 */
	public void initServer(String host, int port) {
		
		try {
			// 셀렉터를 연다
			selector = Selector.open();

			// 소켓 채널을 생성함
			socketChannel = SocketChannel.open(new InetSocketAddress(host, port));

			// 비블록킹 모드로 설정함
			socketChannel.configureBlocking(false);

			// 서버 소켓 채널을 셀렉터에 등록
			socketChannel.register(selector, SelectionKey.OP_READ);

		} catch (IOException e) {
			new WaveMsgDialogBox("서버연결 - ERROR", "initServer Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	/**
	 * 서버에 데이터 전송
	 * 
	 * @param data 전송할 데이터
	 */
	public int startWriter(String data) {
		SocketCtrl t = new SocketCtrl(socketChannel, data);
		t.start();
		
		return t.getRes();
	}

	/**
	 * 연결된 소켓을 통해 서버로부터 데이터를 읽음
	 */
	public void startReader() {
		try {
			while (socketConChk) {
				// 셀렉터의 select() 메소드로 준비된 이벤트가 있는지 확인함
				selector.select();

				// 셀렉터의 SelectedSet에 저장된 준비된 이벤트들 (SelectionKey 들)을
				Iterator it = selector.selectedKeys().iterator();
				
				while (it.hasNext()) {
					SelectionKey key = (SelectionKey) it.next();
					if (key.isReadable()) {
						// 이미 여결된 클라이언트가 메세지를 보낸 경우
						read(key);
					}
					// 이미 처리한 이벤트 이므로 반드시 삭제함
					it.remove();
				}

			}
		} catch (Exception e) {
			new WaveMsgDialogBox("서버연결 - ERROR", "startReader Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	/**
	 * 소켓 채널을 획득 <br>
	 * 획득한 채널에서 데이터를 읽음 <br>
	 * 
	 * @param key 셀렉터 키
	 */
	private void read(SelectionKey key) {
		
		// SelectionKey로 부터 소켓 채널을 얻어 옴
		SocketChannel sc = (SocketChannel) key.channel();
		
		// ByteBuffer를 생성함
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		
		int read = 0;

		try {
			// 요청한 클라이언트의 소켓 채널로 부터 데이터를 읽어 들임
			read = sc.read(buffer);
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
		} catch (CharacterCodingException e) {
			new WaveMsgDialogBox("서버연결 - ERROR", "read Error", JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Message - " + data);

		// 버퍼 메모리를 해제함
		clearBuffer(buffer);
	}

	private void clearBuffer(ByteBuffer buffer) {
		if (buffer != null) {
			buffer.clear();
			buffer = null;
		}
	}
	
	/**
	 * 소켓 채널(현재의 쓰레드)를 종료 처리 <br>
	 *  
	 */
	public void connectSocket() {
		// TODO : 소켓 채널을 종료하기 위한 로직 
		//        서버에 종료 요청
	}
	
	/**
	 * 연결 해제를 위한 세팅 <br>
	 * true : 연결 유지 <br>
	 * false : 연결 종료 <br>
	 * 
	 * @param socketConChk
	 */
	public void setSocketConChk(boolean socketConChk) {
		this.socketConChk = socketConChk;
	}

}
