import java.util.*;
import java.lang.*;

public class WordCount{
    private TreeSet<WordElem> wordFrequency = new TreeSet<WordElem>();
    private HashSet<String> addedWords = new HashSet<String>();
    private int totalWords = 0;

    public final Set<WordElem> getStats(){
        for(WordElem elem : wordFrequency) {
            elem.frequency = elem.count / 1.0 / totalWords * 100;
        }
        return wordFrequency;
    }

    public void addWordsToStat(List<String> words){
        for(String word : words) {
            WordElem elem = new WordElem(word, 1);
            if (addedWords.contains(word)) {
                Iterator<WordElem> it = wordFrequency.iterator();
                WordElem elem1;
                while (it.hasNext()) {
                    elem1 = it.next();
                    if (elem1.word.equals(word)) {
                        elem = elem1;
                        break;
                    }
                }
                wordFrequency.remove(elem);
                elem.count++;
            } else {
                addedWords.add(word);
            }
            wordFrequency.add(elem);
            totalWords++;
        }
    }
}
