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

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.comm.WaveMsgException;
import com.wavem.msgp.component.WaveMsgFrame;

/**
 * 그룹 화면 
 * 
 * <pre>
 * 	GroupFrame groupFrame = new GroupFrame();
 * </pre>
 * 
 * @author 
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class GroupFrame extends WaveMsgFrame{
	
	private static final long serialVersionUID = -3827633116266407657L;
	
	/** 타이틀 */
	private String title = CommMsg.GROUP_FRAME_TITLE;
	
	/** 그룹 화면 인스턴스 변수 */
	private static GroupFrame frame = null;
	
	/**
	 * 그룹화면 생성자 <br>
	 * 최초 makeInitFrame()호출 <br>
	 * 
	 * @throws WaveMsgException 
	 */
	private GroupFrame() throws WaveMsgException {
		makeInitFrame();
	}
	
	/**
	 * 그룹 화면을 위한 인스턴스 반환
	 * 
	 * @return 그룹 화면을 위한 화면 인스턴스
	 * @throws WaveMsgException 
	 */
	public static GroupFrame getInstance() throws WaveMsgException {
		
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
	public void makeInitFrame() throws WaveMsgException {
		getContentPane().setLayout(null);
		setTitle(this.title);
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

	@Override
	public void callBackData() throws WaveMsgException {
		// TODO Auto-generated method stub
		
	}
	
}
