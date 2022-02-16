import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.StreamSupport;

public class WordCount{
    private static TreeSet<WordElem> data = new TreeSet<WordElem>();
    static int totalwords = 0;

    public static void addword(String word){
        WordElem elem = new WordElem(word, 1);
        if(!data.isEmpty()) {
            Iterator<WordElem> it = data.iterator();
            WordElem elem1 = elem;
            boolean exist = false;
            while (it.hasNext()) {
                elem1 = it.next();
                if (elem1.word.equals(word)) {
                    exist = true;
                    break;
                }
            }
            if(exist) {
                elem = elem1;
                data.remove(elem);
                elem.count++;
            }
        }
        data.add(elem);
        totalwords++;
    }

    public static void printwords(){
        Writer writer;
        try{
            writer = new OutputStreamWriter(new FileOutputStream("output.csv"));
            writer.write("Word;Count;Part of all words\n");
            Iterator<WordElem> it = data.iterator();
            while(it.hasNext()){
                WordElem elem = it.next();
                writer.write(elem.word + ";" + elem.count + ";" + elem.count/1.0/totalwords*100 + "%\n");
            }
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
