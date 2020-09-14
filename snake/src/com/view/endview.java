/*
 * 通关界面
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
		//下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}
