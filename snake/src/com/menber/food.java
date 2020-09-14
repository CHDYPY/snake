/*
 * 食物的定义
 */
package com.menber;

public class food {
	public int x;
	public int y;
	public food() {
		x = ((int)(Math.random()*100))*5;
		y = ((int)(Math.random()*100))*5;
	}
}
