public class WordElem implements Comparable<WordElem>{
    String word;
    int count;

    public WordElem(String word, int count){
        this.word = word;
        this.count = count;
    }

    public int compareTo(WordElem elem){
        if(this.word.compareTo(elem.word) == 0){
            return 0;
        }
        else if(elem.count < this.count ||
                (this.word.length() < elem.word.length() || this.word.compareTo(elem.word) < 0)) {
            return -1;
        }
        else{
            return 1;
        }
    }
}
