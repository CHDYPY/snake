/*
 * 既用作蛇的躯体，又用作地形元素
 */
package com.menber;

import java.awt.Graphics;

public class body {
	public int x;
	public int y;
	public body next;//他的前一个身体
	public int ditrect;
	public int speed = 5;
	
	public body(int x, int y, int dirtect) {
		this.x = x;
		this.y = y;
		this.ditrect = dirtect;
	}
	
	public body(int x, int y, int dirtect, int speed) {
		this.x = x;
		this.y = y;
		this.ditrect = dirtect;
		this.speed = speed*5;
	}
	
	public void Up() {
		y = y - speed; 
	}
	
	public void Down() {
		y = y + speed;
	}
	
	public void Left() {
		x = x - speed;
	}
	
	public void Right() {
		x = x + speed;
	}
	
	public void Move() {
		switch(this.ditrect) {
		case 1:
			this.Up();
			break;
		case 2:
			this.Left();
			break;
		case 3:
			this.Down();
			break;
		case 4:
			this.Right();
			break;
		}
	}
	
	public void paintbody(Graphics g, int w, int h) {
		while(x>=w) {
			x = x - w;
		}
		
		while(y>=h) {
			y = y - h; 
		}
		
		while(x<0) {
			x = x + w;
		}
		
		while(y<0) {
			y = y + h;
		}
		g.draw3DRect(x, y, 5, 5, false);
	}
	
	public boolean istouch(int sx, int sy) {
		if(this.x == sx && this.y == sy) {
			return true;
		}
		return false;
	}
	
}