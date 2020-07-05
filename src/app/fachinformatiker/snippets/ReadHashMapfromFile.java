package app.fachinformatiker.snippets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ReadHashMapfromFile {

    final static String filePath = "hashmap-data.txt";

    public static void main(String[] args) {

        //read text file to HashMap
        Map<String, Integer> mapFromFile = getHashMapFromTextFile();

        //iterate over HashMap entries
        for(Map.Entry<String, Integer> entry : mapFromFile.entrySet()){
            System.out.println( entry.getKey() + " => " + entry.getValue() );
        }

    }

    public static Map<String, Integer> getHashMapFromTextFile(){

        Map<String, Integer> mapFileContents = new HashMap<String, Integer>();
        BufferedReader br = null;

        try{

            //create file object
            File file = new File(filePath);

            //create BufferedReader object from the File
            br = new BufferedReader( new FileReader(file) );

            String line = null;

            //read file line by line
            while ( (line = br.readLine()) != null ){

                //split the line by :
                String[] parts = line.split(":");

                //second part is name, first is age
                String name = parts[1].trim();
                Integer age = Integer.parseInt( parts[0].trim() );

                //put name, age in HashMap if they are not empty
                if( !name.equals("") && !age.equals("") )
                    mapFileContents.put(name, age);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{

            //Always close the BufferedReader
            if(br != null){
                try {
                    br.close();
                }catch(Exception e){};
            }
        }

        return mapFileContents;

    }
}