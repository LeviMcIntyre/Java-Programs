package randomthings;

import java.awt.AWTException;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
** This is a program that takes a screenshot and make a frame saying that it did.
*/

public class FullScreenCaptureExample extends JFrame {
	
    static String path = "C:\\Users\\shared\\Desktop\\Levi\\Java\\ImageWriter.txt";
    static String name = "image";
    static String line = null;
	 
	
    private static final long serialVersionUID = 1L;
	 
	   public static void main(String[] args) {
		   Read();
	      
	      FullScreenCaptureExample f = new FullScreenCaptureExample();
	      try {
	        /*
	         * Let the program wait for 5 seconds to allow you to open the
	         * window whose screenshot has to be captured
	         */
	         Thread.sleep(5000);
	         Robot robot = new Robot();
	         String fileName = "C:\\Users\\shared\\Pictures\\Levi's pictures\\"+ name + ".png";
	 
	         Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit()
	                                     .getScreenSize());
	         BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
	         ImageIO.write(screenFullImage, "png", new File(fileName));
	 
	         f.setLocation(500, 500);
	         JLabel text = new JLabel("A full screenshot saved!");
	         f.add(text);
	         f.setSize(200, 100);
	         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         f.getContentPane().setLayout(new FlowLayout());
	         f.setVisible(true);
	      } catch (AWTException | IOException | InterruptedException ex) {
	               System.err.println(ex);
	      }
	      Write();
	 }
	   private static void Write() {
			try{
		        // Create new file
				//String trying = textArea.getText();
		        File file = new File(path);
		//
		        // If file doesn't exists, then create it
		        if (!file.exists()) {
		            file.createNewFile();
		        }
		
		        FileWriter fw = new FileWriter(file, true);
		  		BufferedWriter bw = new BufferedWriter(fw);
		  		bw.append("1");
		  	bw.close();
			}
			catch(Exception e){
			 System.out.println(e);
		 	}
		}
	   private static void Read() {
			
			BufferedReader br;
			try {
				InputStreamReader isr = new InputStreamReader
					(new DataInputStream(new FileInputStream(path)), "UTF-8");
				br = new BufferedReader(isr);
				while ((line = br.readLine()) != null) {
					name = name + line;
				}
			}
			catch (FileNotFoundException fnfe) {
				System.err.println("Error opening file" + fnfe);
				System.exit(1);
			}
			catch (UnsupportedEncodingException uee) {
				System.err.println("Error opening file" + uee);
				System.exit(1);
			}
			catch (Exception e) {
				System.err.println("Error opening file" + e);
				System.exit(1);
			}
		}
}