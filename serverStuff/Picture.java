package serverStuff;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class Picture {
	
	public static JTextPane pane;
	public JFrame f;
	
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	                Picture window = new Picture();
	                window.f.setVisible(true);
	        }
	    }
	    );
	}
	
	
	// Create new new Diagnostic display using a black JTextPane
	  public Picture() {
		  Imagey();
	  }
	  
	  public void Imagey() {
		  
		  f = new JFrame("Picture Frame");
		  f.setBounds(0, 0, 1367, 735);
		
		  pane = new JTextPane();
		  pane.setBounds(0, 0, 1367, 735);
		  pane.setBackground(Color.black);
		  pane.setEditable(false);
		  f.getContentPane().add(pane);
		  
		  add();
	  }
	  
		public void add() {  
	  
		  String path = "C:\\Users\\school\\Desktop\\Levi\\Java\\WriteTo.png";
		  
		  ImageIcon icon = new ImageIcon(path);
		  Image img = icon.getImage();
		  BufferedImage bi = new BufferedImage(img.getWidth(null), 
				  img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		  Graphics g = bi.createGraphics();
		  g.drawImage(img, 0, 0, 1367, 735, null);
		  ImageIcon newIcon = new ImageIcon(bi);
	    
	    pane.insertIcon(newIcon);
	    //pane.insertIcon(image);
	  }
	  
}
