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

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JScrollPane;

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

}
