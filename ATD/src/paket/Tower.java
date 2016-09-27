package paket;

import org.newdawn.slick.geom.Circle;

public class Tower {
	//Rate Of Fire
	private int ROF=1;
	//DaMaGe
	private int DMG=1;
	//coordinates
	private int x;
	private int y;
	
	//used by intersect to determine if the tower can hit a troop
	Circle range;
	
	public Tower(int x, int y){
		//create range "hitbox"
		this.x=x;
		this.y=y;
		range = new Circle(this.x, this.y, 100);
	}
	//Shooting troops in range
	public void shootTroop(Troop T, int i){
		//reduce troop health
		T.setHealth(T.getHealth() - 1);
		//debug message, what troop was shot
		System.out.println("Shot troop: " + i);
		//if troop runs out of health
		if(T.getHealth()<=0){
			//remove troop from the game
			Towers.killtroop(i);
		}
		
		
	}

}
