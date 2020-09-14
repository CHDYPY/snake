/*
 * 奖励食物，蛇吃到五个普通食物后，
 * 就会随机出现一个特殊食物，食物持续10秒，
 * 奖励的分数会随着时间的流逝而减少
 * 奖励食物的大小为普通食物大小的25倍 （5*5）
 */
package com.menber;

import java.awt.Color;
import java.awt.Graphics;

public class Reward implements Runnable{
	public int x;
	public int y;
	public boolean life;
	public int price;//奖励参数，每过一秒减一
	public Reward() {
		x = ((int)(Math.random()*95))*5;
		y = ((int)(Math.random()*95))*5;
		life = true;
		price = 100;
	}
	
	public boolean istouch(int sx, int sy) {
		boolean b = false;
		for(int i = 0; i<5; i++) {
			int w = x+i*5;
			for(int j = 0; j<5; j++) {
				int h = j*5 + y;
				if(sx == w && sy == h) {
					return true;
				}
			}
		}
		
		
		return b;
		
	}
	
	public void paintreward(Graphics g) {
		g.fillOval(x, y, 25, 25);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(price > 0) {
			price--;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		life = false;
	}

}
