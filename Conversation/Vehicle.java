package Conversation;

import java.util.Random;

public class Vehicle {	
	static String d;
	static String make;
	static String color;
	static String fuel;
	static boolean engineState;
	static boolean trailer;
	static Random random = new Random();
	public static void main (String args[]) {
			makeVehicle();
			d = color;
		}
	@SuppressWarnings("static-access")
	public static void makeVehicle() {
	 Vehicle V = new Vehicle();
	 
	 switch (random.nextInt(2)) {
	    case 0: 
	    	V.trailer = true;
	        break;
	    case 1: 
	    	V.trailer = false;
	        break;
	 	}
	 switch (random.nextInt(2)) {
	    case 0: 
	    	V.engineState = true;
	        break;
	    case 1: 
	    	V.engineState = false;
	        break;
	 } 
	}

	protected
	static String getLocation(Random random) {
		String rl = "";
	
		switch (random.nextInt(3)){
		    case 0: 
		    	rl = "in The Driveway.";
		        break;
		    case 1: 
		    	rl = "in The Garage.";
		        break;
		    case 2:
		    	rl = "being used.";
		}
		return rl;
	}
	/**This makes the engine roar.
	 * Author Levi
	 */
	void startEngine()  {
	     	 if (engineState == true) {
	  		System.out.println("The engine is already on.");
		 }else {
				engineState = true;
				System.out.println("The engine is on now.");
			}
		}
	public String getMake() {
		return make;
	}
	@SuppressWarnings("static-access")
	public void setMake(String make) {
		this.make = make;
	}
	@SuppressWarnings("static-access")
	public String getColor() {
		if (this.color==null) {
			switch (random.nextInt(6)){
		    case 0: 
		    	this.color = "Yellow";
		        break;
		    case 1: 
		    	this.color = "Red";
		        break;
		    case 2: 
		    	this.color = "Orange";
		        break;
		    case 3:
		    	this.color = "Grey";
		    	break;
		    case 4:
		    	this.color = "Black";
		    	break;
		    case 5:
		    	this.color = "Blue";
		    	break;
		 		}
		}
		return color;
	}
	{
		if( d != "Orange") {
	         d = "an" ;
	}else {
	         d = "a";
	      }
		}
	@SuppressWarnings("static-access")
	public void setColor(String color) {
		this.color = color;
	}
	@SuppressWarnings("static-access")
	protected String getFuel() {
		switch (random.nextInt(3)) {
	 	case 0:
	 		this.fuel = "that uses Diesel,";
	 		break;
	 	case 1:
	 		this.fuel = "that uses Gas,";
	 		break;
	 	case 2:
	 		this.fuel ="that is Electric,";
	 		break;
		}
		return fuel;
		}
			public void testType() {
				System.out.println("Test "+this.getClass().getSimpleName());
		}
		public static void main1 (String args[]) {
			d = color;
		}
	}