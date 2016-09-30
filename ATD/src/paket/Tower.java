package paket;

import org.newdawn.slick.geom.Circle;

public class Tower {
	//Rate Of Fire
	private int ROF;
	//Last time it shot
	public long lastShot;
	//DaMaGe
	private int DMG;
	//coordinates
	public int x;
	public int y;
	
	boolean hasShot = false;
	
	public double aimingAt;
	//used by intersect to determine if the tower can hit a troop
	Circle range;
	
	public Tower(int x, int y, int DMG, int ROF){
		//create range "hitbox"
		this.x=x;
		this.y=y;
		this.DMG=DMG;
		this.ROF=ROF;
		this.lastShot=Player.updateTime;
		range = new Circle(this.x, this.y, 100);
	}
	//Shooting troops in range
	public void shootTroop(Troop T, int i){
		if(ROF<Player.updateTime-lastShot){
			System.out.println(Player.updateTime-lastShot);
			//if true paint shot(laser)
			this.hasShot = true;
			lastShot=Player.updateTime;
			//reduce troop health
			T.setHealth(T.getHealth() - DMG);
			//debug message, what troop was shot
//			System.out.println("Shot troop: " + i + " Remaining health: " +Troops.troops[i].getHealth());
			//if troop runs out of health
			if(T.getHealth()<=0){
				//remove troop from the game
				Towers.killtroop(i);
			}
			
			lastShot=Player.updateTime;
			
		}
		
		//calculate angle to fire at
		float xDistance = T.positionX + (T.troopWidth/2) - this.x;
		float yDistance = T.positionY + (T.troopHeight/2) - this.y;
		this.aimingAt = Math.toDegrees(Math.atan2(yDistance, xDistance));
				

	}

}
