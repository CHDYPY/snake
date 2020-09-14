/*
 * ��ʼ����
 */
package com.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.menber.*;
import java.util.*;

public class beginlogin extends JFrame implements ActionListener,Runnable{
	
	//�������
	JPanel jp; //��ʼ����
	JMenuBar jmb;
	JMenu jm1,jm2;
	JMenuItem jm1_1,jm1_2,jm1_3;
	gamelogin gl;
	level level;
	int fen;
	int levelnum;
	message mess;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new beginlogin();
	}
	
	public beginlogin() {
		//�������
		jmb = new JMenuBar();
		jm1 = new JMenu("��Ϸ");
		jm1_1 = new JMenuItem("����ģʽ");
		jm1_1.addActionListener(this);
		jm1_2 = new JMenuItem("�Զ���ģʽ");
		jm1_2.addActionListener(this);
		jm1_3 = new JMenuItem("����ģʽ");
		jm1_3.addActionListener(this);
		
		//������
		jm1.add(jm1_1);
		jm1.add(jm1_2);
		jm1.add(jm1_3);
		
		jmb.add(jm1);
		
		jp = new welcomeview();
		
		this.add(jp);
		
		this.setJMenuBar(jmb);
		
		this.setSize(800, 600);
		this.setLocation(500, 150);
		this.setTitle("̰����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jm1_1) {
			mess = new message();
			speedDialog sd = new speedDialog(this, "�Զ�����Ϸ", true, mess);
			
			this.update(getGraphics());
			level = new level1();
			gl = new gamelogin(level, mess.speed);
			this.addKeyListener(gl);
			this.add(gl);
			this.setVisible(true);
			Thread t = new Thread(gl);
			t.start();
		} else if(e.getSource() == jm1_2) {
			mess = new message();
			setDialog sd = new setDialog(this, "�Զ�����Ϸ", true, mess);
			
			this.update(getGraphics());
			gl = new gamelogin(chooselevel(mess.levelnum), mess.speed);
			this.addKeyListener(gl);
			this.add(gl);
			this.setVisible(true);
			Thread t = new Thread(gl);
			t.start();
			
		} else if(e.getSource() == jm1_3) {
			mess = new message();
			speedDialog sd = new speedDialog(this, "�Զ�����Ϸ", true, mess);
			
			levelnum = 1;
			fen = 0;
			this.update(getGraphics());
			level = new level1();
			gl = new gamelogin(level, mess.speed, fen);
			this.addKeyListener(gl);
			this.add(gl);
			this.setVisible(true);
			Thread t = new Thread(gl);
			t.start();
			Thread t1 = new Thread(this);
			t1.start();
		}
	}
	
	public level chooselevel(int num) {
		
		level l = null;
		
		switch(num) {
		case 1:
			l = new level1();
			break;
		case 2:
			l = new level2();
			break;
		case 3:
			l = new level3();
			break;
		case 4:
			l = new level4();
			break;
		case 5:
			l = new level5();
			break;
		}
		
		return l;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//ֻ�е�����ģʽ�²������ý��̣�����ؿ��Ľ��ȣ������Ƿ�������һ��
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(this.level.course > 20) {
				
				if(levelnum == 5
						) {
					this.remove(gl);
					this.remove(jp);
					jp = new endview();
					this.add(jp, BorderLayout.CENTER);
					break;
				}
				fen = gl.fens;
				levelnum++;
				level = this.chooselevel(levelnum);
				this.remove(gl);
				gl = new gamelogin(level, mess.speed, fen);
				this.addKeyListener(gl);
				this.add(gl);
				this.setVisible(true);
				Thread t = new Thread(gl);
				t.start();
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
