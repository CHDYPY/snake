package com.menber;

import java.awt.Color;

public class level4 extends level{
	
	public level4() {
		backcolor = new Color(255, 0, 0);
		foodcolor = new Color(0, 255, 255);
		rwcolor = Color.white;
		snakecolor = new Color(255, 231, 186);
		landcolor = new Color(139, 26, 26);
		this.num = 4;
		
		body []b4_1 = new body[320];
		body []b4_2 = new body[320]; 
		body []b4_3 = new body[1000]; 
		body []b4_4 = new body[600]; 
		
		for(int i = 0; i<40; i++) {
			b4_1[i] = new body(0, i*5, 1);
			b4_1[i+40] = new body(5, i*5, 1);
			b4_1[i+80] = new body(10, i*5, 1);
			b4_1[i+120] = new body(15, i*5, 1);
			
			b4_1[i+160] = new body(495-0, i*5, 1);
			b4_1[i+200] = new body(495-5, i*5, 1);
			b4_1[i+240] = new body(495-10, i*5, 1);
			b4_1[i+280] = new body(495-15, i*5, 1);
			
			
			b4_2[i] = new body(0, 495-i*5, 1);
			b4_2[i+40] = new body(5, 495-i*5, 1);
			b4_2[i+80] = new body(10, 495-i*5, 1);
			b4_2[i+120] = new body(15, 495-i*5, 1);
			
			b4_2[i+160] = new body(495-0, 495-i*5, 1);
			b4_2[i+200] = new body(495-5, 495-i*5, 1);
			b4_2[i+240] = new body(495-10, 495-i*5, 1);
			b4_2[i+280] = new body(495-15, 495-i*5, 1);
		}
		
		for(int i = 0; i<100; i++) {
			b4_3[i] = new body(i*5, 0, 1); 
			b4_3[i+100] = new body(i*5, 5, 1); 
			b4_3[i+200] = new body(i*5, 10, 1);
			b4_3[i+300] = new body(i*5, 15, 1); 
			b4_3[i+400] = new body(i*5, 20, 1); 
			
			b4_3[i+500] = new body(i*5, 495-0, 1); 
			b4_3[i+600] = new body(i*5, 495-5, 1); 
			b4_3[i+700] = new body(i*5, 495-10, 1);
			b4_3[i+800] = new body(i*5, 495-15, 1); 
			b4_3[i+900] = new body(i*5, 495-20, 1); 
		}
		
		for(int i = 0; i<60; i++) {
			b4_4[i] = new body(100+i*5, 100, 1);
			b4_4[i+60] = new body(100+i*5, 105, 1);
			b4_4[i+120] = new body(100+i*5, 110, 1);
			b4_4[i+180] = new body(100+i*5, 115, 1);
			b4_4[i+240] = new body(100+i*5, 120, 1);
			
			b4_4[i+300] = new body(100+i*5, 495-100, 1);
			b4_4[i+360] = new body(100+i*5, 495-105, 1);
			b4_4[i+420] = new body(100+i*5, 495-110, 1);
			b4_4[i+480] = new body(100+i*5, 495-115, 1);
			b4_4[i+540] = new body(100+i*5, 495-120, 1);
			
		}
		
		
		
		
		
		land l4_1 = new land(b4_1, 320);
		land l4_2 = new land(b4_2, 320);
		land l4_3 = new land(b4_3, 1000);
		land l4_4 = new land(b4_4, 600);
		
		block = new land[num];
		block[0] = l4_1;
		block[1] = l4_2;
		block[2] = l4_3;
		block[3] = l4_4;
	}

}
