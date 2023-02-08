package serverStuff;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteTextFile {
	
	public static void main(String[] args) {
		
		 try{
	            // Create new file
	            String text = "bla bla bla";
	            String path="C:\\Users\\shared\\Desktop\\Levi\\Java\\WriteTo.txt";
	            File file = new File(path);

	            // If file doesn't exists, then create it
	            if (!file.exists()) {
	                file.createNewFile();
	            }

	        FileWriter fw = new FileWriter(file.getAbsoluteFile());
	      	BufferedWriter bw = new BufferedWriter(fw);

	      	// Write in file
	      	bw.write(text + "\n" + "\n");

	      	// Close connection
	        bw.close();
		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
	}
}
