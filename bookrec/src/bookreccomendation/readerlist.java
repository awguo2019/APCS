package bookreccomendation;

import java.util.*;
import java.io.*;

public class readerlist {
	reader[] rlist = new reader[100];
	int c;
	
	    public readerlist(){                      
	          File f = new File("ratings.txt");    
	          c = 0;
	            try {                                         
	            	Scanner input = new Scanner(f); 
	            	while (input.hasNextLine()) { 
	 	               reader r = new reader(); 
	 	               	String n; 
	 	               	n = input.nextLine();
	 	               	r.setname(n);
	 	               	n= input.nextLine();
	 	               	r.setscore(n);
	 	               	rlist[c]= r;
	 	                  	c++;
	 	                }
	            }
	            catch (FileNotFoundException e) {           
                	// TODO Auto-generated catch block        
	            	e.printStackTrace();                      
	            }                                             
	           
	           
	            }

	   
	
	    
	    }
	            

