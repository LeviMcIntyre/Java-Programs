package randomthings;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Open {
	
	
	int Button1 = InputEvent.BUTTON1_DOWN_MASK;
	int y;
	int x;
	private JFrame frame;
	//private JPasswordField Pass;
	//private JButton Button;
	private JButton Open1;
	private JButton Open2;
	private JButton Open3;
	private JButton Open4;
	private JButton Open5;
	private JButton Open6;
	private JButton Open7;
	private JButton Open8;
	private JButton Open9;
	boolean debug = false;
	char[] text = null;
	char text2;
	
	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                Open window = new Open();
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
	public Open() {
		
		frame = new JFrame("Open a file");
		//  Left side, Top, How far away from left side, How far away from top. 
	    frame.setBounds(0, 0, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowFocusListener(new WindowAdapter() {
			/*public void windowGainedFocus(WindowEvent e) {
				Pass.requestFocusInWindow(); TODO
		    }*/
	    }
		);
		frame.getContentPane().setLayout(null);
		
		/*Button = new JButton( new AbstractAction("Enter the password.") {
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unlikely-arg-type")
			@Override
	        public void actionPerformed( ActionEvent e ) {
				text = Pass.getPassword();
				//text = Character.toLowerCase(text);
				if(text.equals("levi")) {
					Pass.setVisible(false);
					Button.setVisible(false);
					initialize();
				}
	        }
	    }
		);
		Button.setBounds(0, 0, 150, 767);
		frame.getContentPane().add(Button);
		
		Pass = new JPasswordField();
		Pass.setBounds(130, 0, 1366-130, 768);
		frame.getContentPane().add(Pass);
		Pass.addKeyListener(
	    		new KeyAdapter()
	    		{
	    			@SuppressWarnings("unlikely-arg-type")
					public void keyPressed( KeyEvent e )
	    			{
	    				if( e.getKeyCode() == KeyEvent.VK_ENTER)
	    				{
	    					text = Pass.getPassword();
	    					if(text.equals("levi")) {
	    						Pass.setVisible(false);
	    						Button.setVisible(false);
	    						initialize();
	    					}
	    				}
	    			}
	    		}
	    	);
		*/
	    initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	    
	    Open1 = new JButton( new AbstractAction("Eclipse") {
			private static final long serialVersionUID = 1L;

			@Override
	        public void actionPerformed( ActionEvent e ) {
	    		Desktop d = Desktop.getDesktop();
	    		File f = new File("C:\\Users\\shared\\Desktop\\Levi\\\\Java\\Eclipse\\java-2019-12\\eclipse"
	    		+ "\\Eclipse.exe"); 
	    	    try {
					d.open(f);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	        }
	    }
		);
	    Open1.setBounds(138, 39, 273, 153);
	    frame.getContentPane().add(Open1);
	    
	    Open2 = new JButton( new AbstractAction("Warzone") {
			private static final long serialVersionUID = 1L;

			@Override
	        public void actionPerformed( ActionEvent e ) {
	    		Desktop d = Desktop.getDesktop();
	    		File f= new File("C:\\Users\\shared\\Desktop\\Levi\\Support Stuff\\Warzone 2100\\"
	    				+ "3.3.0\\launch_warzone.bat"); 
	    	    try {
					d.open(f);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	        }
	    }
		);
	    Open2.setBounds(547, 39, 273, 153);
	    frame.getContentPane().add(Open2);
	    
	    Open3 = new JButton( new AbstractAction("The Aetherlight") {
			private static final long serialVersionUID = 1L;

			@Override
	        public void actionPerformed( ActionEvent e ) {
	    		Desktop d = Desktop.getDesktop();
	    		File f = new File("C:\\Users\\shared\\AppData\\Local\\TheAetherlightLauncher\\app-1.6.3\\TheAetherlightLauncher.exe"); 
	    	    try {
					d.open(f);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	        }
	    }
		);
	    Open3.setBounds(956, 39, 273, 153);
	    frame.getContentPane().add(Open3);
	    
	    Open4 = new JButton( new AbstractAction("Playlists") {
			private static final long serialVersionUID = 1L;

			@Override
	        public void actionPerformed( ActionEvent e ) {
	    		Desktop d = Desktop.getDesktop();
	    		File f = new File("C:\\Users\\shared\\Music\\PLaylists"); 
	    	    try {
					d.open(f);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	        }
	    }
		);
	    Open4.setBounds(138, 269, 273, 154);
	    frame.getContentPane().add(Open4);
	    
	    Open5 = new JButton( new AbstractAction("Levi's Pictures") {
			private static final long serialVersionUID = 1L;

			@Override
	        public void actionPerformed( ActionEvent e ) {
	    		Desktop d = Desktop.getDesktop();
	    		File f = new File("C:\\Users\\shared\\Pictures\\Levi's pictures"); 
	    	    try {
					d.open(f);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	        }
	    }
		);
	    Open5.setBounds(547, 269, 273, 154);
	    frame.getContentPane().add(Open5);
	    
	    Open6 = new JButton( new AbstractAction("Videos") {
			private static final long serialVersionUID = 1L;

			@Override
	        public void actionPerformed( ActionEvent e ) {
	    		Desktop d = Desktop.getDesktop();
	    		File f = new File("C:\\Users\\shared\\Desktop\\Levi\\Videos"); 
	    	    try {
					d.open(f);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	        }
	    }
		);
	    Open6.setBounds(956, 269, 273, 154);
	    frame.getContentPane().add(Open6);
	    
	    Open7 = new JButton( new AbstractAction("Minecraft") {
			private static final long serialVersionUID = 1L;

			@Override
	        public void actionPerformed( ActionEvent e ) {
				Desktop d = Desktop.getDesktop();
	    		File f = new File("C:\\Program Files (x86)\\Minecraft Launcher\\MinecraftLauncher.exe"); 
	    	    try {
					d.open(f);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	        }
	    }
		);
	    Open7.setBounds(138, 507, 273, 154);
	    frame.getContentPane().add(Open7);
	    
	    Open8 = new JButton( new AbstractAction("Freecol") {
			private static final long serialVersionUID = 1L;

			@Override
	        public void actionPerformed( ActionEvent e ) { 
				Desktop d = Desktop.getDesktop();
	    		File f = new File("C:\\Users\\shared\\Desktop\\Levi\\Support Stuff\\FreeCol\\FreeCol"); 
	    	    try {
					d.open(f);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Robot r = null;
				try {
					r = new Robot();
		    		Thread.sleep(2000);
				} catch (AWTException | InterruptedException e1) {
					e1.printStackTrace();
				}
				Point point = MouseInfo.getPointerInfo().getLocation();
	    		int x = (int) point.getX();
	    		int y = (int) point.getY();
	    		r.mouseMove(300, 400);
	    		r.mousePress(Button1);
	    		r.mouseRelease(Button1);
	    		r.mousePress(Button1);
	    		r.mouseRelease(Button1);
	    		r.mouseMove(1350, 5);
	    		r.mousePress(Button1);
	    		r.mouseRelease(Button1);
	    		r.mouseMove(x, y);
	        }
	    }
		);
	    Open8.setBounds(547, 507, 273, 154);
	    frame.getContentPane().add(Open8);
	    
	    Open9 = new JButton( new AbstractAction("Audacity") {
			private static final long serialVersionUID = 1L;

			@Override
	        public void actionPerformed( ActionEvent e ) {
				Desktop d = Desktop.getDesktop();
	    		File f = new File("C:\\Program Files (x86)\\Audacity\\Audacity.exe"); 
	    	    try {
					d.open(f);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
	    }
		);
	    Open9.setBounds(956, 507, 273, 154);
	    frame.getContentPane().add(Open9);
	    
	}
	
}