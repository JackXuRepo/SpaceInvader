package Space;
import java.awt.*; 
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;

public class Control extends JFrame implements ActionListener, ItemListener{

	JLabel P1move= new JLabel();
	JLabel P2move= new JLabel();
	JLabel P1shoot= new JLabel();
	JLabel P2shoot= new JLabel();
	JLabel P1= new JLabel();
	JLabel P2= new JLabel();
	JLabel m1= new JLabel();
	JLabel m2= new JLabel();
	JLabel s1= new JLabel();
	JLabel s2= new JLabel();
	JLabel mainlogo= new JLabel();
	JButton back= new JButton();
	
	
	public Control(){
		super("SPACE INVADERS");
		setSize(600, 800);
		SpringLayout SP = new SpringLayout();
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//set background image for GUI
		GetImage background = new GetImage();
		background.setLayout(SP);
		background.setBounds(0, 0, 600, 800);
		add(background);
		
		P1.setIcon(new ImageIcon("P1.png"));
		background.add(P1);
		SP.putConstraint(SpringLayout.WEST, P1, 150, SpringLayout.WEST, background); 
		SP.putConstraint(SpringLayout.NORTH, P1, 160, SpringLayout.NORTH, background);
		
		P2.setIcon(new ImageIcon("P2.png"));
		background.add(P2);
		SP.putConstraint(SpringLayout.WEST, P2, 150, SpringLayout.WEST, background);  
		SP.putConstraint(SpringLayout.NORTH, P2, 490, SpringLayout.NORTH, background);
		
		back.setIcon(new ImageIcon("back.png"));
		background.add(back);
		SP.putConstraint(SpringLayout.WEST, back, 10, SpringLayout.WEST, background);  
		SP.putConstraint(SpringLayout.NORTH, back, 10, SpringLayout.NORTH, background);
		back.addActionListener(this);
		
		P1move.setIcon(new ImageIcon("P1Controls.png"));
		background.add(P1move);
		SP.putConstraint(SpringLayout.WEST, P1move, 20, SpringLayout.WEST, background); 
		SP.putConstraint(SpringLayout.NORTH, P1move, 30, SpringLayout.SOUTH, P1);
		
		P2move.setIcon(new ImageIcon("P2Controls.png"));
		background.add(P2move);
		SP.putConstraint(SpringLayout.WEST, P2move, -100, SpringLayout.WEST, background);  
		SP.putConstraint(SpringLayout.NORTH, P2move, 10, SpringLayout.SOUTH, P2);
		
		P1shoot.setIcon(new ImageIcon("P1shoot.png"));
		background.add(P1shoot);
		SP.putConstraint(SpringLayout.WEST, P1shoot, 380, SpringLayout.WEST, background); 
		SP.putConstraint(SpringLayout.NORTH, P1shoot, 20, SpringLayout.SOUTH, P1);
		
		P2shoot.setIcon(new ImageIcon("P2shoot.png"));
		background.add(P2shoot);
		SP.putConstraint(SpringLayout.WEST, P2shoot, 360, SpringLayout.WEST, background);  
		SP.putConstraint(SpringLayout.NORTH, P2shoot, 80, SpringLayout.SOUTH, P2);
		
		m1.setIcon(new ImageIcon("move.png"));
		background.add(m1);
		SP.putConstraint(SpringLayout.WEST, m1, 80, SpringLayout.WEST, background); 
		SP.putConstraint(SpringLayout.NORTH, m1, 10, SpringLayout.SOUTH, P1move);
		
		m2.setIcon(new ImageIcon("move.png"));
		background.add(m2);
		SP.putConstraint(SpringLayout.WEST, m2, 80, SpringLayout.WEST, background); 
		SP.putConstraint(SpringLayout.NORTH, m2, -80, SpringLayout.SOUTH, P2move);
		
		s1.setIcon(new ImageIcon("shoot.png"));
		background.add(s1);
		SP.putConstraint(SpringLayout.WEST, s1, 400, SpringLayout.WEST, background); 
		SP.putConstraint(SpringLayout.NORTH, s1, 10, SpringLayout.SOUTH, P1move);
		
		s2.setIcon(new ImageIcon("shoot.png"));
		background.add(s2);
		SP.putConstraint(SpringLayout.WEST, s2, 400, SpringLayout.WEST, background); 
		SP.putConstraint(SpringLayout.NORTH, s2, -80, SpringLayout.SOUTH, P2move);
		
		mainlogo.setIcon(new ImageIcon("Controls.png"));
		background.add(mainlogo);
		SP.putConstraint(SpringLayout.WEST, mainlogo, 180, SpringLayout.WEST, background); 
		SP.putConstraint(SpringLayout.NORTH, mainlogo, 5, SpringLayout.NORTH, background);
		
		
		setVisible(true);
	}


	public static void main(String[] args) {
		new Control();

	}


	@Override
	public void itemStateChanged(ItemEvent event) {
		
		
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == back){
			new Menu();
			dispose();
			
		}
		
	}

}