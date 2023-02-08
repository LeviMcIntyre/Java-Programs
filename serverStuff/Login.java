package serverStuff;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class Login {
	
	private JFrame frame;
	private JLabel password;
	private JTextField Password;
	private JLabel username;
	private JTextField Username;
	String s;
	final String path = "C:\\Users\\shared\\Desktop\\Levi\\Java\\WriteTo.txt";
	String text;
	Color abgc = (Color.blue);
	Color pbgc = (Color.red);
	Color tabc = (Color.white);
    Border border = BorderFactory.createLineBorder(tabc);
	boolean debug = true;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
	                Login Window = new Login();
	                Window.frame.setVisible(true);
	        }
		}
	    );
	}
		
	
	private Login() {
		Run();
	}
	
		private void Run() {
		
			frame = new JFrame("Login");
			frame.setBounds(425, 150, 450, 450);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setBackground(abgc);
			frame.getContentPane().setLayout(null);
			
			password = new JLabel("Password below.");
			password.setBounds(125, 31, 150, 20);
		    password.setOpaque(true);
		    password.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(1, 1, 1, 1)));;
		    password.setBackground(pbgc);
		    password.setForeground(tabc);
			frame.getContentPane().add(password);
			
			Password = new JTextField();
			Password.setBounds(125, 50, 150, 20);
			Password.setColumns(10);
			Password.setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(1, 1, 1, 1)));;
			Password.setBackground(pbgc);
			Password.setCaretColor(abgc);
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
		    frame.getContentPane().add(Password);
		    
		    username = new JLabel("Username below.");
		    username.setBounds(125, 80, 150, 20);
		    username.setOpaque(true);
		    username.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(1, 1, 1, 1)));;
		    username.setBackground(pbgc);
		    username.setForeground(tabc);
			frame.getContentPane().add(username);
		    
			Username = new JTextField();
			Username.setBounds(125, 99, 150, 20);
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
			frame.getContentPane().add(Username);
			
			//Password.setVisible(false);
			//Username.setVisible(false);
	}
		
	private void switcher() {
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

		
		String hashSHAPassword(String password) throws NoSuchAlgorithmException,
		UnsupportedEncodingException {
			MessageDigest digest = MessageDigest.getInstance("SHA");
			digest.update(password.getBytes("UTF8"));
			String shaPassword = new String(Base64.getEncoder().encode(digest.digest())
					, "UTF8"); // For UTF8 encoding
	
			return "{SHA}" + shaPassword;
		}
	
	@SuppressWarnings("unused")
	private void doSomething() {
	     String text = Password.getText();
	 	
			try {
				s = hashSHAPassword(text);
	
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
	        System.out.println("Entered:" + text);
	        System.out.println("Hashed:" + s.toString());
//	        compare();
	}
}
