package TYJ;

public class testblock {
	void Testblock() {    
		int x = 10;    
			{ // Start of block      
				int y = 50;      
				System.out.println("Inside the block:");      
				System.out.println("x:" + x);      
				System.out.println("y:" + y);
			if (x < y)    
				System.out.println("x is smaller than y");
		    
			} // End of block
		}
	int x = 1;{
	do {    
		System.out.println("Looping, round " + x);    
		x++; }
	while (x <= 10);
	}
}

