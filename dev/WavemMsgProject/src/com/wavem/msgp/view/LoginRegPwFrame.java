/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : LoginRegPwFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import java.awt.Color;

import javax.swing.JOptionPane;

import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgCheckBox;
import com.wavem.msgp.component.WaveMsgDialogBox;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.component.WaveMsgLabel;
import com.wavem.msgp.component.WaveMsgPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 최초 로그인 시 비밀번호 등록 화면
 * @author 
 *
 */
public class LoginRegPwFrame extends WaveMsgFrame {

	private static final long serialVersionUID = 680851293791230322L;
	
	/** 로그인 화면 */
	LoginFrame loginFrame = null;
	
	/** 비밀번호 입력 필드 */
	private WaveMsgPasswordField pwField = null;
	
	/** 비밀번호 확인 입력 필드 */
	private WaveMsgPasswordField pwChkField = null;

	/**
	 * 로그인 비밀번호 등록 
	 * 
	 * @param loginFrame 로그인 화면
	 */
	public LoginRegPwFrame(LoginFrame loginFrame) throws Exception {
		this.loginFrame = loginFrame;
		makeInitFrame();
	}

	@Override
	public void makeInitFrame() throws Exception {

		setTitle("최초 비밀번호 등록");

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 254, 190);

		// PW 텍스트
		WaveMsgLabel lblId = new WaveMsgLabel("PW");
		lblId.setBounds(23, 43, 67, 15);
		getContentPane().add(lblId);

		// PW 확인 텍스트
		WaveMsgLabel lblPassword = new WaveMsgLabel("PW 확인");
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

		// 비밀번호 입력 필드
		pwField = new WaveMsgPasswordField();
		pwField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyCode() == 10) {
					regPw();
				}
			}
		});
		pwField.setBounds(110, 40, 116, 21);
		pwField.setColumns(15);
		getContentPane().add(pwField);

		// 비밀번호 확인 입력 필드
		pwChkField = new WaveMsgPasswordField();
		pwChkField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyCode() == 10) {
					regPw();
				}
			}
		});
		pwChkField.setBounds(111, 70, 115, 21);
		pwChkField.setColumns(15);
		getContentPane().add(pwChkField);

		// 확인 버튼
		WaveMsgButton loginBtn = new WaveMsgButton("OK");
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				regPw();
			}
		});
		loginBtn.setBounds(94, 111, 60, 30);
		getContentPane().add(loginBtn);

		// 닫기 버튼
		WaveMsgButton closeBtn = new WaveMsgButton("CLOSE");
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginFrame.setVisible(true);
				close();
			}
		});
		closeBtn.setBounds(166, 111, 60, 30);
		getContentPane().add(closeBtn);

	}

	@Override
	public void close() {
		this.dispose();
	}
	
	/**
	 * 비밀번호 등록
	 */
	@SuppressWarnings("deprecation")
	public void regPw() {
		
		// 비밀번호 체크
		if (pwField.getText().trim().equals("")) {
			new WaveMsgDialogBox("비밀번호 등록", "비밀번호를 입력하세요", JOptionPane.WARNING_MESSAGE);
			pwField.requestFocus();
			return;
		}
		
		// 비밀번호 확인 체크
		if (pwChkField.getText().trim().equals("")) {
			new WaveMsgDialogBox("비밀번호 등록", "비밀번호 확인을 입력하세요", JOptionPane.WARNING_MESSAGE);
			pwChkField.requestFocus();
			return;
		}
		
		// 비밀번호와 비밀번호 확인 체크
		if (!pwField.getText().trim().equals(pwChkField.getText().trim())) {
			new WaveMsgDialogBox("비밀번호 등록", "비밀번호와 비밀번호확인이 다릅니다.", JOptionPane.WARNING_MESSAGE);
			pwField.requestFocus();
			return;
		}
		/* ****************************************************************
		 * TODO : 최초 로그인 시 비밀번호 등록 처리 (예외처리 필수)
		 * 
		 *  
		 *  
		 * ****************************************************************/
		
		loginFrame.makeMain();
		close();
		
	}

	@Override
	public void callBackData() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
