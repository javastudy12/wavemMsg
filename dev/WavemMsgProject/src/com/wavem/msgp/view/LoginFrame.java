/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : LoginFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.wavem.msgp.comm.PropertiesInfo;
import com.wavem.msgp.comm.WaveMsgException;
import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgCheckBox;
import com.wavem.msgp.component.WaveMsgDialogBox;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.component.WaveMsgLabel;
import com.wavem.msgp.component.WaveMsgPasswordField;
import com.wavem.msgp.component.WaveMsgTextField;
import com.wavem.msgp.controller.DataController;
import com.wavem.msgp.dto.LoginParamInfo;
import com.wavem.msgp.dto.UserInfo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 로그인 화면
 * 
 * <pre>
 * 	LoginFrame loginFrame = new LoginFrame();
 * </pre>
 * 
 * @author 
 *
 */
public class LoginFrame extends WaveMsgFrame{
	
	private static final long serialVersionUID = -4114307065580336554L;
	
	/** ID입력 필드 */
	private WaveMsgTextField idField = null;
	
	/** 비밀번호 입력 필드 */
	private WaveMsgPasswordField passwordField = null;

	/** ID 저장 여부 */
	private WaveMsgCheckBox idSaveChk = null;
	
	/** 환경설정 인스턴스 변수 */
	private PropertiesInfo properties = null;
	
	/**
	 * 로그인 화면 생성자 <br>
	 * 최초에 makeInitFrame()호출 <br>
	 */
	public LoginFrame() {

		try {
			properties = PropertiesInfo.getInstance();
			MsgMainFrame.getInstance().close(); // 실패한 메인 화면 종료
			makeInitFrame();
		} catch (Exception e) {
			new WaveMsgDialogBox("로그인", e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void makeInitFrame() throws Exception {
		
		setTitle("로그인");
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 254, 233);
		
		// ID 텍스트
		WaveMsgLabel lblId = new WaveMsgLabel("ID");
		lblId.setBounds(23, 43, 67, 15);
		getContentPane().add(lblId);
		
		// PASSWORD 텍스트
		WaveMsgLabel lblPassword = new WaveMsgLabel("PASSWORD");
		lblPassword.setBounds(23, 73, 75, 15);
		getContentPane().add(lblPassword);
		
		// 콜론
		WaveMsgLabel label = new WaveMsgLabel(":");
		label.setBounds(94, 43, 5, 15);
		getContentPane().add(label);
		
		// 콜론
		WaveMsgLabel label_1 = new WaveMsgLabel(":");
		label_1.setBounds(94, 73, 5, 15);
		getContentPane().add(label_1);
		
		// ID입력 필드
		idField = new WaveMsgTextField();
		idField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyCode() == 10) { // Enter Key 입력 시
					login();
				}
			}
		});
		idField.setBounds(110, 40, 116, 21);
		idField.setColumns(15);
		getContentPane().add(idField);
		
		// 기존 설정에 ID가 저장으로 되어있는경우
		// 저장되어 있는 ID를 세팅한다.
		if (properties.isIdSaveChk()) {
			idField.setText("admin"/*properties.getLoginUserId()*/);
		}
		
		// 비밀번호 입력 필드
		passwordField = new WaveMsgPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyCode() == 10) { // Enter Key 입력 시
					login();
				}
			}
		});
		passwordField.setBounds(111, 70, 115, 21);
		passwordField.setColumns(15);
		getContentPane().add(passwordField);
		
		// ID 저장 여부 체크 박스
		idSaveChk = new WaveMsgCheckBox("ID를 저장합니다.");
		idSaveChk.setBackground(Color.WHITE);
		idSaveChk.setBounds(23, 109, 203, 23);
		idSaveChk.setSelected(properties.isIdSaveChk()); //환경설정에서 ID저장여부 로드
		getContentPane().add(idSaveChk);
		
		// 로그인 버튼
		WaveMsgButton loginBtn = new WaveMsgButton("LOGIN");
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login();
			}
		});
		loginBtn.setBounds(94, 155, 60, 30);
		getContentPane().add(loginBtn);
		
		// 닫기 버튼
		WaveMsgButton closeBtn = new WaveMsgButton("CLOSE");
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0); // 닫기버튼 클릭시 전체 종료
			}
		});
		closeBtn.setBounds(166, 155, 60, 30);
		getContentPane().add(closeBtn);
	}
	
	@Override
	public void close() {
		this.dispose();
	}
	
	/**
	 * 로그인 <br>
	 * 사용자 인증 및 메인화면 활성화 <br>
	 * 만약 첫 로그인 사용자일 경우 regPasswordInfo() 호출
	 */
	@SuppressWarnings("deprecation")
	public void login() {
		
		// ID 체크
		if (idField.getText().trim().equals("")) {
			new WaveMsgDialogBox("로그인", "ID를 입력하세요", JOptionPane.WARNING_MESSAGE);
			idField.requestFocus();
			return;
		}
		
		// 비밀번호 체크
		if (passwordField.getText().trim().equals("")) {
			new WaveMsgDialogBox("로그인", "비밀번호를 입력하세요", JOptionPane.WARNING_MESSAGE);
			passwordField.requestFocus();
			return;
		}
		
		// 데이터 전송을 위한 객체 생성
		LoginParamInfo parm = new LoginParamInfo();
		parm.setUserId(idField.getText());
		parm.setUserPw(passwordField.getText());
		
		// 데이터 전송을 위한 인스턴스 생성
		DataController dataCtrl = new DataController(parm);

		// 데이터 전송 결과
		int success = 0;
		
		// 데이터 전송
		try {
			dataCtrl.selectData();
 			
		} catch (WaveMsgException e) {
			new WaveMsgDialogBox("로그인", e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
		
		success = dataCtrl.getRes(); // 결과
		
		if (success == 0) { // 로그인 성공 시
			makeMain();
		} else if (success == 1){ // 최초 로그인시
			regPasswordInfo();
		} else {
			
			/* ****************************************************************
			 * TODO : 실패 메시지를 받아와 띄운다.
			 * 
			 *  
			 *  
			 * ****************************************************************/
			
			new WaveMsgDialogBox("로그인", "없는 사용자입니다.", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	/**
	 * 첫 로그인 사용자만 해당 <br>
	 * 비밀번호 재등록 화면 호출
	 */
	public void regPasswordInfo() {
		setVisible(false); // 로그인창 감추기
		
		LoginRegPwFrame frame = null;
		
		try {
			frame = new LoginRegPwFrame(this); // 비밀번호 등록 화면 생성
			frame.setVisible(true);
		} catch (Exception e) {
			new WaveMsgDialogBox("비밀번호 등록", e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * 로그인 성공 시 메인화면 생성 
	 */
	public void makeMain() {
		
		if (idSaveChk.isSelected() != properties.isIdSaveChk()) { // 설정이 서로 다르면 환경설정에 저장
			properties.setIdSaveChk(idSaveChk.isSelected()); // id저장여부
		}
		
		MsgMainFrame.setLoginUser(new UserInfo()); // TODO : 실제 서버에서 가져온 데이터를 넣어야함
		
		MsgMainFrame frame =  MsgMainFrame.getInstance(); // 메인 생성
		frame.setVisible(true);
		
		close(); // 로그인 화면 종료
	}
	
}
