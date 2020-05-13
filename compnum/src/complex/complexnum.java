package complex;
import java.util.*;

public class complexnum {
	private double a, b;
	private String s;
	
	public complexnum() {
		a = 0;
		b = 0;
	}
	
	public complexnum(double x, double y) {
		a = x;
		b = y;
	}
	
	public complexnum(String userget) {
		int usernum = userget.length();
		int check;
		check = 0;
		String qs;
		qs = "";
		String rs;
		rs = "";
		if (userget.charAt(0) == '-'){
			qs = qs + userget.charAt(0);
			check = check + 1;
			for (int i = 1; i < usernum; i++){
				if (userget.charAt(i) != '+' && userget.charAt(i) != '-'){
					qs = qs + userget.charAt(i);
					check++;
				}
				else{
					if (userget.charAt(i) == '-'){
						rs = rs + '-';
						check++;
					}
					break;
				}

			}

			for (int i = check; i < (usernum - 1); i++){
				rs = rs + userget.charAt(i);
				check++;
			}
		}

		else{
			for (int i = 0; i < (usernum - 1); i++){
				if (userget.charAt(i) != '+' && userget.charAt(i) != '-'){
					qs = qs + userget.charAt(i);
					check++;
				}
				else{
					if (userget.charAt(i) == '-'){
						rs = rs + '-';
						check++;
					}
					

					break;
				}

			}

			for (int i = (check); i < (usernum - 1); i++){
				rs = rs + userget.charAt(i);

			}

		}
		
		a = Double.parseDouble(qs);
		b = Double.parseDouble(rs);
		
	}
	
	public void copy(double x, double y) {
		 a = x;
		 b = y;
	 }
	
	 public void add(complexnum n1, complexnum n2) {
		 a = n1.a() + n2.a();
		 b = n1.b() + n2.b();
	 }
	 
	 public void subt(complexnum n1, complexnum n2) {
		 a = n1.a() - n2.a();
		 b = n1.b() - n2.b();
	 }
	 
	 public void mult(complexnum n1, complexnum n2) {
		 a = n1.a()*n2.a() - n1.b()*n2.b();
		 b = n1.b()*n2.a() + n1.a()*n2.b();
	 }
	 public void div(complexnum n1, complexnum n2) {
		 	double d;
			d = (n2.a()*n2.a() + n2.b()*n2.b());
			complexnum conj = new complexnum(n2.a(), (-n2.b()));
			mult(n1, conj);
			a = a / d;
			b = b / d;
	 }
	 
	 public void exp(complexnum n1, float e) {
		double av;
			double theta;

			av = n1.abs();
			theta = n1.a / av;
			theta = Math.acos(theta);
			a = Math.pow(av, e)*Math.cos(e*theta);
			b = Math.pow(av, e)*Math.sin(e*theta);
	 }
	 
	 public double abs() {
		 double x;
			x = Math.pow((a* a + b*b), .5);
			return x;
	 }
	 
	public double a() {
		return a;
	}
	public double b() {
		return b;
	}
	
	public String toString() {
		String ss;
		String as;
		String bs;
		ss = "";
		as = a + "";
		bs = b + "";
		if (a != 0){
			if (b < 0){
				ss = as + (bs)+"i";
			}
			if (b > 0){
				ss = as + "+" + bs + "i";
			}
			if (b == 0){
				ss = as;
			}
		}
		else{
			if (b != 0){
				ss = bs + "i";
			}
			else{
				ss = "0";
			}
		}
		return ss;
	}
}
