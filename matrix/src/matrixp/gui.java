package matrixp;

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

    static JTextArea tf1,tf2,tf3;  
    static JButton b1,b2,b3,b4,b5,b6;
    static JButton m11, m12, m21, m22, m13, m23;
    static String s1, s2;
    static JLabel l1, l2;
    gui(){  
        JFrame f= new JFrame("Chess");
        f.setSize(525,600);  
        f.setLayout(new BorderLayout());
        l1 = new JLabel("Array1");
        l1.setBounds(75, 25, 150, 25);
        l2 = new JLabel("Array2");
        l2.setBounds(275, 25, 150, 25);
        tf1=new JTextArea();  
        tf1.setBounds(75,50,150,150);  
        tf2=new JTextArea();  
        tf2.setBounds(275,50,150,150);  
        tf3=new JTextArea();  
        tf3.setBounds(175,350,150,150);  
        tf3.setEditable(false); 
        m11 = new JButton("Import");
        m11.setBounds(75, 210, 75, 15);
        m11.addActionListener(new Import1());
        m12 = new JButton("RNG");
        m12.setBounds(160, 210, 65, 15);
        m12.addActionListener(new RNG1());
        m21 = new JButton("Import");
        m21.setBounds(275, 210, 75, 15);
        m21.addActionListener(new Import2());
        m22 = new JButton("RNG");
        m22.setBounds(360, 210, 65, 15);
        m22.addActionListener(new RNG2());
        m13 = new JButton("Save Array");
        m13.setBounds(75, 230, 150, 15);
        m13.addActionListener(new Export1());
        m23 = new JButton("Save Array");
        m23.setBounds(275, 230, 150, 15);
        m23.addActionListener(new Export2());
        b1=new JButton("+");  
        b1.setBounds(50,265,50,50); 
        b1.addActionListener (new Action1());
        b2=new JButton("-");  
        b2.setBounds(120,265,50,50);  
        b2.addActionListener (new Action2());
        b3=new JButton("*");  
        b3.setBounds(190,265,50,50);  
        b3.addActionListener (new Action3());
        b4=new JButton("/");  
        b4.setBounds(260,265,50,50); 
        b4.addActionListener (new Action4());
        b5=new JButton("dt");  
        b5.setBounds(330,265,50,50);  
        b5.addActionListener (new Action5());
        b6=new JButton("inv");  
        b6.setBounds(400,265,50,50); 
        b6.addActionListener (new Action6());
        
        f.add(m11);f.add(m12); f.add(m21);f.add(m22);f.add(m13);f.add(m23);
        f.add(l1); f.add(l2);f.add(tf1);f.add(tf2);f.add(tf3);f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);f.add(b6);  
        
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
		  s1=tf1.getText();  
		  s2=tf2.getText();  
		matrix m1 = new matrix(s1);
		matrix m2 = new matrix(s2);
		matrix ans = new matrix(m1, m2, 1);
		tf3.setText(ans.toString());
		
		
		/*JFrame graph = new JFrame("Chess");
	    
	    graph.setSize(500,500);
	    graph.setVisible(true);
	    graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		colorpanel panel = new colorpanel(Color.white, 0, ans);
		Container pane = graph.getContentPane();
		pane.add(panel);
		*/
	  }
	}   
	static class Action2 implements ActionListener {        
	  public void actionPerformed (ActionEvent e) {     
		  s1=tf1.getText();  
		  s2=tf2.getText();  
		  matrix m1 = new matrix(s1);
			matrix m2 = new matrix(s2);
			matrix ans = new matrix(m1, m2, 2);
			tf3.setText(ans.toString());
		  

		
		
	  }
	}   
	static class Action3 implements ActionListener {
		public void actionPerformed (ActionEvent e) {     
			 s1=tf1.getText();  
			  s2=tf2.getText();  
			  matrix m1 = new matrix(s1);
				matrix m2 = new matrix(s2);
				matrix ans = new matrix(m1, m2, 3);
				tf3.setText(ans.toString());

		
		  }
	}
	static class Action4 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			  s1=tf1.getText();  
			  s2=tf2.getText();  
			  matrix m1 = new matrix(s1);
			matrix m2 = new matrix(s2);
			matrix ans = new matrix(m1, m2, 4);
			tf3.setText(ans.toString());
			

			  }
			}   
	static class Action5 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			  s1=tf1.getText();  
			  s2=tf2.getText();  
			  matrix m1 = new matrix(s2);
			
			 double det = m1.det(m1.getx(), m1.getarr());
			 
			tf3.setText(""+det);
		
			}   

	}
	
	static class Action6 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			  s1=tf2.getText(); 
			  matrix m1 = new matrix(s1);
				
				matrix ans = new matrix(m1);
				tf3.setText(ans.toString());
			}   

	}
	
	static class Import1 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {   
			  String mat;
			  mat = "";
			  try {
				  String path;
				  	path = JOptionPane.showInputDialog("Path of file:");
				  	Scanner input = new Scanner(System.in);
				  	File file = new File(path);
				  	input = new Scanner(file);
				  	 while (input.hasNextLine()) {
			                mat = mat + input.nextLine() + "\n";			              
			            }
			            input.close();
			            
			  }catch (Exception ex) {
		            ex.printStackTrace();
		        }
			  tf1.setText(mat);
			  
			}   

	}
	
	static class Import2 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			  String mat;
			  mat = "";
			  try {
				  String path;
				  	path = JOptionPane.showInputDialog("Path of file:");
				  	Scanner input = new Scanner(System.in);
				  	File file = new File(path);
				  	input = new Scanner(file);
				  
				  	 while (input.hasNextLine()) {
			                mat = mat +  input.nextLine() + "\n";			              
			            }
			            
				 	input.close(); 
			  }catch (Exception ex) {
		            ex.printStackTrace();
		        }
			  
			  tf2.setText(mat);
			}   

	}
	
	static class RNG1 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {    
			  int x;
			  int y;
			  x = Integer.parseInt(JOptionPane.showInputDialog("Width of array:"));
			  y = Integer.parseInt(JOptionPane.showInputDialog("Length of array:"));
			  matrix ans = new matrix(x, y, true);
				tf1.setText(ans.toString());
			}   

	}
	
	static class RNG2 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			  int x;
			  int y;
			  x = Integer.parseInt(JOptionPane.showInputDialog("Width of array:"));
			  y = Integer.parseInt(JOptionPane.showInputDialog("Length of array:"));
			  matrix ans = new matrix(x, y, true);
				tf2.setText(ans.toString());
			}   

	}
	
	static class Export1 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			  String path;
			  	path = JOptionPane.showInputDialog("File name:");
			  	String s=tf1.getText(); 
			  	try {
					PrintWriter out = new PrintWriter(path);
					out.print(s);
					out.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  	
			  	
			}   

	}
	
	static class Export2 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			  String path;
			  	path = JOptionPane.showInputDialog("File name:");
			  	String s=tf2.getText(); 
			  	try {
					PrintWriter out = new PrintWriter(path);
					out.print(s);
					out.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  	
			  	
			}   

	}

}

