import java.util.*;
import java.lang.*;

public class WordCount{
    private TreeSet<WordElem> wordfrequency = new TreeSet<WordElem>();
    private HashSet<String> metwords = new HashSet<String>();
    private int totalwords = 0;

    public final TreeSet<WordElem> getStats(){
        for(WordElem elem : wordfrequency) {
            elem.frequency = elem.count / 1.0 / totalwords * 100;
        }
        return wordfrequency;
    }

    public void addWordsToStat(ArrayList<String> words){
        for(String word : words) {
            WordElem elem = new WordElem(word, 1);
            if (metwords.contains(word)) {
                Iterator<WordElem> it = wordfrequency.iterator();
                WordElem elem1;
                while (it.hasNext()) {
                    elem1 = it.next();
                    if (elem1.word.equals(word)) {
                        elem = elem1;
                        break;
                    }
                }
                wordfrequency.remove(elem);
                elem.count++;
            } else {
                metwords.add(word);
            }
            wordfrequency.add(elem);
            totalwords++;
        }
    }
}
