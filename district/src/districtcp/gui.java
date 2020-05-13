package districtcp;

import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.awt.*;

import javax.swing.*;
import java.util.*;
import java.io.*;




public class gui implements ActionListener{
			static String[] lnames;
			static String[] fnames;
			static String [] mnames;
			
		    static JTextArea tf1;  
	    static JButton b1, b2, b3, b4;
	    static ScrollPane srbar;
	    static JLabel l1;
	    static JMenuBar menubar;
	    static JFrame frame;
	    static ArrayList<String> data = new ArrayList<String>();
	    gui() throws FileNotFoundException{ 
		    menubar = new JMenuBar();
		    JMenu edit = new JMenu("Edit...");
		    JMenuItem add = new JMenuItem("Add");
	        JMenuItem change = new JMenuItem("Change");
	        JMenuItem delete = new JMenuItem("Delete");
	        add.addActionListener (new Action2());
	        change.addActionListener (new Action3());
	        delete.addActionListener (new Action4());
	        edit.add(add);
	        edit.add(change);
	        edit.add(delete);
	        menubar.add(edit);

	    	Scanner sc = new Scanner(new File("Male.txt"));
			List<String> lines = new ArrayList<String>();
			while (sc.hasNextLine()) {
			  lines.add(sc.nextLine());
			}
			Scanner qq = new Scanner(new File("Last.txt"));
			List<String> line = new ArrayList<String>();
			while (qq.hasNextLine()) {
			  line.add(qq.nextLine());
			}
			Scanner zz = new Scanner(new File("Female.txt"));
			List<String> linez = new ArrayList<String>();
			while (zz.hasNextLine()) {
			  linez.add(zz.nextLine());
			}
			lnames = line.toArray(new String[0]);
			mnames = lines.toArray(new String[0]);
			fnames = linez.toArray(new String[0]);
	    	
	    	
	        JFrame f= new JFrame("Chess");
	        f.setSize(675,550);  
	        f.setLayout(new BorderLayout());
	        
	       
	        l1 = new JLabel("DISTRICT");
	        l1.setBounds(25, 25, 150, 25);
	       
	        b1=new JButton("Generate");  
	        b1.setBounds(25,75,150,50); 
	        b1.addActionListener (new Action1());
	        
	        b2=new JButton("Add");  
	        b2.setBounds(200,75,75,50); 
	        b2.addActionListener (new Action2());
	        
	        b3=new JButton("Change");  
	        b3.setBounds(300,75,150,50); 
	        b3.addActionListener (new Action3());
	        
	        b4=new JButton("Delete");  
	        b4.setBounds(475,75,150,50); 
	        b4.addActionListener (new Action4());
	        
	        srbar = new ScrollPane();
	       
	        tf1=new JTextArea();  
	        tf1.setBounds(25,150,600,325);  
	        srbar.add(tf1);
	       srbar.setBounds(25,150,600,325);
	       
	        
	        
	        
	        f.add(l1); f.add(srbar);f.add(b1); f.add(b2); f.add(b3); f.add(b4); 
	       f.setJMenuBar(menubar);
	        f.setLayout(null);  
	     
	        f.setVisible(true);  
	      
	    }         

	public static void main(String[] args) throws FileNotFoundException {  
	    new gui();  
	}
	
	static class Action1 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) { 
			 ArrayList<String> d = new ArrayList<String>();

			  String s;
			  s = "";

			 for(int x = 0; x<1000; x++) {
				 Random r = new Random();
				 int i = r.nextInt(3);
				 
				 if(i == 0) {
					 
					try {
						elementary o = new elementary(lnames, mnames, fnames);
						 s = s + x + "  " + o.toString();
						 d.add(o.toString());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				 }else if(i == 1) {
					 
					try {
						middle p = new middle(lnames, mnames, fnames);
						 s = s + x + "  " +p.toString();
						 d.add(p.toString());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				 }else {
					 try {
							high w = new high(lnames, mnames, fnames);
							 s = s +x + "  " + w.toString();
							 d.add(w.toString());
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				 }
				 s = s + "\n";
			 }
			  tf1.setText(s);
			  data = d;
		  }
		}
	
	static class Action2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Random r = new Random();
			String letter;
			int idnum, fees;
			 String fname = JOptionPane.showInputDialog("Enter First Name: ");
			 String lname = JOptionPane.showInputDialog("Enter Last Name: ");
			 int year = Integer.parseInt(JOptionPane.showInputDialog("Enter School Year: "));
			 int gradetotal = Integer.parseInt(JOptionPane.showInputDialog("Enter Raw Grade: "));
			if(year>8) {
				idnum = 400000 + r.nextInt(9000);
				fees = (year*10) + 700;

			}else if(year>5) {
				idnum = 500000 + r.nextInt(9000);
				fees = (year*8) + 600;

			}else {
				idnum = 600000 + r.nextInt(9000);
				fees = (year*5) + 400;

			}
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
			String s;
			if(year >8){
				s = "HS SSID: " + idnum + "  Year: " + year + "  Name: " + lname + ", " + fname + "  Tuition Costs: $" + fees + "  Grade: " + gradetotal + ", " + letter;

			}else if(year > 5){
				s = "MS SSID: " + idnum + "  Year: " + year + "  Name: " + lname + ", " + fname + "  Tuition Costs: $" + fees + "  Grade: " + gradetotal + ", " + letter;

			}else if( year > 3){
				s = "INT SSID: " + idnum + "  Year: " + year + "  Name: " + lname + ", " + fname + "  Tuition Costs: $" + fees + "  Grade: " + gradetotal + ", " + letter;

			}else{
				s = "ELE SSID: " + idnum + "  Year: " + year + "  Name: " + lname + ", " + fname + "  Tuition Costs: $" + fees + "  Grade: " + gradetotal + ", " + letter;

			}
			data.add(s);
			String q = "";
			for(int i = 0; i < data.size(); i++) {
				q = q + i + "  " + data.get(i) + "\n";
			}
			tf1.setText(q);
		}
	}
	
	static class Action3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Random r = new Random();
			String letter;
			int idnum, fees;
			int changenum = Integer.parseInt(JOptionPane.showInputDialog("Enter value to be changed: "));
			 String fname = JOptionPane.showInputDialog("Enter First Name: ");
			 String lname = JOptionPane.showInputDialog("Enter Last Name: ");
			 int year = Integer.parseInt(JOptionPane.showInputDialog("Enter School Year: "));
			 int gradetotal = Integer.parseInt(JOptionPane.showInputDialog("Enter Raw Grade: "));
			if(year>8) {
				idnum = 400000 + r.nextInt(9000);
				fees = (year*10) + 700;

			}else if(year>5) {
				idnum = 500000 + r.nextInt(9000);
				fees = (year*8) + 600;

			}else {
				idnum = 600000 + r.nextInt(9000);
				fees = (year*5) + 400;

			}
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
			String s;
			if(year >8){
				s = "HS SSID: " + idnum + "  Year: " + year + "  Name: " + lname + ", " + fname + "  Tuition Costs: $" + fees + "  Grade: " + gradetotal + ", " + letter;

			}else if(year > 5){
				s = "MS SSID: " + idnum + "  Year: " + year + "  Name: " + lname + ", " + fname + "  Tuition Costs: $" + fees + "  Grade: " + gradetotal + ", " + letter;

			}else if( year > 3){
				s = "INT SSID: " + idnum + "  Year: " + year + "  Name: " + lname + ", " + fname + "  Tuition Costs: $" + fees + "  Grade: " + gradetotal + ", " + letter;

			}else{
				s = "ELE SSID: " + idnum + "  Year: " + year + "  Name: " + lname + ", " + fname + "  Tuition Costs: $" + fees + "  Grade: " + gradetotal + ", " + letter;

			}
			data.set(changenum, s);
			String q = "";
			for(int i = 0; i < data.size(); i++) {
				q = q + i + "  " + data.get(i) + "\n";
			}
			tf1.setText(q);
		}
	}
	
	static class Action4 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int changenum = Integer.parseInt(JOptionPane.showInputDialog("Enter value to be deleted: "));
			data.remove(changenum);
			String q = "";
			for(int i = 0; i < data.size(); i++) {
				q = q + i + "  " + data.get(i) + "\n";
			}
			tf1.setText(q);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}   
	
}
