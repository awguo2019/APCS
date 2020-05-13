package me.sid;

public class Summation {

	public static int IterSummation(int n) {
		int sum = 0;
		for (int i = 0; i<= n; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static int RecSummation(int n) {
		if (n == 1) {
			return n;
		}
		return n + RecSummation(n-1);
	}

}
