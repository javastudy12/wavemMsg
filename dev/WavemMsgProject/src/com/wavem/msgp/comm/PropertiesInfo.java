/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : PropertiesInfo.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.comm;

import java.io.Serializable;

/** 
 * 환경설정 로컬 저장 클래스 <br>
 * 
 * <pre>
 * 	PropertiesInfo properties = PropertiesInfo.getInstance();
 * </pre>
 * @author 
 *
 */
public class PropertiesInfo implements Serializable {
	
	private static final long serialVersionUID = -6484416053755315109L;
	
	/** 쪽지 자동팝업 설정 */
	private boolean msgAutoPopUpFlag = true;
	
	/** 자동 부재중 설정 */
	private boolean autoStatusChangeFlag = true;
	
	/** 자동 부재중 설정시 동작 시간 (분) */
	private int autoStatusChangeLimite = 5;
	
	/** 더블 클릭 시 설정 (채팅, 쪽지) */
	private String doubleClickOperate = "";
	
	/** 파일 다운로드 기본 경로 */
	private String fileDownPath = "";
	
	/** 채팅 대화 내역 저장 설정 */
	private boolean chatSaveFlag = false;
	
	/** 대화 저장 경로 */
	private String chatSavePath = "";
	
	/** 테마 설정 (기본배경, 사용자설정) */
	private boolean themeFlag = false;
	
	/** 배경 이미지 이름 */
	private String themeName = "";
	
	/** 배경 이미지 경로 */
	private String themePath = "";
	
	/** 폰트 */
	private String font = "";
	
	/** 색상 */
	private String color = "";
	
	/** 알림음 설정 */
	private boolean arlamFlag = true;
	
	/** 알림음 경로 */
	private String arlamPath = "";
	
	/** 채팅, 쪽지 배경 설정 (기본배경, 사용자설정) */
	private boolean chatBackgroundFlag = false;
	
	/** 채팅, 쪽지 배경 이미지 이름 */
	private String chatBackgroundName = "";
	
	/** 채팅, 쪽지 배경 이미지 경로 */
	private String chatBackgroundPath = "";

	/** 로그인 시 사용자 ID 저장 여부 */
	private boolean idSaveChk = true;
	
	/** 로그인시 저장된 사용자 ID */
	private String loginUserId = "";
	
	/** 환경설정 인스턴스 */
	private static PropertiesInfo properties = null;
    
	/**	
	 * 환경설정 PropertiesInfo 생성자 <br>
	 * 최초 환경설정 로드 <br>
	 * 외부에서 PropertiesInfo클래스 생성 막음 <br>
	 */
	private PropertiesInfo() {
		loadPropertiesFile();
	}

	/**
	 * PropertiesInfo 인스턴스 생성 및 반환
	 * 
	 * @return 기존 혹은 생성된 메일 화면 인스턴스
	 */
	public static PropertiesInfo getInstance() {
		if (properties == null) {
			synchronized (PropertiesInfo.class) {
				if (properties == null) {
					properties = new PropertiesInfo();
				}
			}
		}

		return properties;
	}
	
	/**
	 * 환경설정 로드 (로컬)
	 * 
	 * @return 로드 성공 여부
	 */
	public int loadPropertiesFile() {
		return 0;
	}
	
	/**
	 * 환경설정 저장 (로컬)
	 * 
	 * @return 저장 설정 여부
	 */
	public int savePropertiesFile() {
		return 0;
	}
	
	/**
	 * 쪽지 자동팝업 설정 반환
	 * 
	 * @return 쪽지 자동팝업 설정값
	 */
	public boolean isMsgAutoPopUpFlag() {
		return msgAutoPopUpFlag;
	}

	/**
	 * 쪽지 자동팝업 설정 저장 
	 * 
	 * @param msgAutoPopUpFlag 쪽지 자동팝업 설정값
	 */
	public void setMsgAutoPopUpFlag(boolean msgAutoPopUpFlag) {
		this.msgAutoPopUpFlag = msgAutoPopUpFlag;
	}

	/**
	 * 자동 부재중 설정 반환
	 * 
	 * @return 자동 부재중 설정값
	 */
	public boolean isAutoStatusChangeFlag() {
		return autoStatusChangeFlag;
	}

	/**
	 * 자동 부재중 설정 저장
	 * 
	 * @param autoStatusChangeFlag 자동 부재중 설정값
	 */
	public void setAutoStatusChangeFlag(boolean autoStatusChangeFlag) {
		this.autoStatusChangeFlag = autoStatusChangeFlag;
	}

	/**
	 * 자동 부재중 설정시 동작 시간 반환 (분)
	 * 
	 * @return 자동 부재중 설정시 동작 시간
	 */
	public int getAutoStatusChangeLimite() {
		return autoStatusChangeLimite;
	}

	/**
	 * 자동 부재중 설정시 동작 시간 저장 (분)
	 * 
	 * @param autoStatusChangeLimite 자동 부재중 설정시 동작 시간
	 */
	public void setAutoStatusChangeLimite(int autoStatusChangeLimite) {
		this.autoStatusChangeLimite = autoStatusChangeLimite;
	}

	/**
	 * 더블 클릭 시 설정 (채팅, 쪽지) 반한
	 * 
	 * @return 더블 클릭 시 설정값 (채팅, 쪽지)
	 */
	public String getDoubleClickOperate() {
		return doubleClickOperate;
	}

	/**
	 * 더블 클릭 시 설정 (채팅, 쪽지) 저장
	 * 
	 * @param doubleClickOperate 더블 클릭 시 설정값 (채팅, 쪽지)
	 */
	public void setDoubleClickOperate(String doubleClickOperate) {
		this.doubleClickOperate = doubleClickOperate;
	}

	/**
	 * 파일 다운로드 기본 경로 반환
	 * 
	 * @return 파일 다운로드 기본 경로
	 */
	public String getFileDownPath() {
		return fileDownPath;
	}

	/**
	 * 파일 다운로드 기본 경로 저장
	 * 
	 * @param fileDownPath 파일 다운로드 기본 경로
	 */
	public void setFileDownPath(String fileDownPath) {
		this.fileDownPath = fileDownPath;
	}

	/**
	 * 채팅 대화 내역 저장 설정 반환
	 * 
	 * @return 채팅 대화 내역 저장 설정값
	 */
	public boolean isChatSaveFlag() {
		return chatSaveFlag;
	}

	/**
	 * 채팅 대화 내역 저장 설정 저장
	 * 
	 * @param chatSaveFlag 채팅 대화 내역 저장 설정값
	 */
	public void setChatSaveFlag(boolean chatSaveFlag) {
		this.chatSaveFlag = chatSaveFlag;
	}

	/**
	 * 대화 저장 경로 반환
	 * 
	 * @return 대화 저장 경로
	 */
	public String getChatSavePath() {
		
		// 만약 다른 에러및 버그로 인해 저장경로에 문제가 생겼을 경우
		if (chatSavePath == null || chatSavePath.trim().equals("")) {
			chatSavePath = "C:\\";
		}
		
		return chatSavePath;
	}

	/**
	 * 대화 저장 경로 저장
	 * 
	 * @param chatSavePath 대화 저장 경로
	 */
	public void setChatSavePath(String chatSavePath) {
		this.chatSavePath = chatSavePath;
	}

	/**
	 * 테마 설정 (기본배경, 사용자설정) 반환 <br>
	 * true  : 기본배경 <br>
	 * false : 사용자설정 <br>
	 * 
	 * @return 테마 설정 (기본배경, 사용자설정)
	 */
	public boolean isThemeFlag() {
		return themeFlag;
	}

	/**
	 * 테마 설정 (기본배경, 사용자설정) 저장 <br>
	 * true  : 기본배경 <br>
	 * false : 사용자설정 <br> 
	 * 
	 * @param themeFlag 테마 설정 (기본배경, 사용자설정)
	 */
	public void setThemeFlag(boolean themeFlag) {
		this.themeFlag = themeFlag;
	}

	/**
	 * 배경 이미지 이름 반환
	 * 
	 * @return 배경 이미지 이름
	 */
	public String getThemeName() {
		return themeName;
	}

	/**
	 * 배경 이미지 이름 저장
	 * 
	 * @param themeName 배경 이미지 이름
	 */
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	/**
	 * 배경 이미지 경로 반환
	 * 
	 * @return 배경 이미지 경로
	 */
	public String getThemePath() {
		return themePath;
	}

	/**
	 * 배경 이미지 경로 저장
	 * 
	 * @param themePath 배경 이미지 경로
	 */
	public void setThemePath(String themePath) {
		this.themePath = themePath;
	}

	/**
	 * 폰트 반환
	 * 
	 * @return 폰트
	 */
	public String getFont() {
		return font;
	}

	/**
	 * 폰트 저장
	 * 
	 * @param font 폰트
	 */
	public void setFont(String font) {
		this.font = font;
	}

	/** 
	 * 색상 반환
	 * 
	 * @return 색상
	 */
	public String getColor() {
		return color;
	}

	/**
	 * 색상 저장
	 * 
	 * @param color 색상
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * 알림음 설정 반환
	 * 
	 * @return 알림음 설정
	 */
	public boolean isArlamFlag() {
		return arlamFlag;
	}

	/**
	 * 알림음 설정 저장
	 * 
	 * @param arlamFlag 알림음 설정
	 */
	public void setArlamFlag(boolean arlamFlag) {
		this.arlamFlag = arlamFlag;
	}

	/**
	 * 알림음 경로 반한
	 * 
	 * @return 알림음 경로
	 */
	public String getArlamPath() {
		return arlamPath;
	}

	/**
	 * 알림음 경로 저장
	 * 
	 * @param arlamPath 알림음 경로
	 */
	public void setArlamPath(String arlamPath) {
		this.arlamPath = arlamPath;
	}

	/**
	 * 채팅, 쪽지 배경 설정 (기본배경, 사용자설정) 반환 <br>
	 * true  : 기본배경 <br>
	 * false : 사용자설정 <br>
	 * 
	 * @return 채팅, 쪽지 배경 설정 (기본배경, 사용자설정)
	 */
	public boolean isChatBackgroundFlag() {
		return chatBackgroundFlag;
	}

	/**
	 * 채팅, 쪽지 배경 설정 (기본배경, 사용자설정) 저장 <br>
	 * true  : 기본배경 <br>
	 * false : 사용자설정 <br>
	 * 
	 * @param chatBackgroundFlag 채팅, 쪽지 배경 설정 (기본배경, 사용자설정)
	 */
	public void setChatBackgroundFlag(boolean chatBackgroundFlag) {
		this.chatBackgroundFlag = chatBackgroundFlag;
	}

	/**
	 * 채팅, 쪽지 배경 이미지 이름 반환
	 * 
	 * @return 채팅, 쪽지 배경 이미지 이름
	 */
	public String getChatBackgroundName() {
		return chatBackgroundName;
	}

	/**
	 * 채팅, 쪽지 배경 이미지 이름 저장
	 * 
	 * @param chatBackgroundName 채팅, 쪽지 배경 이미지 이름
	 */
	public void setChatBackgroundName(String chatBackgroundName) {
		this.chatBackgroundName = chatBackgroundName;
	}

	/**
	 * 채팅, 쪽지 배경 이미지 경로 반환
	 * 
	 * @return 채팅, 쪽지 배경 이미지 경로
	 */
	public String getChatBackgroundPath() {
		return chatBackgroundPath;
	}

	/**
	 * 채팅, 쪽지 배경 이미지 경로 저장
	 * 
	 * @param chatBackgroundPath 채팅, 쪽지 배경 이미지 경로
	 */
	public void setChatBackgroundPath(String chatBackgroundPath) {
		this.chatBackgroundPath = chatBackgroundPath;
	}

	/**
	 * 로그인 시 ID 저장 여부 반환
	 * @return 저장 여부
	 */
	public boolean isIdSaveChk() {
		return idSaveChk;
	}

	/**
	 * 로그인 시 ID 저장 여부 저장
	 * @param idSaveChk 저장 여부
	 */
	public void setIdSaveChk(boolean idSaveChk) {
		this.idSaveChk = idSaveChk;
	}

	/**
	 * 저장된 사용자 ID 반환
	 * 
	 * @return 사용자 ID
	 */
	public String getLoginUserId() {
		return loginUserId;
	}

	/**
	 * 사용자 ID 저장
	 * 
	 * @param loginUserId 사용자 ID
	 */
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

}
