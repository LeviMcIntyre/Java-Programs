package serverStuff;

/**
 * This had a mess-up in it's name when I made it.
 */
public class StringTest {
	
	static String l = "Long enough String.";
	static String s = "s";
	
	public static void main(String[] args) {
		one();
		two();
		
	}
		
	private static void two() {
		l = "A String to be read.";
		s = "A String to be read.";
		System.out.println("This is String l before checking. : " + l);
		System.out.println("This is String c before checking. : " + s);
		s = methody(s);
		System.out.println("This is String l after checking. : " + l);
		System.out.println("This is String c after checking. : " + s);
	}
	
	public static String methody(String str) {
	    if (str != null && str.length() > 3) {
	    	str = str.substring(str.length() -3, str.length());
	    	
	    	if (str.equals( "ad.")) {
	    		System.out.println("It works : " + str );
		    }
	    }
	    
	    return str;
	}
	
	private static  void one() {
		System.out.println("This is String s before attempted shortening. : " + s);
		System.out.println("This is String l before attempted shortening. : " + l);
		s = method(s);
		System.out.println("This is String s after attempted shortening. : " + s);
		l = method(l);
		System.out.println("This is String l after attempted shortening. : " + l);
		System.out.println();
	}
		
	public static String method(String str) {
	    if (str != null && str.length() > 1) {
	    	return str.substring(0, str.length() - 1);
	    } else {
	    	System.out.println();
	    	System.out.println("ERROR: the string is to short it needs "
	    			+ "to be at least two characters long.");
	    	System.out.println();
	    }
	    return str;
	}
}
