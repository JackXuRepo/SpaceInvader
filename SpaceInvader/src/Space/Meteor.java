//JACK XU
package Space;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;

public class Meteor extends Entity {
	
	Image meteors; //image for the meteor
	int level; //current level

	//obtains location of meteor and level used to determine speed of meteor movement
	public Meteor(int x, int y, int lvl) {
		super(x, y);
	level= lvl;
		// TODO Auto-generated constructor stub
	}
	
	//updates the location of the meteor
	public void update(){
		
		y+= level-1; //meteor goes down by 1 pixel
		
	}
	
	//draws the meteor and also the rectangle box
	public void draw(Graphics2D g2){
		g2.drawImage(getImage(), x, y, 50, 50, null);
		g2.draw(Box());
	}
	
	

	//obtains image for the meteor
	public Image getImage(){
		Toolkit kit = Toolkit.getDefaultToolkit();

		meteors = kit.getImage("meteor.png");
		return meteors;
	}
	
	//creates a rectangle box for collision detection
	public Rectangle Box(){
		return new Rectangle(x,y, 50, 50);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
