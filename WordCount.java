import java.util.*;
import java.lang.*;
import java.io.*;

public class WordCount{
    private TreeSet<WordElem> data = new TreeSet<WordElem>();
    private HashSet<String> words = new HashSet<String>();
    private int totalwords = 0;

    public void readfile(InputStreamReader input){
        Reader reader = null;
        try {
            reader = input;
            int symbol;
            String word = "";
            while((symbol = reader.read()) != -1){
                if(Character.isLetterOrDigit((char)symbol)) {
                    word += (char) symbol;
                }
                else if(word.length() != 0){
                    addword(word);
                    word = "";
                }
            }
            addword(word);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(reader != null){
                try{
                    reader.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void writewords(OutputStreamWriter output){
        Writer writer = null;
        try{
            writer = output;
            writer.write("Word;Count;Part of all words\n");
            Iterator<WordElem> it = data.iterator();
            while(it.hasNext()){
                WordElem elem = it.next();
                writer.write(elem.word + ";" + elem.count + ";" + elem.count/1.0/totalwords*100 + "%\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void addword(String word){
        WordElem elem = new WordElem(word, 1);
        if(words.contains(word)) {
            Iterator<WordElem> it = data.iterator();
            WordElem elem1;
            while (it.hasNext()) {
                elem1 = it.next();
                if (elem1.word.equals(word)) {
                    elem = elem1;
                    break;
                }
            }
            data.remove(elem);
            elem.count++;
        }
        else{
            words.add(word);
        }
        data.add(elem);
        totalwords++;
    }
}
