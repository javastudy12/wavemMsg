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
 * 환경설정 로컬 저장 클래스
 * 
 * @author 
 *
 */
public class PropertiesInfo implements Serializable {
	
	private static final long serialVersionUID = -6484416053755315109L;
	
	private boolean msgAutoPopUpFlag = true;
	private boolean autoStatusChangeFlag = true;
	private int autoStatusChangeLimite = 5;
	private String doubleClickOperate = "";
	private String fileDownPath = "";
	private boolean chatSaveFlag = false;
	private String chatSavePath = "";
	private boolean themeFlag = false;
	private String themeName = "";
	private String themePath = "";
	private String font = "";
	private String color = "";
	private boolean arlamFlag = true;
	private String arlamPath = "";
	private int chatBackgroundFlag = 0;
	private String chatBackgroundName = "";
	private String chatBackgroundPath = "";

	
	/** 환경설정 인스턴스 */
	private static PropertiesInfo properties = null;
    
	/**	
	 * 환경설정 PropertiesInfo 생성자 <br>
	 * 최초 환경설정 로드
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
	
	public int loadPropertiesFile() {
		return 0;
	}
	
	public int savePropertiesFile() {
		return 0;
	}
	
	public boolean isMsgAutoPopUpFlag() {
		return msgAutoPopUpFlag;
	}

	public void setMsgAutoPopUpFlag(boolean msgAutoPopUpFlag) {
		this.msgAutoPopUpFlag = msgAutoPopUpFlag;
	}

	public boolean isAutoStatusChangeFlag() {
		return autoStatusChangeFlag;
	}

	public void setAutoStatusChangeFlag(boolean autoStatusChangeFlag) {
		this.autoStatusChangeFlag = autoStatusChangeFlag;
	}

	public int getAutoStatusChangeLimite() {
		return autoStatusChangeLimite;
	}

	public void setAutoStatusChangeLimite(int autoStatusChangeLimite) {
		this.autoStatusChangeLimite = autoStatusChangeLimite;
	}

	public String getDoubleClickOperate() {
		return doubleClickOperate;
	}

	public void setDoubleClickOperate(String doubleClickOperate) {
		this.doubleClickOperate = doubleClickOperate;
	}

	public String getFileDownPath() {
		return fileDownPath;
	}

	public void setFileDownPath(String fileDownPath) {
		this.fileDownPath = fileDownPath;
	}

	public boolean isChatSaveFlag() {
		return chatSaveFlag;
	}

	public void setChatSaveFlag(boolean chatSaveFlag) {
		this.chatSaveFlag = chatSaveFlag;
	}

	public String getChatSavePath() {
		return chatSavePath;
	}

	public void setChatSavePath(String chatSavePath) {
		this.chatSavePath = chatSavePath;
	}

	public boolean isThemeFlag() {
		return themeFlag;
	}

	public void setThemeFlag(boolean themeFlag) {
		this.themeFlag = themeFlag;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getThemePath() {
		return themePath;
	}

	public void setThemePath(String themePath) {
		this.themePath = themePath;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isArlamFlag() {
		return arlamFlag;
	}

	public void setArlamFlag(boolean arlamFlag) {
		this.arlamFlag = arlamFlag;
	}

	public String getArlamPath() {
		return arlamPath;
	}

	public void setArlamPath(String arlamPath) {
		this.arlamPath = arlamPath;
	}

	public int isChatBackgroundFlag() {
		return chatBackgroundFlag;
	}

	public void setChatBackgroundFlag(int chatBackgroundFlag) {
		this.chatBackgroundFlag = chatBackgroundFlag;
	}

	public String getChatBackgroundName() {
		return chatBackgroundName;
	}

	public void setChatBackgroundName(String chatBackgroundName) {
		this.chatBackgroundName = chatBackgroundName;
	}

	public String getChatBackgroundPath() {
		return chatBackgroundPath;
	}

	public void setChatBackgroundPath(String chatBackgroundPath) {
		this.chatBackgroundPath = chatBackgroundPath;
	}

}
