package randomthings;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



	public class Hasher implements ActionListener {
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	public String s;
	public String previousS;
	boolean debug = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                Hasher window = new Hasher();
	                window.frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
	
	/**
	 * Create the application.
	 */
	public Hasher() {
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
	
	    JLabel lblEnterText = new JLabel("Enter text");
	    lblEnterText.setBounds(50, 29, 96, 14);
	    frame.getContentPane().add(lblEnterText);
	
	    JLabel lblHash = new JLabel("Hashed text");
	    lblHash.setBounds(50, 112, 70, 14);
	    frame.getContentPane().add(lblHash);
	
	    textField = new JTextField();
	    textField.setBounds(118, 26, 86, 20);
	    frame.getContentPane().add(textField);
	    textField.setColumns(10);
	
	    textField_1 = new JTextField();
	    textField_1.setBounds(118, 109, 266, 20);
	    frame.getContentPane().add(textField_1);
	    textField_1.setColumns(10);
	    
	    JButton btnHash = new JButton("Hash");
	    btnHash.addActionListener(this);
	    
	    textField.addKeyListener(
	    		new KeyAdapter()
	    		{
	    			public void keyReleased( KeyEvent e )
	    			{
	    				if (debug) {System.out.println("It works!" + e.getKeyCode());}

	    				if( e.getKeyCode() == KeyEvent.VK_ENTER )
	    				{
	    					if (debug) {System.out.println("It works!");}
	    					doSomething();
	    				}
	    			}
	    		}
	    		);
	    
	    btnHash.setBounds(222, 201, 89, 23);
	    frame.getContentPane().add(btnHash);
	    
	}
	
	/*	String hashSHAPassword(String password) throws NoSuchAlgorithmException,
		UnsupportedEncodingException {
			MessageDigest digest = MessageDigest.getInstance("SHA");
			digest.update(password.getBytes("UTF8"));
			String shaPassword = new String(Base64.getEncoder().encode(digest.digest())
					, "UTF8"); // For UTF8 encoding
	
			return "{SHA}" + shaPassword;
		}*/
	
	//TODO
	
	private static final char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static String byteArray2Hex(byte[] bytes) {
	    StringBuffer sb = new StringBuffer(bytes.length * 2);
	    for(final byte b : bytes) {
	        sb.append(hex[(b & 0xF0) >> 4]);
	        sb.append(hex[b & 0x0F]);
	    }
	    return sb.toString();
	}

	public static String getStringFromSHA256(String stringToEncrypt) throws NoSuchAlgorithmException {
	    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
	    messageDigest.update(stringToEncrypt.getBytes());
	    return byteArray2Hex(messageDigest.digest());
	}
		
		@SuppressWarnings("unused")
		private void compare () {
			// Compare previousS and s.
			System.out.println("s = " + s + " " + previousS);
			
			if (s != null && previousS != null)
				System.out.println("Not null s =" + s + " " + previousS);
			
			if (previousS != null && previousS.equals(s))
				System.out.println("They are equal.");
			else
				System.out.println("They are not equal.");
			
		}
	    public void actionPerformed(ActionEvent arg0) {
	       doSomething();
	    }

		private void doSomething() {
			  
			 textField.requestFocusInWindow();
			 
		     String text = textField.getText();
		     textField.setText("");
		 	
				byte[] b = text.getBytes();
				//s = hashSHAPassword(text);
				s = byteArray2Hex(b);
				
				//TODO
				
		        textField_1.setText(s);
		        System.out.println("Entered:" + text);
		        System.out.println("Hashed:" + s.toString());
//		        compare();
		        previousS = s; 
		        
			
		}
}