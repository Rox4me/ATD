package paket;

public class Enemy {

	static int health;
	
	public Enemy(int health){
		Enemy.health = health;
	}
	
	public static int getHealth(){
		return health;
	}
}
