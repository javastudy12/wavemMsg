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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgComboBox;
import com.wavem.msgp.component.WaveMsgDialogBox;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.component.WaveMsgLabel;
import com.wavem.msgp.component.WaveMsgPanel;
import com.wavem.msgp.component.WaveMsgRadioButton;
import com.wavem.msgp.component.WaveMsgTextField;
import com.wavem.msgp.controller.DataController;
import com.wavem.msgp.dto.UserInfo;

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
	
	/** 수정된 사용자 정보를 담고 있는 UserInfo 인스턴스 변수 */
	private UserInfo userUpdateInfo = new UserInfo();
	
	/** 프로필 사진을 위한 이미지*/
	private WaveMsgPanel profileImg = null;
	
	/** 프로필 사진 경로를 위한 인스턴스 */
	private File profileImgPath = null;
	
	/** 선택한 프로필 사진 */
	private String imgPath = "";
	
	/** 기본 설정 라디오버튼 */
	private WaveMsgRadioButton defaultRdBtn = null;
	
	/** 사용자 설정 라디오버튼 */
	private WaveMsgRadioButton userRdBtn = null;
	
	/** 사용자 설정 찾기 버튼 */
	private WaveMsgButton userSetBtn = null;
	
	/** 기본 설정일 경우 기본 이미지 설정을 위한 콤보 */
	private WaveMsgComboBox defaultImgCombo = null;
	
	/** 사용자 설정일 경우 이미지 경로 */
	private WaveMsgTextField userSetPath = null;
	
	/** 사용자 이름 */
	private WaveMsgLabel nameValueLbl = null;
	
	/** 사용자 ID */
	private WaveMsgLabel idValueLbl = null;
	
	/** 사용자 직급 */
	private WaveMsgLabel levelValueLbl = null;
	
	/** 사용자 생년월일 */
	private WaveMsgLabel birthValueLbl = null;
	
	/** 상태메시지 수정 */
	private WaveMsgTextField messageValueTxt = null;
	
	/** e-mail 수정 */
	private WaveMsgTextField emailValueTxt = null;
	
	/** 핸드폰 번호 */
	private WaveMsgTextField phoneValue1 = null;
	private WaveMsgTextField phoneValue2 = null;
	private WaveMsgTextField phoneValue3 = null;
	
	/** 집전화 번호 */
	private WaveMsgTextField homeValue1 = null;
	private WaveMsgTextField homeValue2 = null;
	private WaveMsgTextField homeValue3 = null;
	
	/** 주소 */
	private WaveMsgTextField addrValueTxt = null;
	
	/** 라디오버튼 그룹 */
	private ButtonGroup imgSetRadioGroup = null;
	
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
		setBounds(100, 100, 416, 510);
		
		/* ****************************************************
		 * 프로필 사진 설정 패널 시작
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
		defaultRdBtn = new WaveMsgRadioButton("기본 이미지");
		defaultRdBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setProfileImg();
			}
		});
		defaultRdBtn.setBounds(8, 6, 228, 23);
		
		// 사용자 설정 라디오 버튼
		userRdBtn = new WaveMsgRadioButton("사용자 설정");
		userRdBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setProfileImg();
			}
		});
		userRdBtn.setBounds(8, 66, 228, 23);
		
		// 라디오 버튼 그룹 설정
		imgSetRadioGroup = new ButtonGroup();
		imgSetRadioGroup.add(defaultRdBtn);
		imgSetRadioGroup.add(userRdBtn);
		
		// 프로필 사진 설정을 위한 공간에 라디오버튼 추가
		imgSet.add(defaultRdBtn);
		imgSet.add(userRdBtn);
		
		// 기본 설정 콤보 박스
		defaultImgCombo = new WaveMsgComboBox();
		defaultImgCombo.setBounds(18, 35, 218, 23);
		defaultImgCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				changeCombo(e);
			}
		});
		imgSet.add(defaultImgCombo);
		
		// 사용자 설정 이미지 경로
		userSetPath = new WaveMsgTextField();
		userSetPath.setEditable(false);
		userSetPath.setBounds(18, 95, 155, 21);
		userSetPath.setColumns(10);
		imgSet.add(userSetPath);
		
		// 기본 설정에서 이미지 검색을 위한 버튼
		userSetBtn = new WaveMsgButton("FIND");
		userSetBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectImgPath();
			}
		});
		userSetBtn.setBounds(176, 95, 60, 21);
		imgSet.add(userSetBtn);
		
		/* ****************************************************
		 * 프로필 사진 설정 패널 끝
		 * ****************************************************/
		
		
		/* ****************************************************
		 * 프로필 기본 정보 패널 시작
		 * ****************************************************/
		// 기본정보 패널
		WaveMsgPanel panel = new WaveMsgPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 149, 400, 120);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		//********** 이름 ********** 
		WaveMsgPanel panel_name = new WaveMsgPanel();
		panel_name.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_name.setBounds(12, 10, 120, 25);
		panel.add(panel_name);
		panel_name.setLayout(null);
		
		WaveMsgLabel nameLbl = new  WaveMsgLabel("이름");
		nameLbl.setBounds(5, 2, 103, 21);
		panel_name.add(nameLbl);
		
		WaveMsgPanel panel_namevalue = new WaveMsgPanel();
		panel_namevalue.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_namevalue.setBackground(Color.WHITE);
		panel_namevalue.setBounds(144, 10, 244, 25);
		panel.add(panel_namevalue);
		panel_namevalue.setLayout(null);
		
		nameValueLbl = new WaveMsgLabel(""); // 실제 사용자 이름이 나오는 곳
		nameValueLbl.setBounds(5, 2, 227, 21);
		panel_namevalue.add(nameValueLbl);
		
		
		//********** ID ********** 
		WaveMsgPanel panel_id = new WaveMsgPanel();
		panel_id.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_id.setLayout(null);
		panel_id.setBounds(12, 35, 120, 25);
		panel.add(panel_id);
		
		WaveMsgLabel idLbl = new WaveMsgLabel("ID");
		idLbl.setBounds(5, 2, 103, 21);
		panel_id.add(idLbl);
		
		WaveMsgPanel panel_idvalue = new WaveMsgPanel();
		panel_idvalue.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_idvalue.setBackground(Color.WHITE);
		panel_idvalue.setBounds(144, 35, 244, 25);
		panel.add(panel_idvalue);
		panel_idvalue.setLayout(null);
		
		idValueLbl = new WaveMsgLabel("");
		idValueLbl.setBounds(5, 2, 227, 21);
		panel_idvalue.add(idValueLbl);
	
		
		//********** 직급(직책) **********
		WaveMsgPanel panel_level = new WaveMsgPanel();
		panel_level.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_level.setLayout(null);
		panel_level.setBounds(12, 60, 120, 25);
		panel.add(panel_level);
		
		WaveMsgLabel levelLbl = new WaveMsgLabel("직급 (직책)");
		levelLbl.setBounds(5, 2, 103, 21);
		panel_level.add(levelLbl);
		
		WaveMsgPanel panel_levelvalue = new WaveMsgPanel();
		panel_levelvalue.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_levelvalue.setBackground(Color.WHITE);
		panel_levelvalue.setBounds(144, 60, 244, 25);
		panel.add(panel_levelvalue);
		panel_levelvalue.setLayout(null);
		
		levelValueLbl = new WaveMsgLabel("");
		levelValueLbl.setBounds(5, 2, 227, 21);
		panel_levelvalue.add(levelValueLbl);
		
		
		//********** 생년월일 **********
		WaveMsgPanel panel_birth = new WaveMsgPanel();
		panel_birth.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_birth.setLayout(null);
		panel_birth.setBounds(12, 85, 120, 25);
		panel.add(panel_birth);
		
		WaveMsgLabel birthLbl = new WaveMsgLabel("생년월일");
		birthLbl.setBounds(5, 2, 103, 21);
		panel_birth.add(birthLbl);
		
		WaveMsgPanel panel_birthvalue = new WaveMsgPanel();
		panel_birthvalue.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_birthvalue.setBackground(Color.WHITE);
		panel_birthvalue.setBounds(144, 85, 244, 25);
		panel.add(panel_birthvalue);
		panel_birthvalue.setLayout(null);
		
		birthValueLbl = new WaveMsgLabel("");
		birthValueLbl.setBounds(5, 2, 227, 21);
		panel_birthvalue.add(birthValueLbl);
		
		/* ****************************************************
		 * 프로필 기본 정보 패널 끝
		 * ****************************************************/
		
		
		/* ****************************************************
		 * 프로필 수정 정보 패널 시작
		 * ****************************************************/
		// 수정 가능한 공간
		WaveMsgPanel panel_modify = new WaveMsgPanel();
		panel_modify.setBackground(Color.WHITE);
		panel_modify.setBounds(0, 267, 400, 150);
		panel_modify.setLayout(null);
		getContentPane().add(panel_modify);
		
		
		//********** 상태메시지 **********
		WaveMsgPanel panel_message = new WaveMsgPanel();
		panel_message.setLayout(null);
		panel_message.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_message.setBounds(12, 10, 120, 25);
		panel_modify.add(panel_message);
		
		WaveMsgLabel messageLbl = new WaveMsgLabel("상태메시지");
		messageLbl.setBounds(5, 2, 103, 21);
		panel_message.add(messageLbl);
		
		WaveMsgPanel panel_messagevalue = new WaveMsgPanel();
		panel_messagevalue.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_messagevalue.setBackground(Color.WHITE);
		panel_messagevalue.setBounds(144, 10, 244, 25);
		panel_messagevalue.setLayout(null);
		panel_modify.add(panel_messagevalue);
		
		messageValueTxt = new WaveMsgTextField();
		messageValueTxt.setBounds(5, 2, 227, 21);
		messageValueTxt.setColumns(10);
		panel_messagevalue.add(messageValueTxt);
		
		
		//********** e-mail **********
		WaveMsgPanel panel_email = new WaveMsgPanel();
		panel_email.setLayout(null);
		panel_email.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_email.setBounds(12, 35, 120, 25);
		panel_modify.add(panel_email);
		
		WaveMsgLabel emailLbl = new WaveMsgLabel("e-mail");
		emailLbl.setBounds(5, 2, 103, 21);
		panel_email.add(emailLbl);
		
		WaveMsgPanel panel_emailvalue = new WaveMsgPanel();
		panel_emailvalue.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_emailvalue.setBackground(Color.WHITE);
		panel_emailvalue.setBounds(144, 35, 244, 25);
		panel_emailvalue.setLayout(null);
		panel_modify.add(panel_emailvalue);
		
		emailValueTxt = new WaveMsgTextField();
		emailValueTxt.setColumns(10);
		emailValueTxt.setBounds(5, 2, 227, 21);
		panel_emailvalue.add(emailValueTxt);
		
		
		//********** 핸드폰 **********
		WaveMsgPanel panel_phone = new WaveMsgPanel();
		panel_phone.setLayout(null);
		panel_phone.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_phone.setBounds(12, 60, 120, 25);
		panel_modify.add(panel_phone);
		
		WaveMsgLabel phoneLbl = new WaveMsgLabel("핸드폰");
		phoneLbl.setBounds(5, 2, 103, 21);
		panel_phone.add(phoneLbl);
		
		WaveMsgPanel panel_phonevalue = new WaveMsgPanel();
		panel_phonevalue.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_phonevalue.setBackground(Color.WHITE);
		panel_phonevalue.setBounds(144, 60, 244, 25);
		panel_phonevalue.setLayout(null);
		panel_modify.add(panel_phonevalue);
		
		phoneValue1 = new WaveMsgTextField();
		phoneValue1.setColumns(10);
		phoneValue1.setBounds(5, 2, 50, 21);
		panel_phonevalue.add(phoneValue1);
		
		phoneValue2 = new WaveMsgTextField();
		phoneValue2.setColumns(10);
		phoneValue2.setBounds(67, 2, 76, 21);
		panel_phonevalue.add(phoneValue2);
		
		phoneValue3 = new WaveMsgTextField();
		phoneValue3.setColumns(10);
		phoneValue3.setBounds(155, 2, 77, 21);
		panel_phonevalue.add(phoneValue3);
		
		
		//********** 집전화 **********
		WaveMsgPanel panel_home = new WaveMsgPanel();
		panel_home.setLayout(null);
		panel_home.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_home.setBounds(12, 85, 120, 25);
		panel_modify.add(panel_home);
		
		JLabel homeLbl = new JLabel("집전화");
		homeLbl.setBounds(5, 2, 103, 21);
		panel_home.add(homeLbl);
		
		WaveMsgPanel panel_homevalue = new WaveMsgPanel();
		panel_homevalue.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_homevalue.setBackground(Color.WHITE);
		panel_homevalue.setBounds(144, 85, 244, 25);
		panel_homevalue.setLayout(null);
		panel_modify.add(panel_homevalue);
		
		homeValue1 = new WaveMsgTextField();
		homeValue1.setColumns(10);
		homeValue1.setBounds(5, 2, 50, 21);
		panel_homevalue.add(homeValue1);
		
		homeValue2 = new WaveMsgTextField();
		homeValue2.setColumns(10);
		homeValue2.setBounds(67, 2, 76, 21);
		panel_homevalue.add(homeValue2);
		
		homeValue3 = new WaveMsgTextField();
		homeValue3.setColumns(10);
		homeValue3.setBounds(155, 2, 77, 21);
		panel_homevalue.add(homeValue3);
		
		
		//********** 집전화 **********
		WaveMsgPanel panel_addr = new WaveMsgPanel();
		panel_addr.setLayout(null);
		panel_addr.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_addr.setBounds(12, 110, 120, 25);
		panel_modify.add(panel_addr);
		
		WaveMsgLabel addrLbl = new WaveMsgLabel("주소");
		addrLbl.setBounds(5, 2, 103, 21);
		panel_addr.add(addrLbl);
		
		WaveMsgPanel panel_addrvalue = new WaveMsgPanel();
		panel_addrvalue.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_addrvalue.setBackground(Color.WHITE);
		panel_addrvalue.setBounds(144, 110, 244, 25);
		panel_addrvalue.setLayout(null);
		panel_modify.add(panel_addrvalue);
		
		addrValueTxt = new WaveMsgTextField();
		addrValueTxt.setColumns(10);
		addrValueTxt.setBounds(5, 2, 227, 21);
		panel_addrvalue.add(addrValueTxt);
		
		/* ****************************************************
		 * 프로필 수정 정보 패널 끝
		 * ****************************************************/
		
		
		/* ****************************************************
		 * 버튼 시작
		 * ****************************************************/
		
		WaveMsgButton btnNewButton = new WaveMsgButton("SAVE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modifyProfileInfo();
			}
		});
		btnNewButton.setBounds(256, 427, 60, 30);
		getContentPane().add(btnNewButton);
		
		WaveMsgButton waveMsgButton = new WaveMsgButton("CLOSE");
		waveMsgButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
		waveMsgButton.setBounds(328, 427, 60, 30);
		getContentPane().add(waveMsgButton);
		
		/* ****************************************************
		 * 버튼 끝
		 * ****************************************************/
		
		// 화면을 다 그린 후 사용자 정보를 표현한다.
		invokeProfileInfo();
	}

	@Override
	public void close() {
		this.dispose();
	}

	/**
	 * 라디오버튼 선택 시
	 */
	public void setProfileImg() {
		
		// 기본설정 버튼 선택시
		if (defaultRdBtn.isSelected()) {
			setProfileImgEnable(true);
		}
		
		// 사용자설정 버튼 선택시
		if (userRdBtn.isSelected()) {
			setProfileImgEnable(false);
		}
	}
	
	/**
	 * 프로필 기본설정 및 사용자 설정 <br>
	 * 
	 * true : 기본설정 선택 <br>
	 * false : 사용자설정 선택 <br>
	 * 
	 * @param chk 선택 유무
	 */
	public void setProfileImgEnable(boolean chk) {
		
		if (chk) {
			defaultImgCombo.setEnabled(true);
			userSetPath.setEnabled(false);
			userSetBtn.setEnabled(false);
			
			/* **********************************************************
			 * 파일을 검색하여 콤보에 세팅 시작
			 * **********************************************************/
			if (profileImgPath == null) {
				profileImgPath = new File(ProfileFrame.class.getResource("/com/wavem/resource/img/profile/").getPath());
				
				String[] fileList = profileImgPath.list();

				for (int i=0; i<fileList.length; i++) {
					defaultImgCombo.addItem(fileList[i].replace(".png", ""));
				}
			}
			/* **********************************************************
			 * 파일을 검색하여 콤보에 세팅 끝
			 * **********************************************************/
			
		} else {
			defaultImgCombo.setEnabled(false);
			userSetPath.setEnabled(true);
			userSetBtn.setEnabled(true);
		}
		
	}
	
	/**
	 * 사용자 프로필 호출
	 */
	public void invokeProfileInfo() {
		
		// 첫 로딩시 기본 설정을 가져와야 하지만 현재 임시로 설정 
		setProfileImgEnable(true); // 첫 로딩시 기본설정으로 설정
		defaultRdBtn.setSelected(true);
		
		/* *******************************************************
		 * TODO : 사용자 프로필 세팅
		 * *******************************************************/
		
	}

	/**
	 * 콤보 선택 시 프로필 이미지 세팅
	 * 
	 * @param e 이벤트
	 */
	public void changeCombo(ItemEvent e) {
		
		if (e.getStateChange() == ItemEvent.SELECTED) {
			try {
				imgPath = profileImgPath.getAbsoluteFile() + "\\" + e.getItem().toString() + ".png";
				profileImg.setImage(new File(imgPath));
			} catch (IOException e1) {
				new WaveMsgDialogBox("프로필", "선택한 이미지가 없습니다.", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * 사용자 이미지 선택
	 */
	public void selectImgPath() {
		
		// 파일찾기 화면 실행
		JFileChooser fileChooser = new JFileChooser();
		
		// 이미지만 선택할 수 있도록 필터 적용
		FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & PNG", "png", "jpg");
		fileChooser.setFileFilter(imgFilter);
		
		// 파일 선택
		int returnVal = fileChooser.showOpenDialog(null);

		// 파일선택 후 이미지를 프로필 사진으로 세팅
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			
			// 파일 경로 출력
			userSetPath.setText(fileChooser.getSelectedFile().getAbsolutePath());
		
			try {
				imgPath = fileChooser.getSelectedFile().getAbsolutePath();
				
				BufferedImage bufImg = ImageIO.read(new BufferedInputStream(new FileInputStream(imgPath)));
				Image atemp = bufImg.getScaledInstance(120, 130, Image.SCALE_AREA_AVERAGING);
				
				//profileImg.setImage(fileChooser.getSelectedFile()); // 이미지 적용한다. // 이미지 미변환
				profileImg.setImage(atemp);// 이미지 적용한다. // 이미지 변환
				
			} catch (IOException e) {
				new WaveMsgDialogBox("프로필", "선택한 이미지가 없습니다.", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * 사용자 프로필 수정
	 */
	public void modifyProfileInfo() {
		DataController controller;
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
