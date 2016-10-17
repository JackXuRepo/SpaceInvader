package Space;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Space.Main;

public class Game extends JPanel implements ActionListener, KeyListener {

	Timer time;
	Player player1;
	Player player2;
	Enemy alien;
	static boolean multiplayer;
	static int alienNum = 20;
	int alive = alienNum;
	static ArrayList<Enemy> aliens = new ArrayList<Enemy>();
	static ArrayList<Bullet> bullets = new ArrayList<Bullet>(5);
	static ArrayList<Bullet> shots = new ArrayList<Bullet>(5);
	static ArrayList<Meteor> meteors = new ArrayList<Meteor>();
	Image background;
	static int score;
	int level = 1;
	Random gen = new Random();
	/*
	Timer time; //timer that executes different classes at an interval
	Player player1; //object for player 1 in the player class, player class is used to store, update and draw variables related to player 1's ship
	Player player2; //object for player 2 in the player class, player class is used to store, update and draw variables related to player 2's ship
	static boolean multiplayer; //boolean that lets the program know whether to run code related to player 2
	static int alienNum = 20; //initial number of alien enemies
	static ArrayList<Enemy> aliens = new ArrayList<Enemy>(); //arraylist containing an alien in the game in each of its elements
	static ArrayList<Bullet> bullets = new ArrayList<Bullet>(); //arraylist with each element containing an instance of a bullet shot by player 1, arraylist is used so the number of bullets are not restricted
	static ArrayList<Bullet> shots = new ArrayList<Bullet>(); //arraylist with each element containing an instance of a bullet shot by player 2, arraylist is used so the number of bullets are not restricted
	static ArrayList<Meteor> meteors = new ArrayList<Meteor>();//arraylist with each element containing an instance of a meteor, arraylist is used because the number of meteors increase infinately as level progresses
	Image background; //the background image
	static int score; //keeps track of aliens killed in the game
	int level = 1; //initial level
	Random gen = new Random(); 
*/


	public Game(){
		setFocusable(true);

		

		if (multiplayer == false) {//runs if the single player option is chosen
			player1 = new Player(270, 600, 1);//sends initial location of player 1 (single player) to player class so it can be set and drawn
		}
		if (multiplayer == true) {//runs if multiplayer option is chosen
			player1 = new Player(300, 600, 1); //send initial location of player 1 (multiplayer) to player class so it can be set
			player2 = new Player(240, 600, 2); //initial location of player 2 (single player) to player class so it can be set and drawn
		}
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		background = kit.getImage("Space.gif"); //obtains picture for background
		int count = 0;

		for (int i = 0; i < 4; i++) { //rows
			for (int k = 0; k < alienNum / 4; k++) { //columns
				addEnemy(new Enemy(30 + k * 50, 30 + i * 50, level));//sends x and y separation distance to enemy class and creates the enemy arrayl
			}
		}

		aliens.trimToSize();

		time = new Timer(7, this); //timer used to update, redraw and check collisions every 7 milliseconds
		time.start(); //starts timer
		addKeyListener(this);//keylistener is created so key input can be done
	}

	public static void setMulti(boolean b) { //sets the boolean multiplayer either true or false depending on whether user selected single
		multiplayer = b;
	}

	public int getAlienNum() { //returns number of aliens
		return alienNum;
	}

	public void paint(Graphics g) {//draws the graphic related variables or sends commands to methods found in other classes so they could run them
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Graphics g3 = (Graphics) g;
		g2.drawImage(background, 0, 0, 600, 800, this);
		player1.draw(g2); //causes the player class to draw/update drawing of player 1 ship
		if (multiplayer == true) { //runs if multiplayer mode is selected
			player2.draw(g2); //causes the player class to draw/update drawing of player 2 ship
		}

		for (int i = 0; i < aliens.size(); i++) { //draws each instance of aliens found in the arraylist
			Enemy tempAlien = aliens.get(i);
			tempAlien.draw(g2);
		}

		for (int j = 0; j < bullets.size(); j++) { //draws each instance of bullets for player 1 found in the arraylist
			Bullet tempBullet = bullets.get(j);
			tempBullet.draw(g2);

			g.setFont(g.getFont().deriveFont(30f));
			g.drawString("KILLS:" + score, 30, 700);
		}

		if (multiplayer == true) {
			for (int j = 0; j < shots.size(); j++) { //draws each instance of bullets for player 2 found in the arraylist
				Bullet tempBullet = shots.get(j);
				tempBullet.draw(g2);
			}

			
		}
		if (level > 1) {
			for (int j = 0; j < meteors.size(); j++) { //meteors show up after level 1, causes draw method in meteor class to draw each instance of meteor
				Meteor rock = meteors.get(j);
				rock.draw(g2);
			}
		}

		repaint();

	}

	
	
	public static int getScore(){
		return score;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//creates a new instance of an alien in the enemy arraylist
		public void addEnemy(Enemy e) {
			aliens.add(e);
		}
		//removes the current instance of alien in the enemy arraylist
		public static void removeEnemy(Enemy e) {
			aliens.remove(e);
		}

		//creates a new instance of an bullet player 1 in the bullet arraylist
		public static void addBullet(Bullet b) {
			bullets.add(b);
		}

		//removes the current instance of an bullet player 1 in the bullet arraylist
		public static void removeBullet(Bullet b) {
			bullets.remove(b);
		}
		
		//creates a new instance of an bullet player 2 in the shot arraylist
		public static void addShot(Bullet s) {
			bullets.add(s);
		}

		//creates a new instance of a meteor obstacle in meteor arraylist
		public static void addMeteor(Meteor m) {
			meteors.add(m);
		}
		//removes current instance of an bullet player 2 in the shot arraylist
		public static void removeShot(Bullet s) {
			bullets.remove(s);
		}


	

	public void collisionDetect() { //detects collision and runs commands
		
		//NOTE: each object that has an image also has a parallel rectangle with the same coordinates as the object itself so that collision detection can take place
		for (int i = 0; i < aliens.size(); i++) { 
			if (player1.Box().intersects(aliens.get(i).Box())) {//check whether player collides with each enemy
				time.stop();//if collision happens, stop timer, this stops the program as no action event is performed
				new GameOver(); //opens new game over window
				i = aliens.size(); //makes the for loop requirement true code doesnt repeat
				player1.resetPlayer(); //resets location and stats for player
				JOptionPane.showMessageDialog(null, "Your Score: " + score
					); //shows score
				
				
				
				score=0;
				for (int i1 = 0; i1 < aliens.size(); i1++) {
					aliens.clear(); //removes all instances of aliens in the arraylist
					aliens.get(i1).reset(); //resets stats for alien at current element in arraylist back to default
				}
				Main.close(); //closes the frame

			}
		}

		if (level > 1) { //runs if player completes level 1
			for (int i = 0; i < meteors.size(); i++) {
				if (player1.Box().intersects(meteors.get(i).Box())) { //checks whether player collides with an insteace of the meteor arraylist
					time.stop(); 
					new GameOver();
				
						meteors.clear();//removes all instances of meteors in the meteor arraylist
						
						JOptionPane.showMessageDialog(null, "Your Score: " + score
								);
					
						score=0; //reset score to 0
						for (int i1 = 0; i1 < aliens.size(); i1++) {
							
							aliens.clear(); //remove all instances of aliens in arraylist
							aliens.get(i1).reset(); //reset object variables to default
						}
					Main.close();

				}
			}
		}
		//check if meteor collides with player 2
		if (level > 1 && multiplayer == true) {
			for (int i = 0; i < meteors.size(); i++) {
				if (player2.Box().intersects(meteors.get(i).Box())) {
					time.stop();
					new GameOver();
					
						meteors.clear();
						
						JOptionPane.showMessageDialog(null, "Your Score: " + score
								);
						
						score=0;
						for (int i1 = 0; i1 < aliens.size(); i1++) {
							aliens.clear();
							aliens.get(i1).reset();
						}
					
					Main.close();

				}
			}
		}
		
		//check if bullet collides with alien
		for (int i = 0; i < bullets.size() && bullets.size() > 0; i++) {
			for (int k = 0; k < aliens.size() && bullets.size() > 0; k++) { //checks if each instance of bullet object intersects with aliens
				if (bullets.get(i).Box()
						.intersects(aliens.get(k).Box())) {
					aliens.remove(k); //remove objects
					bullets.remove(i);
					i=0; //set temporal variables to 0 so the loop restarts using the update elements and index this prevents index out of bounds
					k=0;
					score++; //score increases
				}
			}
		}
		//check if bullet for player 2 collides with alien
		if (multiplayer == true) {
			for (int i = 0; i < shots.size() && shots.size() > 0; i++) {
				for (int k = 0; k < aliens.size() && shots.size() > 0; k++) {
					if (shots.get(i).Box()
							.intersects(aliens.get(k).Box())) {
						aliens.remove(k);
						shots.remove(i);
						i=0;
						k=0;
						score++;
					}
				}
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		player1.update();           //.update updates location of objects
		if (multiplayer == true) {
			player2.update();
		}
		collisionDetect(); //check collision

		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			collisionDetect();
		}

		if (level > 1) {
			for (int i = 0; i < meteors.size(); i++) {
				Meteor rock = meteors.get(i);
				rock.update();
				collisionDetect();
			}
		}

		for (int j = 0; j < bullets.size(); j++) {
			bullets.get(j).update();
			collisionDetect();
		}

		if (multiplayer == true) {
			for (int j = 0; j < shots.size(); j++) {
				shots.get(j).update();
				collisionDetect();
			}
		}

		collisionDetect();

		repaint();

		if (aliens.size() == 0) {
			level++;
			bullets.clear();
			if (multiplayer == true) {
				shots.clear();
			}
			if (level>1){meteors.clear();}
			JOptionPane.showMessageDialog(null, "LEVEL " + (level - 1)
					+ " COMPLETE");
			for (int i = 0; i < 4; i++) {
				for (int k = 0; k < alienNum / 4; k++) {
					addEnemy(new Enemy(30 + k * 50, 30 + i * 50, level));
				}
			}
			
				for (int k = 0; k < level * 3; k++) {
					addMeteor(new Meteor(gen.nextInt(600), -gen.nextInt(1500),
							level));
				}
			

		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		player1.keyPressed(event);
		if (multiplayer == true) {
			player2.keyPressed(event);
		}

	}

	@Override
	public void keyReleased(KeyEvent event) {
		player1.keyReleased(event);
		if (multiplayer == true) {
			player2.keyReleased(event);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
