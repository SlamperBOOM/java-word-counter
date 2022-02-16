import java.lang.*;
import java.io.*;

public class WordReader {
    public static void main(String[] args) {
        Reader reader;
        try {
            if(args.length == 0){
                reader = new InputStreamReader(System.in);
            }
            else{
                reader = new InputStreamReader(new FileInputStream((args[0])));
            }
            int symbol;
            String word = "";
            while((symbol = reader.read()) != -1){
                if(Character.isLetterOrDigit((char)symbol)) {
                    word += (char) symbol;
                }
                else if(word.length() != 0){
                    WordCount.addword(word);
                    word = "";
                }
            }
            WordCount.addword(word);
            WordCount.printwords();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


