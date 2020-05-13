package bookreccomendation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class reader {

	books[] blist = new books[100];
	private String rname;
	int blistn;
	
	public reader(){   
		    File f = new File("books.txt");         
	          int c;
	          c = 0;
	            try {                                            
	            	Scanner input = new Scanner(f); 
	                while (input.hasNextLine()) {
	                    String i = input.nextLine();
	                    books x = new books(i);
	                    blist[c] = x;
	                    c++;
	                   
	                }
	                input.close();
	                blistn = c;
	            } catch (FileNotFoundException e) {              
	            	// TODO Auto-generated catch block           
	            	e.printStackTrace();                         
	            }     
	            
	            
	            		                                       	 
	     }                                                                                        
		                                       	                                             
	
	public void setscore(String s) {
		String[] scores = (s.split(" "));
			for(int x = 0; x<blistn; x++){
			blist[x].setscore(Integer.parseInt(scores[x]));
		}
		
	}
	
	public void deletebook(int n) {
		for(int i = n; i<blistn; i++) {
			blist[i] = blist[i+1];
		}
		blist[blistn] = null;
		blistn--;   
	}
	
	public void addbook(String s) {
		books x = new books(s);
		x.setscore(0);
		blist[blistn] = x;
		blistn++;
	}

	public void setname(String s) {
		rname = s;
	}
	
	public void setscore(boolean b) {
		for(int x = 0; x<blistn; x++){
			blist[x].setscore(0);
		}
	}
	
	String gname(){
		return rname;
	}

}
