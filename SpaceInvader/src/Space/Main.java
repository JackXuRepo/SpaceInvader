//JACK XU
package Space;

import java.awt.Color;
import java.awt.Window;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	static JFrame frame;
	
	//sets up frame the gameplay takes place in
	public Main() throws FileNotFoundException{
		frame= new JFrame("SPACE INVADERS");
		frame.setSize(600, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.add(new Game());

	}

	//closes the frame
	public static void close(){

		frame.dispose();
	}
	
	

public static void main(String[] args) throws FileNotFoundException{
	new Main();
	
	


	

}
}