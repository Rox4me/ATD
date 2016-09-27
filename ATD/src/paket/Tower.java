package paket;

public class Tower {
	private static int maxTurrets=50;
	public static int Nturrets=0;
	//array of all towers on the map
	public static Tower1[] turrets= new Tower1[50] ;
	
	public static void createTower(int x, int y){
		//only create turrets if the max limit has not been reached
		if(Nturrets>=maxTurrets){}
		else{
			//create new turret
			turrets[Nturrets]= new Tower1(x, y);
			Nturrets++;
		}
	}
	//remove troop from the game
	public static void killtroop(int i){
		for(;i<Troops.NTroops;i++){
			//move troops in array to fill the empty slot left by the dying troop
			Troops.troops[i]=Troops.troops[i+1];
		}
		//reduce ammount of troops on the map
		Troops.NTroops--;
	}

}
