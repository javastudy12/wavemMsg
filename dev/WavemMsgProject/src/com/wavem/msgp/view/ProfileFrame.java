/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : ProfileFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import java.awt.Color;

import javax.swing.ButtonGroup;

import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgComboBox;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.component.WaveMsgPanel;
import com.wavem.msgp.component.WaveMsgRadioButton;
import com.wavem.msgp.component.WaveMsgTextField;
import com.wavem.msgp.dto.UserInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * 프로필 설정 화면
 * 
 * <pre>
 * 	ProfileFrame profileFrame = new ProfileFrame();
 * </pre>
 * 
 * @author 
 *
 */
public class ProfileFrame extends WaveMsgFrame {

	private static final long serialVersionUID = 5045138939543198397L;

	/** 프로필 설정 화면 인스턴스 변수 */
	private static ProfileFrame frame = null;
	
	/** 사용자 정보를 담고 있는 UserInfo 인스턴스 변수 */
	private UserInfo userInfo = null;
	
	/** 프로필 사진을 위한 이미지*/
	private WaveMsgPanel profileImg = null;
	
	/** 기본 설정일 경우 기본 이미지 설정을 위한 콤보 */
	private WaveMsgComboBox defaultImgCombo = null;
	
	/** 사용자 설정일 경우 이미지 경로 */
	private WaveMsgTextField userSetPath = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	
	/**
	 * 프로필 설정 생성자 <br>
	 * 최초 makeInitFrame() 호출 <br>
	 */
	private ProfileFrame(UserInfo userInfo) {
		getContentPane().setBackground(Color.WHITE);
		this.userInfo = userInfo;
		makeInitFrame();
	}
	
	/**
	 * 프로필 설정 화면을 위한 인스턴스 반환
	 * 
	 * @return 프로필 설정 화면을 위한 화면 인스턴스
	 */
	public static ProfileFrame getInstance(UserInfo userInfo) {
		
		if (frame == null) { // 생성된 인스턴스가 없는 경우 새로 생성
			synchronized (ProfileFrame.class) {
				if (frame == null) {
					frame = new ProfileFrame(userInfo);
				}
			}
		} 
		
		return frame;
	}
	
	@Override
	public void makeInitFrame() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 416, 738);
		
		/* ****************************************************
		 * 프로필 설정 패널 시작
		 * ****************************************************/
		WaveMsgPanel imgSetPane = new WaveMsgPanel();
		imgSetPane.setBackground(Color.WHITE);
		imgSetPane.setBounds(0, 0, 400, 150);
		getContentPane().add(imgSetPane);
		imgSetPane.setLayout(null);
		
		// 프로필 사진을 보여주기 위한 공간
		profileImg = new WaveMsgPanel();
		profileImg.setBounds(12, 10, 120, 130);
		imgSetPane.add(profileImg);
		
		// 프로필 사진 설정을 위한 패널 공간
		WaveMsgPanel imgSet = new WaveMsgPanel();
		imgSet.setBounds(144, 10, 244, 130);
		imgSet.setLayout(null);
		imgSetPane.add(imgSet);
		
		// 기본 이미지 라디오 버튼
		WaveMsgRadioButton defaultRdBtn = new WaveMsgRadioButton("기본 이미지");
		defaultRdBtn.setBounds(8, 6, 228, 23);
		
		// 사용자 설정 라디오 버튼
		WaveMsgRadioButton userRdBtn = new WaveMsgRadioButton("사용자 설정");
		userRdBtn.setBounds(8, 66, 228, 23);
		
		// 라디오 버튼 그룹 설정
		ButtonGroup imgSetRadioGroup = new ButtonGroup();
		imgSetRadioGroup.add(defaultRdBtn);
		imgSetRadioGroup.add(userRdBtn);
		
		// 프로필 사진 설정을 위한 공간에 라디오버튼 추가
		imgSet.add(defaultRdBtn);
		imgSet.add(userRdBtn);
		
		// 기본 설정 콤보 박스
		defaultImgCombo = new WaveMsgComboBox();
		defaultImgCombo.setBounds(18, 35, 218, 23);
		imgSet.add(defaultImgCombo);
		
		// 사용자 설정 이미지 경로
		userSetPath = new WaveMsgTextField();
		userSetPath.setBounds(18, 95, 155, 21);
		imgSet.add(userSetPath);
		userSetPath.setColumns(10);
		
		// 기본 설정에서 이미지 검색을 위한 버튼
		WaveMsgButton userSetBtn = new WaveMsgButton("FIND");
		userSetBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		userSetBtn.setBounds(176, 95, 60, 21);
		imgSet.add(userSetBtn);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 149, 400, 120);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.setBounds(12, 10, 120, 25);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setBounds(5, 2, 103, 21);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_2.setLayout(null);
		panel_2.setBounds(12, 35, 120, 25);
		panel.add(panel_2);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(5, 2, 103, 21);
		panel_2.add(lblId);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_3.setLayout(null);
		panel_3.setBounds(12, 60, 120, 25);
		panel.add(panel_3);
		
		JLabel label_1 = new JLabel("직급 (직책)");
		label_1.setBounds(5, 2, 103, 21);
		panel_3.add(label_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_4.setLayout(null);
		panel_4.setBounds(12, 85, 120, 25);
		panel.add(panel_4);
		
		JLabel label_2 = new JLabel("생년월일");
		label_2.setBounds(5, 2, 103, 21);
		panel_4.add(label_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(144, 10, 244, 25);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(5, 2, 227, 21);
		panel_5.add(label);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(144, 35, 244, 25);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(5, 2, 227, 21);
		panel_6.add(label_3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(144, 60, 244, 25);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(5, 2, 227, 21);
		panel_7.add(label_4);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(144, 85, 244, 25);
		panel.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(5, 2, 227, 21);
		panel_8.add(label_5);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(0, 267, 400, 150);
		getContentPane().add(panel_9);
		panel_9.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_10.setBounds(12, 10, 120, 25);
		panel_9.add(panel_10);
		
		JLabel label_6 = new JLabel("상태메시지");
		label_6.setBounds(5, 2, 103, 21);
		panel_10.add(label_6);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_11.setBounds(12, 35, 120, 25);
		panel_9.add(panel_11);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(5, 2, 103, 21);
		panel_11.add(lblEmail);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_12.setBounds(12, 60, 120, 25);
		panel_9.add(panel_12);
		
		JLabel label_8 = new JLabel("핸드폰");
		label_8.setBounds(5, 2, 103, 21);
		panel_12.add(label_8);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_13.setBounds(12, 85, 120, 25);
		panel_9.add(panel_13);
		
		JLabel label_9 = new JLabel("집전화");
		label_9.setBounds(5, 2, 103, 21);
		panel_13.add(label_9);
		
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_14.setBounds(12, 110, 120, 25);
		panel_9.add(panel_14);
		
		JLabel label_10 = new JLabel("주소");
		label_10.setBounds(5, 2, 103, 21);
		panel_14.add(label_10);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_15.setBackground(Color.WHITE);
		panel_15.setBounds(144, 10, 244, 25);
		panel_9.add(panel_15);
		panel_15.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(5, 2, 227, 21);
		panel_15.add(textField);
		textField.setColumns(10);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_16.setBackground(Color.WHITE);
		panel_16.setBounds(144, 35, 244, 25);
		panel_9.add(panel_16);
		panel_16.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(5, 2, 227, 21);
		panel_16.add(textField_1);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_17.setBackground(Color.WHITE);
		panel_17.setBounds(144, 60, 244, 25);
		panel_9.add(panel_17);
		panel_17.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(5, 2, 50, 21);
		panel_17.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(67, 2, 76, 21);
		panel_17.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(155, 2, 77, 21);
		panel_17.add(textField_5);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_18.setBackground(Color.WHITE);
		panel_18.setBounds(144, 85, 244, 25);
		panel_9.add(panel_18);
		panel_18.setLayout(null);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(5, 2, 50, 21);
		panel_18.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(67, 2, 76, 21);
		panel_18.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(155, 2, 77, 21);
		panel_18.add(textField_8);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_19.setBackground(Color.WHITE);
		panel_19.setBounds(144, 110, 244, 25);
		panel_9.add(panel_19);
		panel_19.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(5, 2, 227, 21);
		panel_19.add(textField_3);
		
		
		
		
		/* ****************************************************
		 * 프로필 설정 패널 끝
		 * ****************************************************/
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(219, 427, 97, 23);
		getContentPane().add(btnNewButton);
	}

	@Override
	public void close() {
		this.dispose();
	}

	/**
	 * 사용자 프로필 호출
	 */
	public void invokeProfileInfo() {

	}

	/**
	 * 사용자 프로필 수정
	 */
	public void modifyProfileInfo() {

	}

	@Override
	public void callBackData() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] a) {
		ProfileFrame frame = ProfileFrame.getInstance(MsgMainFrame.getLoginUser());
		frame.setVisible(true);
	}
}
