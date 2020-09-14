package com.menber;

import java.awt.Color;
import java.awt.Graphics;

public class level2 extends level {
	
	
	public level2() {
		
		backcolor = Color.yellow;
		foodcolor = Color.blue;
		landcolor = Color.CYAN;
		rwcolor = Color.RED;
		snakecolor = Color.black;
		this.num = 4;
		
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
		land l2_1 = new land(b2_1, 99);
		land l2_2 = new land(b2_2, 99);
		land l2_3 = new land(b2_3, 99);
		land l2_4 = new land(b2_4, 99);
		
		block = new land[num];
		block[0] = l2_1;
		block[1] = l2_2;
		block[2] = l2_3;
		block[3] = l2_4;
	}


}
