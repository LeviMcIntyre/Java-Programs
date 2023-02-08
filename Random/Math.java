package randomthings;

import java.util.Scanner;

public class Math {
	
	static Boolean i = false; 
	static Boolean error;
	static Scanner s = new Scanner(System.in);
	static double fn;
	static int o;
	static double sn;
	
	public static void main(String[] args) {
		
		while(i == false) {
			
			error = false;
			System.out.println("First number.");
			try {
				fn = Double.parseDouble(s.nextLine());
			} catch(Exception e){
				 System.out.println(e);
				 error = true;
			}
			System.out.println("Operation.");
			o = Integer.parseInt(s.nextLine());
			/*if(o != 1 || o != 2 || o != 3 || o != 4) {
				error = true;
			}*/
			System.out.println("Second number.");
			try {
				sn = Double.parseDouble(s.nextLine());
			} catch(Exception e){
				 System.out.println(e);
				 error = true;
			}
			
			if(error == false) {
				
				if(o == 1) {
					System.out.println(fn + sn);
				} else {
					if(o == 2) {
						System.out.println(fn - sn);
					} else {
						if(o == 3) {
							System.out.println(fn * sn);
						} else {
							if(o == 4) {
								System.out.println(fn / sn);
							} else {
								System.out.println("Invalid Math Problem.");
							}
						}
					}
				}
			}
			
			System.out.println();
		}
	}

}
