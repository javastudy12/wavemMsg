package com.wavem.msgp.component;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.wavem.msgp.comm.CommSet;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseEvent;

/**
 * 채팅 전용 패널
 * 
 * @author 정재요
 *
 */
public class WaveMsgChatPane extends WaveMsgPanel {

	private static final long serialVersionUID = -4594390795554550450L;
	
	private int x = 0;
	private int y = 0;
	
	/**
	 * 기본 생성자
	 */
	public WaveMsgChatPane() {
		super();
		setLayout(null);
		
		makeInitPane();
	}
	
	/**
	 * 화면 구성
	 */
	private void makeInitPane() {
//		this.setPreferredSize(new Dimension(1000,1000));
		
		WaveMsgScrollPane chatScroll = new WaveMsgScrollPane(this);
		chatScroll.setVisible(true);
		
		JButton btnNewButton = new JButton("눌러");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addLbl();
			}
		});
		btnNewButton.setBounds(331, 254, 97, 23);
		add(btnNewButton);
		
		
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1000, 1000);
	}


	public void addLbl() {
		WaveMsgLabel backLbl = new WaveMsgLabel(new ImageIcon(CommSet.getOriChatBackImgPath("Desert")));
		backLbl.setBounds(x,y,100,100);
		this.add(backLbl);
		y = y+120;
		System.out.println("머시기냐" + y);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WaveMsgChatPane pane = new WaveMsgChatPane();
		
		JFrame frame = new JFrame();
		frame.getContentPane().add(pane);
		frame.setBounds(0,0,500,500);
		frame.setVisible(true);
	}
}
