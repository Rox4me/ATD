package paket;

public class Towers {
	private static int maxTurrets=50;
	public static int Nturrets=0;
	//array of all towers on the map
	public static Tower[] turrets= new Tower[50] ;
	
	public static void createTower(int x, int y, int DMG, int ROF, int imageID){
		//only create turrets if the max limit has not been reached
		if(Nturrets>=maxTurrets){}
		else{
			//create new turret
			turrets[Nturrets]= new Tower(x, y, DMG, ROF, imageID);
			Nturrets++;
		}
	}
	public static void createRandomTowerMap2(int DMG, int ROF, int imageID){
		//only create turrets if the max limit has not been reached
		if(Nturrets>=maxTurrets){}
		else{
			
			
			//Math.random() * (largenumber - smallnumber) + smallnumber;
			//create new turret
			int Random = (int) ((int) 30000*Math.random());
			if(Random==0||Random==18){
					turrets[Nturrets]= new Tower( (int) (Math.random() * 119-21) + 0, (int) (Math.random() * 340-21) + 0, DMG, ROF, imageID);

					Nturrets++;
			}
			else if(Random == 1||Random==17){
				turrets[Nturrets]= new Tower( (int) (Math.random() * 680) + 120, (int) (Math.random() * 60-21) + 0, DMG, ROF, imageID);

				Nturrets++;
			}
			else if(Random == 2||Random==16){
				turrets[Nturrets]= new Tower( (int) (Math.random() * 120+20) + 680, (int) (Math.random() * 282-41) + 60, DMG, ROF, imageID);

				Nturrets++;
			}
			else if(Random == 3||Random==15){
				turrets[Nturrets]= new Tower( (int) (Math.random() * 360-41) + 260, (int) (Math.random() * 60+21) + 120, DMG, ROF, imageID);

				Nturrets++;
			}
			else if(Random == 4||Random==14){
				turrets[Nturrets]= new Tower( (int) (Math.random() * 200+21) + 320, (int) (Math.random() * 216+21) + 284, DMG, ROF, imageID);

				Nturrets++;
			}
			else if(Random == 5||Random==13){
				turrets[Nturrets]= new Tower( (int) (Math.random() * 260-21) + 0, (int) (Math.random() * 200+21) + 400, DMG, ROF, imageID);

				Nturrets++;
			}
			else if(Random == 6||Random==10){
				turrets[Nturrets]= new Tower( (int) (Math.random() * 420) + 220, (int) (Math.random() * 20+21) + 602, DMG, ROF, imageID);

				Nturrets++;
			}
			else if(Random == 7||Random==12){
				turrets[Nturrets]= new Tower( (int) (Math.random() * 180+21) + 620, (int) (Math.random() * 200+21) + 402, DMG, ROF, imageID);

				Nturrets++;
			}
			else if(Random == 8||Random==11){
				turrets[Nturrets]= new Tower( (int) (Math.random() * 40+21) + 180, (int) (Math.random() * 282+21) + 120, DMG, ROF, imageID);

				Nturrets++;
			}
			else if(Random == 9){
				turrets[Nturrets]= new Tower( (int) (Math.random() * 120) + 560, (int) (Math.random() * 20-21) + 282+41, DMG, ROF, imageID);

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
