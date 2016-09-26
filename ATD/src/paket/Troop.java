package paket;

import org.newdawn.slick.geom.Rectangle;

public class Troop {
	
	private int health;
	private int speed;
	//position is not specified in the constructor as it should be specified by the map
	int positionX = 130;
	int positionY = 100;
	//gamestate saves an array of images for troops, this is used to select the image for this troop
	int troopImage = 0;
	
	//used by intersect() to check if a tower can hit the troop
	Rectangle hitBox;

	//constructor
	public Troop(int health, int speed, int troopImage){
		this.health = health;
		this.speed = speed;
		this.troopImage = troopImage;
		//create hitbox
		hitBox = new Rectangle(this.positionX, this.positionY, 20, 20);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void move(Path path){
		
	}
	
	

}
