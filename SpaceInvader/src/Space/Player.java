//JACK XU
package Space;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;




public class Player extends Entity {

	Image shipimg;
	int vel1 = 0;
	int num;

		//obtains location of player depending on player id;
	public Player(int x, int y, int playernum) {
		super(x, y);
		// TODO Auto-generated constructor stub
		num= playernum;
	}

	//updates the location of the player depending
	public void update() {
		x+= vel1;
		if (x<-10){ //prevents user to move out on left
			vel1=0;
		}
		if (x>550){ //prevevents user to move out on the right
			vel1=0;
		}
		
	
	}
	
	

	public void draw(Graphics2D g2) {
		g2.drawImage(getImage(), x, y, 50, 70, null);
		g2.draw(Box());
		
		
		
	}

	public Image getImage() {
		Toolkit kit = Toolkit.getDefaultToolkit();

		if(num==1){
		shipimg = kit.getImage("ship.png");
		}
		
		if(num==2){
			shipimg = kit.getImage("ship2.png");
			}
		return shipimg;
	}
	

	
	
	
	public Rectangle Box(){
		return new Rectangle(x,y, 50, 70);
	}
	



	public void keyPressed (KeyEvent event){
		
		if (event.getKeyCode() == KeyEvent.VK_RIGHT && num==1){
			if(x<530){ 
			vel1= 5;}
		}
		else if (event.getKeyCode() == KeyEvent.VK_LEFT && num==1){
			if(x>0){
			vel1= -5;}}
		
		if (event.getKeyCode() == KeyEvent.VK_D && num==2){
			if(x<530){
			vel1= 5;}
		}
		else if (event.getKeyCode() == KeyEvent.VK_A && num==2){
			if(x>0){
			vel1= -5;}}
		
		
		
	}
	
	

	public void keyReleased(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_RIGHT && num==1) {
			vel1= 0;
		}
		else if (event.getKeyCode() == KeyEvent.VK_LEFT && num==1) {
			vel1=0;
		}
		else if (event.getKeyCode() == KeyEvent.VK_ENTER && num==1){
			Game.addBullet(new Bullet(x, y, num)); //creates an instance of bullet object for player 1
			}
		if (event.getKeyCode() == KeyEvent.VK_D && num==2) {
			vel1= 0;
		}
		else if (event.getKeyCode() == KeyEvent.VK_A && num==2) {
			vel1=0;
		}
		else if (event.getKeyCode() == KeyEvent.VK_SPACE && num==2){
			Game.addBullet(new Bullet(x, y, num)); //creates an instance of bullet object for player 2
			}
		
	}
	
	public void resetPlayer(){
		
		vel1= 0;
		x=-1000;
		y=-1000;
	}

}
