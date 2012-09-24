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
 * ȯ�漳�� ���� ���� Ŭ���� <br>
 * 
 * <pre>
 * 	PropertiesInfo properties = PropertiesInfo.getInstance();
 * </pre>
 * @author 
 *
 */
public class PropertiesInfo implements Serializable {
	
	private static final long serialVersionUID = -6484416053755315109L;
	
	/** ���� �ڵ��˾� ���� */
	private boolean msgAutoPopUpFlag = true;
	
	/** �ڵ� ������ ���� */
	private boolean autoStatusChangeFlag = true;
	
	/** �ڵ� ������ ������ ���� �ð� (��) */
	private int autoStatusChangeLimite = 5;
	
	/** ���� Ŭ�� �� ���� (ä��, ����) */
	private String doubleClickOperate = "";
	
	/** ���� �ٿ�ε� �⺻ ��� */
	private String fileDownPath = "";
	
	/** ä�� ��ȭ ���� ���� ���� */
	private boolean chatSaveFlag = false;
	
	/** ��ȭ ���� ��� */
	private String chatSavePath = "";
	
	/** �׸� ���� (�⺻���, ����ڼ���) */
	private boolean themeFlag = false;
	
	/** ��� �̹��� �̸� */
	private String themeName = "";
	
	/** ��� �̹��� ��� */
	private String themePath = "";
	
	/** ��Ʈ */
	private String font = "";
	
	/** ���� */
	private String color = "";
	
	/** �˸��� ���� */
	private boolean arlamFlag = true;
	
	/** �˸��� ��� */
	private String arlamPath = "";
	
	/** ä��, ���� ��� ���� (�⺻���, ����ڼ���) */
	private boolean chatBackgroundFlag = false;
	
	/** ä��, ���� ��� �̹��� �̸� */
	private String chatBackgroundName = "";
	
	/** ä��, ���� ��� �̹��� ��� */
	private String chatBackgroundPath = "";

	
	/** ȯ�漳�� �ν��Ͻ� */
	private static PropertiesInfo properties = null;
    
	/**	
	 * ȯ�漳�� PropertiesInfo ������ <br>
	 * ���� ȯ�漳�� �ε� <br>
	 * �ܺο��� PropertiesInfoŬ���� ���� ���� <br>
	 */
	private PropertiesInfo() {
		loadPropertiesFile();
	}

	/**
	 * PropertiesInfo �ν��Ͻ� ���� �� ��ȯ
	 * 
	 * @return ���� Ȥ�� ������ ���� ȭ�� �ν��Ͻ�
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
	 * ȯ�漳�� �ε� (����)
	 * 
	 * @return �ε� ���� ����
	 */
	public int loadPropertiesFile() {
		return 0;
	}
	
	/**
	 * ȯ�漳�� ���� (����)
	 * 
	 * @return ���� ���� ����
	 */
	public int savePropertiesFile() {
		return 0;
	}
	
	/**
	 * ���� �ڵ��˾� ���� ��ȯ
	 * 
	 * @return ���� �ڵ��˾� ������
	 */
	public boolean isMsgAutoPopUpFlag() {
		return msgAutoPopUpFlag;
	}

	/**
	 * ���� �ڵ��˾� ���� ���� 
	 * 
	 * @param msgAutoPopUpFlag ���� �ڵ��˾� ������
	 */
	public void setMsgAutoPopUpFlag(boolean msgAutoPopUpFlag) {
		this.msgAutoPopUpFlag = msgAutoPopUpFlag;
	}

	/**
	 * �ڵ� ������ ���� ��ȯ
	 * 
	 * @return �ڵ� ������ ������
	 */
	public boolean isAutoStatusChangeFlag() {
		return autoStatusChangeFlag;
	}

	/**
	 * �ڵ� ������ ���� ����
	 * 
	 * @param autoStatusChangeFlag �ڵ� ������ ������
	 */
	public void setAutoStatusChangeFlag(boolean autoStatusChangeFlag) {
		this.autoStatusChangeFlag = autoStatusChangeFlag;
	}

	/**
	 * �ڵ� ������ ������ ���� �ð� ��ȯ (��)
	 * 
	 * @return �ڵ� ������ ������ ���� �ð�
	 */
	public int getAutoStatusChangeLimite() {
		return autoStatusChangeLimite;
	}

	/**
	 * �ڵ� ������ ������ ���� �ð� ���� (��)
	 * 
	 * @param autoStatusChangeLimite �ڵ� ������ ������ ���� �ð�
	 */
	public void setAutoStatusChangeLimite(int autoStatusChangeLimite) {
		this.autoStatusChangeLimite = autoStatusChangeLimite;
	}

	/**
	 * ���� Ŭ�� �� ���� (ä��, ����) ����
	 * 
	 * @return ���� Ŭ�� �� ������ (ä��, ����)
	 */
	public String getDoubleClickOperate() {
		return doubleClickOperate;
	}

	/**
	 * ���� Ŭ�� �� ���� (ä��, ����) ����
	 * 
	 * @param doubleClickOperate ���� Ŭ�� �� ������ (ä��, ����)
	 */
	public void setDoubleClickOperate(String doubleClickOperate) {
		this.doubleClickOperate = doubleClickOperate;
	}

	/**
	 * ���� �ٿ�ε� �⺻ ��� ��ȯ
	 * 
	 * @return ���� �ٿ�ε� �⺻ ���
	 */
	public String getFileDownPath() {
		return fileDownPath;
	}

	/**
	 * ���� �ٿ�ε� �⺻ ��� ����
	 * 
	 * @param fileDownPath ���� �ٿ�ε� �⺻ ���
	 */
	public void setFileDownPath(String fileDownPath) {
		this.fileDownPath = fileDownPath;
	}

	/**
	 * ä�� ��ȭ ���� ���� ���� ��ȯ
	 * 
	 * @return ä�� ��ȭ ���� ���� ������
	 */
	public boolean isChatSaveFlag() {
		return chatSaveFlag;
	}

	/**
	 * ä�� ��ȭ ���� ���� ���� ����
	 * 
	 * @param chatSaveFlag ä�� ��ȭ ���� ���� ������
	 */
	public void setChatSaveFlag(boolean chatSaveFlag) {
		this.chatSaveFlag = chatSaveFlag;
	}

	/**
	 * ��ȭ ���� ��� ��ȯ
	 * 
	 * @return ��ȭ ���� ���
	 */
	public String getChatSavePath() {
		return chatSavePath;
	}

	/**
	 * ��ȭ ���� ��� ����
	 * 
	 * @param chatSavePath ��ȭ ���� ���
	 */
	public void setChatSavePath(String chatSavePath) {
		this.chatSavePath = chatSavePath;
	}

	/**
	 * �׸� ���� (�⺻���, ����ڼ���) ��ȯ <br>
	 * true  : �⺻��� <br>
	 * false : ����ڼ��� <br>
	 * 
	 * @return �׸� ���� (�⺻���, ����ڼ���)
	 */
	public boolean isThemeFlag() {
		return themeFlag;
	}

	/**
	 * �׸� ���� (�⺻���, ����ڼ���) ���� <br>
	 * true  : �⺻��� <br>
	 * false : ����ڼ��� <br> 
	 * 
	 * @param themeFlag �׸� ���� (�⺻���, ����ڼ���)
	 */
	public void setThemeFlag(boolean themeFlag) {
		this.themeFlag = themeFlag;
	}

	/**
	 * ��� �̹��� �̸� ��ȯ
	 * 
	 * @return ��� �̹��� �̸�
	 */
	public String getThemeName() {
		return themeName;
	}

	/**
	 * ��� �̹��� �̸� ����
	 * 
	 * @param themeName ��� �̹��� �̸�
	 */
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	/**
	 * ��� �̹��� ��� ��ȯ
	 * 
	 * @return ��� �̹��� ���
	 */
	public String getThemePath() {
		return themePath;
	}

	/**
	 * ��� �̹��� ��� ����
	 * 
	 * @param themePath ��� �̹��� ���
	 */
	public void setThemePath(String themePath) {
		this.themePath = themePath;
	}

	/**
	 * ��Ʈ ��ȯ
	 * 
	 * @return ��Ʈ
	 */
	public String getFont() {
		return font;
	}

	/**
	 * ��Ʈ ����
	 * 
	 * @param font ��Ʈ
	 */
	public void setFont(String font) {
		this.font = font;
	}

	/** 
	 * ���� ��ȯ
	 * 
	 * @return ����
	 */
	public String getColor() {
		return color;
	}

	/**
	 * ���� ����
	 * 
	 * @param color ����
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * �˸��� ���� ��ȯ
	 * 
	 * @return �˸��� ����
	 */
	public boolean isArlamFlag() {
		return arlamFlag;
	}

	/**
	 * �˸��� ���� ����
	 * 
	 * @param arlamFlag �˸��� ����
	 */
	public void setArlamFlag(boolean arlamFlag) {
		this.arlamFlag = arlamFlag;
	}

	/**
	 * �˸��� ��� ����
	 * 
	 * @return �˸��� ���
	 */
	public String getArlamPath() {
		return arlamPath;
	}

	/**
	 * �˸��� ��� ����
	 * 
	 * @param arlamPath �˸��� ���
	 */
	public void setArlamPath(String arlamPath) {
		this.arlamPath = arlamPath;
	}

	/**
	 * ä��, ���� ��� ���� (�⺻���, ����ڼ���) ��ȯ <br>
	 * true  : �⺻��� <br>
	 * false : ����ڼ��� <br>
	 * 
	 * @return ä��, ���� ��� ���� (�⺻���, ����ڼ���)
	 */
	public boolean isChatBackgroundFlag() {
		return chatBackgroundFlag;
	}

	/**
	 * ä��, ���� ��� ���� (�⺻���, ����ڼ���) ���� <br>
	 * true  : �⺻��� <br>
	 * false : ����ڼ��� <br>
	 * 
	 * @param chatBackgroundFlag ä��, ���� ��� ���� (�⺻���, ����ڼ���)
	 */
	public void setChatBackgroundFlag(boolean chatBackgroundFlag) {
		this.chatBackgroundFlag = chatBackgroundFlag;
	}

	/**
	 * ä��, ���� ��� �̹��� �̸� ��ȯ
	 * 
	 * @return ä��, ���� ��� �̹��� �̸�
	 */
	public String getChatBackgroundName() {
		return chatBackgroundName;
	}

	/**
	 * ä��, ���� ��� �̹��� �̸� ����
	 * 
	 * @param chatBackgroundName ä��, ���� ��� �̹��� �̸�
	 */
	public void setChatBackgroundName(String chatBackgroundName) {
		this.chatBackgroundName = chatBackgroundName;
	}

	/**
	 * ä��, ���� ��� �̹��� ��� ��ȯ
	 * 
	 * @return ä��, ���� ��� �̹��� ���
	 */
	public String getChatBackgroundPath() {
		return chatBackgroundPath;
	}

	/**
	 * ä��, ���� ��� �̹��� ��� ����
	 * 
	 * @param chatBackgroundPath ä��, ���� ��� �̹��� ���
	 */
	public void setChatBackgroundPath(String chatBackgroundPath) {
		this.chatBackgroundPath = chatBackgroundPath;
	}

}
