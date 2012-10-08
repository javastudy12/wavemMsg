/* ********************************************************************************************************
 * Project    : WavemMessenger
 * FileName   : WaveMsgPanel.java
 * Date       : 2012.09.25
 * 
 * ModifyDate : 
 * Comment    :
 * 
 * ********************************************************************************************************/

package com.wavem.msgp.component;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.wavem.msgp.comm.PropertiesInfo;

/**
 * 패널 <br>
 * 이미지 설정 메서드 추가 <br>
 * 
 * <pre>
 * 	WaveMsgPanel panel = new WaveMsgPanel();
 * 	panel.setImage(file);
 * </pre>
 * 
 * @author 정재요
 * @since jdk 1.6
 * @version 1.0
 * @see JPanel
 */
public class WaveMsgPanel extends JPanel {

	private static final long serialVersionUID = -6119513404278944133L;

	/** 배경 등록 Image 인스턴스 변수 */
	private Image img = null;
	
	/**
	 * 패널 기본 생성자
	 * 
	 * @see WaveMsgPanel#setProperties()
	 */
	public WaveMsgPanel() {
		super();
		setProperties();
	}
	
	/**
	 * 패널 생성자 <br>
	 * 더블 버퍼링 사용 유무 초기화 <br>
	 * 
	 * @param b 더블 버퍼링 유무
	 * @see WaveMsgPanel#setProperties()
	 */
	public WaveMsgPanel(boolean b) {
		super(b);
		setProperties();
	}
	
	/**
	 * 패널 생성자 <br>
	 * 레이아웃 초기화 <br>
	 * 
	 * @param layoutMgr 레이아웃
	 * @see WaveMsgPanel#setProperties()
	 */
	public WaveMsgPanel(LayoutManager layoutMgr) {
		super(layoutMgr);
		setProperties();
	}
	
	/**
	 * 패널 생성자 <br>
	 * 더블 버퍼링 사용 유무 및 레이아웃 초기화 <br>
	 * 
	 * @param layoutMgr 레이아웃
	 * @param b 더블 버퍼링 유무
	 * @see WaveMsgPanel#setProperties()
	 */
	public WaveMsgPanel(LayoutManager layoutMgr, boolean b) {
		super(layoutMgr, b);
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
		
		// 색상 설정
		setForeground(property.getColor());
	}
}
