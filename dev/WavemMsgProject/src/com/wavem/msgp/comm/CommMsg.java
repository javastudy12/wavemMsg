/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : CommMsg.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.comm;

/**
 * 공통 메시지
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 */
public class CommMsg {

	/* **************************************************************************************************
	 * 메시지창 관련
	 * **************************************************************************************************/
	/** 저장 물음 메시지  */
	public static final String SAVE_Q_MSG = "저장하시겠습니까?";
	
	/** 저장 완료 메시지 */
	public static final String SAVE_MSG = "저장되었습니다.";
	
	/** 저장 미완료 메시지 */
	public static final String NOT_SAVE_MSG = "저장할 수 없습니다.";
	
	/** 수정 물음 메시지 */
	public static final String MODIFY_Q_MSG = "수정하시겠습니까?";
	
	/** 수정 완료 메시지 */
	public static final String MODIFY_MSG = "수정되었습니다.";
	
	/** 수정 미완료 메시지 */
	public static final String NOT_MODIFY_MSG = "수정할 수 없습니다.";
	
	/** 삭제 물음 메시지 */
	public static final String DELETE_Q_MSG = "삭제하시겠습니까?";
	
	/** 삭제 완료 메시지 */
	public static final String DELETE_MSG = "삭제되었습니다.";
	
	/** 삭제 미완료 메시지 */
	public static final String NOT_DELETE_MSG = "삭제할 수 없습니다.";
	
	/** 로그아웃 메시지 */
	public static final String LOGOUT_Q_MSG = "정말로 로그아웃 하시겠습니까?";
	
	/** 채팅방 나가기 메시지 */
	public static final String OUTCHAT_Q_MSG = "정말로 나가시겠습니까?";
	
	
	
	
	
	/* **************************************************************************************************
	 * 에러 메시지 관련
	 * **************************************************************************************************/
	/** 화면 로딩 에러 메시지 */
	public static final String LOAD_FRAME_ERROR = "화면을 불러올 수 없습니다.";
	
	/** 이미지 설정 중 선택한 이미지가 없는 경우 */
	public static final String NOT_EXSIST_IMG = "선택한 이미지가 없습니다.";
	
	/** 환경 설정 에러 */
	public static final String PROPERTY_SAVE_ERROR = "환경 설정을 저장할 수 없습니다.";
	
	
	
	
	
	
	/* **************************************************************************************************
	 * 경고 메시지 관련
	 * **************************************************************************************************/
	/** ID 입력 경고 */
	public static final String ID_NOT_NULL_WARNING = "ID를 입력하세요";
	
	/** 비밀번호 입력 경고 */
	public static final String PW_NOT_NULL_WARNING = "비밀번호를 입력하세요";
	
	
	
	
	
	
	/* **************************************************************************************************
	 * 타이틀 관련
	 * **************************************************************************************************/
	/** 폰트 설정 타이틀 */
	public static final String FONT_FRAME_TITLE = "폰트 설정";
	
	/** 색상 설정 타이틀 */
	public static final String COLOR_FRAME_TITLE = "색상 설정";
	
	/** 환경 설정 타이틀 */
	public static final String PROPERTY_FRAME_TITLE = "환경 설정";
	
	/** 프로필 설정 타이틀 */
	public static final String PROFILE_FRAME_TITLE = "프로필 설정";
	
	/** 공지사항 타이틀 */
	public static final String NOTICE_FRAME_TITLE = "공지사항";
	
	/** 웨이브엠 메신저 메인 타이틀 */
	public static final String MSGMAIN_FRAME_TITLE = "웨이브엠 메신저";
	
	/** 받은 쪽지 타이틀 */
	public static final String RMSG_FRAME_TITLE = "받은 쪽지";
	
	/** 쪽지 쓰기 타이틀 */
	public static final String WMSG_FRAME_TITLE = "쪽지 쓰기";
	
	/** 쪽지 내역 타이틀 */
	public static final String MSG_HISTORY_FRAME_TITLE = "쪽지 내역";
	
	/** 로그인 타이틀 */
	public static final String LOGIN_FRAME_TITLE = "로그인";
	
	/** 로그인 비밀번호 변경 타이틀 */
	public static final String REG_PW_FRAME_TITLE = "최초 비밀번호 등록";
	
	/** 초대 타이틀 */
	public static final String INVITE_FRAME_TITLE = "초대";
	
	/** 그룹 설정 타이틀 */
	public static final String GROUP_FRAME_TITLE = "그룹 설정";
	
	/** 파일 보내기 타이틀 */
	public static final String FILE_UP_FRAME_TITLE = "파일 보내기";
	
	/** 파일 받기 타이틀 */
	public static final String FILE_DOWN_FRAME_TITLE = "파일 받기";
	
	/** 파일 내역 타이틀 */
	public static final String FILE_HISTORY_FRAME_TITLE = "파일 내역";
	
	/** 채팅 타이틀 */
	public static final String CHAT_FRAME_TITLE = "채팅";
	
	/** 채팅 내역 상세 타이틀 */
	public static final String CHAT_DETAIL_FRAME_TITLE = "채팅 상세보기";
	
	/** 채팅 내역 타이틀 */
	public static final String CHAT_HISTORY_FRAME_TITLE = "채팅 내역";
	
	/** 배경 설정 타이틀 */
	public static final String BACKGROUND_FRAME_TITLE = "배경 설정";
	
	/** 로그아웃 타이틀 */
	public static final String LOGOUT_TITLE = "로그아웃";
	
	
}
