//JACK XU
package Space;
import java.awt.*; 
import java.awt.event.*;
import java.awt.image.*;
import java.io.FileNotFoundException;
import java.applet.Applet;
import java.applet.AudioClip;

import javax.print.DocFlavor.URL;
import javax.swing.*;

public class Menu extends JFrame implements ItemListener, ActionListener{
	JButton single= new JButton();
	JButton multi= new JButton();
	JButton controls= new JButton();
	JButton sound= new JButton();
	JButton settings= new JButton();
	JLabel logo= new JLabel();
	JButton instructions= new JButton();

	
	//sets up GUI for menu
	public Menu(){
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
		
		logo.setIcon(new ImageIcon("logo.png"));
		background.add(logo);
		SP.putConstraint(SpringLayout.WEST, logo, 60, SpringLayout.WEST, background); 
		SP.putConstraint(SpringLayout.NORTH, logo, -40, SpringLayout.NORTH, background);
		
		single.setIcon(new ImageIcon("single.png"));
		background.add(single);
		SP.putConstraint(SpringLayout.WEST, single, 115, SpringLayout.WEST, background); 
		SP.putConstraint(SpringLayout.NORTH, single, 220, SpringLayout.NORTH, background);
		single.addActionListener(this);
		
		multi.setIcon(new ImageIcon("multi.png"));
		background.add(multi);
		SP.putConstraint(SpringLayout.WEST, multi, 115, SpringLayout.WEST, background); 
		SP.putConstraint(SpringLayout.NORTH, multi, 20, SpringLayout.SOUTH, single);
		multi.addActionListener(this);
		
		sound.setIcon(new ImageIcon("music.png"));
		sound.setOpaque(false);
		sound.setContentAreaFilled(false);
		sound.setBorderPainted(false);
		background.add(sound);
		SP.putConstraint(SpringLayout.WEST, sound, 190, SpringLayout.EAST, instructions);  
		SP.putConstraint(SpringLayout.NORTH, sound, 650, SpringLayout.NORTH, background);
		
		controls.setIcon(new ImageIcon("controller.png"));
		controls.setOpaque(false);
		controls.setContentAreaFilled(false);
		controls.setBorderPainted(false);
		background.add(controls);
		SP.putConstraint(SpringLayout.WEST, controls, 115, SpringLayout.WEST, background);  
		SP.putConstraint(SpringLayout.NORTH, controls, 430, SpringLayout.NORTH, background);
		controls.addActionListener(this);
		
		
		setVisible(true);
	}


	public static void main(String[] args) {
		new Menu();

	}


	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == controls){ //if player clicks control button display control window
			new Control();
			dispose();
			
		}
		
		if(event.getSource() == multi){ //* launch multiplayer mode
			Game.setMulti(true); //sets multiplayer to true
			try {
				new Main();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();
			
		}
		
		if(event.getSource() == single){  //* launch single player mode
			Game.setMulti(false); //sets mutiplayer to false
			try {
				new Main();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();
			
		}
		
		
		
		if(event.getSource() == controls){
			new Control();
			dispose();
			
		}
		
	}


	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
