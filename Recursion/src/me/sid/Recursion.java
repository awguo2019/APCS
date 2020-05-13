package me.sid;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Recursion {
	
	public Recursion() {
		
		JFrame GUI = new JFrame();
		GUI.setTitle("Recursion");
		GUI.setSize(700, 760);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		JButton RecEx = new JButton("Exponentiation");
		RecEx.setFont(new Font("Serif", Font.BOLD, 22));
		JButton ItEx = new JButton("Exponentiation");
		ItEx.setFont(new Font("Serif", Font.BOLD, 22));
		JButton RecSum = new JButton("Summation");
		RecSum.setFont(new Font("Serif", Font.BOLD, 22));
		JButton ItSum = new JButton("Summation");
		ItSum.setFont(new Font("Serif", Font.BOLD, 22));
		JButton RecFac = new JButton("Factorial");
		RecFac.setFont(new Font("Serif", Font.BOLD, 22));
		JButton ItFac = new JButton("Factorial");
		ItFac.setFont(new Font("Serif", Font.BOLD, 22));
		JButton RecFib = new JButton("Fibonacci");
		RecFib.setFont(new Font("Serif", Font.BOLD, 22));
		JButton ItFib = new JButton("Fibonacci");
		ItFib.setFont(new Font("Serif", Font.BOLD, 22));
		JButton EvenOdd = new JButton("Even/Odd");
		EvenOdd.setFont(new Font("Serif", Font.BOLD, 22));
		JButton clear = new JButton("Clear");
		clear.setFont(new Font("Serif", Font.BOLD, 22));
		
		JTextField text = new JTextField("");
		text.setFont(new Font("Serif", Font.BOLD, 22));
		
		JTextField answer = new JTextField("");
		answer.setFont(new Font("Serif", Font.BOLD, 22));
		answer.setEditable(false);
		JLabel recursive = new JLabel("Recursive Functions");
		recursive.setFont(new Font("Serif", Font.BOLD, 22));
		JLabel inter = new JLabel("Iterative Functions");
		inter.setFont(new Font("Serif", Font.BOLD, 22));
		
		
		
		RecEx.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e1) {
				String s = text.getText();
				String[] in = s.split(",");
				int b = Integer.parseInt(in[0]);
				int e = Integer.parseInt(in[1]);
				String a = Exponentiation.RecExponentiation(b, e) + "";
				answer.setText(a);
			}
		});
		
		ItEx.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e1) {
				String s = text.getText();
				String[] in = s.split(",");
				int b = Integer.parseInt(in[0]);
				int e = Integer.parseInt(in[1]);
				String a = Exponentiation.IterExponentiation(b, e) + "";
				answer.setText(a);
			}
		});
		RecSum.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e1) {
				String s = text.getText();
				int n = Integer.parseInt(s);
				String a = Summation.RecSummation(n) + "";
				answer.setText(a);
			}
		});
		ItSum.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e1) {
				String s = text.getText();
				int n = Integer.parseInt(s);
				String a = Summation.IterSummation(n) + "";
				answer.setText(a);
			}
		});
		RecFac.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e1) {
				String s = text.getText();
				int n = Integer.parseInt(s);
				String a = Factorial.RecFactorial(n) + "";
				answer.setText(a);
			}
		});
		ItFac.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e1) {
				String s = text.getText();
				int n = Integer.parseInt(s);
				String a = Factorial.IterFactorial(n) + "";
				answer.setText(a);
			}
		});
		RecFib.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e1) {
				String s = text.getText();
				int n = Integer.parseInt(s);
				String a = Fibonacci.RecFibonacci(n) +"";
				answer.setText(a);
			}
		});
		ItFib.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e1) {
				String s = text.getText();
				int n = Integer.parseInt(s);
				String a = Fibonacci.IterFibonacci(n) +"";
				answer.setText(a);
			}
		});
		clear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e1) {
				text.setText("");
				answer.setText("");
			}
		});
		p.setLayout(null);
		
		recursive.setSize(200, 100);
		recursive.setLocation(0,0);
		p.add(recursive);
		RecEx.setSize(200, 100);
		RecEx.setLocation(0, 100);
		p.add(RecEx);
		RecFac.setSize(200, 100);
		RecFac.setLocation(0, 200);
		p.add(RecFac);
		RecSum.setSize(200, 100);
		RecSum.setLocation(0, 300);
		p.add(RecSum);
		RecFib.setSize(200, 100);
		RecFib.setLocation(0, 400);
		p.add(RecFib);
		clear.setSize(700, 200);
		clear.setLocation(0, 500);
		p.add(clear);
		
		text.setSize(300, 250);
		text.setLocation(200,0);
		p.add(text);
		answer.setSize(300, 250);
		answer.setLocation(200,250);
		p.add(answer);
		
		inter.setSize(200, 100);
		inter.setLocation(500,0);
		p.add(inter);
		ItEx.setSize(200, 100);
		ItEx.setLocation(500, 100);
		p.add(ItEx);
		ItFac.setSize(200, 100);
		ItFac.setLocation(500, 200);
		p.add(ItFac);
		ItSum.setSize(200, 100);
		ItSum.setLocation(500, 300);
		p.add(ItSum);
		ItFib.setSize(200, 100);
		ItFib.setLocation(500, 400);
		p.add(ItFib);
		
		GUI.add(p);
		GUI.revalidate();
		GUI.setVisible(true);
		
	}

}
