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
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.comm.CommSet;
import com.wavem.msgp.comm.PropertiesInfo;
import com.wavem.msgp.comm.WaveMsgException;
import com.wavem.msgp.component.WaveMsgBackImgInterface;
import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgDialogBox;
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
	private PropertiesInfo properties = PropertiesInfo.getInstance();
	
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
	
	
	/** 배경 이미지 경로를 위한 인스턴스 */
	private File imgPath = null;
	
	
	
	/** 채팅, 쪽지 배경 설정 (기본배경, 사용자설정) */
	private boolean chatBackgroundFlag = false;
	
	/** 채팅, 쪽지 배경 이미지 이름 */
	private String chatBackgroundName = "";
	
	/** 채팅, 쪽지 배경 이미지 경로 */
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
		setBounds(100, 100, 376, 500);
		setTitle(this.title);
		
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
				setDefaultImgEnable(defaultRadioBtn.isSelected());
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
					setPreviewImg(e);
				}
			}
		});
		
		
		// 이미지 목록 스크롤 패널
		WaveMsgScrollPane defaultScrollPane = new WaveMsgScrollPane(defaultList);
		defaultScrollPane.setBounds(12, 47, 138, 143);
		defaultPane.add(defaultScrollPane);
		
		// 사용자 배경 설정 라디오 버튼
		userRadioBtn = new WaveMsgRadioButton("사용자 배경");
		userRadioBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setDefaultImgEnable(!userRadioBtn.isSelected());
			}
		});
		userRadioBtn.setSelected(false);
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
		
		
		
		setDefaultImgEnable(defaultRadioBtn.isSelected()); // 최초 세팅을 위해 호출
	}

	@Override
	public void close() {
		this.dispose();
	}
	
	
	
	/**
	 * 환경설정으로부터 현재의 배경화면 설정 로드
	 */
	public void loadBackgroundProperty() {
		this.chatBackgroundFlag = properties.isChatBackgroundFlag();
		this.chatBackgroundName = properties.getChatBackgroundName();
		this.chatBackgroundPath = properties.getChatBackgroundPath();
	}
	
	/**
	 * 현재 설정된 정보 환경설정에 저장
	 */
	public void saveBackgroundProperty() {
		frame.setBackGround(); // 프레임에 배경 이미지 설정
	}
	
	/**
	 * 리스트에서 선택하면 미리보기에 보여준다.
	 * @param e 리스트 아이템 이벤트
	 */
	public void setPreviewImg(ListSelectionEvent e) {
		
		// 선택할 때 두개의 인덱스를 반환
		// FirstIndex -> 기존에 선택한 아이템과 현재 선택한 아이템중 인덱스가 작은 값 
		// ListIndex -> 기존에 선택한 아이템과 현재 선택한 아이템중 인덱스가 큰 값
		// 위의 두 인덱스 중 변화가 생긴 인덱스를 통해서 현재 선택한 인덱스를 구할 수 있다.
		
		if (selectedImgListIndex != e.getFirstIndex()) { 
			selectedImgListIndex = e.getFirstIndex();
		} else if (selectedImgListIndex != e.getLastIndex()) {
			selectedImgListIndex = e.getLastIndex();
		}
		
		String path = CommSet.getOriChatBackImgPath(defaultImgList.get(selectedImgListIndex)); // 선택한 이미지의 절대 경로를 얻는다.
		
		try {
			//previewImg.setImage(new File(path));
			
			BufferedImage bufImg = ImageIO.read(new BufferedInputStream(new FileInputStream(path)));
			Image atemp = bufImg.getScaledInstance(154, 232, Image.SCALE_AREA_AVERAGING);
			previewImg.setImage(atemp);
			
		} catch (IOException ie) {
			ie.printStackTrace();
			new WaveMsgDialogBox(this.title, CommMsg.NOT_EXSIST_IMG, JOptionPane.ERROR_MESSAGE);
		}
		
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
	public void setDefaultImgEnable(boolean radioChk) {

		if (radioChk) {
			defaultList.setEnabled(true); // 기본 이미지 목록 활성화
			userSetPath.setEnabled(false); // 선택한 경로 필드 비활성화
			findBtn.setEnabled(false); // 찾기 버튼 비활성화
			
			if (defaultImgList.size() == 0) { // 리스트 목록이 없는 경우
				
				imgPath = new File(CommSet.getOriChatBackImgPath()); // 기본 배경 이미지의 실제 경로
				
				String[] fileList = imgPath.list(); // 이미지 리스트 반환
				
				// 이미지 리스트 생성 작업
				for (String fileName : fileList) {
					
					// 확장자가 있는 경우 확장자를 제거한다.
					int index = fileName.indexOf(".");
					if (index > 0) {
						fileName = fileName.substring(0, index);
					}
					
					defaultImgList.add(fileName);
				}
			}
		} else {
			defaultList.setEnabled(false); // 기본 이미지 목록 비활성화
			userSetPath.setEnabled(true); // 선택한 경로 필드 활성화
			findBtn.setEnabled(true); // 찾기 버튼 활성화
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
				String imgPath = fileChooser.getSelectedFile().getAbsolutePath();
				
				BufferedImage bufImg = ImageIO.read(new BufferedInputStream(new FileInputStream(imgPath)));
				Image atemp = bufImg.getScaledInstance(154, 232, Image.SCALE_AREA_AVERAGING);
				
				previewImg.setImage(atemp);// 이미지 적용한다. // 이미지 변환
				
			} catch (IOException e) {
				new WaveMsgDialogBox(this.title, CommMsg.NOT_EXSIST_IMG, JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	
	@Override
	public void callBackData() throws WaveMsgException {
		// TODO Auto-generated method stub
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
