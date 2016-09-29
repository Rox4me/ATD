package paket;

public class Troops {
	private static int maxTroops=50;
	public static int  NTroops=0;
	//array of troops in the game
	public static Troop[] troops = new Troop[51] ;	
	
	public static void createTroop(int health, int speed, int trooptype, int cost, int troopWidth, int troopHeight){
		//only create troops if the player has not yet hit the troop limit
		if(!(NTroops>=maxTroops) && (Player.credit - cost) >= 0){
			//create troop
			troops[NTroops]= new Troop(health, speed, trooptype, cost, troopWidth, troopHeight);
			NTroops++;
			Player.purchaseTroops(cost);
//			System.out.println("Player credits: " + Player.credit);
		}
	
	}
		
}
