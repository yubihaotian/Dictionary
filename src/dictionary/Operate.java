package dictionary;

import java.awt.*;
import java.io.FileWriter;
import java.util.*;
import javax.swing.*;

public class Operate extends Main{
	//英译汉
	public void englishToChinese(JTextField txtEnglish , JTextField txtChinese) {
		String word = txtEnglish.getText().trim();
		ArrayList<Word> words = dictionary.searchWord(word);

		if(words.isEmpty()) {
			txtChinese.setForeground(Color.RED);
			txtChinese.setText("单词不存在！");
		}else {
			for(Word w :words) {
				txtChinese.setText(w.getTranslation() + "\t" + w.getPartOfSpeech());
			}
		}
	}

	//汉译英
	public void chineseToEnglish(JTextField txtChinese , JTextField txtEnglish) {
		String word = txtChinese.getText().trim();
		ArrayList<Word> words = new ArrayList<Word>();
		
		//遍历单词散列表中的每个单词
		for(ArrayList<Word> entry :dictionary.dictionaryMap.values()) {
			for(Word w :entry) {
				if(w.getTranslation().equals(word)) {
					words.add(w);
				}
			}
		}
		
		if(words.isEmpty()) {
			txtEnglish.setForeground(Color.RED);
			txtEnglish.setText("单词不存在！");
		}else {
			for(Word w :words) {
				txtEnglish.setText(w.getWord());
			}
		}
	}
	
	//添加单词
	public void addWord(JTextField txtWord , JTextField txtTranslation , JTextField txtPartOfSpeech , JTextField txtState) throws Exception {
		String word = txtWord.getText();
		String translation = txtTranslation.getText();
		String partOfSpeech = txtPartOfSpeech.getText();
		dictionary.addWord(new Word(word, translation, partOfSpeech));
		dictionary.SaveToFile("dictionary.txt", new Word(word, translation, partOfSpeech));
		txtState.setHorizontalAlignment(JTextField.CENTER);
		txtState.setText("添加成功");
	}

	//删除单词
	public void deleteWord(JTextField txtWord , JTextField txtState) throws Exception{
		String word = txtWord.getText().trim();
		ArrayList<Word> words = dictionary.searchWord(word);
		
		if(words.isEmpty()) {
			txtState.setForeground(Color.RED);
			txtState.setHorizontalAlignment(JTextField.CENTER);
			txtState.setText("单词不存在！");
		}else {
			if(dictionary.dictionaryMap.containsKey(word)) {
				 dictionary.dictionaryMap.remove(word);
			}
			
			//清空文件
			FileWriter fw = new FileWriter("dictionary.txt", false);
			fw.write("");
			fw.close();
			
			//重写文件
			for(ArrayList<Word>arrayList:dictionary.dictionaryMap.values()) {
				Word w = arrayList.get(0);
				String wordStr = w.getWord();
				String translation = w.getTranslation();
				String partOfSpeech = w.getPartOfSpeech();
				dictionary.SaveToFile("dictionary.txt", new Word(wordStr, translation, partOfSpeech));
			}
			txtState.setHorizontalAlignment(JTextField.CENTER);
			txtState.setText("删除成功");
		}
	}

	//编辑单词
	public void editWord(JTextField txtWord, JTextField txtTranslation, JTextField txtPartOfSpeech, JTextField txtState, JComboBox<String> cbTranslation) throws Exception{
		Word word;
		String editedWord = txtWord.getText();
		ArrayList<Word> words = dictionary.searchWord(editedWord);

		if (words.isEmpty()) {
			txtState.setForeground(Color.RED);
			txtState.setHorizontalAlignment(JTextField.CENTER);
			txtState.setText("单词不存在！");
		} else {
			int index = cbTranslation.getSelectedIndex();
			if (index < 0 || index >= words.size()) {
				txtState.setForeground(Color.RED);
				txtState.setHorizontalAlignment(JTextField.CENTER);
				txtState.setText("输入无效");
			} else {
				word = words.get(index);
				String translation = txtTranslation.getText();
				word.setTranslation(translation);
				String partOfSpeech = txtPartOfSpeech.getText();
				word.setPartOfSpeech(partOfSpeech);
				
				//更新词典库
				words.set(index, word);
				String key = word.getWord().toLowerCase();
				dictionary.dictionaryMap.put(key, words);
			}
			
			//清空文件
			FileWriter fw = new FileWriter("dictionary.txt", false);
			fw.write("");
			fw.close();
			
			//重写文件
			for(ArrayList<Word>arrayList:dictionary.dictionaryMap.values()) {
				Word w = arrayList.get(0);
				String wordStr = w.getWord();
				String translation = w.getTranslation();
				String partOfSpeech = w.getPartOfSpeech();
				dictionary.SaveToFile("dictionary.txt", new Word(wordStr, translation, partOfSpeech));
			}
			txtState.setHorizontalAlignment(JTextField.CENTER);
			txtState.setText("修改完成");
		}
	}
}
