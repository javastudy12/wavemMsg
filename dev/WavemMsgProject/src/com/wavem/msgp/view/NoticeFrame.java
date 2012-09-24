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

import com.wavem.msgp.main.WaveMsgFrame;

/**
 * 공지사항 화면 <br>
 * 
 * 긴급공지 : 자동팝업 <br>
 * 일반공지 : 알림표시 <br>
 * 
 * <pre>
 * 	NoticeFrame noticeFrame = new NoticeFrame();
 *  NoticeFrame.makeInitFrame(); // 실제 데이터를 호출하고 화면을 그리는 메서드
 * </pre>
 * 
 * @author
 * 
 */
public class NoticeFrame extends WaveMsgFrame {

	private static final long serialVersionUID = -3466883580966965039L;

	@Override
	public void makeInitFrame() {

	}

	@Override
	public void close() {

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
