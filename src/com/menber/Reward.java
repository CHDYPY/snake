/*
 * ����ʳ��߳Ե������ͨʳ���
 * �ͻ��������һ������ʳ�ʳ�����10�룬
 * �����ķ���������ʱ������Ŷ�����
 * ����ʳ��Ĵ�СΪ��ͨʳ���С��25�� ��5*5��
 */
package com.menber;

import java.awt.Color;
import java.awt.Graphics;

public class Reward implements Runnable{
	public int x;
	public int y;
	public boolean life;
	public int price;//����������ÿ��һ���һ
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
