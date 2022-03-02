import java.io.*;
import java.util.Set;

public class CSVWriter {
    public void writeWords(Writer output, Set<WordElem> words){
        Writer writer;
        try{
            writer = output;
            writer.write("Word;Count;Part of all words\n");
            for (WordElem elem : words) {
                writer.write(elem.word + ";" + elem.count + ";" + elem.frequency + "%\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
