package dictionary;

import java.util.*;
import java.io.*;

public class Dictionary {
	Map<String, ArrayList<Word>> dictionaryMap = new HashMap<String, ArrayList<Word>>();	//单词映射
	
	
	//添加单词
	public void addWord(Word word) throws Exception{
		String key = word.getWord().toLowerCase();	//通过将单词转换为小写字母作为键
		ArrayList<Word> words = dictionaryMap.get(key);	//获取键所对应值
		if(words == null){
			words = new ArrayList<>();
			dictionaryMap.put(key, words);
		}
		if(!words.contains(word)) {
			words.add(word);
		}
	}
	
	//搜索单词
	public ArrayList<Word> searchWord(String word) {
		String key = word.toLowerCase();
		ArrayList<Word> words = dictionaryMap.get(key);
		if(words != null) {
			return words;
		}
		return new ArrayList<Word>();
	}
	
	//保存词典内容到文件
	public  void  SaveToFile(String  filePath,  Word  word)  throws  Exception  {
		FileWriter  fw  =  new  FileWriter(filePath,true);
		BufferedWriter  bw  =  new  BufferedWriter(fw);
		StringBuilder  sb  =  new  StringBuilder();
		sb.append(word.getWord()).append(",").append(word.getTranslation()).append(",").append(word.getPartOfSpeech());
		File file = new File(filePath);
		if(file != null || file.length() != 0 || file.exists()) {
		bw.newLine();			
		}
		bw.write(sb.toString());
		bw.close();
	}
	
	//从文件读取词典内容
	public ArrayList<Word> ReadToProgram(String filepath) throws Exception{
		ArrayList<Word> words =new ArrayList<Word>();
		FileReader fr =new FileReader(filepath);
		BufferedReader br = new BufferedReader(fr); 
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] array = line.split(",");
			if(array.length > 2 ) {
				String word = array[0];
				String translation = array[1];
				String partofspeech = array[2];
				words.add(new Word(word, translation, partofspeech));
			}
		}
		br.close();
		return words; 
	}
}
