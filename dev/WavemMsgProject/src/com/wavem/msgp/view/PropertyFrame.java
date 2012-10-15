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
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.comm.CommSet;
import com.wavem.msgp.comm.PropertiesInfo;
import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgCheckBox;
import com.wavem.msgp.component.WaveMsgComboBox;
import com.wavem.msgp.component.WaveMsgDialogBox;
import com.wavem.msgp.component.WaveMsgException;
import com.wavem.msgp.component.WaveMsgFontInterface;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.component.WaveMsgLabel;
import com.wavem.msgp.component.WaveMsgRadioButton;
import com.wavem.msgp.component.WaveMsgSpinner;
import com.wavem.msgp.component.WaveMsgTextField;

/**
 * 환경설정 화면
 * 
 * <pre>
 * 	PropertyFrame propertyFrame = new PropertyFrame();
 * </pre>
 * 
 * @author 
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class PropertyFrame extends WaveMsgFrame implements WaveMsgFontInterface {
	
	private static final long serialVersionUID = 8935617435151137888L;
	
	/** 환경설정 인스턴스 변수 */
	private PropertiesInfo properties = null;

	/** 환경설정 화면 인스턴스 변수 */
	private static PropertyFrame frame = null;

	/** 타이틀 */
	private String title = CommMsg.PROPERTY_FRAME_TITLE;
	
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
	
	/** 대화 저장 여부 */
	private WaveMsgCheckBox chatSaveState = null;
	
	/** 대화 내역 저장 경로 */
	private WaveMsgTextField chatSavePathTxt = null;
	
	/** 대화 저장 버튼 */
	private WaveMsgButton chatSavePathFind = null;
	
	/** 테마 기본설정 */
	private WaveMsgRadioButton defaultSettingTheme = null;
	
	/** 테마 사용자설정*/
	private WaveMsgRadioButton userSettingTheme = null;
	
	/** 테마 사용자설정 경로*/
	private WaveMsgTextField themeUserSetPathTxt = null;
	
	/** 사용자 테마 경로선택 버튼 */
	private WaveMsgButton themeUserBtn = null;
	
	/** 기본 이미지 선택 콤보 */
	private WaveMsgComboBox defaultThemeList = null;
	
	/** 폰트 미리보기 */
	private JEditorPane dtrpnHello = null;
	
	/** 폰트 및 컬러 설정 프레임 */
	private WaveMsgFontFrame fontFrame = null;
	private WaveMsgColorChooser colorFrame = null;
	
	/** 알림음 선택 */
	private WaveMsgCheckBox alarmChkBox = null;
	private JTextField alarmPathTxt = null;
	private WaveMsgButton alarmFindBtn = null;
	
	//private File themeImgFile = new File(PropertyFrame.class.getResource("/com/wavem/resource/img/profile/").getPath());
	private File themeImgFile = new File(CommSet.getOriBackImgPath());
	
	//******************************************************
	// 환경설정 데이터 저장 변수
	//******************************************************
	/** 쪽지 자동팝업 설정 */
	private boolean msgAutoPopUpFlag = true;
	
	/** 자동 부재중 설정 */
	private boolean autoStatusChangeFlag = true;
	
	/** 자동 부재중 설정시 동작 시간 (분) */
	private int autoStatusChangeLimite = 5;
	
	/** 더블 클릭 시 설정 (채팅, 쪽지) */
	private String doubleClickOperate = "";
	
	/** 파일 다운로드 기본 경로 */
	private String fileDownPath = "";
	
	/** 채팅 대화 내역 저장 설정 */
	private boolean chatSaveFlag = false;
	
	/** 대화 저장 경로 */
	private String chatSavePath = "";
	
	/** 테마 설정 (기본배경, 사용자설정) */
	private boolean themeFlag = false;
	
	/** 배경 이미지 이름 */
	private String themeName = "";
	
	/** 배경 이미지 확장자 */
	private String themeExtension = "";
	
	/** 배경 이미지 경로 */
	private String themePath = "";
	
	/** 폰트 */
	private String font = "굴림";
	private int fontStyle = Font.BOLD;
	private int fontSize = 12;
	
	
	/** 색상 */
	private Color color = null;
	
	/** 알림음 설정 */
	private boolean alarmFlag = true;
	
	/** 알림음 경로 */
	private String alarmPath = "";
	
	/** 서버 IP */
	private String host = "localhost";
	
	/** 서버 PORT */
	private int port = 9090; 
	//******************************************************
	// 환경설정 데이터 저장 변수
	//******************************************************
	
	
	
	
	/**
	 * 환경설정 화면 생성자 <br>
	 * 최초 환경설정 관련 인스턴스 획득 <br>
	 * 최초 makeInitFrame() 호출 <br>
	 * @throws WaveMsgException 
	 */
	private PropertyFrame() throws WaveMsgException {
		super();
		this.properties = PropertiesInfo.getInstance();
		
		makeInitFrame();
	}
	
	/**
	 * 환경설정 화면을 위한 인스턴스 반환
	 * 
	 * @return 환경설정 화면을 위한 화면 인스턴스
	 * @throws WaveMsgException 
	 */
	public static PropertyFrame getInstance() throws WaveMsgException {
		
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
	public void makeInitFrame() throws WaveMsgException {

		// 환경설정창에서 데이터 로딩
		loadPropertyInfo();
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 416, 760);
		setTitle(this.title);
		setDefaultCloseOperation(WaveMsgFrame.DISPOSE_ON_CLOSE);
		
		/* *********************************************************
		 * 기본 설정 시작
		 * *********************************************************/
		WaveMsgLabel defaultSettinglbl = new WaveMsgLabel("기본설정");
		defaultSettinglbl.setBounds(12, 10, 376, 15);
		getContentPane().add(defaultSettinglbl);
		
		// 쪽지 자동팝업 설정 체크 박스
		msgAutoPop = new WaveMsgCheckBox("쪽지 자동 팝업");
		msgAutoPop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectMsgAutPop();
			}
		});
		msgAutoPop.setBackground(Color.WHITE);
		msgAutoPop.setBounds(22, 31, 227, 23);
		msgAutoPop.setSelected(msgAutoPopUpFlag); // 쪽지 자동 팝업 설정
		getContentPane().add(msgAutoPop);
		
		// 자동 부재중 설정 체크 박스
		autoOut = new WaveMsgCheckBox("자동 부재중");
		autoOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectAutoOut();
			}
		});
		autoOut.setBackground(Color.WHITE);
		autoOut.setBounds(22, 56, 115, 23);
		autoOut.setSelected(autoStatusChangeFlag); // 자동 부재중 설정
		getContentPane().add(autoOut);
		
		// 분 설정
		spinner = new WaveMsgSpinner();
		spinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				changeSpinner();
			}
		});
		spinner.setBounds(145, 57, 40, 22);
		spinner.setValue(autoStatusChangeLimite);
		getContentPane().add(spinner);
		
		if (!autoStatusChangeFlag) spinner.setEnabled(false); // 자동 부재중 선택 안되어있을 시 분 선택 비활성화

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
				selectDblClickSet(e);
			}
		});
		dblClickSet.setBounds(113, 97, 72, 21);
		dblClickSet.setSelectedItem(doubleClickOperate);
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
		fileSavePathTxt.setColumns(10);
		fileSavePathTxt.setText(fileDownPath);
		getContentPane().add(fileSavePathTxt);
		
		// 파일 저장 경로 설정
		WaveMsgButton fileSavePathFind = new WaveMsgButton("FIND");
		fileSavePathFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectPath("file", fileDownPath);
			}
		});
		fileSavePathFind.setBounds(328, 161, 60, 21);
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
		
		chatSaveState = new WaveMsgCheckBox("저장 안함");
		chatSaveState.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectChatSaveState();
			}
		});
		chatSaveState.setBackground(Color.WHITE);
		chatSaveState.setBounds(22, 223, 115, 23);
		chatSaveState.setSelected(chatSaveFlag);
		getContentPane().add(chatSaveState);
		
		WaveMsgLabel chatSavePathnm = new WaveMsgLabel("저장 경로");
		chatSavePathnm.setBounds(22, 252, 72, 15);
		getContentPane().add(chatSavePathnm);
		
		chatSavePathTxt = new WaveMsgTextField();
		chatSavePathTxt.setColumns(10);
		chatSavePathTxt.setBounds(85, 249, 231, 21);
		chatSavePathTxt.setText(chatSavePath);
		getContentPane().add(chatSavePathTxt);
		
		chatSavePathFind = new WaveMsgButton("FIND");
		chatSavePathFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectPath("chat", chatSavePath);
			}
		});
		chatSavePathFind.setBounds(328, 250, 60, 21);
		getContentPane().add(chatSavePathFind);
		
		// 만약 대화 저장 선택이 안되어있을 시 
		// 저장 경로 텍스트 필드와 찾기 버튼 비활성화
		if (!chatSaveFlag) {
			chatSavePathTxt.setEnabled(false);
			chatSavePathFind.setEnabled(false);
		}
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
		defaultSettingTheme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectSettingTheme();
			}
		});
		defaultSettingTheme.setBackground(Color.WHITE);
		defaultSettingTheme.setBounds(22, 312, 121, 23);
		defaultSettingTheme.setSelected(this.themeFlag);
		getContentPane().add(defaultSettingTheme);
		
		WaveMsgLabel themeDefaultLbl = new WaveMsgLabel("기본");
		themeDefaultLbl.setBounds(64, 343, 30, 15);
		getContentPane().add(themeDefaultLbl);
		
		defaultThemeList = new WaveMsgComboBox();
		defaultThemeList.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				selectThemeList(event);
			}
		});
		defaultThemeList.setBounds(113, 341, 136, 21);
		getContentPane().add(defaultThemeList);
		
		userSettingTheme = new WaveMsgRadioButton("사용자 설정");
		userSettingTheme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectSettingTheme();
			}
		});
		userSettingTheme.setBackground(Color.WHITE);
		userSettingTheme.setBounds(22, 364, 121, 23);
		userSettingTheme.setSelected(!this.themeFlag);
		getContentPane().add(userSettingTheme);
		
		themeUserSetPathTxt = new WaveMsgTextField();
		themeUserSetPathTxt.setColumns(10);
		themeUserSetPathTxt.setBounds(85, 393, 231, 21);
		themeUserSetPathTxt.setText(themePath);
		getContentPane().add(themeUserSetPathTxt);
		
		themeUserBtn = new WaveMsgButton("FIND");
		themeUserBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectPath("theme", themePath);
			}
		});
		themeUserBtn.setBounds(328, 394, 60, 21);
		getContentPane().add(themeUserBtn);
		
		ButtonGroup group = new ButtonGroup();
		group.add(defaultSettingTheme);
		group.add(userSettingTheme);
		
		// 기본 설정 콤보 세팅 시작
		String[] fileList = themeImgFile.list();
		
		for (int i=0; i<fileList.length; i++) {
			defaultThemeList.addItem(fileList[i].replace(".png", "")); // 확장자를 제외한 파일 이름만 리스트에 등록
		}
		
		if (this.themeFlag) {
			defaultThemeList.setSelectedItem(themeName);// 콤보 선택
		}
		
		selectSettingTheme(); // 테마 설정 세팅
		/* *********************************************************
		 * 테마 설정 끝
		 * *********************************************************/
		
		
		
		/* *********************************************************
		 * 폰트 설정 시작
		 * *********************************************************/
		WaveMsgLabel fontLbl = new WaveMsgLabel("폰트");
		fontLbl.setBounds(12, 432, 57, 15);
		getContentPane().add(fontLbl);
		
		WaveMsgButton fontSetBtn = new WaveMsgButton("SETTING");
		fontSetBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				makeFontFrame();
			}
		});
		fontSetBtn.setBounds(62, 428, 60, 21);
		getContentPane().add(fontSetBtn);
		/* *********************************************************
		 * 폰트 설정 끝
		 * *********************************************************/
		
		/* *********************************************************
		 * 색상 설정 시작
		 * *********************************************************/
		WaveMsgLabel colorLbl = new WaveMsgLabel("색상");
		colorLbl.setBounds(12, 482, 57, 15);
		getContentPane().add(colorLbl);
		
		WaveMsgButton colorSetBtn = new WaveMsgButton("SETTING");
		colorSetBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				makeColorFrame();
			}
		});
		colorSetBtn.setBounds(62, 478, 60, 21);
		getContentPane().add(colorSetBtn);
		/* *********************************************************
		 * 색상 설정 끝
		 * *********************************************************/
		
		
		/* *********************************************************
		 * 미리보기 시작
		 * *********************************************************/		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBackground(Color.WHITE);
		panel.setBounds(134, 437, 150, 60);
		getContentPane().add(panel);
		
		dtrpnHello = new JEditorPane();
		dtrpnHello.setText("1. Hello\r\n2. 안녕하세요");
		panel.add(dtrpnHello);
		
		dtrpnHello.setFont(new Font(font, fontStyle, fontSize));
		dtrpnHello.setForeground(this.color);
		/* *********************************************************
		 * 미리보기 끝
		 * *********************************************************/
		
		
		/* *********************************************************
		 * 알림음 시작
		 * *********************************************************/
		WaveMsgLabel alarmLbl = new WaveMsgLabel("알림음");
		alarmLbl.setBounds(12, 530, 57, 15);
		getContentPane().add(alarmLbl);
		
		alarmChkBox = new WaveMsgCheckBox("알림음 없음");
		alarmChkBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectAlarmChkBox();
			}
		});
		alarmChkBox.setBackground(Color.WHITE);
		alarmChkBox.setBounds(22, 551, 115, 23);
		getContentPane().add(alarmChkBox);
		
		WaveMsgLabel alarmPathLbl = new WaveMsgLabel("알림음 경로");
		alarmPathLbl.setBounds(32, 581, 89, 15);
		getContentPane().add(alarmPathLbl);
		
		alarmPathTxt = new JTextField();
		alarmPathTxt.setBounds(113, 580, 203, 21);
		alarmPathTxt.setColumns(10);
		alarmPathTxt.setText(alarmPath);
		getContentPane().add(alarmPathTxt);
		
		alarmFindBtn = new WaveMsgButton();
		alarmFindBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectPath("alarm", alarmPath);
			}
		});
		alarmFindBtn.setIcon(new ImageIcon(PropertyFrame.class.getResource("/com/wavem/resource/img/button/FIND.png")));
		alarmFindBtn.setBounds(328, 580, 60, 21);
		getContentPane().add(alarmFindBtn);
		
		selectAlarmChkBox(); // 초기 알림음 세팅
		/* *********************************************************
		 * 알림음 끝
		 * *********************************************************/

		
		WaveMsgButton saveBtn = new WaveMsgButton("SAVE");
		saveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				savePropertyInfo();
			}
		});
		saveBtn.setBounds(256, 636, 60, 23);
		getContentPane().add(saveBtn);
		
		WaveMsgButton closeBtn = new WaveMsgButton("CLOSE");
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
		closeBtn.setBounds(328, 636, 60, 23);
		getContentPane().add(closeBtn);
		
		
		
		
		
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
		 * 환경설정 데이터 로딩 시작
		 * **********************************************/
		this.msgAutoPopUpFlag = properties.isMsgAutoPopUpFlag(); // 쪽지 자동 팝업 설정
		this.autoStatusChangeFlag = properties.isAutoStatusChangeFlag(); // 자동 부재중 설정
		this.autoStatusChangeLimite = properties.getAutoStatusChangeLimite(); // 자동 부재중 설정시 동작 시간
		this.doubleClickOperate = properties.getDoubleClickOperate(); // 더블 클릭 시 설정 (쪽지, 채팅)
		this.fileDownPath = properties.getFileDownPath(); // 파일 다운로드 기본 경로
		this.chatSaveFlag = properties.isChatSaveFlag(); // 채팅 대화 내역 저장 설정
		this.chatSavePath = properties.getChatSavePath(); // 대화 저장 경로
		this.themeFlag = properties.isThemeFlag(); // 테마 설정
		this.themeName = properties.getThemeName(); // 배경 이미지 이름
		this.themeExtension = properties.getThemeExtension(); // 배경 이미지 확장자
		this.themePath = properties.getThemePath(); // 배경 이미지 경로
		this.font = properties.getFont(); // 폰트
		this.fontStyle = properties.getFontStyle(); // 폰트 스타일
		this.fontSize = properties.getFontSize(); // 폰트 사이즈
		this.color = properties.getColor(); //  폰트 색상
		this.alarmFlag = properties.isAlarmFlag(); // 알림음 설정
		this.alarmPath = properties.getAlarmPath(); // 알림음 경로
		this.host = properties.getHost(); // 서버 주소
		this.port = properties.getPort(); // 서버 포트
		/* **********************************************
		 * 환경설정 데이터 로딩 끝
		 * **********************************************/
	}

	/**
	 * 환경설정 저장 (로컬)
	 */
	public void savePropertyInfo() {
		
		// 저장 할 것인지 질문 메시지
		WaveMsgDialogBox confirm = new WaveMsgDialogBox(this, this.title, CommMsg.SAVE_Q_MSG, JOptionPane.OK_CANCEL_OPTION);
		
		if (confirm.getResult() > 0) { // 저장 취소
			return;
		}
		
		/* **********************************************
		 * 환경설정 데이터 저장 시작
		 * **********************************************/
		properties.setMsgAutoPopUpFlag(this.msgAutoPopUpFlag); // 쪽지 자동 팝업 설정
		properties.setAutoStatusChangeFlag(this.autoStatusChangeFlag); // 자동 부재중 설정
		properties.setAutoStatusChangeLimite(this.autoStatusChangeLimite); // 자동 부재중 설정시 동작 시간
		properties.setDoubleClickOperate(this.doubleClickOperate); // 더블 클릭 시 설정 (쪽지, 채팅)
		properties.setFileDownPath(this.fileDownPath); // 파일 다운로드 기본 경로
		properties.setChatSaveFlag(this.chatSaveFlag); // 채팅 대화 내역 저장 설정
		properties.setChatSavePath(this.chatSavePath); // 대화 저장 경로
		properties.setThemeFlag(this.themeFlag); // 테마 설정
		properties.setThemeName(this.themeName); // 배경 이미지 이름
		properties.setThemeExtension(this.themeExtension); // 배경 이미지 확장자
		properties.setThemePath(this.themePath); // 배경 이미지 경로
		properties.setFont(this.font); // 폰트
		properties.setFontStyle(this.fontStyle); // 폰트 스타일
		properties.setFontSize(this.fontSize); // 폰트 사이즈
		properties.setColor(this.color); //  폰트 색상
		properties.setAlarmFlag(this.alarmFlag); // 알림음 설정
		properties.setAlarmPath(this.alarmPath); // 알림음 경로
		properties.setHost(this.host); // 서버 주소
		properties.setPort(this.port); // 서버 포트
		/* **********************************************
		 * 환경설정 데이터 저장 끝
		 * **********************************************/
		System.out.println(properties.getAutoStatusChangeLimite());
		
		try {
			properties.savePropertiesFile();
			new WaveMsgDialogBox(this.title, CommMsg.SAVE_MSG, JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
			new WaveMsgDialogBox(this.title, CommMsg.NOT_SAVE_MSG, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * 폰트 설정 화면 
	 */
	public void makeFontFrame() {
		try {
			fontFrame = new WaveMsgFontFrame(this, this.font, this.fontStyle, this.fontSize);
			fontFrame.setVisible(true);
		} catch (WaveMsgException e) {
			e.printStackTrace();
			new WaveMsgDialogBox(this.title, CommMsg.LOAD_FRAME_ERROR, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * 색상 설정 화면
	 */
	public void makeColorFrame() {
		try {
			colorFrame = new WaveMsgColorChooser(this, this.color);
			colorFrame.setVisible(true);
		} catch (WaveMsgException e) {
			e.printStackTrace();
			new WaveMsgDialogBox(this.title, CommMsg.LOAD_FRAME_ERROR, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void setFrameFont() {
		
		// 폰트 설정창에서 데이터 로드
		this.font = fontFrame.getFontPreview(); // 폰트 
		this.fontStyle = fontFrame.getStylePreview(); // 폰트 스타일
		this.fontSize = fontFrame.getSizePreview(); // 폰트 사이즈
		
		// 미리보기 화면에 폰트 설정
		dtrpnHello.setFont(new Font(this.font, this.fontStyle, this.fontSize));
	}
	
	@Override
	public void setFrameColor() {
		
		// 색상 설정
		this.color = colorFrame.getSettingColor();
		
		// 미리보기 화면에 색상 설정
		dtrpnHello.setForeground(this.color);
	}
	
	/**
	 * 경로 탐색 메서드
	 * 
	 * @param ch 선택 구분
	 * @param path 기존 설정된 파일 경로
	 */
	public void selectPath(String ch, String path) {
		
		if (path.length() == 0) path = ".";
		
		// 파일찾기 화면 실행
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(path));
		
		if (ch.equals("file")) { // 파일 다운로드 경로 지정
			
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // 디렉터리만 선택할수 있도록 설정
			int returnVal = fileChooser.showSaveDialog(this); // 파일 경로 선택
			
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				path = fileChooser.getSelectedFile().getAbsolutePath();
				fileSavePathTxt.setText(path);
				
				this.fileDownPath = path; // 파일 다운로드 경로 수정
			}
			
		} else if (ch.equals("chat")) { // 채팅 내역 저장 경로 지정
			
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // 디렉터리만 선택할수 있도록 설정
			int returnVal = fileChooser.showSaveDialog(this); // 파일 경로 선택
			
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				path = fileChooser.getSelectedFile().getAbsolutePath();
				chatSavePathTxt.setText(path);
				
				this.chatSavePath = path; // 패팅내역 저장 경로 수정
			}
			
		} else if (ch.equals("theme")) { // 배경 화면 이미지 선택
			
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // 디렉터리만 선택할수 있도록 설정

			// 이미지만 선택할 수 있도록 필터 적용
			FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & PNG", "png", "jpg");
			fileChooser.setFileFilter(imgFilter);
			
			// 파일 경로 선택
			int returnVal = fileChooser.showSaveDialog(this);

			// 파일선택 후 이미지 세팅
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				
				path = fileChooser.getSelectedFile().getAbsolutePath(); // 선택한 이미지의 절대경로
				themeUserSetPathTxt.setText(path); // 경로 세팅
				
				File imgFile = new File(path);
				
				if (!imgFile.exists()) { // 선택한 파일이 없는경우..
					new WaveMsgDialogBox(this.title, CommMsg.NOT_EXSIST_IMG, JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				this.themeName = imgFile.getName(); // 이미지 이름
				this.themeExtension = ""; // 이미지 확장자
				
				// 이미지 이름에 확장자가 있는 경우 확장자 분리하여 세팅
				int index = this.themeName.indexOf(".");
				if (index > 0) {
					this.themeName = imgFile.getName().substring(0, index);
					this.themeExtension = imgFile.getName().substring(index+1);
				}
				
				this.themePath = path; // 이미지 경로 
			}
			
		} else if (ch.equals("alarm")) { // 알림음 선택
			
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // 디렉터리만 선택할수 있도록 설정
			int returnVal = fileChooser.showSaveDialog(this);// 파일 경로 선택
			
			// 파일선택 후 이미지를 프로필 사진으로 세팅
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				path = fileChooser.getSelectedFile().getAbsolutePath();
				alarmPathTxt.setText(path);
				
				this.alarmPath = path; // 알림음 경로 수정
			}
		}
		
	}
	
	/**
	 * 쪽지 자동 팝업 선택
	 */
	public void selectMsgAutPop() {
		this.msgAutoPopUpFlag = msgAutoPop.isSelected();
		System.out.println("쪽지 자동 팝업 : " + this.msgAutoPopUpFlag);
	}
	
	/**
	 * 자동 부재중 선택
	 */
	public void selectAutoOut() {
		
		this.autoStatusChangeFlag = autoOut.isSelected();
		System.out.println("자동 부재중 : " + this.autoStatusChangeFlag);
		
		// 선택 상태에 따라서 분 설정 활정화 결정
		if (autoStatusChangeFlag) {
			spinner.setEnabled(true);
		} else {
			spinner.setEnabled(false);
		}
		
	}
	
	/**
	 * 분 설정
	 */
	public void changeSpinner() {
		this.autoStatusChangeLimite = Integer.parseInt(spinner.getValue().toString());
		System.out.println("분설정 : " + this.autoStatusChangeLimite);
	}
	
	/**
	 * 더블클릭 설정 
	 */
	public void selectDblClickSet(ItemEvent event) {
		this.doubleClickOperate = event.getItem().toString();
	}
	
	/**
	 * 대화 저장 여부
	 */
	public void selectChatSaveState() {
		
		this.chatSaveFlag = chatSaveState.isSelected();
		System.out.println("대화저장 : " + this.chatSaveFlag);
		
		if (this.chatSaveFlag) {
			chatSavePathTxt.setEnabled(true); // 경로 텍스트 필드 활성화
			chatSavePathFind.setEnabled(true); // 경로 찾기 버튼 활성화
		} else {
			chatSavePathTxt.setEnabled(false); // 경로 텍스트 필드 비활성화
			chatSavePathFind.setEnabled(false); // 경로 찾기 버튼 비활성화
		}
	}
	
	/**
	 * 테마 선택 여부
	 */
	public void selectSettingTheme() {
		this.themeFlag = defaultSettingTheme.isSelected();
		System.out.println("테마 선택 : " + this.themeFlag);
		
		// 테마 선택 여부
		if (this.themeFlag) { // 기본 테마 선택
		
			defaultThemeList.setEnabled(true); // 기본 선택 콤보 활성화
			themeUserSetPathTxt.setEnabled(false); // 사용자 선택 경로 비활성화
			themeUserBtn.setEnabled(false); // 사용자 경로 찾기 버튼 비활성화
			
			// 콤보에 들어가 있는 기본 이미지 경로
			this.themeName = defaultThemeList.getSelectedItem().toString();
			this.themePath = themeImgFile.getAbsolutePath() + "\\" + this.themeName + ".png";

		} else { // 사용자 선택
			
			defaultThemeList.setEnabled(false); // 기본 선택 콤보 비활성화
			themeUserSetPathTxt.setEnabled(true); // 사용자 선택 경로 활성화
			themeUserBtn.setEnabled(true); // 사용자 경로 찾기 버튼 활성화
			
			String path = themeUserSetPathTxt.getText();
			
			File imgFile = new File(path);
			
			if (!imgFile.exists()) { // 선택한 파일이 없는경우..
				new WaveMsgDialogBox(this.title, CommMsg.NOT_EXSIST_IMG, JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			this.themeName = imgFile.getName(); // 이미지 이름
			this.themeExtension = ""; // 이미지 확장자
			
			// 이미지 이름에 확장자가 있는 경우 확장자 분리하여 세팅
			int index = this.themeName.indexOf(".");
			if (index > 0) {
				this.themeName = imgFile.getName().substring(0, index);
				this.themeExtension = imgFile.getName().substring(index+1);
			}
			
			this.themePath = path; // 이미지 경로 
			
			
			/*
			if (path.length() > 0) { // 설정된 경로가 있는 경우 세팅
				name = path.substring(path.lastIndexOf("\\")+1, path.lastIndexOf("."));
			}
			
			this.themeName = name;
			this.themePath = path;
			*/
		}
		
		System.out.println("테마 이미지 이름 : " + this.themeName);
		System.out.println("테마 이미지 경로 : " + this.themePath);
	}
	
	/**
	 * 테마설정 기본 설정 콤보 선택
	 */
	public void selectThemeList(ItemEvent event) {
	
		// 콤보에 들어가 있는 기본 이미지 경로
		
		if (event.getStateChange() == ItemEvent.SELECTED) {
			this.themeName = event.getItem().toString();
			this.themePath = themeImgFile.getAbsolutePath() + "\\" + this.themeName + ".png";
		}
		
		System.out.println("테마 이미지 이름 : " + this.themeName);
		System.out.println("테마 이미지 경로 : " + this.themePath);
		
	}
	
	/**
	 * 알림음 선택
	 */
	public void selectAlarmChkBox() {
		this.alarmFlag = alarmChkBox.isSelected();
		System.out.println("알림음 선택 : " + this.alarmFlag);
		
		// 알림음 선택에 따른 활성화
		if (this.alarmFlag) { 
			alarmPathTxt.setEnabled(false); // 알림음 경로 비활성화
			alarmFindBtn.setEnabled(false); // 알림음 찾기 버튼 비활성화
		} else {
			alarmPathTxt.setEnabled(true); // 알림음 경로 활성화
			alarmFindBtn.setEnabled(true); // 알림음 찾기 버튼 비활성화
		}
	}
	
	@Override
	public void callBackData() throws WaveMsgException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] sdf) throws WaveMsgException {
		PropertyFrame frame = PropertyFrame.getInstance();
		frame.setVisible(true);
	}

}
