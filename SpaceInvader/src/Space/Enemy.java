//JACK XU
package Space;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;

public class Enemy extends Entity { //alien entity class
	
	Image aliens;
	int right=0; //x values moved right by aliens
	int left= 0; //x values moved left by aliens
	int speed; //speed of alien movement
	int level; //current level

	//obtains location of alien and the current level so its speed can be determined
	public Enemy(int x, int y, int lvl) {
		super(x, y);
	level= lvl;
		// TODO Auto-generated constructor stub
	}
	
	//updates the location of the alien, the speed.
	public void update(){
		
		speed= level+1; //determines speed of movement of alien due to current level
		
		//Alien movement algorithm
		if(right<300/speed){  //if alien can still move right move the alien to right
		x+=speed;
		right++;}
		
		else if(left < 300/speed ){ //if alien can still move left move alien to left
			x+=-speed;
			left++;
			}
		else{
			y+=50;  //if alien cannot move left or right move the alien down by 50 pixels down
			right=0;
			left=0;
			speed+= 1;
		}
		
	}
	
	//draws objecct
	public void draw(Graphics2D g2){
		g2.drawImage(getImage(), x, y, 50, 50, null);
		g2.draw(Box());
	}
	
	//reset variables to default
	public void reset(){
		right= 0;
		left=0;
	}

	//obtains image
	public Image getImage(){
		Toolkit kit = Toolkit.getDefaultToolkit();

		aliens = kit.getImage("alien.png");
		return aliens;
	}
	//rectangle for collision check
	public Rectangle Box(){
		return new Rectangle(x,y, 50, 50);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
