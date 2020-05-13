package matrixp;
import java.util.*;
import javax.swing.*;
public class matrix {
private double[][] m = new double [99][99];
private int x, y;

public matrix(int a, int b, boolean c){
	Random r = new Random();
	x = a;
	y = b;
	for(int i = 0; i<x; i++){
		for(int j = 0; j<y; j++){
			m[i][j] = r.nextInt(50) + 1;
		}
	}
}

public matrix(matrix m1, matrix m2, int op) {
	switch(op) {
	
	case 1: //addition
		if(m1.getx() == m2.getx() && m1.gety() == m2.gety()) {
			x = m1.getx();
			y = m1.gety();
			for(int i = 0; i<x; i++) {
				for(int j = 0; j<y; j++) {
					m[i][j] = m1.getnum(i, j) + m2.getnum(i, j);
				}
			}
			
		}else{
			JOptionPane.showMessageDialog(null, "Cannot Add");
		}
		break;
		
	case 2: //subtraction
		if(m1.getx() == m2.getx() && m1.gety() == m2.gety()) {
			x = m1.getx();
			y = m1.gety();
			for(int i = 0; i<x; i++) {
				for(int j = 0; j<y; j++) {
					m[i][j] = m1.getnum(i, j) - m2.getnum(i, j);
				}
			}
			
		}else{
			JOptionPane.showMessageDialog(null, "Cannot Subtract");
		}
		break;
		
	case 3: //multiplication
		if (m1.gety() == m2.getx()) {
			x = m1.getx();
			y = m2.gety();
			for(int i = 0; i < x; i++) {
				for(int j = 0; j<y; j++) {
					m[i][j] = 0;
					for(int a = 0; a<m1.gety(); a++) {
						m[i][j] += m1.getnum(i, a)*m2.getnum(a, j);
					}
				}
			}
			
		}else if (m2.gety() == 1 && m2.getx() == 1) {
			double scalar = m2.getnum(0, 0);
			x = m1.getx();
			y = m1.gety();
			for(int i = 0; i<m1.getx(); i++) {
				for(int j = 0; j<m1.gety(); j++) {
					m[i][j] = m1.getnum(i, j) * scalar;
				}
			}
		}else{
			JOptionPane.showMessageDialog(null, "Cannot Multiply");
		}
		break;
		
	case 4: //division
		matrix inv = new matrix(m2);
		
		if (m1.gety() == inv.getx()) {
			x = m1.getx();
			y = inv.gety();
			for(int i = 0; i < x; i++) {
				for(int j = 0; j<y; j++) {
					m[i][j] = 0;
					for(int a = 0; a<m1.gety(); a++) {
						
						m[i][j] += m1.getnum(i, a)*inv.getnum(a, j);
					}
				}
			}
			
		}else if (m2.gety() == 1 && m2.getx() == 1) {
			double scalar = m2.getnum(0, 0);
			x = m1.getx();
			y = m1.gety();
			for(int i = 0; i<m1.getx(); i++) {
				for(int j = 0; j<m1.gety(); j++) {
					m[i][j] = m1.getnum(i, j) / scalar;
				}
			}
		}else{
			JOptionPane.showMessageDialog(null, "Cannot Divide");
		}
		
		
		
		
	}
	
}

public matrix(String s){
	String str[] = s.split("\\n");
	
	int strlen = str.length;
	int strnlen;
	strnlen = 0;
	for(int i = 0; i<strlen; i++){
		String strn[] = str[i].split(" ");
		strnlen = strn.length;
		for(int j = 0; j<strnlen; j++){
			m[i][j] = Double.parseDouble(strn[j]);
		}
	}
	
	x = strlen;
	y = strnlen;
	
}



public double det(int size, double A[][]){  //first try mothafuckas
	
	// I'm beginning to feeel like a math god math god 
	
	double dete;
	dete = 0;
	
	//initiate recursion
	switch(size){
		
	case 1: //if size is just 1x1
		dete = A[0][0];
		break;
		
	case 2: //finding determinant of 2x2
		dete = (A[0][0] * A[1][1]) - (A[1][0]*A[0][1]);
		break;
	
		
	default: 											//heres the meat of the algorithm!!!
		dete = 0; 											//initiate running total
		for(int i = 0; i<size; i++){   							//loop through columns to form subarray
            double[][]mt = new double[size-1][size-1];  	//initiate subarray
            for(int p = 1; p<size; p++){   				//fill subarray from the 2nd row of main array, rows loop           	
                int num;  								//num is the altered running total for subarray
                num = 0;   
                for(int q = 0; q<size; q++){  				//loop through columns main array                	
                    if(q != i){   					//test if the value shares a column                     	
                        mt[p-1][num]=A[p][q];   			//fill array, increment num
                        num++;
                    }                
                }
            }
            											//add to running total
            if(i%2 == 0) {
            		dete = dete + A[0][i] * det(size-1, mt);
            		
            }else{
            	dete = dete - A[0][i] * det(size-1, mt);
            }
      
		}
		
		
	}

	return dete;   	   // recursive bitchhhhhhh 
	

}

public matrix(matrix ma){
	x = ma.getx();
	y = ma.gety();
	
	int check = 0;
	double det = det(ma.getx(), ma.getarr());
	for(int i = 0; i<x; i++) {
		for(int j = 0; j<y; j++) {
			m[i][j] = ma.getnum(i, j);
			if((j+check)%2 == 1){
				m[i][j] *= -1;
			}
			
		}
		check++;
	}
	
	double temp[][] = m;
	m = temp;
	double tempo;
	switch(x){
	
	case 2:
		 tempo=m[0][0];
		m[0][0] = temp[1][1];
		m[1][1] = tempo;
		for(int i = 0; i<x; i++) {
			for(int j = 0; j<y; j++) {
				m[i][j] /= det;
				
			}
			
		}
		break;
	
	default:
		
		for(int i = 0; i<x; i++) {
			for(int j = 0; j<y; j++) {
				m[i][j] = temp[j][i]/ det;
				
			}
			
		}
	}
	
	
		
	

	
	
	
	
}

public double[][] getarr() {
	return m;        //only really used for det calculations
}

public int getx() {
	return x;
}

public int gety() {
	return y;
}

public double getnum(int x, int y) {
	return m[x][y];
}

public String toString() {
	String s;
	s = "";
	for(int i = 0; i<x; i++) {
		for(int j = 0; j<y; j++) {
			s = s + "" + m[i][j]+" ";
		}
		s+="\n";
	}
	return s;
}




}
