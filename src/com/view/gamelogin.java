/*
 * 游戏界面
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
	//定义变量
	snake sk;
	//定义普通食物
	food f;
	//定义分数
	int fens;
	//定义奖励食物
	Reward rw;
	//定义奖励参数,当奖励次数达到5时，创建一个奖励食物
	int rwflag;
	//定义关卡类，里面包含必要的地形信息
	level level;
	//蛇的速度
	public double speed;
	//设置一个奖励的进度条
	public JProgressBar jpb;
	//闯关模式特有的属性
	public JProgressBar jcourse; //闯关进度条
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	//判断普通食物是否与蛇和地形重合
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
	
	//判断奖励是否与蛇和地形重合 
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
	//非闯关模式的构造函数
	public gamelogin(level l, double speed) {
		l.course = -1; //区分闯关模式的标志
		this.setLayout(null);
		//添加奖励进度条
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
	//闯关模式的构造函数
	public gamelogin(level l, double speed, int fen) {
		this.setLayout(null);
		//添加奖励进度条
		jpb = new JProgressBar();
		jpb.setBounds(510, 200, 250, 20);
		this.add(jpb);
		//添加闯关进度条
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
	//画出蛇来
	public void Drawsnake(Graphics g) {
		g.setColor(level.snakecolor);
	/*	for(int i = 0; i<sk.num ;i++) {
			body b = sk.box[i];
			g.drawRect(b.x, b.y, b.speed, b.speed);
		}*/
		sk.paintsnake(g, 500, 500);
	}
	//画出普通食物
	public void Drawfood(Graphics g) {
		g.setColor(level.foodcolor);
		g.fillOval(f.x, f.y, 5, 5);
	}
	
	//画出地形
	public void Drawland(Graphics g) {
		g.setColor(level.landcolor);
		level.paint(g);
	}
	
	//写出游戏结束
	public void gameover(Graphics g) {
		g.setFont(new Font("宋体", 1, 50));
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
	
	//蛇吃掉食物
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
	//分数
	public void score(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("宋体", 1, 50));
		g.drawString("分数", 600, 50);
		g.drawString(fens+"", 620, 100);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(level.backcolor);
		g.fillRect(0, 0, 500, 500);
		//画出分数
		score(g);
		
		//画出地形
		Drawland(g);
		
		Drawsnake(g);
		//先画奖励食物，再画普通食物
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
