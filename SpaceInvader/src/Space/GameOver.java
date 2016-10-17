//JACK XU
package Space;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;

public class GameOver extends JFrame implements ActionListener{

	JLabel over= new JLabel();
	JButton retry= new JButton();
	
	
	//Game over GUI
	public GameOver(){
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
		
		over.setIcon(new ImageIcon("gameover.png"));
		background.add(over);
		SP.putConstraint(SpringLayout.WEST, over, 80, SpringLayout.WEST, background); 
		SP.putConstraint(SpringLayout.NORTH, over, 150, SpringLayout.NORTH, background);
		
		retry.setIcon(new ImageIcon("retry.png"));
		retry.setBackground(Color.RED);
		background.add(retry);
		SP.putConstraint(SpringLayout.WEST, retry, 115, SpringLayout.WEST, background);  
		SP.putConstraint(SpringLayout.NORTH, retry, 400, SpringLayout.NORTH, background);
		retry.addActionListener(this);
		
		setVisible(true);
	}


	public static void main(String[] args) {
		new GameOver();

	}

	//if player clicks retry button the menu GUI is executed
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == retry){
			new Menu();
			dispose();
			
		}
		
		
	}

}