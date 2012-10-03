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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.AbstractListModel;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * 폰트 선택 공통 프레임
 * 
 * @author wody
 *
 */
public class WaveMsgFontFrame extends JFrame {
	
	private WaveMsgTextField fontSearchTxt = null;
	
	private WaveMsgList fontList = null;
	
	private String[] fontName = {};
	
	private WaveMsgButton boldBtn = null;
	private WaveMsgButton italicBtn = null;
	
	/** 스크롤 패널 */
	private WaveMsgScrollPane scrollPane = null;
	
	public WaveMsgFontFrame() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 400, 600);
		
		/* *************************************************************
		 * 폰트 검색 시작
		 * *************************************************************/
		WaveMsgPanel panel_font = new WaveMsgPanel();
		panel_font.setBackground(Color.WHITE);
		panel_font.setBounds(12, 10, 200, 300);
		getContentPane().add(panel_font);
		panel_font.setLayout(null);
		
		fontSearchTxt = new WaveMsgTextField();
		fontSearchTxt.setBounds(12, 10, 176, 21);
		fontSearchTxt.setColumns(10);
		panel_font.add(fontSearchTxt);
		
		fontList = new WaveMsgList();
		fontList.setLocation(22, 43);
		fontList.setModel(new AbstractListModel() {
			
			public int getSize() {
				return fontName.length;
			}
			public Object getElementAt(int index) {
				return fontName[index];
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(211, 10, 161, 300);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		/* *************************************************************
		 * 폰트 검색 끝
		 * *************************************************************/
		
		boldBtn = new WaveMsgButton("F");
		boldBtn.setFont(new Font("굴림", Font.BOLD, 12));
		boldBtn.setText("F");
		boldBtn.setBounds(12, 41, 40, 50);
		panel.add(boldBtn);
		
		italicBtn = new WaveMsgButton("F");
		italicBtn.setText("F");
		italicBtn.setFont(new Font("굴림", Font.ITALIC, 12));
		italicBtn.setBounds(64, 41, 40, 50);
		panel.add(italicBtn);
		
		WaveMsgButton waveMsgButton_1 = new WaveMsgButton("F");
		waveMsgButton_1.setText("F");
		waveMsgButton_1.setFont(new Font("굴림", Font.BOLD, 12));
		waveMsgButton_1.setBounds(116, 41, 40, 50);
		panel.add(waveMsgButton_1);
		
		
		
		
		loadData();
	}
	
	/**
	 * 
	 */
	public void loadData() {
		
		// 시스템에서 폰트 가져오기
		GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] font = genv.getAllFonts();
		fontName = new String[font.length];

		for (int i = 0; i < font.length; i++) {
			fontName[i] = font[i].getFontName();
		}
		
		
		
		
		
		
		
		
	}
	
	public static void main(String[] adsf) {
		WaveMsgFontFrame pa = new WaveMsgFontFrame();
		pa.setVisible(true);
	}
}
