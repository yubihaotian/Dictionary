package dictionary;

public class Word {
	private String word;				//单词
	private String translation;			//翻译
	private String partOfSpeech;		//词性
	
	public Word(String word,String translation,String partOfSpeech) {	//编写含参构造
		this.word = word;
		this.translation = translation;
		this.partOfSpeech = partOfSpeech;
	}
	
	public String getWord() {					//获取单词
		return word;
	}

    public String getTranslation() {			//获取翻译
        return translation;
    }

    public String getPartOfSpeech() {			//获取词性
        return partOfSpeech;
    }
    
	public void setTranslation(String translation) {			//更改翻译
		this.translation = translation;		
	}
    
    public void setPartOfSpeech(String partOfSpeech) {			//更改词性
        this.partOfSpeech = partOfSpeech;
    }
    
}
