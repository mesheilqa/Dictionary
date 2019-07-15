package dictionary;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dict{

	private static String AbsoluteString(String path)
	{
		File b = new File(path);
        String absolute = b.getAbsolutePath(); 
        return absolute;
	}
	
	 public static boolean doesFileExist(String absolute){
		    File tempFile = new File(absolute);
	        boolean exists = tempFile.exists();
	        
	        if(exists){
	            return true;
	        }
	        return false;
	    }
	
	 public static void printDictionary(String dictionaryPath)
	 {
		 if(!doesFileExist(dictionaryPath)){
	            System.err.println("File does not exist.");
	        }
		 
		 BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(dictionaryPath));
				String line = reader.readLine();
				while (line != null) {
					  String[] splitLine = line.split("-");
		                String[] meanings = splitLine[1].split(",");
		                System.out.println("Word:" + splitLine[0].trim());
		                for(String s: meanings){
		                    System.out.println("Meaning:"+ s.trim());
		                }
		                System.out.println("");  
		                line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
	 
	 
    public static void main(String[] args) throws IOException {
        if(args.length<1){
            System.err.println("Not enough arguments. Please provide the path to the dictionary file");
            return;
        }

        System.out.println("Please enter your dictionary's relative path.\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
     
        String path = filePath;
        
        String absolute = AbsoluteString(path);
    
        if(doesFileExist(absolute)){
            System.out.println("The file exists.\n");
        }else{
            System.out.println("The file doesn't exist");
            return;
        }
        
        printDictionary(path);
     }
}