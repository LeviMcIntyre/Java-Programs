package randomthings;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Whack_A_Mole implements ActionListener {

	private static final String OFF_STRING = "   ";
	private static final String UP_STRING = ":-)";
	private static final String DOWN_STRING = ":-(";
	private static final Color OFF_COLOR = Color.LIGHT_GRAY;
	private static final Color UP_COLOR = Color.GREEN;
	private static final Color DOWN_COLOR = Color.RED;
	
	@SuppressWarnings("unused")
	private static int Hits;
	@SuppressWarnings("unused")
	private static int Total;
	private static Boolean Going = false;
	private static JFrame frame;
	static Boolean i;
	
	private static int count = 20;
	private static int score;
	private JButton startButton;
	private JButton[] buttons;
	private JLabel timeLabel, scoreLabel;
	private JTextArea timeArea;
	private JTextArea scoreArea;
	private static Random random = new Random();

	public Whack_A_Mole() {
		
		Font font = new Font(Font.MONOSPACED, Font.BOLD, 14);

		JFrame frame = new JFrame("Whack-A-Mole");
		frame.setSize(350, 325);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pane = new JPanel();

		startButton = new JButton("Start");
		pane.add(startButton);
		startButton.addActionListener(this);

		timeLabel = new JLabel("Time Left:");
		pane.add(timeLabel);

		timeArea = new JTextArea(1, 5);
		timeArea.setEditable(false);
		pane.add(timeArea);
		timeArea.setVisible(true);

		scoreLabel = new JLabel("Score:");
		pane.add(scoreLabel);

		scoreArea = new JTextArea(1, 5);
		scoreArea.setEditable(false);
		pane.add(scoreArea);
		scoreArea.setVisible(true);

		buttons = new JButton[35];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(OFF_STRING);
			buttons[i].setOpaque(true);
			buttons[i].setFont(font);
			buttons[i].setBackground(OFF_COLOR);
			pane.add(buttons[i]);
			buttons[i].addActionListener(this);
		}

		frame.setContentPane(pane);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new Whack_A_Mole();
	}

	public static class MoleThread extends Thread {
		JButton button;

		MoleThread(JButton button) {
			this.button = button;
			if (count > -1) {
				if (button.getText().equals(OFF_STRING)) {
					button.setText(UP_STRING);
					button.setBackground(UP_COLOR);

				} else {
					button.setText(OFF_STRING);
					button.setBackground(OFF_COLOR);
				}
			}
		}

		public void run() {
			while (count > -1) {
				int randomSleepTime = random.nextInt(4000);
				synchronized (button) {
					if (button.getText().equals(OFF_STRING)) {
						button.setText(UP_STRING);
						button.setBackground(UP_COLOR);

					} else {
						button.setText(OFF_STRING);
						button.setBackground(OFF_COLOR);
					}

				}
				try {
					Thread.sleep(randomSleepTime);
				} catch (InterruptedException e) {
					// Should not happen
					throw new AssertionError(e);
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
				}
				
				if(count == 0) {
					i = false;
				}
				
			}
			
			if(count == -1) {

				//Acurracy(Hits, Total);
				i = false;
			}
			
			if (count == -1) {
				button.setText(OFF_STRING);
				button.setBackground(OFF_COLOR);
				Read();
				Going = false;
			}

		}
		
		//I added this TODO
		
		@SuppressWarnings("unused")
		private void Acurracy(int hits, int amount) {
			
			if(i = true) {
				frame = new JFrame();
				//  Left side, Top, How far away from left side, How far away from top. 
		    	frame.setBounds(260, 250, 549, 231);
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    frame.getContentPane().setLayout(null);
			    frame.setVisible(true);
			}
			i = false;
	
		}
		
		//I added this TODO
		
		private void Read() {
			
			BufferedReader br;
			String line = "";
			
			try {
				InputStreamReader isr = new InputStreamReader
					(new DataInputStream(new FileInputStream("C:\\Users\\shared\\Desktop\\"
							+ "Levi\\Java\\My Java Files\\Scores\\WhackAMole.txt")), "UTF-8");
				br = new BufferedReader(isr);
				line = br.readLine();
				int old_score = Integer.parseInt(line);
				Set_Highscore(score, old_score);
				
			}
			catch (FileNotFoundException fnfe) {
				System.err.println("Error opening file" + fnfe + " 1");
				System.exit(1);
			}
			catch (UnsupportedEncodingException uee) {
				System.err.println("Error opening file" + uee + " 2");
				System.exit(1);
			}
			catch (Exception e) {
				System.err.println("Error opening file" + e + " 3");
				System.exit(1);
			}
		}
		
		//I added this. TODO
		
		private void Set_Highscore(int score, int old_score) {
			
			if(score > old_score) {
			
				try{
		            // Create new file
		            String text = String.valueOf(score);
		            String path = "C:\\Users\\shared\\Desktop\\Levi\\Java\\My Java Files\\Scores"
		            		+ "\\WhackAMole.txt";
		            File file = new File(path);
	
		            // If file doesn't exists, then create it
		            if (!file.exists()) {
		                file.createNewFile();
		            }
	
			        FileWriter fw = new FileWriter(file.getAbsoluteFile());
			      	BufferedWriter bw = new BufferedWriter(fw);
		
			      	// Write in file
			      	bw.write(text);
		
			      	// Close connection
			        bw.close();
				 }catch(Exception e){
					 System.out.println(e);
				 }
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Thread[] moleThread = new Thread[buttons.length];

		if (e.getSource() == startButton) {
			Going = true;
			startButton.setEnabled(false);
			if(count != -1 && count != 0) {
				i = true;
			}

			// create timer, start timer, create array of mole threads, start
			Thread timerThread = new Thread(new Runnable() {

				@Override
				public void run() {
					while (count > -1) {

						try {

							timeArea.setText("" + count);
							count--;
							Thread.sleep(1000);
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
						if(count == 0) {
							
							i = false;
						}
					}
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					count = 20;
					score = 0;
					timeArea.setText("" + count);
					scoreArea.setText("" + score);
					startButton.setEnabled(true);
					Going = false;
				}
			});

			timerThread.start();

			for (int i = 0; i < moleThread.length; i++) {
				int randomMoleNum = random.nextInt(buttons.length);
				JButton button = buttons[randomMoleNum];
				moleThread[i] = new MoleThread(button);
				moleThread[i].start();

			}
		}
		for (int i = 0; i < buttons.length; i++) {
			if (e.getSource() == buttons[i]) {
				if (count > 0) {
					if (buttons[i].getText().equals(UP_STRING)) {
						score++;
						scoreArea.setText("" + score);
						buttons[i].setText(DOWN_STRING);
						buttons[i].setBackground(DOWN_COLOR);

					} else {
						if(Going == true) {
							score--;
							scoreArea.setText("" + score);
						}
						// I added this. TODO
					}
				}
			}

		}
	}
}