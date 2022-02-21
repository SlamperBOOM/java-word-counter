import java.io.*;
import java.util.*;

public class InputReader {
    public ArrayList<String> readWords(InputStreamReader input){
        Reader reader;
        ArrayList<String> words = new ArrayList<String>();
        try {
            reader = input;
            int symbol;
            String word = "";
            while((symbol = reader.read()) != -1){
                if(Character.isLetterOrDigit((char)symbol)) {
                    word += (char) symbol;
                }
                else if(word.length() != 0){
                    words.add(word);
                    word = "";
                }
            }
            words.add(word);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}
