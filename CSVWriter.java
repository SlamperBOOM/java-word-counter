import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.TreeSet;

public class CSVWriter {
    public void writeWords(OutputStreamWriter output, TreeSet<WordElem> words){
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
