import java.io.*;
import java.util.*;

public class InputReader {
    public List<String> readWords(Reader input){
        Reader reader;
        List<String> words = new ArrayList<String>();
        try {
            reader = input;
            int symbol;
            StringBuilder word = new StringBuilder();
            while((symbol = reader.read()) != -1){
                if(Character.isLetterOrDigit((char)symbol)) {
                    word.append((char) symbol);
                }
                else if(word.length() != 0){
                    words.add(word.toString());
                    word = new StringBuilder();
                }
            }
            words.add(word.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}
