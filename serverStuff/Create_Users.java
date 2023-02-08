package serverStuff;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Create_Users implements ActionListener {
	
	private static JFrame frame2;
	private static JTextField RUSE;
	static String  ruse;
	static byte[] Ruse;
	
	static String path = "C:\\Users\\shared\\Desktop\\Levi\\Java\\Ruses";
	File f;
	
	private static JPasswordField SAp;
	static char[] sap;
	static byte[] Sap;
	static String SAP;
	
	private static JFrame frame1;
	
	private static JTextField Username;
	private static JLabel username;
	
	private static JPasswordField Password;
	private static JLabel password;
	
    static Border border = BorderFactory.createLineBorder(Color.black);
	
	private static JTextField Status;
	
	static boolean debug = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		initialize_Login();
		
	    //initialize_Creator();
	}
	
	private static void initialize_Login() {
		
		frame1 = new JFrame("Login");
		frame1.setVisible(true);
		frame1.setBounds(425, 150, 450, 450);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		password = new JLabel("Password below.");
		password.setBounds(125, 31, 150, 20);
		password.setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(1, 1, 1, 1)));;
		frame1.getContentPane().add(password);
		
		Password = new JPasswordField();
		Password.setBounds(125, 50, 150, 20);
		Password.setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(1, 1, 1, 1)));;
	    Password.addKeyListener(
	    	new KeyAdapter() {
	    		public void keyReleased( KeyEvent e ) {
	    			
	    			if( e.getKeyCode() == KeyEvent.VK_ENTER) {
	    				
	    				Attempt_To_Login();
	    			}
	    			if( e.getKeyCode() == KeyEvent.VK_TAB )
	    				{
	    					switcher();
	    				}
	    			}
	    		}
	    	);
	    frame1.getContentPane().add(Password);
	    
	    username = new JLabel("Username below.");
	    username.setBounds(125, 80, 150, 20);
	    username.setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(1, 1, 1, 1)));;
		frame1.getContentPane().add(username);
	    
		Username = new JTextField();
		Username.setBounds(125, 99, 150, 20);
		Username.setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(1, 1, 1, 1)));;
	    Username.addKeyListener(
		    	new KeyAdapter() {
		    		public void keyReleased( KeyEvent e ) {
		    			
		    			if( e.getKeyCode() == KeyEvent.VK_ENTER) {
		    				
		    				Attempt_To_Login();
		    			}
		    			if( e.getKeyCode() == KeyEvent.VK_TAB )
		    				{
		    					switcher();
		    				}
		    			}
		    		}
		    	);
		frame1.getContentPane().add(Username);
		
		//Password.setVisible(false);
		//Username.setVisible(false);
	}
	
	private static void Attempt_To_Login() {
		
		System.out.println("Trying to login.");
	}
	
	private static void switcher() {
		Password.addActionListener(new ActionListener() {
			   @Override
			    public void actionPerformed(ActionEvent e) {
			      Username.requestFocusInWindow();    
			    }
			}); 

		Username.addActionListener(new ActionListener() {
			   @Override
			   public void actionPerformed(ActionEvent e) {
				   Password.requestFocusInWindow(); 
			   }
			}
		);
	}
	
	@SuppressWarnings("unused")
	private static void initialize_Creator() {
		frame2 = new JFrame();
	//  Left side, Top, How far away from left side, How far away from top. 
		frame2.setBounds(450, 200, 400, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
	
	    JLabel lblUser = new JLabel("Enter Username.");
	    lblUser.setBounds(20, 29, 96, 14);
	    frame2.getContentPane().add(lblUser);
	
	    JLabel lblPass = new JLabel("Enter Password.");
	    lblPass.setBounds(20, 96, 95, 14);
	    frame2.getContentPane().add(lblPass);
	
	    RUSE = new JTextField();
	    RUSE.setBounds(118, 26, 86, 20);
	    frame2.getContentPane().add(RUSE);
	
	    SAp = new JPasswordField();
	    SAp.setBounds(118, 96, 86, 20);
	    frame2.getContentPane().add(SAp);
	    
	    Status = new JTextField();
	    Status.setBounds(118, 172, 86, 20);
	    frame2.getContentPane().add(Status);
	    
	    JButton btnCreate = new JButton("Create.");
	    
	    RUSE.addKeyListener(
	    		new KeyAdapter()
	    		{
	    			public void keyReleased( KeyEvent e )
	    			{
	    				if (debug) {System.out.println("It works!" + e.getKeyCode());}
	    				
	    				Status.setText("");
	    				
	    				if( e.getKeyCode() == KeyEvent.VK_ENTER )
	    				{
	    					if (debug) {System.out.println("It works!");}
	    					doSomething();
	    				}
	    			}
	    		}
	    		);
	    
	    btnCreate.setBounds(118, 201, 86, 23);
	    frame2.getContentPane().add(btnCreate);
	    
	}


    public void actionPerformed(ActionEvent arg0) {
       doSomething();
    }
	
	private static void doSomething() {
	    
		Status.setText("Creating user.");
		
        ruse = RUSE.getText();
        Ruse = ruse.getBytes();
        ruse = byteArray2Hex(Ruse);
        
        sap = SAp.getPassword();
        Sap = toBytes(sap);
        sap = null;
        SAP = byteArray2Hex(Sap);
        Sap = null;
        
        CreateUser();
        
        SAp.setText("");
        RUSE.setText("");
        
        Status.setText("User created.");
	}
	
	private static void CreateUser() {
		//ruse, SAP
		
		String path2 = path + "\\" + ruse + ".txt";
		
		Write(path2, SAP);
		
	}
	
	private static void Write(String path, String sap) {
		try{
	        // Create new file
			//String trying = textArea.getText();
	        File file = new File(path);
	//
	        // If file doesn't exists, then create it
	        if (!file.exists()) {
	            file.createNewFile();
	
		        FileWriter fw = new FileWriter(file, true);
		  		BufferedWriter bw = new BufferedWriter(fw);
		  		// Write in file
		  		//bw.write(trying);
		  		bw.newLine();
		  		bw.append(sap);
		  		// Close connection
		  		bw.close();
	        } else {
	        	
	        	Replace_line(2, sap);
	        }
		}
		catch(Exception e){
		 System.out.println(e);
	 	}
	}
	
	private static void Replace_line(int lineNumber, String data) throws IOException {
	    
		Path path = Paths.get("C:\\Users\\school\\Desktop\\Levi\\Java\\Ruses" + "\\" + ruse + ".txt");
	    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
	    lines.set(lineNumber - 1, data);
	    Files.write(path, lines, StandardCharsets.UTF_8);
	}
	
	private static final char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static String byteArray2Hex(byte[] bytes) {
	    StringBuffer sb = new StringBuffer(bytes.length * 2);
	    for(final byte b : bytes) {
	        sb.append(hex[(b & 0xF0) >> 4]);
	        sb.append(hex[b & 0x0F]);
	    }
	    return sb.toString();
	}
	
	private static byte[] toBytes(char[] chars) {
	    CharBuffer charBuffer = CharBuffer.wrap(chars);
	    ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
	    byte[] bytes = Arrays.copyOfRange(byteBuffer.array(),
	            byteBuffer.position(), byteBuffer.limit());
	    Arrays.fill(charBuffer.array(), '\u0000'); // clear sensitive data
	    Arrays.fill(byteBuffer.array(), (byte) 0); // clear sensitive data
	    return bytes;
	}
}