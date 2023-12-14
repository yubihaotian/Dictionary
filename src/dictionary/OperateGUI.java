package dictionary;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class OperateGUI extends MainGUI {
	//编辑单词界面
	public void newEditWordGUI() {
		//建立顶部框架
		JFrame frmEditWord = new JFrame();
		frmEditWord.setSize(525,350);
		frmEditWord.setLocation(540,300);
		frmEditWord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditWord.setLayout(null);

		//添加编辑单词界面组件
		JLabel labWord = new JLabel("需要编辑的单词：");
		labWord.setBounds(50, 20, 200, 30);
		frmEditWord.getContentPane().add(labWord);

		JTextField txtWord = new JTextField();
		txtWord.setBounds(250, 20, 200, 30);
		frmEditWord.getContentPane().add(txtWord);
		
		JLabel labcbTranslation = new JLabel("选择需要编辑的意思编号：");
		labcbTranslation.setBounds(50, 65, 200, 30);
		frmEditWord.getContentPane().add(labcbTranslation);
		
		JComboBox<String> cbTranslation = new JComboBox<String>();
		cbTranslation.setBounds(250, 65, 200, 30);
		frmEditWord.getContentPane().add(cbTranslation);

		JLabel labTranslation = new JLabel("输入新的翻译：");
		labTranslation .setBounds(50, 110, 200, 30);
		frmEditWord.getContentPane().add(labTranslation );

		JTextField txtTranslation = new JTextField();
		txtTranslation.setBounds(250, 110, 200, 30);
		frmEditWord.getContentPane().add(txtTranslation);

		JLabel labPartOfSpeech = new JLabel("输入新的词性：");
		labPartOfSpeech .setBounds(50, 155, 200, 30);
		frmEditWord.getContentPane().add(labPartOfSpeech );

		JTextField txtPartOfSpeech = new JTextField();
		txtPartOfSpeech.setBounds(250, 155, 200, 30);
		frmEditWord.getContentPane().add(txtPartOfSpeech);

		JTextField txtState = new JTextField();
		txtState.setBounds(150, 200, 200, 30);
		txtState.setBackground(Color.WHITE);
		txtState.setEditable(false);
		frmEditWord.getContentPane().add(txtState);

		JButton btAdd = new JButton("添加");
		btAdd.setBounds(50, 245, 175, 40); 
		frmEditWord.getContentPane().add(btAdd);

		JButton btReturn = new JButton("返回");
		btReturn.setBounds(275, 245, 175, 40);
		frmEditWord.getContentPane().add(btReturn);

		frmEditWord.setVisible(true);
		
		//添加事件

		// 进行翻译选择框列表项添加
		cbTranslation.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        String editdWord = txtWord.getText();
		        ArrayList<Word> words = dictionary.searchWord(editdWord);

		        if (words.isEmpty()) {
		            txtState.setForeground(Color.RED);
		            txtState.setHorizontalAlignment(JTextField.CENTER);
		            txtState.setText("单词不存在！");
		        } else {
		            txtState.setText("该单词有以下意思：");
		            cbTranslation.removeAllItems(); // 清空选项列表

		            for (int i = 0; i < words.size(); i++) {
		                cbTranslation.addItem((i + 1) + ":" + words.get(i).getTranslation() + words.get(i).getPartOfSpeech());
		            }
		        }
		    }
		});

		// 进行编辑单词
		btAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					operate.editWord(txtWord, txtTranslation, txtPartOfSpeech, txtState, cbTranslation);
				}  catch (Exception ex) {
					System.out.println(ex);
					txtState.setForeground(Color.RED);
					txtState.setHorizontalAlignment(JTextField.CENTER);
					txtState.setText("无法添加到文件");
				}
			}
		});

		//返回主界面
		btReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmEditWord.setVisible(false);
			}
		});
	}
	
	//删除单词界面
	public void newDeleteWordGUI() {
		//建立顶部框架
		JFrame frmDeleteWord = new JFrame();
		frmDeleteWord.setSize(525,350);
		frmDeleteWord.setLocation(540,300);
		frmDeleteWord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeleteWord.setLayout(null);

		//添加删除单词界面组件
		JLabel labWord = new JLabel("需要删除的单词：");
		labWord.setBounds(50, 80, 200, 40);
		frmDeleteWord.getContentPane().add(labWord);

		JTextField txtWord = new JTextField();
		txtWord.setBounds(250, 80, 200, 40);
		frmDeleteWord.getContentPane().add(txtWord);

		JTextField txtState = new JTextField();
		txtState.setBounds(150, 190, 200, 40);
		txtState.setBackground(Color.WHITE);
		txtState.setEditable(false);
		frmDeleteWord.getContentPane().add(txtState);

		JButton btAdd = new JButton("删除");
		btAdd.setBounds(50, 245, 175, 40); 
		frmDeleteWord.getContentPane().add(btAdd);

		JButton btReturn = new JButton("返回");
		btReturn.setBounds(275, 245, 175, 40);
		frmDeleteWord.getContentPane().add(btReturn);

		frmDeleteWord.setVisible(true);

		//添加事件

		//进行删除单词
		btAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					operate.deleteWord(txtWord, txtState);
				} catch (Exception e1) {
					System.out.println(e1);
					txtState.setForeground(Color.RED);
					txtState.setHorizontalAlignment(JTextField.CENTER);
					txtState.setText("无法添加到文件");
				}
			}
		});

		//返回主界面
		btReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmDeleteWord.setVisible(false);
			}
		});
	}
	
	//添加单词界面
	public void newAddWordGUI() {
		//建立顶部框架
		JFrame frmAddWord = new JFrame();
		frmAddWord.setSize(525,350);
		frmAddWord.setLocation(540,300);
		frmAddWord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddWord.setLayout(null);

		//添加添加单词界面组件
		JLabel labWord = new JLabel("需要添加的单词：");
		labWord.setBounds(50, 20, 200, 40);
		frmAddWord.getContentPane().add(labWord);

		JTextField txtWord = new JTextField();
		txtWord.setBounds(250, 20, 200, 40);
		frmAddWord.getContentPane().add(txtWord);

		JLabel labTranslation = new JLabel("单词对应的翻译：");
		labTranslation .setBounds(50, 80, 200, 40);
		frmAddWord.getContentPane().add(labTranslation );

		JTextField txtTranslation = new JTextField();
		txtTranslation.setBounds(250, 80, 200, 40);
		frmAddWord.getContentPane().add(txtTranslation);
		
		JLabel labPartOfSpeech = new JLabel("单词对应的词性：");
		labPartOfSpeech .setBounds(50, 140, 200, 40);
		frmAddWord.getContentPane().add(labPartOfSpeech );

		JTextField txtPartOfSpeech = new JTextField();
		txtPartOfSpeech.setBounds(250, 140, 200, 40);
		frmAddWord.getContentPane().add(txtPartOfSpeech);
		
		JTextField txtState = new JTextField();
		txtState.setBounds(150, 190, 200, 40);
		txtState.setBackground(Color.WHITE);
		txtState.setEditable(false);
		frmAddWord.getContentPane().add(txtState);

		JButton btAdd = new JButton("添加");
		btAdd.setBounds(50, 245, 175, 40); 
		frmAddWord.getContentPane().add(btAdd);

		JButton btReturn = new JButton("返回");
		btReturn.setBounds(275, 245, 175, 40);
		frmAddWord.getContentPane().add(btReturn);

		frmAddWord.setVisible(true);

		//添加事件

		//进行添加单词
		btAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					operate.addWord(txtWord, txtTranslation, txtPartOfSpeech, txtState);
				} catch (Exception e1) {
					System.out.println(e1);
					txtState.setText("添加失败");
				}
			}
		});

		//返回主界面
		btReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmAddWord.setVisible(false);
			}
		});
	}
	
	//汉译英界面
	public void newChineseToEnglishGUI() {
		//建立顶部框架
		JFrame frmCnToEn = new JFrame();
		frmCnToEn.setSize(525,350);
		frmCnToEn.setLocation(540,300);
		frmCnToEn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCnToEn.setLayout(null);
		
		//添加英译汉界面组件
		JLabel labChinese = new JLabel("需要翻译的中文单词：");
		labChinese.setBounds(50, 50, 200, 40);
		frmCnToEn.getContentPane().add(labChinese);
		
		JTextField txtChinese = new JTextField();
		txtChinese.setBounds(250, 50, 200, 40);
		frmCnToEn.getContentPane().add(txtChinese);
		
		JLabel labEnglish = new JLabel("其对应的英文单词为：");
		labEnglish.setBounds(50, 125, 200, 40);
		frmCnToEn.getContentPane().add(labEnglish);
		
		JTextField txtEnglish = new JTextField();
		txtEnglish.setBounds(250, 125, 200, 40);
		txtEnglish.setBackground(Color.WHITE);
		txtEnglish.setEditable(false);
		frmCnToEn.getContentPane().add(txtEnglish);
		
		JButton btTranslation = new JButton("翻译");
		btTranslation.setBounds(50, 245, 175, 40); 
		frmCnToEn.getContentPane().add(btTranslation);
		
		JButton btReturn = new JButton("返回");
		btReturn.setBounds(275, 245, 175, 40);
		frmCnToEn.getContentPane().add(btReturn);
		
		frmCnToEn.setVisible(true);
		
		//添加事件
		
		//进行汉译英
		btTranslation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				operate.chineseToEnglish(txtChinese, txtEnglish);
			}
		});

		//返回主界面
		btReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmCnToEn.setVisible(false);
			}
		});
	}
	
	//英译汉界面
	public void newEnglishToChineseGUI() {
		//建立顶部框架
		JFrame frmEnToCn = new JFrame();
		frmEnToCn.setSize(525,350);
		frmEnToCn.setLocation(540,300);
		frmEnToCn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnToCn.setLayout(null);
		
		//添加英译汉界面组件
		JLabel labEnglish = new JLabel("需要翻译的英文单词：");
		labEnglish.setBounds(50, 50, 200, 40);
		frmEnToCn.getContentPane().add(labEnglish);
		
		JTextField txtEnglish = new JTextField();
		txtEnglish.setBounds(250, 50, 200, 40);
		frmEnToCn.getContentPane().add(txtEnglish);
		
		JLabel labChinese = new JLabel("其中文翻译及词性为：");
		labChinese.setBounds(50, 125, 200, 40);
		frmEnToCn.getContentPane().add(labChinese);
		
		JTextField txtChinese = new JTextField();
		txtChinese.setBounds(250, 125, 200, 40);
		txtChinese.setBackground(Color.WHITE);
		txtChinese.setEditable(false);
		frmEnToCn.getContentPane().add(txtChinese);
		
		JButton btTranslation = new JButton("翻译");
		btTranslation.setBounds(50, 245, 175, 40); 
		frmEnToCn.getContentPane().add(btTranslation);
		
		JButton btReturn = new JButton("返回");
		btReturn.setBounds(275, 245, 175, 40);
		frmEnToCn.getContentPane().add(btReturn);
		
		frmEnToCn.setVisible(true);
		
		//添加事件
		
		//进行英译汉
		btTranslation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operate.englishToChinese(txtEnglish, txtChinese);
			}
		});
		
		//返回主界面
		btReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmEnToCn.setVisible(false);
			}
		});
	}
}
