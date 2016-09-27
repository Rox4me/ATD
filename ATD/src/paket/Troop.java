package paket;

import org.newdawn.slick.geom.Rectangle;

public class Troop {
		
	private int health;
	private int speed;
	private int whichWay=1;
	//position is not specified in the constructor as it should be specified by the map
	int positionX = 0;
	int positionY = 0;
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
		hitBox = new Rectangle(positionX, positionY, 20, 20);
		System.out.println(hitBox);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void move(){
		if(whichWay==1){
			this.positionX = positionX+speed;
			//move troop hitbox
			hitBox.setLocation(positionX, positionY);
		}else if(whichWay==2){
			this.positionY = positionY-speed;
			//move troop hitbox
			hitBox.setLocation(positionX, positionY);
		}else if(whichWay==3){
			this.positionX = positionX-speed;
			//move troop hitbox
			hitBox.setLocation(positionX, positionY);
		}else if(whichWay==4){
			this.positionY = positionY+speed;
			//move troop hitbox
			hitBox.setLocation(positionX, positionY);
		}
	}

	public void tempMove(int x, int y){
		//move troop hitbox
		hitBox.setLocation(x, y);
		this.positionX = x;
		this.positionY = y;
	}
	
	//change where the troops will spawn
	//proboably wont work
	public void setSpawnPoint(int x, int y){
		this.positionX = x;
		this.positionY = y;
	}
	

}
