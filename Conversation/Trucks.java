package Conversation;

import java.util.Random;

public class Trucks extends Vehicle{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeVehicle();
		makeTrucks();
	}

	@SuppressWarnings("static-access")
	public static void makeTrucks() {
	 Trucks t = new Trucks();
	 t.getColor();
	 t.getFuel();
	 Random random = new Random();
	 switch (random.nextInt(6)) {
		 case 0: 
		 	t.make = "Ranger";
		     break;
		 case 1: 
		 	t.make = "Silverado";
		     break;
		 case 2: 
		 	t.make = "Titan";
		     break;
		 case 3:
		 	t.make = "Tacoma";
		 	break;
		 case 4:
		 	t.make = "Tundra";
		 	break;
		 case 5:
		 	t.make = "F 150";
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
			 System.out.println("Okay.");}
		if (!engineState && rl != "being used.") {
			 System.out.println("Start engine then.");
			 System.out.println("Okay going to start engine, it is "+ rl);
			 System.out.println("Good meet me at rendezvous point 2.");
			 System.out.println("Okay.");}
			 if (!engineState && rl== "being used.") {
				 	System.out.println("Start engine then.");
					System.out.println("The Truck is being used so cannot start it."); 
					} 
			 }
		}
	 static void Vehicledef () {
			 System.out.println("Okay it is a Truck that is " + d + " " + color + " " + make + " " + fuel);
			 if (trailer == true)
				 System.out.println("and it has a trailer,");
			 if (engineState == true)
			 System.out.println("the engine is on.");
			 else System.out.println("the engine is off.");
		 }
	}