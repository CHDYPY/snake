/*
 * ѡ���ٶ�ѡ��
 */
package com.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.menber.*;
import java.util.*;

public class speedDialog extends JDialog implements ActionListener{
	message mess;
	//���帴ѡ����
	CheckboxGroup cbg1;
	Checkbox cb2_1, cb2_2, cb2_3;
	
	JPanel jp1, jp2;
	
	JLabel jl1;
	
	JButton jb;
	
	
	public speedDialog(Frame owner, String title, boolean modal, message m) {
		super(owner, title, modal);
		
		mess = m;
		
		jl1 = new JLabel("�ٶȣ�");
		
		jb = new JButton("ȷ��");
		jb.addActionListener(this);
		jb.setActionCommand("yes");
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		cbg1 = new CheckboxGroup();

		
		cb2_1 = new Checkbox("��", cbg1, true);
		cb2_2 = new Checkbox("��ͨ", cbg1, false);
		cb2_3 = new Checkbox("����", cbg1, false);
		
		
		
		jp1.add(jl1);
		jp1.add(cb2_1);
		jp1.add(cb2_2);
		jp1.add(cb2_3);
		
		jp2.add(jb);
		
		this.add(jp1, BorderLayout.CENTER);
		this.add(jp2, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setSize(400, 200);
		this.setLocation(600, 300);
		this.setVisible(true);
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("yes")) {
			Checkbox cb = cbg1.getSelectedCheckbox();
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
