package dictionary;

import java.awt.event.*;
import javax.swing.*;

public class MainGUI extends Main{
	JFrame frm = new JFrame();
	boolean flag = false;
	public void newMainGUI() {
		OperateGUI gui = new OperateGUI();
		//建立顶部框架
		
		frm.setSize(600,550);
		frm.setLocation(500,200);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);
		
		//添加主界面组件
		JButton bt1 = new JButton("英译汉");
		bt1.setBounds(100, 20, 400, 60); 
		frm.getContentPane().add(bt1);
		
		JButton bt2 = new JButton("汉译英");
		bt2.setBounds(100, 100, 400, 60);
		frm.getContentPane().add(bt2);
		
		JButton bt3 = new JButton("添加单词");
		bt3.setBounds(100, 180, 400, 60);
		frm.getContentPane().add(bt3);
		
		JButton bt4 = new JButton("删除单词");
		bt4.setBounds(100, 260, 400, 60);
		frm.getContentPane().add(bt4);
		
		JButton bt5 = new JButton("编辑单词");
		bt5.setBounds(100, 340, 400, 60);
		frm.getContentPane().add(bt5);
		
		JButton bt6 = new JButton("退出");
		bt6.setBounds(100, 420, 400, 60);
		frm.getContentPane().add(bt6);
		
		frm.setVisible(true);
		
		//添加事件
		
		//打开英译汉界面
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.newEnglishToChineseGUI();
			}
		});
		
		//打开汉译英界面
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.newChineseToEnglishGUI();
			}
		});
		
		//打开添加单词界面
		bt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.newAddWordGUI();
			}
		});
		
		//打开删除单词界面
		bt4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.newDeleteWordGUI();
			}
		});
		
		//打开编辑单词界面
		bt5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.newEditWordGUI();
			}
		});
		
		//退出词典
		bt6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
}
