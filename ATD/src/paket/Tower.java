package paket;

import org.newdawn.slick.geom.Circle;

public class Tower {
	//Rate Of Fire
	private int ROF;
	//Last time it shot
	private long lastShot;
	//DaMaGe
	private int DMG;
	//coordinates
	public int x;
	public int y;
	
	//used by intersect to determine if the tower can hit a troop
	Circle range;
	
	public Tower(int x, int y, int DMG, int ROF){
		//create range "hitbox"
		this.x=x;
		this.y=y;
		this.DMG=DMG;
		this.ROF=ROF * 1000000;
		this.lastShot=System.nanoTime();
		range = new Circle(this.x, this.y, 100);
	}
	//Shooting troops in range
	public void shootTroop(Troop T, int i){
		if(ROF<System.nanoTime()-lastShot){
			lastShot=System.nanoTime();
			//reduce troop health
			T.setHealth(T.getHealth() - DMG);
			//debug message, what troop was shot
//			System.out.println("Shot troop: " + i + " Remaining health: " +Troops.troops[i].getHealth());
			//if troop runs out of health
			if(T.getHealth()<=0){
				//remove troop from the game
				Towers.killtroop(i);
			}
			
			lastShot=System.nanoTime();
			
		}else{
//			System.out.println("Not ready to fire yet");
			
		}
		
	}

}
