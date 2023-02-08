package Conversation;

import java.util.Random;

public class MB {

String make;
	String color;
	String fuel;

	public static void main (String args[]) {
		makeMB();
	}
	public static void makeMB() {
	
 MB MB = new MB();
 Random random = new Random();
 switch (random.nextInt(6)) {
    case 0: 
    	MB.make = "Yamaha RZ250";
        break;
    case 1: 
    	MB.make = "Buell";
        break;
    case 2: 
    	MB.make = "Soft Tail";
        break;	 
    case 3: 
    	MB.make = "Cruiser";
        break;
    case 4: 
    	MB.make = "Chopper";
        break;	 
    case 5: 
    	MB.make = "Gold Wing";
        break;	 
 }      
 switch (random.nextInt(3)) {
 	case 0:
 		MB.fuel = "and it uses Diesel.";
 		break;
 	case 1:
 		MB.fuel = "and it uses Gas.";
 		break;
 	case 2:
 		MB.fuel ="and it is Electric.";
 		break;
 }   
        
 switch (random.nextInt(6)){
    case 0: 
    	MB.color = "Yellow";
        break;
    case 1: 
    	MB.color = "Red";
        break;
    case 2: 
    	MB.color = "Orange";
        break;
    case 3:
    	MB.color = "Grey";
    	break;
    case 4:
    	MB.color = "Black";
    	break;
    case 5:
    	MB.color = "Blue";
    	break;
}
 


 MB.Vehicledef();
		}

@SuppressWarnings("unused")
private static String getLocation(Random random) {
	String l = "";

	switch (random.nextInt(3)){
	    case 0: 
	    	l = "in The Driveway.";
	        break;
	    case 1: 
	    	l = "in The Garage.";
	        break;
	    case 2:
	    	l = "being used.";
	}
	return l;
}
 void Vehicledef () {
	 System.out.println("The Motorcycle is a "
	 + color + " " + make + " " + fuel);
 		}
 	}
