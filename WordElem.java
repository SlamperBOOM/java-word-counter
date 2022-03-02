import java.util.Objects;

public class WordElem implements Comparable<WordElem>{
    String word;
    int count;
    double frequency = 0;

    public WordElem(String word, int count){
        this.word = word;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordElem wordElem = (WordElem) o;
        return this.count == wordElem.count && Double.compare(wordElem.frequency, this.frequency) == 0 && this.word.equals(wordElem.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, count, frequency);
    }

    @Override
    public int compareTo(WordElem elem){
        if(this.equals(elem)){
            return 0;
        }
        else if(elem.count < this.count ||
                this.word.compareTo(elem.word) < 0) {
            return -1;
        }
        else{
            return 1;
        }
    }
}
