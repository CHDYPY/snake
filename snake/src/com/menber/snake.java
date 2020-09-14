/*
 * 蛇的部分
 */
package com.menber;

import java.awt.Graphics;

public class snake implements Runnable{
	//定义元素
	public body head;
	public body[] box;
	public int num;
	public boolean life;
	public double speed; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		snake ss = new snake(1);
		Thread t = new Thread(ss);
		t.start();
	}
	public snake(double speed) {
		this.speed = speed;
		this.head = new body(250, 250, 4);
		head.next = null;
		this.box = new body[10000];
		this.box[0] = this.head;
		this.num = 1;
		this.life = true;
		this.add();
		this.add();
		this.add();
		this.add();
		this.add();
		this.add();
		this.add();
		this.add();
		this.add();
		this.add();
		this.add();
	}
	//在末尾添加一个body
	public void add() {
		body b;
		switch(box[num-1].ditrect) {
		
		case 1:
			b = new body(box[num-1].x, box[num-1].y+5, box[num-1].ditrect);
			b.next = box[num-1];
			box[num] = b;
			num++;
			break;
		case 2:
			b = new body(box[num-1].x+5, box[num-1].y, box[num-1].ditrect);
			b.next = box[num-1];
			box[num] = b;
			num++;
			break;
		case 3:
			b = new body(box[num-1].x, box[num-1].y-5, box[num-1].ditrect);
			b.next = box[num-1];
			box[num] = b;
			num++;
			break;
		case 4:
			b = new body(box[num-1].x-5, box[num-1].y, box[num-1].ditrect);
			b.next = box[num-1];
			box[num] = b;
			num++;
			break;
		}
		
	}
	//整体移动一次
	public void Move() {
		for(int i = num-1; i>0; i--) {
			body b = box[i];
			b.x = b.next.x;
			b.y = b.next.y;
			b.ditrect = b.next.ditrect;
		}
		head.Move();
	}
	
	//判断是否蛇是否有相互碰撞现象
	public boolean istouch() {
		boolean asd = false;
		for(int i = 2; i<num; i++) {
			body b = box[i];
			if(head.x == b.x && head.y == b.y) {
				asd = true;
				break;
			}
		}
		return asd;
	}
	
	//画出蛇来
	public void paintsnake(Graphics g, int w, int h) {
		for(int i = 0; i<num; i++) {
			box[i].paintbody(g, w, h);
		}
	}
	//判断蛇是否与地形碰撞
	public boolean island(int w, int h) {
		boolean asd = false;
		if(head.x >= w || head.x < 0 || head.y >= h || head.y < 0) {
			asd = true;
		}
		return asd;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep((long) (100/speed));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.Move();
			System.out.println(head.x);
			System.out.println(head.y);
			if(!this.life) {
				break;
			}
		}
	}

}

