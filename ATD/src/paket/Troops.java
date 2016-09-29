package paket;

public class Troops {
	private static int maxTroops=50;
	public static int  NTroops=0;
	//array of troops in the game
	public static Troop[] troops = new Troop[51] ;	
	
	public static void createTroop(){
		//only create troops if the player has not yet hit the troop limit
		if(!(NTroops>=maxTroops) && (Player.credit - 50) >= 0){
			//create troop
			troops[NTroops]= new Troop(100, 10,0, 100);
			NTroops++;
			Player.purchaseTroops(50);
//			System.out.println("Player credits: " + Player.credit);
		}
	
	}
		
}
