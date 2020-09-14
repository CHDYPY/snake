/*
 * ��Ϸ����
 */
package com.view;

import java.awt.*;

import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import com.menber.*;
import java.util.*;

public class gamelogin extends JPanel implements Runnable,KeyListener{
	//�������
	snake sk;
	//������ͨʳ��
	food f;
	//�������
	int fens;
	//���影��ʳ��
	Reward rw;
	//���影������,�����������ﵽ5ʱ������һ������ʳ��
	int rwflag;
	//����ؿ��࣬���������Ҫ�ĵ�����Ϣ
	level level;
	//�ߵ��ٶ�
	public double speed;
	//����һ�������Ľ�����
	public JProgressBar jpb;
	//����ģʽ���е�����
	public JProgressBar jcourse; //���ؽ�����
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	//�ж���ͨʳ���Ƿ����ߺ͵����غ�
	public boolean isto() {
		boolean asd = false;
		for(int i = 0; i<sk.num; i++) {
			body b = sk.box[i];
			if(f.x == b.x && f.y == b.y) {
				return true;
			}
		}
		for(int i = 0; i<level.num; i++) {
			if(level.istouch(f.x, f.y)) {
				return true;
			}
		}
		return asd;
	}
	
	//�жϽ����Ƿ����ߺ͵����غ� 
	public boolean isrwto() {
		boolean asd = false;
		for(int i = 0; i<sk.num; i++) {
			body b = sk.box[i];
			if(rw.istouch(b.x, b.y))
				return true;
		}
		
		for(int i = 0; i<level.num; i++) {
			land l = level.block[i];
			for(int j = 0; j<l.num; j++) {
				body b = l.b[j];
				if(rw.istouch(b.x, b.y))
					return true;
			}
		}
		return asd;
	}
	//�Ǵ���ģʽ�Ĺ��캯��
	public gamelogin(level l, double speed) {
		l.course = -1; //���ִ���ģʽ�ı�־
		this.setLayout(null);
		//��ӽ���������
		jpb = new JProgressBar();
		jpb.setBounds(510, 200, 250, 20);
		this.add(jpb);
		
		
		this.speed = speed;
		sk = new snake(this.speed);
		f = new food();
		fens = 0;
		rw = null;
		rwflag = 0;
		level = l;
		while(this.isto()) {
			f = new food();
		}
		Thread t = new Thread(sk);
		t.start();
	}
	//����ģʽ�Ĺ��캯��
	public gamelogin(level l, double speed, int fen) {
		this.setLayout(null);
		//��ӽ���������
		jpb = new JProgressBar();
		jpb.setBounds(510, 200, 250, 20);
		this.add(jpb);
		//��Ӵ��ؽ�����
		l.course = 0;
		this.jcourse = new JProgressBar(0, 21);
		this.jcourse.setBounds(510, 250, 250, 20);
		this.add(jcourse);
		
		
		this.speed = speed;
		sk = new snake(this.speed);
		f = new food();
		fens = fen;
		rw = null;
		rwflag = 0;
		level = l;
		while(this.isto()) {
			f = new food();
		}
		Thread t = new Thread(sk);
		t.start();
	}
	//��������
	public void Drawsnake(Graphics g) {
		g.setColor(level.snakecolor);
	/*	for(int i = 0; i<sk.num ;i++) {
			body b = sk.box[i];
			g.drawRect(b.x, b.y, b.speed, b.speed);
		}*/
		sk.paintsnake(g, 500, 500);
	}
	//������ͨʳ��
	public void Drawfood(Graphics g) {
		g.setColor(level.foodcolor);
		g.fillOval(f.x, f.y, 5, 5);
	}
	
	//��������
	public void Drawland(Graphics g) {
		g.setColor(level.landcolor);
		level.paint(g);
	}
	
	//д����Ϸ����
	public void gameover(Graphics g) {
		g.setFont(new Font("����", 1, 50));
		Image image = null;
		try {
			image = ImageIO.read(new File("image\\gameover.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawString("Game Over", 100, 200);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	//�߳Ե�ʳ��
	public void eat() {
		if(sk.head.x == f.x && sk.head.y == f.y) {
			sk.add();
			fens = (int) (fens+10*speed);
			f = new food();
			while(this.isto()) {
				f = new food();
			}
			rwflag++;
			if(rwflag>=5) {
				rwflag = rwflag - 5;
				rw = new Reward();
				while(this.isrwto()) {
					rw = new Reward();
				}
				Thread t = new Thread(rw);
				t.start();
			}
			if(level.course>=0) {
				level.course = level.course+1;
				this.jcourse.setValue(level.course);
			}
		}
		
		if(rw !=null) {
			if(rw.istouch(sk.head.x, sk.head.y)) {
				fens = fens + 10*rw.price;
				rw.life = false;
			}
		}
	}
	//����
	public void score(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("����", 1, 50));
		g.drawString("����", 600, 50);
		g.drawString(fens+"", 620, 100);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(level.backcolor);
		g.fillRect(0, 0, 500, 500);
		//��������
		score(g);
		
		//��������
		Drawland(g);
		
		Drawsnake(g);
		//�Ȼ�����ʳ��ٻ���ͨʳ��
		if(rw != null) {
			if(rw.life != false) {
				g.setColor(level.rwcolor);
				rw.paintreward(g);
			} else {
				rw = null;
			}
		}
		Drawfood(g);
		if(!sk.life) {
			this.gameover(g);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.eat();
			if(level.istouch(sk.head.x, sk.head.y) || sk.istouch()) {
				sk.life = false;
			}
			if(this.rw!=null) {
				this.jpb.setValue(rw.price);
			} else if(jpb.getValue() != 0){
				this.jpb.setValue(0);
			}
			
			this.repaint();
			if(!sk.life) {
				break;
			}
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP && sk.head.ditrect != 3) {
			sk.head.ditrect = 1;
			System.out.println(sk.head.ditrect);
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT && sk.head.ditrect != 4) {
			sk.head.ditrect = 2;
			System.out.println(sk.head.ditrect);
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN && sk.head.ditrect != 1) {
			sk.head.ditrect = 3;
			System.out.println(sk.head.ditrect);
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT && sk.head.ditrect != 2) {
			sk.head.ditrect = 4;
			System.out.println(sk.head.ditrect);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
