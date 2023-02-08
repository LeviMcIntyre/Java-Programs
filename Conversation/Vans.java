package Conversation;

import java.util.Random;

public class Vans extends Vehicle{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeVehicle();
		makeVans();
	}

	@SuppressWarnings("static-access")
	public static void makeVans() {
	 Vans v = new Vans();
	 v.getColor();
	 v.getFuel();
	 Random random = new Random();
	 switch (random.nextInt(6)) {
	 	case 0: 
	    	v.make = "Express";
	        break;
	    case 1: 
	    	v.make = "E-Series";
	        break;
	    case 2: 
	    	v.make = "Nissan NV Passenger";
	        break;
	    case 3:
	    	v.make = "E 150";
	    	break;
	    case 4:
	    	v.make = "Aerostar";
	    	break;
	    case 5:
	    	v.make = "Sprinter";
	    	break;
	 			}        
		{
		String rl = getLocation(random);
		System.out.println("This is your Captain.");
		System.out.println("Calling Vehicle definition...");
		Vehicledef();
		//v.testType();
		//This method is an example of how to print class name
		//v.Vehicledef();
		//v.setColor("Purple");
		//System.out.println("This is a custom Truck it is a " + v.color + " " + v.make
		//		 + " " + v.fuel);
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
					System.out.println("The Van is being used so cannot start it."); 
					} 
			 }
		}
		 static void Vehicledef () {
			 System.out.println("ROGER This is a Van it is a " + color + " " + make + " " + fuel);
			 if (engineState == true)
			 System.out.println("The engine is on.");
			 else System.out.println("The engine is off.");
		 }
	}