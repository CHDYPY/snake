package com.view;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import com.menber.*;
import java.util.*;
import java.io.*;

public class welcomeview extends JPanel {
	public Image image;
	public welcomeview() {
		try {
			image = ImageIO.read(new File("image\\snakelogin.jpg"));
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
