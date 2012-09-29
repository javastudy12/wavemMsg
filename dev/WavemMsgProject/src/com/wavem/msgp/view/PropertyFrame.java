/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : PropertyFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

import com.wavem.msgp.comm.PropertiesInfo;
import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgCheckBox;
import com.wavem.msgp.component.WaveMsgComboBox;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.component.WaveMsgLabel;
import com.wavem.msgp.component.WaveMsgRadioButton;
import com.wavem.msgp.component.WaveMsgSpinner;
import com.wavem.msgp.component.WaveMsgTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

/**
 * 환경설정 화면
 * 
 * <pre>
 * 	PropertyFrame propertyFrame = new PropertyFrame();
 * </pre>
 * 
 * @author 
 *
 */
public class PropertyFrame extends WaveMsgFrame {
	
	private static final long serialVersionUID = 8935617435151137888L;
	
	/** 환경설정 인스턴스 변수 */
	private PropertiesInfo properties = null;

	/** 환경설정 화면 인스턴스 변수 */
	private static PropertyFrame frame = null;
	
	/** 쪽지 자동 팝업 */
	private WaveMsgCheckBox msgAutoPop = null;
	
	/** 자동 부재중 */
	private WaveMsgCheckBox autoOut = null;
	
	/** 자동부재중 분 설정 */
	private WaveMsgSpinner spinner = null;
	
	/** 더블클릭 시 */
	private WaveMsgComboBox dblClickSet = null;
	
	/** 파일 다운로드 경로 */
	private WaveMsgTextField fileSavePathTxt = null;
	
	/** 대화 내역 저장 경로 */
	private WaveMsgTextField chatSavePathTxt = null;
	
	/** 테마 기본설정 */
	private WaveMsgRadioButton defaultSettingTheme = null;
	
	/** 테마 사용자설정*/
	private WaveMsgRadioButton userSettingTheme = null;
	
	/** 테마 사용자설정 경로*/
	private WaveMsgTextField themeUserSetPathTxt = null;
	
	/** 기본 이미지 선택 콤보 */
	private WaveMsgComboBox defaultThemeList = null;
	
	
	
	/**
	 * 환경설정 화면 생성자 <br>
	 * 최초 환경설정 관련 인스턴스 획득 <br>
	 * 최초 makeInitFrame() 호출 <br>
	 */
	private PropertyFrame() {
		getContentPane().setBackground(Color.WHITE);
		this.properties = PropertiesInfo.getInstance();
		makeInitFrame();
	}
	
	/**
	 * 환경설정 화면을 위한 인스턴스 반환
	 * 
	 * @return 환경설정 화면을 위한 화면 인스턴스
	 */
	public static PropertyFrame getInstance() {
		
		if (frame == null) {
			synchronized (PropertyFrame.class) {
				if (frame == null) {
					frame = new PropertyFrame();
				}
			}
		}
		
		return frame;
	}
	
	@Override
	public void makeInitFrame() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 416, 510);
		
		/* *********************************************************
		 * 기본 설정 시작
		 * *********************************************************/
		WaveMsgLabel defaultSettinglbl = new WaveMsgLabel("기본설정");
		defaultSettinglbl.setBounds(12, 10, 376, 15);
		getContentPane().add(defaultSettinglbl);
		
		// 쪽지 자동팝업 설정 체크 박스
		msgAutoPop = new WaveMsgCheckBox("쪽지 자동 팝업");
		msgAutoPop.setBackground(Color.WHITE);
		msgAutoPop.setBounds(22, 31, 227, 23);
		getContentPane().add(msgAutoPop);
		
		// 자동 부재중 설정 체크 박스
		autoOut = new WaveMsgCheckBox("자동 부재중");
		autoOut.setBackground(Color.WHITE);
		autoOut.setBounds(22, 56, 115, 23);
		getContentPane().add(autoOut);
		
		// 분 설정
		spinner = new WaveMsgSpinner();
		spinner.setBounds(145, 57, 40, 22);
		getContentPane().add(spinner);
		
		WaveMsgLabel mlabel = new WaveMsgLabel("분");
		mlabel.setBounds(192, 60, 57, 15);
		getContentPane().add(mlabel);
		
		
		/* *********************************************************
		 * 기본 설정 끝
		 * *********************************************************/
		
		
		/* *********************************************************
		 * 더블클릭 설정 시작
		 * *********************************************************/
		WaveMsgLabel dblclickLbl = new WaveMsgLabel("더블클릭 설정");
		dblclickLbl.setBounds(12, 100, 89, 15);
		getContentPane().add(dblclickLbl);
		
		String[] dblMenu = {"쪽지", "채팅"};
		dblClickSet = new WaveMsgComboBox(dblMenu);
		dblClickSet.setBackground(Color.WHITE);
		dblClickSet.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				
			}
		});
		dblClickSet.setBounds(113, 97, 72, 21);
		getContentPane().add(dblClickSet);
		
		/* *********************************************************
		 * 더블클릭 설정 끝
		 * *********************************************************/
		
		
		/* *********************************************************
		 * 파일 다운로드 경로 설정 시작
		 * *********************************************************/
		WaveMsgLabel fileDownPathLbl = new WaveMsgLabel("더블클릭 설정");
		fileDownPathLbl.setText("파일 다운로드 경로");
		fileDownPathLbl.setBounds(12, 138, 145, 15);
		getContentPane().add(fileDownPathLbl);
		
		WaveMsgLabel fileSavePathLblnm = new WaveMsgLabel("저장 경로");
		fileSavePathLblnm.setBounds(22, 163, 72, 15);
		getContentPane().add(fileSavePathLblnm);
		
		// 파일경로 
		fileSavePathTxt = new WaveMsgTextField();
		fileSavePathTxt.setBounds(85, 160, 231, 21);
		getContentPane().add(fileSavePathTxt);
		fileSavePathTxt.setColumns(10);
		
		// 파일 저장 경로 설정
		WaveMsgButton fileSavePathFind = new WaveMsgButton("FIND");
		fileSavePathFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectPath("file");
			}
		});
		fileSavePathFind.setBounds(328, 160, 60, 21);
		getContentPane().add(fileSavePathFind);
		
		/* *********************************************************
		 * 파일 다운로드 경로 설정 끝
		 * *********************************************************/
		
		
		/* *********************************************************
		 * 대화 설정 시작
		 * *********************************************************/
		WaveMsgLabel chatSavePathLbl = new WaveMsgLabel("대화 설정");
		chatSavePathLbl.setBounds(12, 202, 145, 15);
		getContentPane().add(chatSavePathLbl);
		
		JCheckBox chatSaveState = new JCheckBox("저장 안함");
		chatSaveState.setBackground(Color.WHITE);
		chatSaveState.setBounds(22, 223, 115, 23);
		getContentPane().add(chatSaveState);
		
		WaveMsgLabel chatSavePathnm = new WaveMsgLabel("저장 경로");
		chatSavePathnm.setBounds(22, 252, 72, 15);
		getContentPane().add(chatSavePathnm);
		
		chatSavePathTxt = new WaveMsgTextField();
		chatSavePathTxt.setColumns(10);
		chatSavePathTxt.setBounds(85, 249, 231, 21);
		getContentPane().add(chatSavePathTxt);
		
		WaveMsgButton chatSavePathFind = new WaveMsgButton("FIND");
		chatSavePathFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectPath("chat");
			}
		});
		chatSavePathFind.setBounds(328, 249, 60, 21);
		getContentPane().add(chatSavePathFind);
		
		
		/* *********************************************************
		 * 대화 설정 끝
		 * *********************************************************/
		
		
		/* *********************************************************
		 * 테마 설정 시작
		 * *********************************************************/
		WaveMsgLabel waveMsgLabel = new WaveMsgLabel("테마 설정");
		waveMsgLabel.setBounds(12, 291, 145, 15);
		getContentPane().add(waveMsgLabel);
		
		defaultSettingTheme = new WaveMsgRadioButton("기본 설정");
		defaultSettingTheme.setBackground(Color.WHITE);
		defaultSettingTheme.setBounds(22, 312, 121, 23);
		getContentPane().add(defaultSettingTheme);
		
		WaveMsgLabel themeDefaultLbl = new WaveMsgLabel("기본");
		themeDefaultLbl.setBounds(64, 343, 30, 15);
		getContentPane().add(themeDefaultLbl);
		
		defaultThemeList = new WaveMsgComboBox();
		defaultThemeList.setBounds(113, 341, 136, 21);
		getContentPane().add(defaultThemeList);
		
		userSettingTheme = new WaveMsgRadioButton("사용자 설정");
		userSettingTheme.setBackground(Color.WHITE);
		userSettingTheme.setBounds(22, 364, 121, 23);
		getContentPane().add(userSettingTheme);
		
		themeUserSetPathTxt = new WaveMsgTextField();
		themeUserSetPathTxt.setColumns(10);
		themeUserSetPathTxt.setBounds(85, 393, 231, 21);
		getContentPane().add(themeUserSetPathTxt);
		
		WaveMsgButton themeUserBtn = new WaveMsgButton("FIND");
		themeUserBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectPath("theme");
			}
		});
		themeUserBtn.setBounds(328, 393, 60, 21);
		getContentPane().add(themeUserBtn);
		
		ButtonGroup group = new ButtonGroup();
		group.add(defaultSettingTheme);
		group.add(userSettingTheme);
		
		
		
		
		/* *********************************************************
		 * 테마 설정 끝
		 * *********************************************************/
		
		
		loadPropertyInfo();
		
	}

	@Override
	public void close() {
		this.dispose();
	}

	/**
	 * 환경설정 로딩 (로컬)
	 */
	public void loadPropertyInfo() {
		
		/* **********************************************
		 * 기본 설정 콤보 세팅 시작
		 * **********************************************/
		File file = new File(PropertyFrame.class.getResource("/com/wavem/resource/img/profile/").getPath());
		String[] fileList = file.list();
		
		for (int i=0; i<fileList.length; i++) {
			defaultThemeList.addItem(fileList[i].replace(".png", ""));
		}
		
		/* **********************************************
		 * 기본 설정 콤보 세팅 끝
		 * **********************************************/
		
		properties.loadPropertiesFile();

		// 테마 설정
		defaultSettingTheme.setSelected(properties.isThemeFlag());
		userSettingTheme.setSelected(!properties.isThemeFlag());
		
		
	}

	/**
	 * 환경설정 저장 (로컬)
	 */
	public void savePropertyInfo() {
		properties.savePropertiesFile();
	}

	/**
	 * 파일 다운로드 저장 경로 선택
	 */
	public void selectPath(String ch) {
		
		// 파일찾기 화면 실행
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("."));
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // 디렉터리만 선택할수 있도록
		
		// 파일 경로 선택
		int returnVal = fileChooser.showSaveDialog(this);
		
		// 파일선택 후 이미지를 프로필 사진으로 세팅
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			
			if (ch.equals("file")) {
				fileSavePathTxt.setText(fileChooser.getSelectedFile().getAbsolutePath());
			} else if (ch.equals("chat")) {
				chatSavePathTxt.setText(fileChooser.getSelectedFile().getAbsolutePath());
			} else if (ch.equals("theme")) {
				themeUserSetPathTxt.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
		}
	}
	
	@Override
	public void callBackData() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] sdf) {
		PropertyFrame frame = PropertyFrame.getInstance();
		frame.setVisible(true);
	}
}
