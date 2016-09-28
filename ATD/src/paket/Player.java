package paket;

public class Player{
	
	static int credit = 1000000;
		
	public static void purchaseTroops(int cost){
		credit = credit - cost;
	}
	
	public static void gainCredits(int gains){
		credit = credit + gains;
	}
	
	public static void setCredits(int credits){
		credit = credits;
	}
}
