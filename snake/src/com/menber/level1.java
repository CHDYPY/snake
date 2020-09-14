package com.menber;

import java.awt.Color;

public class level1 extends level{
	public level1() {
		backcolor = new Color(0, 0, 0);
		foodcolor = new Color(255, 255, 255);
		rwcolor = Color.RED;
		snakecolor = Color.RED;
		landcolor = new Color(0, 0, 0);
		
		this.num  = 1;
		
		body[] b1_1 = new body[1];
		
		b1_1[0] = new body(800, 600, 1);
		
		land l = new land(b1_1, 1);
		
		this.block = new land[1];
		
		block[0] = l;
	}
}
