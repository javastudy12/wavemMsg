/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgColorChooser.java
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

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgDialogBox;
import com.wavem.msgp.component.WaveMsgException;
import com.wavem.msgp.component.WaveMsgFontInterface;
import com.wavem.msgp.component.WaveMsgFrame;

/**
 * 색상 설정 화면
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class WaveMsgColorChooser extends WaveMsgFrame {

	private static final long serialVersionUID = -6672717492693301946L;

	/** 타이틀 */
	private String title = CommMsg.COLOR_FRAME_TITLE;
	
	/** 폰트 설정을 요청한 프레임 */
	private WaveMsgFontInterface frame = null;
	
	/** 색상 인스턴스 */
	private Color color = null;
	
	/** 색상 선택 컴포넌트 */ 
	private JColorChooser colorChooser = null;

	/**
	 * 색상설정 화면 생성자
	 * @throws WaveMsgException 
	 */
	public WaveMsgColorChooser(WaveMsgFontInterface frame, Color color) throws WaveMsgException {
		super();
		this.frame = frame; // 컬러 요청한 인스턴스
		this.color = color; // 기존에 지정된 컬러
		
		makeInitFrame();
	}
	
	@Override
	public void makeInitFrame() throws WaveMsgException {
		
		getContentPane().setLayout(null);
		setBounds(100, 100, 624, 435);
		setTitle(this.title);
		setDefaultCloseOperation(WaveMsgFrame.DISPOSE_ON_CLOSE);
		
		/* *************************************************************
		 * 색상 선택 컴포넌트 시작
		 * *************************************************************/
		colorChooser = new JColorChooser(color);
		colorChooser.setBounds(12, 10, 584, 323);
		getContentPane().add(colorChooser);
		/* *************************************************************
		 * 색상 선택 컴포넌트 끝
		 * *************************************************************/
		
		
		/* *************************************************************
		 * 버튼 시작
		 * *************************************************************/
		WaveMsgButton okBtn = new WaveMsgButton("OK");
		okBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				apply();
			}
		});
		okBtn.setBounds(464, 343, 60, 23);
		getContentPane().add(okBtn);
		
		WaveMsgButton closeBtn = new WaveMsgButton("CLOSE");
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
		closeBtn.setBounds(536, 343, 60, 23);
		getContentPane().add(closeBtn);
		/* *************************************************************
		 * 버튼 끝
		 * *************************************************************/
	}


	@Override
	public void close() {
		this.dispose();
	}
	
	/**
	 * 설정한 생상을 반환한다.
	 * 
	 * @return 색상
	 */
	public Color getSettingColor() {
		return colorChooser.getColor();
	}
	
	/**
	 * 확인 버튼을 통한 데이터 적용
	 */
	public void apply() {
		frame.setFrameColor();
		close();
	}

	@Override
	public void callBackData() throws WaveMsgException {
		// 로컬에서만 동작하기에 따로 구현할 필요 없다.
	}
	
	public static void main(String[] s) throws WaveMsgException {
		WaveMsgColorChooser ss = new WaveMsgColorChooser(new WaveMsgFontInterface() {
			
			@Override
			public void setFrameFont() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setFrameColor() {
				// TODO Auto-generated method stub
				
			}
		}, new Color(49, 32, 198));
		ss.setVisible(true);
	}
}
