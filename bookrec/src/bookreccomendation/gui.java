package bookreccomendation;



import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.*;
import java.util.*;
import java.io.*;




public class gui implements ActionListener{

 
    static JButton b1, b2, b3, b4, b5, b6, b7, b8;
  
    static String s1, s2;
    static JLabel l1, l2, l3;
    static JTextField t1;
    static JTextArea t2;
    static int bookno;
    static reader user;
    static readerlist relist;
    gui(){  
    	 relist = new readerlist();
    	 user = new reader();
         user.setname("User");
         user.setscore(true);
        
    	bookno = 0;
        JFrame f= new JFrame();
        f.setSize(525,600);  
        f.setLayout(new BorderLayout());
        l1 = new JLabel("Book Reccomendation: " + bookno);
        l1.setBounds(25, 25, 150, 50);
        l2 = new JLabel(user.blist[0].toString());
        l2.setBounds(25, 75, 600, 50);
        l3 = new JLabel("Your rating:");
        l3.setBounds(25, 125, 75, 50);  
        t1 = new JTextField(user.blist[0].getscorestring());
        t1.setBounds(125, 125, 50, 50);
        b1=new JButton("Vote");  
        b1.setBounds(200,125,75,50); 
        b1.addActionListener (new Action1());
        b8 = new JButton("Choose");
        b8.setBounds(275,125,125,50); 
        b8.addActionListener (new Action6());
       b2=new JButton("Change book");
        b2.setBounds(25, 200, 125, 50);
        b2.addActionListener (new Action2());
        b3=new JButton("Add book");
        b3.setBounds(150, 200, 100, 50);
        b3.addActionListener (new Action3());
        b4=new JButton("Delete book");
        b4.setBounds(250, 200, 125, 50);
        b4.addActionListener (new Action4());
        b5=new JButton("A");
        b5.addActionListener (new Action5());
        b5.setBounds(25, 275, 75, 35);
        b6=new JButton("B");
        b6.addActionListener (new Action5());
        b6.setBounds(125, 275, 75, 35);
        b7=new JButton("C");
        b7.addActionListener (new Action5());
        b7.setBounds(225, 275, 75, 35);
        t2 = new JTextArea();
        t2.setBounds(25, 325, 450, 200);
        f.add(l1); f.add(l2);f.add(l3);f.add(t1);f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);f.add(b6);f.add(b7);f.add(b8);f.add(t2);
        
        f.setLayout(null);  
     
        f.setVisible(true);  
      
    }         

public static void main(String[] args) {  
    new gui();  
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
} 

static class Action1 implements ActionListener {        
	  public void actionPerformed (ActionEvent e) {  
		s1 = t1.getText();
		int s;
		s = Integer.parseInt(s1);
		user.blist[bookno].setscore(s);
	  }
	}   

static class Action2 implements ActionListener {        
	  public void actionPerformed (ActionEvent e) { 
		s1 = JOptionPane.showInputDialog("Which book number?");
		bookno = Integer.parseInt(s1);
		t1.setText(user.blist[bookno].getscorestring());
		l1.setText("Book Reccomendation: " + bookno);
		l2.setText(user.blist[bookno].toString());
	  }
	}   

static class Action3 implements ActionListener {        
	  public void actionPerformed (ActionEvent e) {  
		  s1 = JOptionPane.showInputDialog("Book name:");
		  s2 = JOptionPane.showInputDialog("Book author:");
		  String sc = s2+","+s1;
		  user.addbook(sc);
		  for(int i = 0; i<relist.c; i++) {
			  relist.rlist[i].addbook(sc);
		  }
	  }
	}   

static class Action4 implements ActionListener {        
	  public void actionPerformed (ActionEvent e) {  
		  s1 = JOptionPane.showInputDialog("Which book number?");
		  int rip = Integer.parseInt(s1);
		  user.deletebook(rip);
		  for(int i = 0; i<relist.c; i++) {
			  relist.rlist[i].deletebook(rip);
		  }
	  }
	}   

static class Action5 implements ActionListener {        
	  public void actionPerformed (ActionEvent e) {  
		int max;
		int checky;
		int readerchoose;
	
		readerchoose  = 0;
		
		max = -99999;
		
		checky = 0;
		for(int i = 0; i<relist.c; i++) {
			int sum;
			sum = 0;
			for(int k = 0; k<user.blistn; k++) {
				if (readerchoose != i) {
				sum = sum + relist.rlist[i].blist[k].getscore()*user.blist[k].getscore();
				if(relist.rlist[i].blist[k].getscore()!= user.blist[k].getscore()){
					checky = 1;
				}
				}
			}
			if(sum>max) {
				if(checky == 1){
				
				max = sum;
				
				readerchoose = i;
				System.out.println(max);
				}
			}
		}
		

	System.out.println(readerchoose);
		String enter;
		enter = "";
		
		
		for(int i = 0; i<user.blistn; i++) {
			if(user.blist[i].getscore() == 0) {
				
				if(relist.rlist[readerchoose].blist[i].getscore()==5) {
					enter = enter + i + ": " + user.blist[i].toString() + "\n";
				}
			
			}
			
		}
		t2.setText(enter);
		
	  }
		  
		  
		  
	}   

static class Action6 implements ActionListener {        
	  public void actionPerformed (ActionEvent e) {  
		  s1 = JOptionPane.showInputDialog("Which reader?");
		  int rip = Integer.parseInt(s1);
		 for(int i = 0; i < user.blistn; i++){
			 user.blist[i].setscore(relist.rlist[rip].blist[i].getscore());
		 }
	
	  }
	}   

}


