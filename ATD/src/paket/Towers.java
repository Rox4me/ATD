package paket;

public class Towers {
	private static int maxTurrets=50;
	public static int Nturrets=0;
	//array of all towers on the map
	public static Tower[] turrets= new Tower[50] ;
	
	public static void createTower(int x, int y, int DMG, int ROF){
		//only create turrets if the max limit has not been reached
		if(Nturrets>=maxTurrets){}
		else{
			//create new turret
			turrets[Nturrets]= new Tower(x, y, DMG, ROF);
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
