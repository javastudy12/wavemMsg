/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgTextPane.java
 * Date       : 2012.09.25
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

import com.wavem.msgp.comm.PropertiesInfo;

/**
 * 텍스트 패널
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see JTextPane
 */
public class WaveMsgTextPane extends JTextPane {

	private static final long serialVersionUID = 206754192314054348L;

	/** 배경 등록 Image 인스턴스 변수 */
	private Image img = null;
	
	/** 투명도 */
	private float alpaValue = 1;
	
	/**
	 * 텍스트 패널 기본 생성자 <br>
	 * 
	 * @see WaveMsgTextPane#setProperties()
	 */
	public WaveMsgTextPane() {
		super();
		setProperties();
	}

	/**
	 * 텍스트 패널 생성자 <br>
	 * 문서양식 초기화 <br>
	 * 
	 * @param doc
	 * @see WaveMsgTextPane#setProperties()
	 */
	public WaveMsgTextPane(StyledDocument doc) {
		super(doc);
		setProperties();
	}
	
	/**
	 * 이미지 설정
	 * 
	 * @param img 이미지
	 */
	public final void setImage(Image img) {
		this.img = img;
		repaint(); // 새로운 이미지로 화면을 새로그림
	}
	
	/**
	 * 이미지 설정
	 * 
	 * @param img 이미지
	 * @param alpaValue 투명도
	 */
	public final void setImage(Image img, float alpaValue) {
		this.img = img;
		this.alpaValue = alpaValue;
		repaint(); // 새로운 이미지로 화면을 새로그림
	}
	
	
	/**
	 * file 파일 경로에 있는 이미지 로드하여 설정
	 * 
	 * @param file 이미지 파일
	 * @param alpaValue 투명도
	 * @throws IOException
	 */
	public final void setImage(File file, float alpaValue) throws IOException{
		
		this.alpaValue = alpaValue;
		
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
	 * file 파일 경로에 있는 이미지 로드하여 설정
	 * 
	 * @param file 이미지 파일 
	 * @throws IOException
	 */
	public final void setImage(File file) throws IOException{
		setImage(file, this.alpaValue);
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
		AlphaComposite alphaComposite = null; // 투명도를 주기 위한
		 

		if (image != null) {
			alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpaValue);
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setComposite(alphaComposite);
			g2d.drawImage(image, 0, 0, this);
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
		
		// 색상 설정
		setForeground(property.getColor());
	}
}
