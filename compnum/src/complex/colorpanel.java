package complex;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class colorpanel extends JPanel {

	double xa;
	double ya;
	
	public colorpanel(Color backcolor, int flag, complexnum x){
		setBackground(backcolor);
		
		setFocusable(true);
	    requestFocus();
		
	    xa = x.a();
	    ya = x.b();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.red);
		for(int x = 0; x < 20; x++){
			g.drawLine(x*getWidth()/20,  getHeight()/2-10, x*getWidth()/20,  getHeight()/2+ 10);
			g.drawLine(getWidth()/2-10,  x*getHeight()/20,  getWidth()/2+10,  x*getHeight()/20);
			
		}
		g.setColor(Color.blue);
		g.drawLine(getWidth()/2,  0,  getWidth()/2,  getHeight());
		g.drawLine(0,  getHeight()/2,  getWidth(),  getHeight()/2);
		
		g.setColor(Color.black);
		Font f = new Font("Arial",Font.ITALIC,getHeight()/50);
		g.setFont(f);
		g.drawString("(0, 0)", getWidth()/2+getWidth()/200, getHeight()/2-getHeight()/75);
		g.drawOval((int)(20*xa+getWidth()/2), (int) (-20*ya+getHeight()/2), 5, 5);
		
	
	}
	}

