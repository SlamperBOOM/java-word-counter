import java.io.*;

public class Main {
    public static void main(String[] args) {
        InputStreamReader input = null;
        OutputStreamWriter output = null;
        try {

            if (args.length == 0) {
                input = new InputStreamReader(System.in);
            } else {
                input = new InputStreamReader(new FileInputStream((args[0])));
            }
            WordCount counter = new WordCount();
            counter.readfile(input);

            if(args.length == 2) {
                output = new OutputStreamWriter(new FileOutputStream(args[1]));
            }
            else{
                output = new OutputStreamWriter(new FileOutputStream("output.csv"));
            }

            counter.writewords(output);
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
