package com.menber;

import java.awt.Color;
import java.awt.Graphics;

public abstract class level {
	
	public Color backcolor;
	public Color landcolor;
	public Color foodcolor;
	public Color rwcolor;
	public Color snakecolor;
	
	public land[] block;
	public int num;
	public int course;//闯关模式下，特有的属性，表示当前关卡的进度
	public double speed; //用于自定义中进行传递
	
	public void paint(Graphics g) {
		for(int i = 0; i<num; i++) {
			block[i].paintland(g);
		}
	}
	
	public boolean istouch(int sx, int sy) {
		for(int i = 0; i<num; i++) {
			if(block[i].istouch(sx, sy)) {
				return true;
			}
		}
		return false;
	}
	
/*	
	static public land[] level1; 
	static public land[] level2; 
	static public land[] level3; 
	static public land[] level4; 
	static public land[] level5; 
	
	public level() {
		//初始化第一关
		body[] b = null;
		land l = new land(b);
		level1 = new land[1];
		level1[0] = l;
		
		//初始化第二关
		body[] b2_1 = new body[99];
		body[] b2_2 = new body[99];
		body[] b2_3 = new body[99];
		body[] b2_4 = new body[99];
		for(int i = 0; i<99; i++) {
			b2_1[i] = new body(i*5, 0, 1);
			b2_2[i] = new body(99*5, i*5, 1);
			b2_3[i] = new body((i+1)*5, 99*5, 1);
			b2_4[i] = new body(0, (i+1)*5, 1);
		}
		land l2_1 = new land(b2_1);
		land l2_2 = new land(b2_2);
		land l2_3 = new land(b2_3);
		land l2_4 = new land(b2_4);
		
		level2 = new land[4];
		level2[0] = l2_1;
		level2[1] = l2_2;
		level2[2] = l2_3;
		level2[3] = l2_4;
	}
	
	public boolean istouch(int sx, int sy) {
		for(int i = 0; i<)
		return false;
	}*/

}
