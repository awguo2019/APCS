package me.sid;

public class Fibonacci {

	public static int IterFibonacci(int n) {
		int x = 0;
		int y = 1;
		int num = 0;
		for (int i=1; i<n; i++) {
			num = x + y;
			x = y;
			y = num;
		}
		return num;
	}
	
	public static int RecFibonacci(int n) {
		if (n < 2) {
			return n;
		}
		return RecFibonacci(n-2) + RecFibonacci(n-1);
	}
}
