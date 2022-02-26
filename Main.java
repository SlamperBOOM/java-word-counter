import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Reader input = null;
        Writer output = null;
        try {

            if (args.length == 0) {
                input = new InputStreamReader(System.in);
            } else {
                input = new InputStreamReader(new FileInputStream((args[0])));
            }
            WordCount counter = new WordCount();
            InputReader reader = new InputReader();
            List<String> words = reader.readWords(input);
            counter.addWordsToStat(words);

            if(args.length == 2) {
                output = new OutputStreamWriter(new FileOutputStream(args[1]));
            }
            else{
                output = new OutputStreamWriter(new FileOutputStream("output.csv"));
            }

            CSVWriter writer = new CSVWriter();
            writer.writeWords(output, counter.getStats());
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        finally {
            if(input != null){
                try{
                    input.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(output != null){
                try{
                    output.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
