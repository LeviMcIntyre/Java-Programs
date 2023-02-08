package Conversation;

import java.util.Random;

public class Cars extends Vehicle{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeVehicle();
		makeCars();
	}

	@SuppressWarnings("static-access")
	public static void makeCars() {
	 Cars C = new Cars();
	 C.getColor();
	 C.getFuel();
	 Random random = new Random();
	 switch (random.nextInt(6)) {
	 case 0: 
	    	C.make = "Neon";
	        break;
	    case 1: 
	    	C.make = "Charger";
	        break;
	    case 2: 
	    	C.make = "Challenger";
	        break;
	    case 3:
	    	C.make = "Dart";
	    	break;
	    case 4:
	    	C.make = "Taurus";
	    	break;
	    case 5:
	    	C.make = "Escape";
	    	break;
	 			}        
		{
		String rl = getLocation(random);
		System.out.println("This is your Captain.");
		System.out.println("Calling Vehicle definition...");
		Vehicledef();
		//C.testType();
		//This method is an example of how to print class name
		//C.Vehicledef();
		//C.setColor("Purple");
		//System.out.println("This is a custom Car it is a " + C.color + " " + C.make
		//		 + " " + C.fuel);
		if (engineState) {
			 System.out.println("Good meet me at rendezvous point 2.");
			 System.out.println("ROGER.");}
		if (!engineState && rl != "being used.") {
			 System.out.println("Start engine then.");
			 System.out.println("ROGER going to start engine, it is "+ rl);
			 System.out.println("Good meet me at rendezvous point 2.");
			 System.out.println("ROGER.");}
			 if (!engineState && rl== "being used.") {
				 	System.out.println("Start engine then.");
					System.out.println("The Car is being used so cannot start it."); 
					} 
			 }
		}
		 static void Vehicledef () {
			 System.out.println("ROGER This is a Car it is a " + color + " " + make + " " + fuel);
			 if (engineState == true)
			 System.out.println("The engine is on.");
			 else System.out.println("The engine is off.");
		 }
	}