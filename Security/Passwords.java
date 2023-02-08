package randomthings;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Passwords implements ActionListener {
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	boolean debug = false;
	String path = "C:\\Users\\shared\\Desktop\\Levi\\Java\\Users\\";
	static String usr;
	String pass;
	String lvl;
	
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                Passwords window = new Passwords();
	                window.frame.setVisible(true);
	            } catch (Exception e) {
	            }
	        }
	    });
	}
	
	/**
	 * Create the application.
	 */
	public Passwords() {
	    initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//  Left side, Top, How far away from left side, How far away from top. 
		    frame.setBounds(450, 200, 400, 300);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.getContentPane().setLayout(null);
		
		    JLabel lblusr = new JLabel("Username");
		    lblusr.setBounds(35, 29, 96, 14);
		    frame.getContentPane().add(lblusr);
		
		    JLabel lblpaswrd = new JLabel("Password");
		    lblpaswrd.setBounds(35, 112, 85, 14);
		    frame.getContentPane().add(lblpaswrd);
		    
		    JLabel lbllvl = new JLabel("User Level");
		    lbllvl.setBounds(35, 195, 85, 14);
		    frame.getContentPane().add(lbllvl);
		
		    textField = new JTextField();
		    textField.setBounds(118, 26, 86, 20);
		    frame.getContentPane().add(textField);
		    textField.setColumns(10);
		
		    textField_1 = new JTextField();
		    textField_1.setBounds(118, 109, 86, 20);
		    frame.getContentPane().add(textField_1);
		    textField_1.setColumns(10);
		    
		    textField_2 = new JTextField();
		    textField_2.setBounds(118, 192, 86, 20);
		    frame.getContentPane().add(textField_2);
		    textField_2.setColumns(10);
		    
		    JButton btndelete = new JButton( new AbstractAction("Delete") {
				private static final long serialVersionUID = 1L;
				
				@Override
		        public void actionPerformed( ActionEvent e ) {
					
					usr = textField.getText();
					usr = usr.toLowerCase();
					byte[] ba = usr.getBytes();
					usr = byteArray2Hex(ba);
					
					File file = new File(path + usr + ".txt"); 
					if(file.exists()){
						file.delete();
					}
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
		        }
		    }
		    );
		    btndelete.setBounds(222, 26, 86, 20);
		    frame.getContentPane().add(btndelete);
		    
		    JButton btncr8 = new JButton( new AbstractAction("Create") {
				private static final long serialVersionUID = 1L;

				@Override
		        public void actionPerformed( ActionEvent e ) {
					
					String t = textField_2.getText();
					if(debug && t.length() == 0){System.out.println(t);}
					if (t.length() == 0) {

						usr = textField.getText();
						byte[] ba = usr.getBytes();
						usr = byteArray2Hex(ba);
						
						String g = textField_1.getText();
						byte[] bb = g.getBytes();
						g = byteArray2Hex(bb);
						//setVariable(2, g);
						Write(g, "0");
					}
					if(t.length() != 0) {
						usr = textField.getText();
						byte[] ba = usr.getBytes();
						usr = byteArray2Hex(ba);
						
						String g = textField_1.getText();
						byte[] bb = g.getBytes();
						g = byteArray2Hex(bb);
						//setVariable(3, g);
						Write(g, "1");
					}
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				}
		    }
		    );
		    btncr8.setBounds(222, 109, 86, 20);
		    frame.getContentPane().add(btncr8);
		    
		    JButton btnedit = new JButton( new AbstractAction("Edit") {
				private static final long serialVersionUID = 1L;

				@Override
		        public void actionPerformed( ActionEvent e ) {
					
					String t = textField_2.getText();
					if(debug && t.length() == 0){System.out.println(t);}
					if (t.length() == 0) {
						
						usr = textField.getText();
						byte[] ba = usr.getBytes();
						usr = byteArray2Hex(ba);
						
						String g = textField_1.getText();
						byte[] bb = g.getBytes();
						g = byteArray2Hex(bb);
						//setVariable(2, g);
						Write(g, "0");
					}
					if(t.length() != 0) {
						usr = textField.getText();
						byte[] ba = usr.getBytes();
						usr = byteArray2Hex(ba);
						
						String g = textField_1.getText();
						byte[] bb = g.getBytes();
						g = byteArray2Hex(bb);
						//setVariable(3, g);
						Write(g, "1");
					}
					
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				}
		    }
		    );
		    btnedit.setBounds(222, 192, 86, 20);
		    frame.getContentPane().add(btnedit);
		    
		    textField.addKeyListener(new KeyAdapter(){
		    			public void keyReleased( KeyEvent e ) {
		    				if (debug) {System.out.println("It works!" + e.getKeyCode());}
		    				if( e.getKeyCode() == KeyEvent.VK_TAB ) {
		    					if (debug==true) {System.out.println("It works!");}
		    					switcher();
		    				}
		    			}
		    		}
		    	);
		    
		    textField_1.addKeyListener(new KeyAdapter(){
    			public void keyReleased( KeyEvent e ) {
    				if (debug) {System.out.println("It works!" + e.getKeyCode());}
    				if( e.getKeyCode() == KeyEvent.VK_TAB ) {
    					if (debug==true) {System.out.println("It works!");}
    					switcher();
    				}
    			}
    		}
    	);
		    
		    textField_2.addKeyListener(new KeyAdapter(){
    			public void keyReleased( KeyEvent e ) {
    				if (debug) {System.out.println("It works!" + e.getKeyCode());}
    				if( e.getKeyCode() == KeyEvent.VK_TAB ) {
    					if (debug==true) {System.out.println("It works!");}
    					switcher();
    				}
    			}
    		}
    	);
	}
	
	private void switcher() {
		textField.addActionListener(new ActionListener() {
			   @Override
			    public void actionPerformed(ActionEvent e) {
				   textField_1.requestFocusInWindow();    
			    }
			}
		); 

		textField_1.addActionListener(new ActionListener() {
			   @Override
			   public void actionPerformed(ActionEvent e) {
				   textField_2.requestFocusInWindow(); 
			   }
			}
		);
		textField_2.addActionListener(new ActionListener() {
			   @Override
			    public void actionPerformed(ActionEvent e) {
				   textField.requestFocusInWindow();    
			    }
			}
		);
	}

	/*public void actionPerformed(ActionEvent arg0) {
		
		if (debug==true) {System.out.println("It works!");}
	}*/
	
	private static final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
			'b', 'c', 'd', 'e', 'f'};
	
	public static String byteArray2Hex(byte[] bytes) {
	    StringBuffer sb = new StringBuffer(bytes.length * 2);
	    for(final byte b : bytes) {
	        sb.append(hex[(b & 0xF0) >> 4]);
	        sb.append(hex[b & 0x0F]);
	    }
	    return sb.toString();
	}
	
	/*public static String getStringFromSHA256(String stringToEncrypt) throws
	    NoSuchAlgorithmException {
	    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
	    messageDigest.update(stringToEncrypt.getBytes());
	    return byteArray2Hex(messageDigest.digest());
	}*/
	
	public static void setVariable(int lineNumber, 
			String data) throws IOException {
	    Path path = Paths.get("C:\\Users\\shared\\Desktop\\Levi\\Java\\Users" + usr +".txt");
	    List<String> lines = Files.readAllLines(path, 
	    		StandardCharsets.UTF_8);
	    lines.set(lineNumber - 1, data);
	    Files.write(path, lines, StandardCharsets.UTF_8);
	}
	
	private void Write(String a, String b) {
		try{
	        // Create new file
			//String trying = textArea.getText();
	        File file = new File(path + usr + ".txt");
	//
	        // If file doesn't exists, then create it
	        if (!file.exists()) {
	            file.createNewFile();
		        FileWriter fw = new FileWriter(file, true);
		  		BufferedWriter bw = new BufferedWriter(fw);
		  		// Write in file
		  		//bw.write(trying);
		  		bw.append(a);
		  		bw.newLine();
		  		bw.append(b);
		  		// Close connection
		  		bw.close();
		  	}else {
		  		FileWriter fw = new FileWriter(file, true);
		  		BufferedWriter bw = new BufferedWriter(fw);
		  		// Write in file
		  		//bw.write(trying);
		  		file.delete();
		  		file.createNewFile();
		  		bw.append(a);
		  		bw.newLine();
		  		bw.append(b);
		  		// Close connection
		  		bw.close();
		  	}
		}
		catch(Exception e){
		 System.out.println(e);
	 	}
	}

	public void actionPerformed(ActionEvent arg0) {	}
}