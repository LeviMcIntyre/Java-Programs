package randomthings;

import java.util.Scanner;


class Permutation {
	
	private static boolean spellcheck = true;
	char temp;
	char[] charArray;
	static Dictionary d;
	
	public static void main(String[] args) {
		
		long start = java.util.Calendar.getInstance().getTimeInMillis();

		try {
			d = new Dictionary();
		}catch(Exception e) {
			System.out.println(e);
		}
        //System.out.println(d.contains(""));
		String str;
		System.out.println("Please list characters to permute, "
				+ "anything longer than 8 characters will take some time.");
		Scanner scanner = new Scanner(System.in);
	    str = scanner.nextLine();
		
		int n = str.length(); 
        Permutation permutation = new Permutation(); 
        permutation.permute(str.toCharArray(), 0, n-1); 
        
        long end = java.util.Calendar.getInstance().getTimeInMillis();
        System.out.println();
        System.out.println("it took this long to complete this stuff: " + (end - start) + 
        		" milliseconds.");
        scanner.close();
    } 
  
    /** 
     * permutation function 
     * @param str string to calculate permutation for 
     * @param l starting index 
     * @param r end index 
     */
    private void permute(char[] str, int l, int r) 
    { 
        if (l == r) {
        	if(d!= null && d.contains(str.toString())){System.out.println(str.toString());}
        }else
        { 
            for (int i = l; i <= r; i++) 
            { 
                str = swap(str,l,i); 
                permute(str, l+1, r); 
                str = swap(str,l,i); 
            } 
        } 
    } 
  
    /** 
     * Swap Characters at position 
     * @param a string value 
     * @param i position 1 
     * @param j position 2 
     * @return swapped string 
     */
    public char[] swap(char[] a, int i, int j) 
    { 
        charArray = a; 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return charArray; 
    } 
  
} 
  
// This code is contributed by Mihir Joshi 