package com.menber;

import java.awt.Color;

public class level3 extends level {
	
	public level3() {
		backcolor = Color.GREEN;
		snakecolor = Color.pink;
		rwcolor = Color.RED;
		foodcolor = Color.BLACK;
		landcolor = Color.GRAY;
		this.num = 4;
		
		body []b3_1 = new body[200];
		body []b3_2 = new body[200]; 
		body []b3_3 = new body[200]; 
		body []b3_4 = new body[200]; 
		
		for(int i = 0; i<40; i++) {
			b3_1[i] = new body(325, i*5, 1);
			b3_1[i+40] = new body(330, i*5, 1);
			b3_1[i+80] = new body(335, i*5, 1);
			b3_1[i+120] = new body(340, i*5, 1);
			b3_1[i+160] = new body(345, i*5, 1);
			
			b3_2[i] = new body(150, 500-i*5, 1);
			b3_2[i+40] = new body(155, 500-i*5, 1);
			b3_2[i+80] = new body(160, 500-i*5, 1);
			b3_2[i+120] = new body(165, 500-i*5, 1);
			b3_2[i+160] = new body(170, 500-i*5, 1);
			
			b3_3[i] = new body(i*5, 150, 1);
			b3_3[i+40] = new body(i*5, 155, 1);
			b3_3[i+80] = new body(i*5, 160, 1);
			b3_3[i+120] = new body(i*5, 165, 1);
			b3_3[i+160] = new body(i*5, 170, 1);
			
			b3_4[i] = new body(500-i*5, 325, 1);
			b3_4[i+40] = new body(500-i*5, 330, 1);
			b3_4[i+80] = new body(500-i*5, 335, 1);
			b3_4[i+120] = new body(500-i*5, 340, 1);
			b3_4[i+160] = new body(500-i*5, 345, 1);
			
		}
		
		land l3_1 = new land(b3_1, 200);
		land l3_2 = new land(b3_2, 200);
		land l3_3 = new land(b3_3, 200);
		land l3_4 = new land(b3_4, 200);
		
		block = new land[num];
		block[0] = l3_1;
		block[1] = l3_2;
		block[2] = l3_3;
		block[3] = l3_4;
	}

}
