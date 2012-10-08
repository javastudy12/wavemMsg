/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgScrollPane.java
 * Date       : 2012.09.25
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JScrollPane;

import com.wavem.msgp.comm.PropertiesInfo;

/**
 * 
 * 현재 이미지 동작 안함
 * 
 * @author 
 *
 */
public class WaveMsgScrollPane extends JScrollPane {
	
	private static final long serialVersionUID = 242158376039312840L;
	
	/** 배경 등록 Image 인스턴스 변수 */
	private Image img = null;
	
	/**
	 * 스크롤 패널 기본 생성자
	 */
	public WaveMsgScrollPane() {
		super();
		setProperties();
	}
	
	/**
	 * 스크롤 패널 생성자 <br>
	 * 횡스크롤 종스크롤 초기화 <br>
	 * 
	 * @param vsbPolicy 종스크롤
	 * @param hsbPolicy 횡스크롤
	 */
	public WaveMsgScrollPane(int vsbPolicy, int hsbPolicy) {
		super(vsbPolicy, hsbPolicy);
		setProperties();
	}
	
	/**
	 * 스크롤 패널 생성자 <br>
	 * @param view
	 */
	public  WaveMsgScrollPane(Component view) {
		super(view);
		setProperties();
	}
	
	/**
	 * 스크롤 패널 생성자 <br>
	 * @param view
	 * @param vsbPolicy
	 * @param hsbPolicy
	 */
	public  WaveMsgScrollPane(Component view, int vsbPolicy, int hsbPolicy) {
		super(view, vsbPolicy, hsbPolicy);
		setProperties();
	}

	/**
	 * 이미지 설정
	 * 
	 * @param img 이미지
	 */
	public final void setImage(Image img) {
		this.img = img;
		repaint();
	}
	
	
	/**
	 * file 파일 경로에 있는 이미지 로드하여 설정
	 * 
	 * @param file 이미지 파일 
	 * @throws IOException
	 */
	public final void setImage(File file) throws IOException{
		
		if (file == null) {
			throw new IOException("File instance is null");
		}
		
		if (!file.exists()) {
			throw new IOException("File is not exist");
		}
		
		BufferedImage bufImg = ImageIO.read(file);
		setImage(bufImg);
	}
	
	/**
	 * 이미지 인스턴스 반환
	 * 
	 * @return 이미지
	 */
	public final Image getImage() {
		return img;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// draw image
		Image image = getImage();

		if (image != null) {
			g.drawImage(image, 0, 0, this);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		Image image = getImage();

		if (image != null) {
			int width = image.getWidth(null);
			int height = image.getHeight(null);
			return new Dimension(width, height);
		} else {
			return super.getPreferredSize();
		}
	}
	
	/**
	 * 환경설정에 의한 설정 적용
	 */
	public void setProperties() {
		
		PropertiesInfo property = PropertiesInfo.getInstance();
		
		// 폰트 설정
		setFont(new Font(property.getFont(), property.getFontStyle(), property.getFontSize()));
	}

}
