package paket;

import org.newdawn.slick.geom.Circle;

public class Tower1 {
	//Rate Of Fire
	private int ROF=1;
	//DaMaGe
	private int DMG=1;
	//coordinates
	private int x=50;
	private int y=50;
	
	//used by intersect to determine if the tower can hit a troop
	Circle range;
	
	public Tower1(){
		//create range "hitbox"
		range = new Circle(this.x, this.y, 100);
	}
	//Shooting troops in range
	public void shootTroop(Troop T, int i){
		//reduce troop health
		T.setHealth(T.getHealth() - 1);
		if(T.getHealth()<=0){
			Tower.killtroop(i);
		}
		
		
	}

}
