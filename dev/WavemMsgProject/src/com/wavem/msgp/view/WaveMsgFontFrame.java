/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgFontFrame.java
 * Date       : 2012.09.30
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.wavem.msgp.comm.CommMsg;
import com.wavem.msgp.comm.WaveMsgException;
import com.wavem.msgp.component.WaveMsgButton;
import com.wavem.msgp.component.WaveMsgComboBox;
import com.wavem.msgp.component.WaveMsgFontInterface;
import com.wavem.msgp.component.WaveMsgFrame;
import com.wavem.msgp.component.WaveMsgLabel;
import com.wavem.msgp.component.WaveMsgList;
import com.wavem.msgp.component.WaveMsgPanel;
import com.wavem.msgp.component.WaveMsgScrollPane;
import com.wavem.msgp.component.WaveMsgTextField;
import com.wavem.msgp.component.WaveMsgTextPane;

/**
 * 폰트 선택 공통 프레임
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see
 */
public class WaveMsgFontFrame extends WaveMsgFrame {

	private static final long serialVersionUID = 2009641432934265812L;

	/** 타이틀 */
	private String title = CommMsg.FONT_FRAME_TITLE;
	
	/** 폰트 설정을 요청한 프레임 */
	private WaveMsgFontInterface frame = null;
	
	/** 검색을 위한 텍스트 필드 */
	private WaveMsgTextField fontSearchTxt = null;
	
	/** 폰트 리스트 */
	private WaveMsgList fontList = null;
	
	/** 폰트 이름 배열 */
	private DefaultListModel<String> fontName = null;
	private DefaultListModel<String> fontViewName = null;
	
	/** 리스트 선택 인덱스 */
	private int selectedFontListIndex = 0;
	
	/** 기타 선택 콤보 */
	private WaveMsgComboBox styleCombo = null;
	/** 크기 선택 콤보 */
	private WaveMsgComboBox sizeCombo = null;
	
	/** 미리보기 */
	private WaveMsgTextPane txtpnHello = null;
	
	/** 스크롤 패널 */
	private WaveMsgScrollPane scrollPane = null;
	
	/** 폰트 */
	private String fontPreview = "";
	private int stylePreview = 0;
	private int sizePreview = 12;
	
	/**
	 * 폰트 설정 화면 <br>
	 * 
	 * <pre>
	 * 0 : 메인 환경설정 화면
	 * 1 : 채팅 폰트설정 화면
	 * </pre>
	 * 
	 * @param frame 폰트 설정을 요청한 프레임
	 * @param font 폰트
	 * @param fontEtc 폰트 기타 (bold, italic)
	 * @param fontSize 폰트 크기
	 * @throws WaveMsgException 
	 */
	public WaveMsgFontFrame(WaveMsgFontInterface frame, String font, int fontEtc, int fontSize) throws WaveMsgException {
		
		/* *************************************************************
		 * 환경변수 및 채팅 설정 구분 시작
		 * *************************************************************/
		this.frame = frame;
		this.fontPreview = font;
		this.stylePreview = fontEtc;
		this.sizePreview = fontSize;
		/* *************************************************************
		 * 환경변수 및 채팅 설정 구분 끝
		 * *************************************************************/
		
		makeInitFrame();
	}
	
	@Override
	public void makeInitFrame() throws WaveMsgException {
		
		getContentPane().setLayout(null);
		setBounds(100, 100, 238, 524);
		setTitle(this.title);
		
		/* *************************************************************
		 * 폰트 검색 시작
		 * *************************************************************/
		WaveMsgPanel panel_font = new WaveMsgPanel();
		panel_font.setBackground(Color.WHITE);
		panel_font.setBounds(12, 10, 200, 330);
		getContentPane().add(panel_font);
		panel_font.setLayout(null);
		
		fontSearchTxt = new WaveMsgTextField();
		fontSearchTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchWord = fontSearchTxt.getText();
				searchFontFromFontList(searchWord);
			}
		});
		fontSearchTxt.setBounds(12, 10, 176, 21);
		fontSearchTxt.setColumns(10);
		panel_font.add(fontSearchTxt);
		
		fontList = new WaveMsgList();
		fontList.setLocation(22, 43);
		fontList.setModel(new AbstractListModel() {
			
			public int getSize() {
				return fontViewName.size();
			}
			public Object getElementAt(int index) {
				return fontViewName.get(index);
			}
		});
		fontList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(! e.getValueIsAdjusting()) { // 체크하지 않으면 valueChanged 메서드를 두번 호출하는 것 같음!
					setPreviewFont(e);
				}
			}
		});
		fontList.setBorder(new LineBorder(Color.LIGHT_GRAY));
		fontList.setBounds(12, 11, 176, 249);
		panel_font.add(fontList);
		
		scrollPane = new WaveMsgScrollPane(fontList);
		scrollPane.setBounds(12, 41, 176, 249);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_font.add(scrollPane);
		
		/* *************************************************************
		 * 폰트 검색 끝
		 * *************************************************************/
		
		
		
		/* *************************************************************
		 * 폰트 기타 및 크기 시작
		 * *************************************************************/
		String[] styleFont = {"Plain", "Bold", "Italic", "Bold Italilc"}; 
		styleCombo = new WaveMsgComboBox(styleFont);
		styleCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				setPreviewStyle(e);
			}
		});
		styleCombo.setBounds(12, 300, 110, 21);
		panel_font.add(styleCombo);
		
		String[] sizeFont = new String[95];
		for (int i=5; i<100; i++) {
			sizeFont[i-5] = String.valueOf(i);
		}
		sizeCombo = new WaveMsgComboBox(sizeFont);
		sizeCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				setPreviewSize(e);
			}
		});
		sizeCombo.setBounds(134, 300, 54, 21);
		panel_font.add(sizeCombo);
		/* *************************************************************
		 * 색상 설정 끝
		 * *************************************************************/
		
		
		
		/* *************************************************************
		 * 미리보기 시작
		 * *************************************************************/
		JPanel panel_preview = new JPanel();
		panel_preview.setBackground(Color.WHITE);
		panel_preview.setBounds(12, 339, 200, 100);
		getContentPane().add(panel_preview);
		panel_preview.setLayout(null);
		
		WaveMsgLabel label = new WaveMsgLabel("미리보기");
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(12, 5, 69, 15);
		panel_preview.add(label);
		
		txtpnHello = new WaveMsgTextPane();
		txtpnHello.setText(" - 가나다라마바사\r\n - Aa Bb Cc Dd Ee\r\n");
		txtpnHello.setBounds(22, 30, 157, 51);
		panel_preview.add(txtpnHello);
		
		/* *************************************************************
		 * 미리보기 끝
		 * *************************************************************/
	
		// 닫기 버튼
		WaveMsgButton closeBtn = new WaveMsgButton("CLOSE");
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
		closeBtn.setBounds(152, 449, 60, 23);
		getContentPane().add(closeBtn);
		
		// 확인 버튼
		WaveMsgButton okBtn = new WaveMsgButton("OK");
		okBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				apply();
			}
		});
		okBtn.setBounds(80, 449, 60, 23);
		getContentPane().add(okBtn);
		
		
		// 데이터 로딩
		loadData();
	}
	
	/**
	 * 화면 닫기 버튼
	 */
	@Override
	public void close() {
		this.dispose();
	}
	
	/**
	 * 데이터 로딩
	 */
	public void loadData() {
		
		// 시스템에서 폰트 가져오기
		GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] font = genv.getAllFonts();
		fontName = new DefaultListModel<String>();
		
		// 폰트 리스트를 추가
		for (int i = 0; i < font.length; i++) { 
			fontName.addElement(font[i].getFontName());
		}
		
		// 폰트 리스트를 폰트를 보여주기 위한 클래스에 저장
		int size = fontName.size();
		fontViewName = new DefaultListModel<String>();
		for (int i=0; i<size; i++) {
			fontViewName.addElement(fontName.get(i)); 
		}
		
		// 저장된 폰트 선택
		int fontListIndex = 0;
		for (int i=0; i<size; i++) {
			if (fontPreview.equals(fontViewName.get(i))) {
				fontListIndex = i;
				break;
			}
		}
		fontList.setSelectedIndex(fontListIndex);
		//fontList. // TODO : 스크롤 이동 로직 필요
		
		// 저장된 형식
		int styleIndex = 0;
		if (stylePreview == Font.BOLD) {
			styleIndex = 1;
		} else if (stylePreview == Font.ITALIC) {
			styleIndex = 2;
		} else if (stylePreview == (Font.BOLD|Font.ITALIC)) {
			styleIndex = 3;
		} 
		styleCombo.setSelectedIndex(styleIndex);
		
		// 저장된 크기
		sizeCombo.setSelectedIndex(sizePreview-5);
		
		// 미리보기
		txtpnHello.setFont(new Font(fontPreview, stylePreview, sizePreview));
	}
	
	/**
	 * 확인 버튼을 통한 데이터 적용
	 */
	public void apply() {
		frame.setFrameFont();
		close();
	}
	
	/**
	 * 리스트 선택 시 선택한 이벤트를 받아 미리보기 적용
	 * 
	 * @param e 리스트 선택 이벤트
	 */
	public void setPreviewFont(ListSelectionEvent e) {
		
		// 선택할 때 두개의 인덱스를 반환
		// FirstIndex -> 기존에 선택한 아이템과 현재 선택한 아이템중 인덱스가 작은 값 
		// ListIndex -> 기존에 선택한 아이템과 현재 선택한 아이템중 인덱스가 큰 값
		// 위의 두 인덱스 중 변화가 생긴 인덱스를 통해서 현재 선택한 인덱스를 구할 수 있다.
		if (selectedFontListIndex != e.getFirstIndex()) { 
			selectedFontListIndex = e.getFirstIndex();
		} else if (selectedFontListIndex != e.getLastIndex()) {
			selectedFontListIndex = e.getLastIndex();
		}
		
		fontPreview = fontViewName.get(selectedFontListIndex); // 선택한 폰트를 가져와 적용한다.
		txtpnHello.setFont(new Font(fontPreview, stylePreview, sizePreview));
	}
	
	/**
	 * 콤보 선택시 이벤트를 받아 미리보기 적용
	 * 
	 * @param e 콤보 선택 이벤트
	 */
	public void setPreviewStyle(ItemEvent e) {
		
		String styleString = e.getItem().toString(); // "Plain", "Bold", "Italic", "Bold Italilc"
		
		// 콤보 값을 비교하여 미리보기에 적용
		if (styleString.equals("Bold")) {
			stylePreview = Font.BOLD;
		} else if (styleString.equals("Italic")) {
			stylePreview = Font.ITALIC;
		} else if (styleString.equals("Bold Italilc")) {
			stylePreview = Font.BOLD|Font.ITALIC;
		} else { // Plain
			stylePreview = Font.PLAIN;
		}
		
		txtpnHello.setFont(new Font(fontPreview, stylePreview, sizePreview));
	}
	
	/**
	 * 글자 크기 콤보 선택 시 미리보기 적용
	 * 
	 * @param e 글자크기 콤보 이벤트
	 */
	public void setPreviewSize(ItemEvent e) {
		sizePreview = Integer.parseInt(e.getItem().toString()); // 콤보의 값을 가져와 int형으로 변환하여 적용
		txtpnHello.setFont(new Font(fontPreview, stylePreview, sizePreview));
	}
	
	/**
	 * 폰트 검색
	 * 
	 * @param searchWord 검색어
	 */
	public void searchFontFromFontList(String searchWord) {
		
		// 폰트 리스트
		int fontListSize = fontName.size();
		
		Pattern pattern = Pattern.compile(".*" + searchWord + ".*"); // 폰트 검색하기 위해 정규식 표현 정의
		Matcher matcher = null; // Pattern에 정의된 표현식 검사하기 위한 클래스
		
		fontViewName.removeAllElements(); // 기존의 엘리먼트 모두 삭제
		for (int i=0; i<fontListSize; i++) { //  검색된 엘리먼트 추가
			String searchTarget = fontName.get(i); // 모든 폰트에서 검색하기 위해 fontViewName이 아닌 fontName에서 검색
			matcher = pattern.matcher(searchTarget); // 매칭 검사
			
			if (matcher.matches()) { // 정규식 표현에 매칭되는 것만 걸러냄
				fontViewName.addElement(searchTarget);
			}
		}
		fontList.updateUI(); // 화면 새로고침
	}
	
	/**
	 * 폰트 반환
	 * 
	 * @return 폰트
	 */
	public String getFontPreview() {
		return this.fontPreview;
	}
	
	/**
	 * 스타일 반환
	 * 
	 * @return 스타일
	 */
	public int getStylePreview() {
		return this.stylePreview;
	}
	
	/**
	 * 폰트 크기 반환
	 * 
	 * @return 폰트 크기
	 */
	public int getSizePreview() {
		return this.sizePreview;
	}

	@Override
	public void callBackData() throws WaveMsgException {
		// 로컬에서만 동작하기에 필요 없음
	}

	public static void main(String[] adsf) throws WaveMsgException {
		WaveMsgFontFrame pa = new WaveMsgFontFrame(PropertyFrame.getInstance(), "굴림", Font.PLAIN, 12);
		pa.setVisible(true);
	}
}
