package paket;

import org.newdawn.slick.geom.Rectangle;

public class Troop {
		
	private int health;
	private int speed;
	private int whichWay=1;
	private int cost;
	private long lastMove;
	//position is not specified in the constructor as it should be specified by the map
	public int positionX = 0;
	public int positionY = 0;
	
	static int spawnX = 0;
	static int spawnY = 0;
	//gamestate saves an array of images for troops, this is used to select the image for this troop
	public int troopImage = 0;
	
	int troopWidth;
	int troopHeight;
	
	//used by intersect() to check if a tower can hit the troop
	public Rectangle hitBox;

	//constructor
	public Troop(int health, int speed, int troopImage, int cost, int troopWidth, int troopHeight){
		this.cost=cost;
		lastMove=Player.updateTime;
		this.health = health;
		this.speed = speed;
		this.troopImage = troopImage;
		this.troopWidth = troopWidth;
		this.troopHeight = troopHeight;
		//create hitbox
		hitBox = new Rectangle(positionX, positionY, this.troopWidth, this.troopHeight);
		this.positionX = spawnX;
		this.positionY = spawnY;
		hitBox.setLocation(spawnX, spawnY);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void move(){
//		System.out.println("MOVE");
		if(speed<Player.updateTime-lastMove){
			double a = (double)cost/800;
			Player.gainCredits(a);
//			System.out.println("Gained creds" + a);
//			System.out.printf("%f", a);
//			System.out.println();
//			System.out.println(Player.credit);
//			System.out.println("MOVED");
			if(whichWay==1){
//				System.out.println(positionX);
				this.positionX++;
//				System.out.println(positionX);
				//move troop hitbox
				hitBox.setLocation(positionX, positionY);
			}else if(whichWay==2){
				this.positionY--;
				//move troop hitbox
				hitBox.setLocation(positionX, positionY);
			}else if(whichWay==3){
				this.positionX--;
				//move troop hitbox
				hitBox.setLocation(positionX, positionY);
			}else if(whichWay==4){
				this.positionY++;
				//move troop hitbox
				hitBox.setLocation(positionX, positionY);
			}
			
			lastMove=Player.updateTime;
		}
	}

	
	//change where the troops will spawn
	public static void setSpawnPoint(int x, int y){
		spawnX = x;
		spawnY = y;
	}
	

}
