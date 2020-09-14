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
		//下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
