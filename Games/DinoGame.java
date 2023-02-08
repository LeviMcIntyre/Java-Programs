package random2022;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.Timer;


public class DinoGame {
	
	static Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
	static Timer timer = new Timer();
	Date d = new Date();
	
	public static void main(String[] args) throws AWTException, InterruptedException{
		
		//waitForObstacle(); 
		Simple();
		System.exit(0);
	}
	
	static void Simple() throws AWTException {

		Robot R = new Robot();
		BufferedImage image = R.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())); 
		int C1 = 0;
		int C2 = 0;
		int L = 0;
		
		R.mouseMove((int)ScreenSize.getWidth()/4, (int) ((int)ScreenSize.getHeight()/1.7));
		
		while(C1 == 1000) {
			
			//Check for all obstacles except the highest birds
			image = R.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			C1 = image.getRGB((int)ScreenSize.getWidth()/4, (int) ((int)ScreenSize.getHeight()/1.6));	
			C2 = image.getRGB((int) ((int)ScreenSize.getWidth()/3.9), (int) ((int)ScreenSize.getHeight()/1.6));
			if(C1 == -11316397 || C2 == -11316397) {
				//System.out.println(C);
				R.keyPress(KeyEvent.VK_SPACE);
			}
			if(image.getRGB((int)ScreenSize.getWidth()/4, (int) ((int)ScreenSize.getHeight()/1.7)) == -11316397) {//Check for the middle birds
				//System.out.println(C);
				R.keyPress(KeyEvent.VK_SHIFT);
			}
		}
	}
	
	/*
	static void waitForObstacle() throws AWTException, InterruptedException {
		
		boolean Triggered1, Triggered2;
		int BtwnTime = 0;
		int Cactus = 0;
		int count = 0;
		Robot R = new Robot();
		int C;
		BufferedImage image = R.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())); 
		int MainW = (int)ScreenSize.getWidth()/2;
		int MainH = (int) ((int)ScreenSize.getHeight()/1.6);
		int LeftW = (int)ScreenSize.getWidth()/4;
		int LeftH = (int) ((int)ScreenSize.getHeight()/1.6);
		int TimeW = (int) (ScreenSize.getWidth()*.333);
		int TimeH = (int) ((int)ScreenSize.getHeight()*.333);
		Date d = new Date();
		float T1 = 0;
		float T2 = 0;

		//R.mouseMove(LeftW, LeftH);
		//R.mouseMove(TimeW, TimeH);
		//R.mouseMove(MainW, MainH);
		while(true) {
			
			image = R.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			C = image.getRGB(MainW, (int)MainH);
			if(C == -11316397) {
				
				Cactus ++;
				if(BtwnTime > 3 || Cactus >=3) {
					//System.out.println(C);
					Cactus = 0;
					count ++;
					System.out.println(count);
					T1 = d.getTime();
					Triggered1 = false;
					BtwnTime = 0;
				}
				
			} else if(C == -1) {
				Triggered1 = false;
				BtwnTime  ++;
				//System.out.println(BtwnTime);
			}
			C = image.getRGB(LeftW, (int)LeftH);
			if(C == -11316397) {

				//System.out.println(C);
				T2 = d.getTime();
				//System.out.println(T2-T1);
				Triggered2 = true;
				
			} else if(C == -1) {
				Triggered2 = false;
			}
		}
	}
	
	void decideType() {
		
	}
	
	void jump() {
		
		
	}
	
	void duck() {
		
	}*/

}
