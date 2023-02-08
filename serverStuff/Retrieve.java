package serverStuff;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Retrieve {
	
	public static void main(String[] args) throws IOException {
        
        String fileName = "C:\\Users\\school\\Desktop\\Levi\\Java\\Gotten file.png"; 
        //<- The file that will be saved on your computer
        URL link = new URL("https://forums.theaetherlight.com/uploads/default/original/3X/a/4"
        		+ "/a4615ff3f89e13eaa837f040c0b765d2ae8c6af3.png"); 
        //<- The file that you want to download
       
        //Code to download
        InputStream in = new BufferedInputStream(link.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf)))
        {
           out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();

        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(response);
        fos.close();
        //End download code
        
        System.out.println("Finished");

   }
}
