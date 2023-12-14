package dictionary;

import java.util.*;

public class Main{
	static Scanner scanf = new Scanner(System.in);
	static Dictionary dictionary = new Dictionary();
	static Operate operate = new Operate();
	
	public static void main(String[] args) throws Exception {
		//初始化词典库
		ArrayList<Word> words = dictionary.ReadToProgram("dictionary.txt");
		
		if(words.isEmpty()) {
			System.exit(0);
		}else {
			for(Word w:words) {
				dictionary.addWord(w);
			}
		}
		
		//创建主界面对象
		MainGUI mainGUI = new MainGUI();
		mainGUI.newMainGUI();
	}
}
