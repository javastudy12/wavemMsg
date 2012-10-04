/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgFontFrame.java
 * Date       : 2012.09.30
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 폰트 선택 공통 프레임
 * 
 * @author wody
 *
 */
public class WaveMsgFontFrame extends JFrame {
	
	/** 검색을 위한 텍스트 필드 */
	private WaveMsgTextField fontSearchTxt = null;
	
	/** 폰트 리스트 */
	private WaveMsgList fontList = null;
	
	/** 폰트 이름 배열 */
	//private String[] fontName = {}; // 전체 폰트 리스트
	//private String[] fontViewName = {}; // 검색하였을 때 보여줄 폰트 리스트
	private DefaultListModel<String> fontName = null;
	private DefaultListModel<String> fontViewName = null;
	
	private int selectedFontListIndex = 0;
	
	/** 기타 선택 콤보 */
	private WaveMsgComboBox etcCombo = null;
	/** 크기 선택 콤보 */
	private WaveMsgComboBox sizeCombo = null;
	
	/** 미리보기 */
	private WaveMsgTextPane txtpnHello = null;
	
	/** 스크롤 패널 */
	private WaveMsgScrollPane scrollPane = null;
	
	
	// TODO : 추후 환경설정에서 데이터를 로드시킴
	private String fontPreview = "굴림";
	private int etcPreview = Font.BOLD;
	private int sizePreview = 12;
	
	
	
	
	public WaveMsgFontFrame() {
		
		getContentPane().setLayout(null);
		setBounds(100, 100, 400, 600);
		
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
		String[] etcFont = {"Plain", "Bold", "Italic", "Bold Italilc"}; 
		etcCombo = new WaveMsgComboBox(etcFont);
		etcCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				setPreviewEtc(e);
			}
		});
		etcCombo.setBounds(12, 300, 110, 21);
		panel_font.add(etcCombo);
		
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
		 * 폰트 기타 및 크기 끝
		 * *************************************************************/
		
		
		
		/* *************************************************************
		 * 색상 설정 시작
		 * *************************************************************/
		WaveMsgPanel panel_color = new WaveMsgPanel();
		panel_color.setBackground(Color.WHITE);
		panel_color.setBounds(211, 10, 161, 330);
		getContentPane().add(panel_color);
		panel_color.setLayout(null);
		
		
		
		/* *************************************************************
		 * 색상 설정 끝
		 * *************************************************************/
		
		
		
		/* *************************************************************
		 * 미리보기 시작
		 * *************************************************************/
		JPanel panel_preview = new JPanel();
		panel_preview.setBackground(Color.WHITE);
		panel_preview.setBounds(12, 339, 360, 100);
		getContentPane().add(panel_preview);
		panel_preview.setLayout(null);
		
		WaveMsgLabel label = new WaveMsgLabel("미리보기");
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(12, 5, 69, 15);
		panel_preview.add(label);
		
		txtpnHello = new WaveMsgTextPane();
		txtpnHello.setText(" - 가나다라마바사\r\n - Aa Bb Cc Dd Ee\r\n");
		txtpnHello.setBounds(22, 30, 281, 51);
		panel_preview.add(txtpnHello);
		
		
		/* *************************************************************
		 * 미리보기 끝
		 * *************************************************************/
		
		
		// 데이터 로딩
		loadData();
	}
	
	/**
	 * 
	 */
	public void loadData() {
		
		// 시스템에서 폰트 가져오기
		GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] font = genv.getAllFonts();
		//fontName = new String[font.length];
		fontName = new DefaultListModel<String>();

		for (int i = 0; i < font.length; i++) {
			fontName.addElement(font[i].getFontName());
		}
		
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
		int etcIndex = 0;
		if (etcPreview == Font.BOLD) {
			etcIndex = 1;
		} else if (etcPreview == Font.ITALIC) {
			etcIndex = 2;
		} else if (etcPreview == (Font.BOLD|Font.ITALIC)) {
			etcIndex = 3;
		} 
		etcCombo.setSelectedIndex(etcIndex);
		
		// 저장된 크기
		sizeCombo.setSelectedIndex(sizePreview-5);
		
		// 미리보기
		txtpnHello.setFont(new Font(fontPreview, etcPreview, sizePreview));
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
		txtpnHello.setFont(new Font(fontPreview, etcPreview, sizePreview));
	}
	
	/**
	 * 콤보 선택시 이벤트를 받아 미리보기 적용
	 * 
	 * @param e 콤보 선택 이벤트
	 */
	public void setPreviewEtc(ItemEvent e) {
		
		String etcString = e.getItem().toString(); // "Plain", "Bold", "Italic", "Bold Italilc"
		
		if (etcString.equals("Bold")) {
			etcPreview = Font.BOLD;
		} else if (etcString.equals("Italic")) {
			etcPreview = Font.ITALIC;
		} else if (etcString.equals("Bold Italilc")) {
			etcPreview = Font.BOLD|Font.ITALIC;
		} else { // Plain
			etcPreview = Font.PLAIN;
		}
		
		txtpnHello.setFont(new Font(fontPreview, etcPreview, sizePreview));
	}
	
	/**
	 * 글자 크기 콤보 선택 시 미리보기 적용
	 * 
	 * @param e 글자크기 콤보 이벤트
	 */
	public void setPreviewSize(ItemEvent e) {
		sizePreview = Integer.parseInt(e.getItem().toString()); // 콤보의 값을 가져와 int형으로 변환하여 적용
		txtpnHello.setFont(new Font(fontPreview, etcPreview, sizePreview));
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
	
	public static void main(String[] adsf) {
		WaveMsgFontFrame pa = new WaveMsgFontFrame();
		pa.setVisible(true);
	}
}
