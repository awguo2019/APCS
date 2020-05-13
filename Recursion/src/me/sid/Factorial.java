package me.sid;

public class Factorial {

	public static int IterFactorial(int n) {
		int fact = 1;
		for (int i=n; i>1; i--) {
			fact = fact * i;
		}
		return fact;
	}
	
	public static int RecFactorial(int n) {
		if (n == 1) {
			return 1;
		}else {
			return n * RecFactorial(n-1);
		}
	}
}
