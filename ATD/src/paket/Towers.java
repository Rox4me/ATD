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
	public static void createRandomTowerMap2(int DMG, int ROF){
		//only create turrets if the max limit has not been reached
		if(Nturrets>=maxTurrets){}
		else{
			//create new turret
			int Random = (int) ((int) 10*Math.random());
			if(Random==0){
					turrets[Nturrets]= new Tower( (int) (Math.floor(Math.random() * 119) + 0), (int) (Math.floor(Math.random() * 340) + 0), DMG, ROF);

					Nturrets++;
			}
			else if(Random == 1){
				turrets[Nturrets]= new Tower( (int) (Math.floor(Math.random() * 800) + 120), (int) (Math.floor(Math.random() * 60) + 0), DMG, ROF);

				Nturrets++;
			}
			else if(Random == 2){
				turrets[Nturrets]= new Tower( (int) (Math.floor(Math.random() * 120) + 680), (int) (Math.floor(Math.random() * 282) + 60), DMG, ROF);

				Nturrets++;
			}
			else if(Random == 3){
				turrets[Nturrets]= new Tower( (int) (Math.floor(Math.random() * 360) + 260), (int) (Math.floor(Math.random() * 100) + 120), DMG, ROF);

				Nturrets++;
			}
			else if(Random == 4){//
				turrets[Nturrets]= new Tower( (int) (Math.floor(Math.random() * 240) + 320), (int) (Math.floor(Math.random() * 256) + 284), DMG, ROF);

				Nturrets++;
			}
			else if(Random == 5){
				turrets[Nturrets]= new Tower( (int) (Math.floor(Math.random() * 409) + 0), (int) (Math.floor(Math.random() * 200) + 400), DMG, ROF);

				Nturrets++;
			}
			else if(Random == 6){
				turrets[Nturrets]= new Tower( (int) (Math.floor(Math.random() * 420) + 220), (int) (Math.floor(Math.random() * 60) + 602), DMG, ROF);

				Nturrets++;
			}
			else if(Random == 7){
				turrets[Nturrets]= new Tower( (int) (Math.floor(Math.random() * 180) + 620), (int) (Math.floor(Math.random() * 200) + 402), DMG, ROF);

				Nturrets++;
			}
			else if(Random == 8){
				turrets[Nturrets]= new Tower( (int) (Math.floor(Math.random() * 80) + 180), (int) (Math.floor(Math.random() * 282) + 120), DMG, ROF);

				Nturrets++;
			}
			else if(Random == 9){
				turrets[Nturrets]= new Tower( (int) (Math.floor(Math.random() * 120) + 560), (int) (Math.floor(Math.random() * 62) + 282), DMG, ROF);

				Nturrets++;
			}
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
