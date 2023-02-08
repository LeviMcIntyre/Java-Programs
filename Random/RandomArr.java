package randomthings;

import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("unused")
public class RandomArr {
	
	static int CT;
	static int[] arr = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
			,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
			,0,0,0,0,0,0,0,0,0,0};
	static Random r = new Random();
	static int NOL;
	static int i = 0;
	static int Array;
	static String Arr = "[";

	public static void main(String[] args) {
		
		FillInt();
		SetArr();
		System.out.println(Arr + "]");
		//System.out.println(Arrays.toString(arr));
	}
	
	
	public static void FillInt() {
		
		NOL = r.nextInt(101);
		//NOL = 100;
		while(i <= NOL) {
			
			arr[i] = r.nextInt(20) + 1;
			i++;
		}
	}	
	public static void SetArr() {
		i = 0;
		while(i <= NOL) {
			
			Array = arr[i];
			Arr = Arr + Integer.toString(Array) + ", ";
			i++;
		}
	}
}
