/*
 * ͨ�ؽ���
 */
package com.view;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import com.menber.*;
import java.util.*;

public class endview extends JPanel{
	public Image image;
	public endview() {
		try {
			image = ImageIO.read(new File("image\\end.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//����������Ϊ�˱���ͼƬ���Ը��洰�����е�����С�������Լ����óɹ̶���С
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}
