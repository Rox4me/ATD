package paket;

public class Troops {
	private static int maxTroops=50;
	public static int  NTroops=0;
	//array of troops in the game
	public static Troop[] troops = new Troop[50] ;	
	
	public static void createTroop(){
		//only create troops if the player has not yet hit the troop limit
		if(NTroops>=maxTroops){}
		else{
			//create troop
			troops[NTroops]= new Troop(1000, 10,0);
			NTroops++;
		}
	}
		
}
