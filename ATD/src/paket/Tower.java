package paket;

public class Tower {
	private static int maxTurrets=50;
	public static int Nturrets=0;
	//array of all towers on the map
	public static Tower1[] turrets= new Tower1[50] ;
	
	public static void createTower(){
		//only create turrets if the max limit has not been reached
		if(Nturrets>=maxTurrets){}
		else{
			//create new turret
			turrets[Nturrets]= new Tower1();
			Nturrets++;
		}
	}
/*
	public void shoot(){
		for(int i=0;i>=Nturrets;i++){
			turrets[i].shootTroop();
		}
	}
	*/
}
