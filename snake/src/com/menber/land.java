package com.menber;

import java.awt.Color;
import java.awt.Graphics;

public class land {
	public body[] b = null;
	public int num;
	public void paintland(Graphics g) {
		for(int i = 0; i<num; i++) {
			g.fillRect(b[i].x, b[i].y, 5, 5);
		}
	}
	
	public land(body[] b, int num) {
		this.b = b;
		this.num = num;
	}
	
	public boolean istouch(int sx, int sy) {
		for(int i = 0; i<num; i++) {
			if(b[i].istouch(sx, sy)) {
				return true;
			}
		}
		return false;
	}
}
