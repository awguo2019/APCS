package me.sid;

public class Exponentiation {
	
	public static int IterExponentiation(int base, int e) {
		if (e == 0) {
			return 1;
		}else {
			int product = base;
			for (int i=1; i<e; i++) {
				product = product * base;
			}
			return product;
		}
	}
	
	public static int RecExponentiation(int base, int e) {
		if (e == 0) {
			return 1;
		}
		
		return base * RecExponentiation(base, e-1);
	}

}
