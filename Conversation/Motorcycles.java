package Conversation;

import java.util.Random;

public class Motorcycles extends Vehicle{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeVehicle();
		makeMotorcycles();
	}

	@SuppressWarnings("static-access")
	public static void makeMotorcycles() {
	 Motorcycles m = new Motorcycles();
	 m.getColor();
	 m.getFuel();
	 Random random = new Random();
	 switch (random.nextInt(6)) {
	   case 0: 
	    	m.make = "Yamaha RZ250";
	        break;
	    case 1: 
	    	m.make = "Buell";
	        break;
	    case 2: 
	    	m.make = "Soft Tail";
	        break;	 
	    case 3: 
	    	m.make = "Cruiser";
	        break;
	    case 4: 
	    	m.make = "Chopper";
	        break;	 
	    case 5: 
	    	m.make = "Gold Wing";
	        break;	
	 			}        
		{
		String rl = getLocation(random);
		System.out.println("This is your Captain.");
		System.out.println("Calling Vehicle definition...");
		Vehicledef();
		//T.testType();
		//This method is an example of how to print class name
		//T.Vehicledef();
		//T.setColor("Purple");
		//System.out.println("This is a custom Truck it is a " + T.color + " " + T.make
		//		 + " " + T.fuel);
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
					System.out.println("The Motorcycle is being used so cannot start it."); 
					} 
			 }
		}
		 static void Vehicledef () {
			 System.out.println("ROGER This is a Motorcycle it is a " + color + " " + make + " " + fuel);
			 if (engineState == true)
			 System.out.println("The engine is on.");
			 else System.out.println("The engine is off.");
		 }
	}