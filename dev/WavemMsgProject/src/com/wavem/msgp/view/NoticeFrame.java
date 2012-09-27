/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : NoticeFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import com.wavem.msgp.component.WaveMsgFrame;

/**
 * 공지사항 화면 <br>
 * 
 * 긴급공지 : 자동팝업 (추후) <br>
 * 일반공지 : 알림표시 (추후) <br>
 * 
 * <pre>
 * 	NoticeFrame noticeFrame = new NoticeFrame();
 * </pre>
 * 
 * @author
 * 
 */
public class NoticeFrame extends WaveMsgFrame {

	private static final long serialVersionUID = -3466883580966965039L;

	/** 공지사항 화면 인스턴스 변수 */
	private static NoticeFrame frame = null;
	
	/**
	 * 공지사항 화면 생성자 <br>
	 * 최초 makeInitFrame() 호출 <br>
	 */
	private NoticeFrame() {
		makeInitFrame();
	}
	
	/**
	 * 공지사항 화면을 위한 인스턴스 반환
	 * 
	 * @return 공지사항 화면을 위한 화면 인스턴스
	 */
	public static NoticeFrame getInstance() {
		
		if (frame == null) {
			synchronized (NoticeFrame.class) {
				if (frame == null) {
					frame = new NoticeFrame();
				}
			}
		}
		
		return frame;
	}
	
	@Override
	public void makeInitFrame() {
		getContentPane().setLayout(null);
	}

	@Override
	public void close() {
		this.dispose();
	}

	/**
	 * 공지사항 게시 리스트 호출
	 */
	public void invokeNoticeList() {

	}

	/**
	 * 공지사항 작성 <br>
	 * 관리자 권한 필요 <br>
	 * 일반 사용자는 관리자의 승인하에 작성 가능 <br>
	 */
	public void writeNotice() {

	}

	/**
	 * 공지사항 저장
	 */
	public void saveNotice() {

	}
}
