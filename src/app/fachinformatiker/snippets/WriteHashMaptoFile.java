package app.fachinformatiker.snippets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteHashMaptoFile {

    final static String outputFilePath = "hashmap-data.txt";

    public static void main(String[] args){

        //create new HashMap
        HashMap<Integer, String> hMapNumbers = new HashMap<Integer, String>();

        //key-value pairs
        hMapNumbers.put(1, "One");
        hMapNumbers.put(2, "Two");
        hMapNumbers.put(3, "Three");

        //new file object
        File file = new File(outputFilePath);

        BufferedWriter bf = null;

        try{

            //create new BufferedWriter for the output file
            bf = new BufferedWriter( new FileWriter(file) );

            //iterate map entries
            for(Map.Entry<Integer, String> entry : hMapNumbers.entrySet()){

                //put key and value separated by a colon
                bf.write( entry.getKey() + ":" + entry.getValue() );

                //new line
                bf.newLine();
            }

            bf.flush();

        }catch(IOException e){
            e.printStackTrace();
        }finally{

            try{
                //always close the writer
                bf.close();
            }catch(Exception e){}
        }
    }
}