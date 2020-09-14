package com.menber;

import java.awt.Color;

public class level5 extends level{
	
	public level5() {
		backcolor = new Color(0, 0, 0);
		foodcolor = new Color(255, 255, 255);
		rwcolor = Color.pink;
		snakecolor = new Color(0, 255, 127);
		landcolor = new Color(105, 105, 105);
		this.num = 8;
		
		
		body []b5_1 = new body[300];
		body []b5_2 = new body[100]; 
		body []b5_3 = new body[175]; 
		body []b5_4 = new body[125]; 
		body []b5_5 = new body[125];
		body []b5_6 = new body[450];
		body []b5_7 = new body[500];
		body []b5_8 = new body[350];
		
		for(int i = 0; i<30; i++) {
			b5_1[i] = new body(0, i*5, 1);
			b5_1[i+30] = new body(5, i*5, 1);
			b5_1[i+60] = new body(10, i*5, 1);
			b5_1[i+90] = new body(15, i*5, 1);
			b5_1[i+120] = new body(20, i*5, 1);
			
			b5_1[i+150] = new body(275, i*5, 1);
			b5_1[i+180] = new body(280, i*5, 1);
			b5_1[i+210] = new body(285, i*5, 1);
			b5_1[i+240] = new body(290, i*5, 1);
			b5_1[i+270] = new body(295, i*5, 1);
		}
		
		for(int i = 0; i<20; i++) {
			b5_2[i] = new body(350+i*5, 0, 1);
			b5_2[i+20] = new body(350+i*5, 5, 1);
			b5_2[i+40] = new body(350+i*5, 10, 1);
			b5_2[i+60] = new body(350+i*5, 15, 1);
			b5_2[i+80] = new body(350+i*5, 20, 1);
		}
		
		for(int i = 0; i<35; i++) {
			b5_3[i] = new body(200, i*5, 1);
			b5_3[i+35] = new body(205, i*5, 1);
			b5_3[i+70] = new body(210, i*5, 1);
			b5_3[i+105] = new body(215, i*5, 1);
			b5_3[i+140] = new body(220, i*5, 1);
		}
		
		for(int i = 0; i<25; i++) {
			b5_4[i] = new body(25+i*5, 0, 1);
			b5_4[i+25] = new body(25+i*5, 5, 1);
			b5_4[i+50] = new body(25+i*5, 10, 1);
			b5_4[i+75] = new body(25+i*5, 15, 1);
			b5_4[i+100] = new body(25+i*5, 20, 1);
		}
		
		for(int i = 0; i<25; i++) {
			b5_5[i] = new body(150, 350+i*5, 1);
			b5_5[i+25] = new body(155, 350+i*5, 1);
			b5_5[i+50] = new body(160, 350+i*5, 1);
			b5_5[i+75] = new body(165, 350+i*5, 1);
			b5_5[i+100] = new body(170, 350+i*5, 1);
		}
		
		for(int i = 0; i<45; i++) {
			b5_6[i] = new body(i*5, 175, 1);
			b5_6[i+45] = new body(i*5, 180, 1);
			b5_6[i+90] = new body(i*5, 185, 1);
			b5_6[i+135] = new body(i*5, 190, 1);
			b5_6[i+180] = new body(i*5, 195, 1);
			
			b5_6[i+225] = new body(275+i*5, 175, 1);
			b5_6[i+270] = new body(275+i*5, 180, 1);
			b5_6[i+315] = new body(275+i*5, 185, 1);
			b5_6[i+360] = new body(275+i*5, 190, 1);
			b5_6[i+405] = new body(275+i*5, 195, 1);
		}
		
		for(int i = 0; i<100; i++) {
			b5_7[i] = new body(i*5, 300, 1);
			b5_7[i+100] = new body(i*5, 305, 1);
			b5_7[i+200] = new body(i*5, 310, 1);
			b5_7[i+300] = new body(i*5, 315, 1);
			b5_7[i+400] = new body(i*5, 320, 1);
		}
		
		for(int i = 0; i<35; i++) {
			b5_8[i] = new body(225, 325+i*5, 1);
			b5_8[i+35] = new body(230, 325+i*5, 1);
			b5_8[i+70] = new body(235, 325+i*5, 1);
			b5_8[i+105] = new body(240, 325+i*5, 1);
			b5_8[i+140] = new body(245, 325+i*5, 1);
			b5_8[i+175] = new body(250, 325+i*5, 1);
			b5_8[i+210] = new body(255, 325+i*5, 1);
			b5_8[i+245] = new body(260, 325+i*5, 1);
			b5_8[i+280] = new body(265, 325+i*5, 1);
			b5_8[i+315] = new body(270, 325+i*5, 1);
		}
		

		land l4_1 = new land(b5_1, 300);
		land l4_2 = new land(b5_2, 100);
		land l4_3 = new land(b5_3, 175);
		land l4_4 = new land(b5_4, 125);
		land l4_5 = new land(b5_5, 125);
		land l4_6 = new land(b5_6, 450);
		land l4_7 = new land(b5_7, 500);
		land l4_8 = new land(b5_8, 350);
		
		block = new land[num];
		block[0] = l4_1;
		block[1] = l4_2;
		block[2] = l4_3;
		block[3] = l4_4;
		block[4] = l4_5;
		block[5] = l4_6;
		block[6] = l4_7;
		block[7] = l4_8;
		
		
		
		
	}

}
