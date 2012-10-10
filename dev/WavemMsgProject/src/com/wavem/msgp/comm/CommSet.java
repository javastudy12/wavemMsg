/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : CommSet.java
 * Date       : 2012.10.09
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.comm;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * 공통
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class CommSet {

	/** 버튼 이미지 경로 */
	private static String buttonImgPath = "/com/wavem/resource/img/button/";
	
	/** 프로필 기본 제공 이미지 경로 */
	private static String profileImgPath = "/com/wavem/resource/img/profile/";
	
	/** 패널 적용 이미지 경로 */
	private static String paneImgPath = "/com/wavem/resource/img/pane/";
	
	
	private static String chatBackImgPath = "/com/wavem/resource/img/chatback/";
	
	/**
	 * 현재 클래스 패스 내에 있는 이미지를 ImageIcon 인스턴스로 반환
	 * 
	 * @param imgNm 존재하는 이미지의 이름
	 * @return 해당하는 이미지로 생성한 ImageIcon 인스턴스
	 */
	public static ImageIcon getButtonImgIcon(String imgNm) {
		return new ImageIcon(getOriButtonImgPath(imgNm));
	}
	
	/**
	 * 버튼 이미지의 패키지 경로
	 * 
	 * @return 경로
	 */
	public static String getButtonImgPath() {
		return buttonImgPath;
	}
	
	/**
	 * 클래스 패스 내에 있는 이미지의 실제 경로 반환
	 * 
	 * @return 실제 경로
	 */
	public static String  getOriButtonImgPath() {
		return CommSet.class.getResource(buttonImgPath).getPath();
	}
	
	/**
	 * 클래스 패스 내에 있는 이미지의 실제 경로 반환 <br>
	 * 이미지 이름에 확장자를 입력하지 않을 경우 자동을 png확장자를 찾는다. <br>
	 * 
	 * @param imgNm 존재하는 이미지의 이름
	 * @return 실제 경로
	 */
	public static String  getOriButtonImgPath(String imgNm) {
		
		int ex = imgNm.indexOf(".");
		
		if (ex > 0) {
			return CommSet.class.getResource(buttonImgPath + imgNm).getPath();
		}
		
		return CommSet.class.getResource(buttonImgPath + imgNm +".png").getPath();
	}
	
	/**
	 * 기본적으로 제공하는 프로필 이미지의 패키지 경로
	 * 
	 * @return 경로
	 */
	public static String getProfileImgPath() {
		return profileImgPath;
	}
	
	/**
	 * 클래스 패스 내에 있는 이미지의 실제 경로 반환
	 * 
	 * @return 실제 경로
	 */
	public static String  getOriProfileImgPath() {
		return CommSet.class.getResource(profileImgPath).getPath();
	}
	
	/**
	 * 클래스 패스 내에 있는 이미지의 실제 경로 반환 <br>
	 * 이미지 이름에 확장자를 입력하지 않을 경우 자동을 png확장자를 찾는다. <br>
	 * 
	 * @param imgNm 존재하는 이미지의 이름
	 * @return 실제 경로
	 */
	public static String  getOriProfileImgPath(String imgNm) {
		
		int ex = imgNm.indexOf(".");
		
		if (ex > 0) { // 이미지 이름에 확장자가 있는 경우
			return CommSet.class.getResource(profileImgPath + imgNm).getPath();
		}
		
		return CommSet.class.getResource(profileImgPath + imgNm+".png").getPath();
	}
	
	
	
	
	
	/**
	 * 화면 디자인을 위한 패널 적용 이미지 패키지 경로
	 * 
	 * @return 경로
	 */
	public static String getPaneImgPath() {
		return paneImgPath;
	}
	
	/**
	 * 클래스 패스 내에 있는 이미지의 실제 경로 반환
	 * 
	 * @return 실제 경로
	 */
	public static String  getOriPaneImgPath() {
		return CommSet.class.getResource(paneImgPath).getPath();
	}
	
	/**
	 * 클래스 패스 내에 있는 이미지의 실제 경로 반환 <br>
	 * 이미지 이름에 확장자를 입력하지 않을 경우 자동을 png확장자를 찾는다. <br>
	 * 
	 * @param imgNm 존재하는 이미지의 이름
	 * @return 실제 경로
	 */
	public static String  getOriPaneImgPath(String imgNm) {
		
		int ex = imgNm.indexOf(".");
		
		if (ex > 0) { // 이미지 이름에 확장자가 있는 경우
			return CommSet.class.getResource(paneImgPath + imgNm).getPath();
		}
		
		return CommSet.class.getResource(paneImgPath + imgNm + ".png").getPath();
	}
	
	/**
	 * 패널에 적용하기 위한 이미지 인스턴스
	 * 
	 * @param imgNm 이미지 이름
	 * @return Image 인스턴스
	 */
	public static Image getPaneImage(String imgNm) {
		return Toolkit.getDefaultToolkit().getImage(getOriPaneImgPath(imgNm));
	}
	
	
	
	
	
	/**
	 * 채팅 배경 이미지 경로 반환
	 * 
	 * @return 채팅 배경 이미지 경로
	 */
	public static String getChatBackImgPath() {
		return chatBackImgPath;
	}
	
	/**
	 * 클래스 패스 내에 있는 이미지의 실제 경로 반환
	 * 
	 * @return 실제 경로
	 */
	public static String getOriChatBackImgPath() {
		return CommSet.class.getResource(chatBackImgPath).getPath();
	}
	
	/**
	 * 클래스 패스 내에 있는 이미지의 실제 경로 반환 <br>
	 * 이미지 이름에 확장자를 입력하지 않을 경우 자동을 png확장자를 찾는다. <br>
	 * 
	 * @param imgNm 존재하는 이미지의 이름
	 * @return 실제 경로
	 */
	public static String getOriChatBackImgPath(String imgNm) {
		
		int ex = imgNm.indexOf(".");
		
		if (ex > 0) {
			return CommSet.class.getResource(chatBackImgPath + imgNm).getPath();
		}
		
		return CommSet.class.getResource(chatBackImgPath + imgNm + ".png").getPath();
	}
	
}
