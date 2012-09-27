/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : GroupFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/


package com.wavem.msgp.view;

import com.wavem.msgp.component.WaveMsgFrame;

/**
 * 그룹 화면 
 * 
 * <pre>
 * 	GroupFrame groupFrame = new GroupFrame();
 * </pre>
 * 
 * @author 
 *
 */
public class GroupFrame extends WaveMsgFrame{
	
	private static final long serialVersionUID = -3827633116266407657L;
	
	/** 그룹 화면 인스턴스 변수 */
	private static GroupFrame frame = null;
	
	/**
	 * 그룹화면 생성자 <br>
	 * 최초 makeInitFrame()호출 <br>
	 */
	private GroupFrame() {
		makeInitFrame();
	}
	
	/**
	 * 그룹 화면을 위한 인스턴스 반환
	 * 
	 * @return 그룹 화면을 위한 화면 인스턴스
	 */
	public static GroupFrame getInstance() {
		
		if (frame == null) {
			synchronized (GroupFrame.class) {
				if (frame == null) {
					frame = new GroupFrame();
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
	 * 전체 사용자 리스트 호출
	 */
	public void invokeUserList() {
	
	}
	
	/**
	 * 그룹 사용자 리스트 호출
	 */
	public void invokeGroupList() {
	
	}
	
	/**
	 * 그룹 생성
	 */
	public void makeGroup() {
	
	}
	
	/**
	 * 그룹 삭제
	 */
	public void deleteGroup() {
	
	}
	
	/**
	 * 그룹에 사용자 추가
	 */
	public void addUserToGroup() {
	
	}
	
	/**
	 * 그룹의 사용자 삭제
	 */
	public void deleteUserToGroup() {
	
	}
	
	/**
	 * 현재 설정된 그룹 사용자 저장
	 */
	public void saveGroup() {
	
	}
	
}
