/*
 * ѡ���Զ���ʱ�����ĶԻ���
 */
package com.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.menber.*;
import java.util.*;

public class setDialog extends JDialog implements ActionListener{
	
	
	message mess;
	//���帴ѡ����
	CheckboxGroup cbg1,cbg2;
	Checkbox cb1_1, cb1_2, cb1_3, cb1_4, cb1_5;
	Checkbox cb2_1, cb2_2, cb2_3;
	
	JPanel jp1, jp2, jp3;
	
	JLabel jl1, jl2;
	
	JButton jb;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	

	public setDialog(Frame owner, String title, boolean modal, message m) {
		super(owner, title, modal);
		
		mess = m;
		
		jl1 = new JLabel("ѡ�أ�");
		jl2 = new JLabel("�ٶȣ�");
		
		jb = new JButton("ȷ��");
		jb.addActionListener(this);
		jb.setActionCommand("yes");
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		cbg1 = new CheckboxGroup();
		cbg2 = new CheckboxGroup();
		
		cb1_1 = new Checkbox("��һ��", cbg1, true);
		cb1_2 = new Checkbox("�ڶ���", cbg1, false);
		cb1_3 = new Checkbox("������", cbg1, false);
		cb1_4 = new Checkbox("���Ĺ�", cbg1, false);
		cb1_5 = new Checkbox("�����", cbg1, false);
		
		cb2_1 = new Checkbox("��", cbg2, true);
		cb2_2 = new Checkbox("��ͨ", cbg2, false);
		cb2_3 = new Checkbox("����", cbg2, false);
		
		
		jp1.add(jl1);
		jp1.add(cb1_1);
		jp1.add(cb1_2);
		jp1.add(cb1_3);
		jp1.add(cb1_4);
		jp1.add(cb1_5);
		
		jp2.add(jl2);
		jp2.add(cb2_1);
		jp2.add(cb2_2);
		jp2.add(cb2_3);
		
		jp3.add(jb);
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setSize(400, 200);
		this.setLocation(600, 300);
		this.setVisible(true);
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("yes")) {
			Checkbox cb = cbg1.getSelectedCheckbox();
			if(cb.getLabel().equals("��һ��")) {
				mess.levelnum = 1;
			} else if(cb.getLabel().equals("�ڶ���")) {
				mess.levelnum = 2;
			} else if(cb.getLabel().equals("������")) {
				mess.levelnum = 3;
			} else if(cb.getLabel().equals("���Ĺ�")) {
				mess.levelnum = 4;
			} else if(cb.getLabel().equals("�����")) {
				mess.levelnum = 5;
			}
			
			cb = cbg2.getSelectedCheckbox();
			if(cb.getLabel().equals("��")) {
				mess.speed = 1;
			} else if(cb.getLabel().equals("��ͨ")) {
				mess.speed = 1.5;
			} else if(cb.getLabel().equals("����")) {
				mess.speed = 2;
			}
			
			this.dispose();
		}
	}

}
