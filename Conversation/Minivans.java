package Conversation;

import java.util.Random;

public class Minivans extends Vehicle{
	static String make;

public static void main (String args[]) {
	makeVehicle();
	makeMinivans();
}

@SuppressWarnings("static-access")
public static void makeMinivans() {
 Minivans M = new Minivans();
 M.getColor();
 M.getFuel();
 Random random = new Random();
 switch (random.nextInt(6)) {
    case 0: 
    	M.make = "Caravan";
        break;
    case 1: 
    	M.make = "Sienna";
        break;
    case 2: 
    	M.make = "Astro";
        break;
    case 3:
    	M.make = "Pacifica";
    	break;
    case 4:
    	M.make = "Odyssey";
    	break;
    case 5:
    	M.make = "Quest";
    	break;
 			}        
	{
	String rl = getLocation(random);
	System.out.println("This is your Captain.");
	System.out.println("Calling Vehicle definition...");
	Vehicledef();
	//M.testType();
	//This method is an example of how to print class name
	//System.out.println(this.getClass().getSimpleName());
	//M.Vehicledef();
	//M.setColor("Purple");
	//System.out.println("This is a custom Vehicle it is a " + V.color + " " + V.make
	//		 + " " + M.fuel);
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
				System.out.println("The Minivan is being used so cannot start it."); 
				} 
		 }
	}
	 static void Vehicledef () {
		 System.out.println("ROGER This is a Minivan it is a " + color + " " + make + " " + fuel);
		 if (engineState == true)
		 System.out.println("The engine is on.");
		 else System.out.println("The engine is off.");
	 	}
	}