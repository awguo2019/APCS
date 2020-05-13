package districtcp;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class elementary extends student {
	
	
	public elementary(String[] lnames, String[] mnames, String[] fnames) throws FileNotFoundException {
		Random r = new Random();
		int gender = r.nextInt(2);
		String sex;
		if(gender == 1) {
			int x = mnames.length;
			fname = mnames[r.nextInt(x)];
			x = lnames.length;
			lname = lnames[r.nextInt(x)];
		}else {
			int x = fnames.length;
			fname = fnames[r.nextInt(x)];
			x = lnames.length;
			lname = lnames[r.nextInt(x)];
		}
		
		
		idnum = 600000 + r.nextInt(9000);
		hw = 50 + r.nextInt(50);
		test = 50 + r.nextInt(50);
		classwk = 50 + r.nextInt(50);
		year = r.nextInt(5) + 1;
		avgscores();
		findGrade();
		getFees();
	}


	public void avgscores() {
		gradetotal = (int) (hw*0.1 + classwk * 0.6 + test*0.3);
		
	}

	
	public void findGrade() {
		if(gradetotal>=89.5) {
			letter = "A (Principal's List)";
		}else if (gradetotal >=79.5){
			letter = "B";
		}else if (gradetotal >=69.5){
			letter = "C";
		}else if (gradetotal >=59.5){
			letter = "D";
		}else{
			letter = "F";
		}
		
	}


	public void getFees() {
		fees = (year*5) + 400;
		
	}
	public String toString() {
		String s;
		if(year>3){
		s = "INT SSID: " + idnum + "  Year: " + year + "  Name: " + lname + ", " + fname + "  Tuition Costs: $" + fees + "  Grade: " + gradetotal + ", " + letter;
		}else{
		s = "ELE SSID: " + idnum + "  Year: " + year + "  Name: " + lname + ", " + fname + "  Tuition Costs: $" + fees + "  Grade: " + gradetotal + ", " + letter;

		}
		return s;
		}
	}

