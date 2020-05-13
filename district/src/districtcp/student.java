package districtcp;


	abstract public class student {
		protected int idnum;
		protected String fname;
		protected String lname;
		protected int hw;
		protected int test;
		protected int classwk;
		protected String letter;
		protected int year;
		protected double gradetotal;
		protected int fees;
		abstract public void avgscores();
		abstract public void findGrade();
		abstract public void getFees();	
		
	}

