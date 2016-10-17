//JACK XU
package Space;

import java.awt.Graphics2D; 
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


//extends entity class (template)
public class Bullet extends Entity {

	Image bulletimg; //image of bullet
	int vel = 0; //speed of bullet
	int num; //Player ID
	
	//obtain values for x, y, and what player the bullet belongs to
	public Bullet(int x, int y, int playernum) {
		super(x, y);
		// TODO Auto-generated constructor stub
		num= playernum;
	}
	
	//updates the location of the bullet
	public void update() {
		vel= 2;
		y+= -vel;
	
	
	}
	
	
	//draws the bullet
	public void draw(Graphics2D g2) {
		g2.drawImage(getImage(), x+5, y, 20, 20, null);
		g2.draw(Box());
		
	}

	//obtains image of the bullet depending on the player number
	public Image getImage() {
		Toolkit kit = Toolkit.getDefaultToolkit();

		if(num==1){
		bulletimg = kit.getImage("bullet.png");}
		if(num==2){
			bulletimg = kit.getImage("shot.png");}
		
		return bulletimg;

	}
	

	
	
	//creates a rectangle box so collisions can be check
	public Rectangle Box(){
		return new Rectangle(x+5,y, 20, 20);
	}
	

	//resets the location and values for bullet
	public void reset(){
		vel= 0;
		x= 0;
		y= 0;
	}

}
