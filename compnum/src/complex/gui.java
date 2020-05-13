package complex;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;






public class gui implements ActionListener{

    static JTextField tf1,tf2,tf3;  
    static JButton b1,b2,b3,b4,b5,b6;  
    static String s1, s2;
    static complexnum ans = new complexnum();
    gui(){  
        JFrame f= new JFrame();
        f.setSize(525,600);  
        tf1=new JTextField();  
        tf1.setBounds(50,50,400,50);  
        tf2=new JTextField();  
        tf2.setBounds(50,150,400,50);  
        tf3=new JTextField();  
        tf3.setBounds(50,350,400,50);  
        tf3.setEditable(false);   
        b1=new JButton("+");  
        b1.setBounds(50,250,50,50); 
        b1.addActionListener (new Action1());
        b2=new JButton("-");  
        b2.setBounds(120,250,50,50);  
        b2.addActionListener (new Action2());
        b3=new JButton("*");  
        b3.setBounds(190,250,50,50);  
        b3.addActionListener (new Action3());
        b4=new JButton("/");  
        b4.setBounds(260,250,50,50); 
        b4.addActionListener (new Action4());
        b5=new JButton("ex");  
        b5.setBounds(330,250,50,50);  
        b5.addActionListener (new Action5());
        b6=new JButton("ab");  
        b6.setBounds(400,250,50,50); 
        b6.addActionListener (new Action6());
        
        f.add(tf1);f.add(tf2);f.add(tf3);f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);f.add(b6);  
       
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
		complexnum x = new complexnum(s1);
		complexnum y = new complexnum(s2);
		ans.add(x, y);
		tf3.setText(ans.toString());
		
		
		JFrame graph = new JFrame("Chess");
	    
	    graph.setSize(500,500);
	    graph.setVisible(true);
	    graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		colorpanel panel = new colorpanel(Color.white, 0, ans);
		Container pane = graph.getContentPane();
		pane.add(panel);
		
	  }
	}   
	static class Action2 implements ActionListener {        
	  public void actionPerformed (ActionEvent e) {     
		  s1=tf1.getText();  
		  s2=tf2.getText();  
		complexnum x = new complexnum(s1);
		complexnum y = new complexnum(s2);
		ans.subt(x, y);
		tf3.setText(ans.toString());
		  

		JFrame graph = new JFrame("Chess");
	    
	    graph.setSize(500,500);
	    graph.setVisible(true);
	    graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		colorpanel panel = new colorpanel(Color.white, 0, ans);
		Container pane = graph.getContentPane();
		pane.add(panel);
		
		
	  }
	}   
	static class Action3 implements ActionListener {
		public void actionPerformed (ActionEvent e) {     
			 s1=tf1.getText();  
			  s2=tf2.getText();  
			complexnum x = new complexnum(s1);
			complexnum y = new complexnum(s2);
			ans.mult(x, y);
			tf3.setText("(" + x.toString() + ") * (" + y.toString() + ") = " + ans.toString());


			JFrame graph = new JFrame("Chess");
		    
		    graph.setSize(500,500);
		    graph.setVisible(true);
		    graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			colorpanel panel = new colorpanel(Color.white, 0, ans);
			Container pane = graph.getContentPane();
			pane.add(panel);
		  }
	}
	static class Action4 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			  s1=tf1.getText();  
			  s2=tf2.getText();  
			complexnum x = new complexnum(s1);
			complexnum y = new complexnum(s2);
			ans.div(x, y);
			tf3.setText("("+x.toString() + ") / (" + y.toString()+") = " + ans.toString());
			

			JFrame graph = new JFrame("Chess");
		    
		    graph.setSize(500,500);
		    graph.setVisible(true);
		    graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			colorpanel panel = new colorpanel(Color.white, 0, ans);
			Container pane = graph.getContentPane();
			pane.add(panel);
			  }
			}   
	static class Action5 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			  s1=tf1.getText();  
			  s2=tf2.getText();  
			complexnum x = new complexnum(s1);
			int y = Integer.parseInt(s2);
			ans.exp(x, y);
			tf3.setText("("+x.toString()+")^"+y+" = "+ans.toString());
			
			

			JFrame graph = new JFrame("Chess");
		    
		    graph.setSize(500,500);
		    graph.setVisible(true);
		    graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			colorpanel panel = new colorpanel(Color.white, 0, ans);
			Container pane = graph.getContentPane();
			pane.add(panel);
			}   

	}
	
	static class Action6 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			  s1=tf1.getText(); 
			  complexnum x = new complexnum(s1);
			  double a;
			  a = x.abs();
			  tf3.setText("abs(" + x.toString()+") = " + a);
			  

				JFrame graph = new JFrame("Chess");
			    
			    graph.setSize(500,500);
			    graph.setVisible(true);
			    graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				colorpanel panel = new colorpanel(Color.white, 0, x);
				Container pane = graph.getContentPane();
				pane.add(panel);
			}   

	}

}
