package Conversation;

import java.util.Random;

public class Generater{
	static String d;
	@SuppressWarnings({ "static-access" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cars c = new Cars();
		Motorcycles m = new Motorcycles();
		Trucks t = new Trucks();
		Vans v = new Vans();
		Minivans M = new Minivans();
		Random random = new Random();
		switch (random.nextInt(5))
		{
		    case 0: 
		    	t.makeTrucks();
		    	if(random.nextBoolean()) {
		    		System.out.println("It also has a Motorcycle in the back.");
		    		MB.makeMB();
		    		System.out.println("Okay.");
		    	}
		    	break;
		    case 1:
		    	m.makeMotorcycles();
		    	break;
		    case 2:
		    	c.makeCars();
		    	break;
		    	
		    case 3:
		    	M.makeMinivans();
		    	break;
		    case 4:
		    	v.makeVans();
		    	if(random.nextBoolean()) {
		    		System.out.println("It also has a Motorcycle in the back.");
		    		MB.makeMB();
		    		System.out.println("Okay.");
		    	}
		    	
			}  
		}
	}