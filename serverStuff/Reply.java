package serverStuff;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.border.Border;

public class Reply implements ActionListener {
	
	private Date d = new Date();
	private String client;
	private boolean loggedIn = false;
	private boolean admin = false;
	private String usr;
	private static char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
			'b', 'c', 'd', 'e', 'f'};
	private JPasswordField Password;
	private JTextField Username;
	private JLabel username;
	private JLabel password;
	/*private String s;
	private String ss;
	private String user;
	private char[] pass;*/
	
	/*private String user_name = "1898909User1sadhcbdcbjbc";
	private String pass_word = "216371376Password1hhccbjdbjhcc";
	
	private String user__name = "1898909Levi'ssadhcbdcbjbc";
	private String pass__word = "2163713761clockhhccbjdbjhcc";
	
	private String user___name = "1898909Ethan'ssadhcbdcbjbc";
	private String pass___word = "216371376Userhhccbjdbjhcc";*/
	
	private JTextArea Error;
	private JTextArea enter;
	
	private JFrame frame;
	String n;
	
	@SuppressWarnings("unused")
	private JScrollBar scrollb;
	private JScrollPane scrollp;
	private JViewport viewport;
	
	Font font = new Font("", 12, 12);
	
	private JTextPane textField;
	private JTextArea textArea;
	private JButton btnReply;
	private JTextArea putreplyhere;
	private JTextArea texts;
	private final String path = "C:\\Users\\shared\\Desktop\\Levi\\Java\\My Java Files\\"
			+ "Chat Prog\\Replies.txt";
	String text;
	Color abgc = (Color.blue);
	Color pbgc = (Color.red);
	Color tabc = (Color.white);
    Border border = BorderFactory.createLineBorder(tabc);
	static boolean debug = false;
	
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	                Reply window = new Reply();
	                window.frame.setVisible(true);
	        }
	    }
	    );
	}
	
	public Reply() {
		Deploy();
	}
	
	private void Deploy() {
		frame = new JFrame("Reply");
		frame.setBounds(425, 150, 450, 450);
		frame.setFont(font);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setBackground(abgc);
	    frame.getContentPane().setLayout(null);
	    
	    Error = new JTextArea();
	    Error.setBounds(125, 138, 150, 40);
	    Error.setFont(font);
	    Error.setCaretColor(tabc);
	    Error.setForeground(tabc);
	    Error.setBackground(abgc);
	    Error.setEditable(false);
	    Error.setLineWrap(true);
	    frame.getContentPane().add(Error);
	    
	    enter = new JTextArea("Hit enter key to submit.");
	    enter.setBounds(125, 118, 150, 20);
	    enter.setFont(font);
	    enter.setBorder(BorderFactory.createCompoundBorder(border, 
	    		BorderFactory.createEmptyBorder(1, 1, 1, 1)));;
	    enter.setBackground(pbgc);
	    enter.setCaretColor(tabc);
	    enter.setForeground(tabc);
	    enter.setEditable(false);
	    frame.getContentPane().add(enter);
	    
		password = new JLabel("Password below.");
		password.setBounds(125, 80, 150, 20);
		password.setFont(font);
	    password.setOpaque(true);
	    password.setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(1, 1, 1, 1)));;
	    password.setBackground(pbgc);
	    password.setForeground(tabc);
		frame.getContentPane().add(password);
		
		Password = new JPasswordField();
		Password.setBounds(125, 99, 150, 20);
		Password.setFont(font);
		Password.setColumns(10);
		Password.setBorder(BorderFactory.createCompoundBorder(border, 
            BorderFactory.createEmptyBorder(1, 1, 1, 1)));;
		Password.setBackground(pbgc);
		Password.setCaretColor(tabc);
	    Password.setForeground(tabc);
	    Password.addKeyListener(
	    	new KeyAdapter() {
	    		public void keyReleased( KeyEvent e ) {
	    			if( e.getKeyCode() == KeyEvent.VK_TAB )
	    				{
	    					switcher();
	    				}
	    			}
	    		}
	    	);
	    Password.addKeyListener(
	    		new KeyAdapter()
	    		{
	    			public void keyReleased( KeyEvent e )
	    			{
	    				if( e.getKeyCode() == KeyEvent.VK_ENTER)
	    				{
	    					login();
	    				}
	    			}
	    		}
	    	);
	    Password.addKeyListener(
		    	new KeyAdapter() {
		    		public void keyPressed( KeyEvent e ) {
		    			if(e.getKeyCode() != KeyEvent.VK_ENTER 
		    					&& e.getKeyCode() != KeyEvent.VK_TAB) {
							Error.setText("");
		    				}
		    			}
		    		}
		    	);
	    frame.getContentPane().add(Password);
	    
	    username = new JLabel("Username below.");
	    username.setBounds(125, 31, 150, 20);
	    username.setFont(font);
	    username.setOpaque(true);
	    username.setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(1, 1, 1, 1)));;
	    username.setBackground(pbgc);
	    username.setForeground(tabc);
		frame.getContentPane().add(username);
	    
		Username = new JTextField();
		Username.setBounds(125, 50, 150, 20);
		Username.setFont(font);
		Username.setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(1, 1, 1, 1)));;
	    Username.setBackground(pbgc);
	    Username.setCaretColor(abgc);
	    Username.setCaretColor(tabc);
	    Username.setForeground(tabc);
	    Username.addKeyListener(
		    	new KeyAdapter() {
		    		public void keyReleased( KeyEvent e ) {
		    			if( e.getKeyCode() == KeyEvent.VK_TAB )
		    				{
		    					switcher();
		    				}
		    			}
		    		}
		    	);
	    Username.addKeyListener(
	    		new KeyAdapter()
	    		{
	    			public void keyReleased( KeyEvent e )
	    			{
	    				if( e.getKeyCode() == KeyEvent.VK_ENTER)
	    				{
	    					{
		    					//initialize();
		    					login();
	    						@SuppressWarnings("unused")
								String b;
	    					}
	    				}
	    			}
	    		}
	    	);
	    Username.addKeyListener(
		    	new KeyAdapter() {
		    		public void keyPressed( KeyEvent e ) {
		    			//e.getKeyCode();
		    			//System.out.println(e);
		    			if(e.getKeyCode() != KeyEvent.VK_ENTER 
		    					&& e.getKeyCode() != KeyEvent.VK_TAB 
		    					&& e.getKeyCode() != KeyEvent.VK_WINDOWS 
		    					&& e.getKeyCode() != KeyEvent.VK_CONTEXT_MENU
		    					&& e.getKeyCode() != KeyEvent.VK_ALT) {
							Error.setText("");
		    				}
		    			}
		    		}
		    	);
		frame.getContentPane().add(Username);
		
		//Password.setVisible(false);
		//Username.setVisible(false);
		//initialize();
	}	
	
	/** init
	 * 
	 */
	//TODO
	private void initialize() {
		
	//  Left side, Top, How far away from left side, How far away from top. 
	
		frame.setBounds(0, 0, 1367, 735);    
		frame.addWindowFocusListener(new WindowAdapter() {
			public void windowGainedFocus(WindowEvent e) {
				textField.requestFocusInWindow();
		    }
	    }
	);
	
	    textField = new JTextPane();
	    textField.setBounds(251, 400, 250, 250);
	    textField.setFont(font);
	    textField.setBorder(BorderFactory.createCompoundBorder(border, 
            BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		//textField.setLineWrap(true);
	    
	    
	    
	    // creates a wrapped scroll pane using the text pane as a viewport.
	    textField.setBackground(pbgc);
	    textField.setCaretColor(tabc);
	    textField.setForeground(tabc);
	    frame.getContentPane().add(textField);
	    
	    textArea = new JTextArea();
	    textArea.setFont(font);
	    textArea.setOpaque(false);
	    textArea.setEditable(false);
	    textArea.setLineWrap(true);
	    textArea.setCaretColor(tabc);
	    if (admin != true) {
	    	textArea.setEditable(false);
	    } else {
	    	textArea.setEditable(true);
	    }
	    
	    viewport = new JViewport();
	    //viewport.setBackground(pbgc);
	    //viewport.setForeground(tabc);
	    viewport.setOpaque(true);
	    //viewport.setBorder(BorderFactory.createCompoundBorder(border, 
	    //        BorderFactory.createEmptyBorder(1, 1, 1, 1)));
	    
	    //TODO
	    scrollp = new JScrollPane(textArea);
	    scrollp.setBounds(500, 100, 250, 550);
	    scrollp.setFont(font);
	    //scrollp.setViewport(viewport);
	    scrollp.getViewport().setBackground(pbgc);//red
	    scrollp.getViewport().setForeground(tabc);//white
	    scrollp.getViewport().getView().setForeground(tabc);
	    scrollp.setOpaque(true);
	    //scrollp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    //scrollp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollp.setBorder(BorderFactory.createCompoundBorder(border, 
            BorderFactory.createEmptyBorder(2, 2, 2, 2)));
	    //scrollp.setViewport(viewport);
	    
	    //JTextArea textArea = new JTextArea(5, 5);
	    
	    frame.getContentPane().add(scrollp);
	    //frame.getContentPane().add(textArea);
	    //JScrollPane scroll = new JScrollPane (textArea);
	    //frame.getContentPane().add(scroll); //Object of Jpanel
	    
	    Read();
	    //TODO
	     
	    texts = new JTextArea("Replys.");
	    texts.setBounds(457, 240, 44, 20);
	    texts.setFont(font);
	    texts.setForeground(tabc);
	    texts.setBackground(pbgc);
	    texts.setCaretColor(tabc);
	    texts.setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(1, 1, 1, 1)));
	    if (admin != true) {
	    	texts.setEditable(false); 
	    } else {
	    	texts.setEditable(true);
	    }
	    frame.getContentPane().add(texts);
	    
	    putreplyhere = new JTextArea("Put Reply Here.");
	    putreplyhere.setBounds(331, 381, 90, 20);
	    putreplyhere.setFont(font);
	    putreplyhere.setForeground(tabc);
	    putreplyhere.setBackground(pbgc);
	    putreplyhere.setCaretColor(tabc);
	    putreplyhere.setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(1, 1, 1, 1)));
	    if (admin != true) {
	    	putreplyhere.setEditable(false);
	    } else {
	    	putreplyhere.setEditable(true);
	    }
	    frame.getContentPane().add(putreplyhere);
	    
	    btnReply = new JButton("Click To Reply.");
	    btnReply.setFont(font);
	    btnReply.addActionListener(this);
	    btnReply.setBackground(pbgc);
	    btnReply.setForeground(tabc);
	    btnReply.setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(1, 1, 1, 1)));
	    textField.addKeyListener(
	    		new KeyAdapter()
	    		{
	    			public void keyReleased( KeyEvent e )
	    			{
	    				if( e.getKeyCode() == KeyEvent.VK_INSERT
	    						|| e.getKeyCode() == KeyEvent.VK_ALT)
	    				{
	    					doSomething();
	    				}
	    			}
	    		}
	    	);
	    btnReply.setBounds(500, 649, 90, 20);
	    frame.getContentPane().add(btnReply);

	    textField.requestFocusInWindow();;
	}
	
	    private void GetReady() {
	    	
			password.setVisible(false);
			Password.setVisible(false);
			username.setVisible(false);
			Username.setVisible(false);
			Error.setVisible(false);
			enter.setVisible(false);
			initialize();
	    }
	    
	    public static String byteArray2Hex(byte[] bytes) {
		    StringBuffer sb = new StringBuffer(bytes.length * 2);
		    for(final byte b : bytes) {
		        sb.append(hex[(b & 0xF0) >> 4]);
		        sb.append(hex[b & 0x0F]);
		    }
		    return sb.toString();
		}
	    
	    //TODO
		@SuppressWarnings("deprecation")
		private void login() {
			//System.out.println("enter pressed");

	    	usr = Username.getText();
	    	client = usr;
			byte[] ur = usr.getBytes();
			usr = byteArray2Hex(ur);
			
			String pswrd = Password.getText();
			byte[] pd = pswrd.getBytes();
			String pasword = byteArray2Hex(pd);
			
				        File file = new File("C:\\Users\\shared\\Desktop\\Levi\\Java\\Users\\"
				        		+ usr + ".txt");
						//System.out.println("checking for file " + usr);
				        if (file.exists()) {
							//System.out.println("checking password");
					        
				BufferedReader br;
				try {
					InputStreamReader isr = new InputStreamReader
						(new DataInputStream(new FileInputStream(file)), "UTF-8");
					br = new BufferedReader(isr);
					while ((line = br.readLine()) != null) {
						
						if(line.equals(pasword)) {
							//System.out.println("logged in");
							loggedIn = true;
						}
						System.out.println(line);
						if(line.equals("1")) {
							//System.out.println("admin");
							admin = true;
						}
					}
				}
				catch (FileNotFoundException fnfe) {
					System.err.println("Error opening file 1 " + fnfe);
					System.exit(1);
				}
				catch (UnsupportedEncodingException uee) {
					System.err.println("Error opening file 2 " + uee);
					System.exit(1);
				}
				catch (Exception e) {
					System.err.println("Error opening file 3 " + e);
					System.exit(1);
				}
		    	
				if (loggedIn == true) {
					GetReady();
				}else {
					Username.setText("");
					Password.setText("");
					Username.requestFocus();
					Error.setText("Incorrect User or" + "\n" + "Password.");
					Error.setVisible(true);
				}
			}
		}
	
	public void actionPerformed(ActionEvent arg0) {
			doSomething();
	}
	
	private void doSomething(){
		
		text = "( " + textField.getText() + " )";
		d = new Date();
		String newline = "\n";
		textArea.append(client + ", " + d);
		textArea.append(newline);
	    textArea.append(text);
	    textArea.append(newline);
	    textArea.append(newline);
	    Write();
	    textField.setText("");
	     }
	//TODO
	private void Write() {
		try{
	        // Load file
			//String trying = textArea.getText();
	        File file = new File(path);
	//
	        // If file doesn't exists, then create it
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	
	        FileWriter fw = new FileWriter(file, true);
	  		BufferedWriter bw = new BufferedWriter(fw);
	  		
			bw.append(client + ", " + d);
			bw.newLine();
		    bw.append(text);
		    bw.newLine();
		    bw.newLine();
	  	bw.close();
		}
		catch(Exception e){
		 System.out.println(e);
	 	}
	}

	static String line = "";
	int number;
	static String use = null;
	private void Read() {
		
		// Load file
					//String trying = textArea.getText();
			        File file = new File(path);
			//
			        // If file doesn't exists, then create it
			        if (!file.exists()) {
			            try {
							file.createNewFile();
						} catch (IOException e) {
							e.printStackTrace();
						}
			        }
		
		BufferedReader br;
		

		//TODO
		try {
			InputStreamReader isr = new InputStreamReader
				(new DataInputStream(new FileInputStream(path)), "UTF-8");
			br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				
				use = line;
				//use = method(use);
				//use = methody(use);
				//methodey(use);
					
				//System.out.println(line);
				textArea.append(line);
				textArea.append("\n");
				//textArea.append("\n");
				text = line;
				number ++;
				if(number % 1000 == 0) {
					System.out.println(number);
				}
			}
		}
		catch (FileNotFoundException fnfe) {
			System.err.println("Error opening file 1 " + fnfe);
			System.exit(1);
		}
		catch (UnsupportedEncodingException uee) {
			System.err.println("Error opening file 2 " + uee);
			System.exit(1);
		}
		catch (Exception e) {
			System.err.println("Error opening file 3 " + e);
			System.exit(1);
		}
		textArea.append("\n");
	}
	
	private void switcher() {
		Password.addActionListener(new ActionListener() {
			   @Override
			    public void actionPerformed(ActionEvent e) {
			      Username.requestFocusInWindow();    
			    }
			}
		); 

		Username.addActionListener(new ActionListener() {
			   @Override
			   public void actionPerformed(ActionEvent e) {
				   Password.requestFocusInWindow(); 
			   }
			}
		);
	}
	
	public static String method(String str) {
	    return str.substring(0, str.length() -1);
	}
	
	public static String methody(String str) {
	    if (str != null && str.length() > 4) {
	    	str = str.substring(str.length() -4, str.length());
	    }
	    
	    return str;
	}
	static String test = null;
	static int first = 0;
	static int second = 1;
	static int add = 1;
	public static String methodey(String str) {
    	System.out.println("It works here.");
	    if (str != null && 0 < str.length()) {
	    	System.out.println("Here to.");
	    	
	    	if (true) {
		    	test = str.substring(first, second);
		    	System.out.println("Here three");
		    	first ++;
		    	second ++;
		    	
	    	}
	    }
	    return str;
	}
}