/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : BackgroundFrame.java
 * Date       : 2012.09.21
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.comm.CommSet;
import com.wavem.msgp.comm.PropertiesInfo;
import com.wavem.msgp.component.WaveMsgBackImgInterface;
import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgDialogBox;
import com.wavem.msgp.component.WaveMsgException;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.component.WaveMsgList;
import com.wavem.msgp.component.WaveMsgPanel;
import com.wavem.msgp.component.WaveMsgRadioButton;
import com.wavem.msgp.component.WaveMsgScrollPane;
import com.wavem.msgp.component.WaveMsgTextField;
import javax.swing.JPanel;

/**
 * 배경설정을 위한 화면
 * 
 * <pre>
 * 	BackgroundFrame backgroundFrame = new BackgroundFrame();
 * </pre>
 * 
 * @author 
 * @since jdk 1.6
 * @version 1.0
 * @see PropertiesInfo#getInstance()
 */
public class BackgroundFrame extends WaveMsgFrame {

	private static final long serialVersionUID = -2400000915834485391L;
	
	/** 타이틀 */
	private String title = CommMsg.BACKGROUND_FRAME_TITLE;
	
	
	/** 배경 설정을 호출한 채팅 프레임 */
	private WaveMsgBackImgInterface frame = null;
	
	
	/** 환경설정 인스턴스 */
	private PropertiesInfo property = PropertiesInfo.getInstance();
	
	/** 기본 설정 라디오 버튼 */
	private WaveMsgRadioButton defaultRadioBtn = null;

	/** 사용자 설정 라디오 버튼 */
	private WaveMsgRadioButton userRadioBtn = null;
	
	
	/** 기본 설정 리스트 */
	private WaveMsgList defaultList = null;
	
	/** 라디오버튼 그룹 */
	private ButtonGroup imgSetRadioGroup = null;
	
	
	/** 사용자 설정 선택 시 파일 경로 찾기 */
	private WaveMsgButton findBtn = null;
	/** 설정 경로 */
	private WaveMsgTextField userSetPath = null;
	
	
	/** 이미지 미리보기 */
	private WaveMsgPanel previewImg = null;
	
	
	/** 기본 설정에서 사용될 이미지 리스트 */
	private Vector<String> defaultImgList = new Vector<String>();
	private Vector<String> imgExtensionList = new Vector<String>();
	
	
	/** 배경 이미지 경로를 위한 인스턴스 */
	private File imgPath = null;
	
	
	
	/** 채팅 배경 설정 (기본배경, 사용자설정) */
	private boolean chatBackgroundFlag = false;
	
	/** 채팅 배경 이미지 이름 */
	private String chatBackgroundName = "";
	
	/** 채팅 배경 이미지 이름 */
	private String chatBackgroundExtension = "";
	
	/** 채팅 배경 이미지 경로 */
	private String chatBackgroundPath = "";
	
	
	/** 리스트 선택 인덱스 */
	private int selectedImgListIndex = 0;
	
	/**
	 * 배경 설정 화면 생성자 <br>
	 * 최초에 makeInitFrame()호출 <br>
	 * @throws WaveMsgException 
	 * 
	 * @see BackgroundFrame#makeInitFrame()
	 */
	public BackgroundFrame(WaveMsgBackImgInterface frame) throws WaveMsgException {
		this.frame = frame;
		makeInitFrame();
	}
	
	/**
	 * 배경설정을 위한 인스턴스 반환
	 * 
	 * @return 배경설정을 위한 화면 인스턴스
	 * @throws WaveMsgException 
	 */
//	public static BackgroundFrame getInstance() throws WaveMsgException {
//		
//		if (frame == null) {
//			synchronized (BackgroundFrame.class) {
//				if (frame == null) {
//					frame = new BackgroundFrame();
//				}
//			}
//		}
//		
//		return frame;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public void makeInitFrame() throws WaveMsgException {

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 376, 390);
		setTitle(this.title);
		setDefaultCloseOperation(WaveMsgFrame.DISPOSE_ON_CLOSE);
		
		loadBackgroundProperty(); // 설정에서 필요한 데이터 로드
		
		// BASC PANEL
		WaveMsgPanel defaultPane = new WaveMsgPanel();
		defaultPane.setBackground(Color.WHITE);
		defaultPane.setBounds(0, 0, 360, 352);
		defaultPane.setLayout(null);
		getContentPane().add(defaultPane);
		
		// 기본 배경 설정 라디오 버튼
		defaultRadioBtn = new WaveMsgRadioButton("기본 배경");
		defaultRadioBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setImgEnable(defaultRadioBtn.isSelected());
			}
		});
		defaultRadioBtn.setBackground(Color.WHITE);
		defaultRadioBtn.setBounds(8, 18, 121, 23);
		defaultRadioBtn.setSelected(this.chatBackgroundFlag);
		defaultPane.add(defaultRadioBtn);
		
		// 기본 배경 리스트
		defaultList = new WaveMsgList();
		defaultList.setModel(new AbstractListModel() {

			@Override
			public Object getElementAt(int index) {
				return defaultImgList.get(index);
			}

			@Override
			public int getSize() {
				return defaultImgList.size();
			}
		});
		defaultList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(! e.getValueIsAdjusting()) {
					setListImg(e);
				}
			}
		});
		
		// 이미지 목록 스크롤 패널
		WaveMsgScrollPane defaultScrollPane = new WaveMsgScrollPane(defaultList);
		defaultScrollPane.setBounds(12, 47, 138, 143);
		defaultPane.add(defaultScrollPane);
		
		// 사용자 배경 설정 라디오 버튼
		userRadioBtn = new WaveMsgRadioButton("사용자 배경");
		userRadioBtn.setSelected(!this.chatBackgroundFlag);
		userRadioBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setImgEnable(!userRadioBtn.isSelected());
			}
		});
		userRadioBtn.setBackground(Color.WHITE);
		userRadioBtn.setBounds(8, 235, 121, 23);
		defaultPane.add(userRadioBtn);
		
		
		
		
		
		// 라디오 그룹 지정
		imgSetRadioGroup =  new ButtonGroup();
		imgSetRadioGroup.add(defaultRadioBtn);
		imgSetRadioGroup.add(userRadioBtn);
		
		userSetPath = new WaveMsgTextField();
		userSetPath.setEditable(false);
		userSetPath.setBounds(18, 267, 240, 21);
		userSetPath.setColumns(10);
		defaultPane.add(userSetPath);
		
		// 파일 찾기 버튼
		findBtn = new WaveMsgButton("FIND");
		findBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectImgPath();
			}
		});
		findBtn.setBounds(270, 266, 60, 23);
		defaultPane.add(findBtn);
		
		previewImg = new WaveMsgPanel();
		previewImg.setBounds(176, 10, 154, 232);
		defaultPane.add(previewImg);
		
		WaveMsgButton okBtn = new WaveMsgButton("OK");
		okBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saveBackground();
			}
		});
		okBtn.setBounds(198, 319, 60, 23);
		defaultPane.add(okBtn);
		
		WaveMsgButton closeBtn = new WaveMsgButton("CLOSE");
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
		closeBtn.setBounds(270, 319, 60, 23);
		defaultPane.add(closeBtn);
		
		
		// 데이터 세팅
		setLoadedDataToFrame();
//		setDefaultImgEnable(defaultRadioBtn.isSelected()); // 최초 세팅을 위해 호출
		
	}

	@Override
	public void close() {
		this.dispose();
	}
	
	
	
	/**
	 * 환경설정으로부터 현재의 배경화면 설정 로드
	 */
	public void loadBackgroundProperty() {
		
		this.chatBackgroundFlag = property.isChatBackgroundFlag(); 
		this.chatBackgroundName = property.getChatBackgroundName();
		this.chatBackgroundExtension = property.getChatBackgroundExtension();
		this.chatBackgroundPath = property.getChatBackgroundPath();
		
		loadDefaultImgList(); // 기본 설정 이미지 로딩
		
	}
	
	/**
	 * 기본 설정용 이미지를 로딩한다.
	 */
	public void loadDefaultImgList() {
		
		imgPath = new File(CommSet.getOriChatBackImgPath()); // 기본 배경 이미지의 실제 경로
		
		String[] fileList = imgPath.list(); // 이미지 리스트 반환
		
		// 이미지 리스트 생성 작업
		for (String fileNameList : fileList) {
			
			String fileName = fileNameList;
			String extension = ""; // 이미지 확장자
			
			// 확장자가 있는 경우 확장자를 제거한다.
			int index = fileNameList.indexOf(".");
			if (index > 0) {
				fileName = fileNameList.substring(0, index);
				extension = fileNameList.substring(index+1); //확장자의 '.'을 제외하고 확장자 명만 저장
			}
			
			defaultImgList.add(fileName); // 파일 이름 저장
			imgExtensionList.add(extension); // 파일 확장자 저장
		}
	}
	
	/**
	 * 로딩된 데이터를 적용한다.
	 */
	public void setLoadedDataToFrame() {
		
		// 저장된 플래그에 따라서 기본 설정인지 사용자 설정인지 파악
		// 파악 후 해당하는 정보 세팅
		if (this.chatBackgroundFlag) {
			setDefaultListItem(); // 설정에 저장되어있는 이미지를 미리 선택
		} else {
			userSetPath.setText(this.chatBackgroundPath);
		}
		
		setPreviewImg(this.chatBackgroundPath);
		setImgEnable(this.chatBackgroundFlag);
	}
	
	/**
	 * 현재 설정된 정보 환경설정에 저장
	 */
	public void saveBackground() {
		
		// 저장 할 것인지 질문 메시지
		WaveMsgDialogBox confirm = new WaveMsgDialogBox(this, this.title, CommMsg.SAVE_Q_MSG, JOptionPane.OK_CANCEL_OPTION);
		
		// 저장 취소시 메서드 종료
		if (confirm.getResult() > 0) {
			return;
		}
		
		property.setChatBackgroundFlag(this.chatBackgroundFlag); // 설정
		property.setChatBackgroundName(this.chatBackgroundName); // 이미지 이름
		property.setChatBackgroundExtension(this.chatBackgroundExtension); // 이미지 확장자
		property.setChatBackgroundPath(this.chatBackgroundPath); // 이미지 경로
		
		// 변경된 설정 저장
		// 설정 저장 실패 시 이미지를 적용하지 않는다.
		try {
			property.savePropertiesFile();
		} catch (IOException e1) {
			e1.printStackTrace();
			new WaveMsgDialogBox(this.title, CommMsg.PROPERTY_SAVE_ERROR, JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// 프레임에 배경 이미지 설정
		try {
			frame.setBackGround();
			new WaveMsgDialogBox(this.title, CommMsg.SAVE_MSG, JOptionPane.INFORMATION_MESSAGE); // 저장 완료 메시지
			
		} catch (WaveMsgException e) {
			e.printStackTrace();
			new WaveMsgDialogBox(this.title, CommMsg.NOT_APPLY_IMG, JOptionPane.ERROR_MESSAGE);
		} finally{
			close(); // 화면 종료
		}
	}
	
	/**
	 * 리스트에서 선택하면 미리보기에 보여준다.
	 * @param e 리스트 아이템 이벤트
	 */
	public void setListImg(ListSelectionEvent e) {
		
		// 선택할 때 두개의 인덱스를 반환
		// FirstIndex -> 기존에 선택한 아이템과 현재 선택한 아이템중 인덱스가 작은 값 
		// ListIndex -> 기존에 선택한 아이템과 현재 선택한 아이템중 인덱스가 큰 값
		// 위의 두 인덱스 중 변화가 생긴 인덱스를 통해서 현재 선택한 인덱스를 구할 수 있다.
		if (this.selectedImgListIndex != e.getFirstIndex()) { 
			this.selectedImgListIndex = e.getFirstIndex();
		} else if (this.selectedImgListIndex != e.getLastIndex()) {
			this.selectedImgListIndex = e.getLastIndex();
		}
		
		this.chatBackgroundName = defaultImgList.get(this.selectedImgListIndex); // 선택한 이미지 이름 
		this.chatBackgroundExtension = imgExtensionList.get(this.selectedImgListIndex); // 선택한 이미지 확장자
		this.chatBackgroundPath = CommSet.getOriChatBackImgPath(this.chatBackgroundName); // 선택한 이미지 절대경로
		
		// 이미지 미리보기 세팅
		setPreviewImg(this.chatBackgroundPath);
	}
	
	/**
	 * 배경선택 라디오 버튼 클릭 <br>
	 * 
	 * <pre>
	 * true		: 기본 배경 선택
	 * false	: 사용자 배경 선택 
	 * </pre>
	 * 
	 * @param radioChk 선택 여부
	 */
	public void setImgEnable(boolean radioChk) {

		this.chatBackgroundFlag = radioChk; // 선택 플러그 저장

		if (radioChk) {
			defaultList.setEnabled(true); // 기본 이미지 목록 활성화
			userSetPath.setEnabled(false); // 선택한 경로 필드 비활성화
			findBtn.setEnabled(false); // 찾기 버튼 비활성화
		} else {
			defaultList.setEnabled(false); // 기본 이미지 목록 비활성화
			userSetPath.setEnabled(true); // 선택한 경로 필드 활성화
			findBtn.setEnabled(true); // 찾기 버튼 활성화
		}
	}
	
	/** 
	 * 환경설정에 설정된 기본 설정 이미지를 미리 선택되어지도록 설정 
	 */
	public void setDefaultListItem() {
		
		int imgListSize = defaultImgList.size();
		int index = 0;
		
		for (index=0; index<imgListSize; index++) {
			
			// 리스트에서 저장되어있는 이미지 이름을 검색
			// 같은 이름일 때의 index를 구한다.
			if (this.chatBackgroundName.equals(defaultImgList.get(index))) {
				break;
			}
		}
		
		defaultList.setSelectedIndex(index); // 목록에서 선택
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
		
		if (userSetPath.getText().trim().length() > 0) { // 선택된 경로가 있는 경우
			fileChooser.setCurrentDirectory(new File(userSetPath.getText()));
		}
		
		// 파일 선택
		int returnVal = fileChooser.showOpenDialog(null);

		// 파일선택 후 이미지를 프로필 사진으로 세팅
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			
			// 파일 경로 출력
			userSetPath.setText(fileChooser.getSelectedFile().getAbsolutePath());
				
			this.chatBackgroundPath = fileChooser.getSelectedFile().getAbsolutePath(); // 파일의 절대경로
			
			imgPath = new File(chatBackgroundPath); // 파일 인스턴스 생성
			
			// 선택한 파일이 없는 경우 메시지를 띄우고 메서드를 종료한다.
			if (!imgPath.exists()) { 
				new WaveMsgDialogBox(this.title, CommMsg.NOT_EXSIST_IMG, JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			this.chatBackgroundName = imgPath.getName(); // 파일 이름
			this.chatBackgroundExtension = ""; // 확장자 초기화
			
			// 파일 이름에 확장자가 존재 할 경우 파일 이름과 확장자를 적용한다.
			int index = this.chatBackgroundName.indexOf(".");
			if (index > 0) {
				this.chatBackgroundName = imgPath.getName().substring(0, index);
				this.chatBackgroundExtension = imgPath.getName().substring(index+1);
			}
			
			userSetPath.setText(this.chatBackgroundPath);
			setPreviewImg(this.chatBackgroundPath); // 이미지를 미리보기 화면에 보인다.
		}
	}
	
	/**
	 * 
	 * @param imgPath
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void setPreviewImg(String imgPath){
		
		// 이미지를 읽어 미리보기 화면에 보여준다.
		try {
			
			BufferedImage bufImg = ImageIO.read(new BufferedInputStream(new FileInputStream(imgPath)));
			Image atemp = bufImg.getScaledInstance(154, 232, Image.SCALE_AREA_AVERAGING);
			previewImg.setImage(atemp);// 이미지 적용한다. // 이미지 변환
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			new WaveMsgDialogBox(this.title, CommMsg.NOT_EXSIST_IMG, JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
			new WaveMsgDialogBox(this.title, CommMsg.NOT_APPLY_IMG, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * 현재 선택한 설정 방법 <br>
	 * 
	 * <pre>
	 * true  : 기본 설정 선택
	 * false : 사용자 설정 선택
	 * </pre>
	 * 
	 * @return 설정 방법
	 */
	public boolean isChatBackgroundFlag() {
		return this.chatBackgroundFlag;
	}
	
	/**
	 * 배경 이미지 이름 반환 <br>
	 * 
	 * @return 이미지 이름
	 */
	public String getChatBackgroundName() {
		return this.chatBackgroundName;
	}
	
	/**
	 * 배경 이미지 확장자 반환 
	 * 
	 * @return 확장자 명
	 */
	public String getChatBackgroundExtension() {
		return this.chatBackgroundExtension;
	}
	
	/**
	 * 배경 이미지 경로 반환
	 * 
	 * @return 이미지 경로
	 */
	public String getChatBackgroundPath() {
		return this.chatBackgroundPath;
	}
	
	
	@Override
	public void callBackData() throws WaveMsgException {
		// 서버와 직접 통신하지 않음
	}
	
	
	
	
	
	
	public static void main(String[] st) throws WaveMsgException {
		BackgroundFrame frame = new BackgroundFrame(new WaveMsgBackImgInterface() {
			@Override
			public void setBackGround() {
			}
		});
		frame.setVisible(true);
	}
}
