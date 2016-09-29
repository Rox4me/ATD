package paket;

public class Player{
	
	static double credit;
	public static long updateTime=0;
		
	public static void purchaseTroops(int cost){
		credit = credit - cost;
	}
	
	public static void gainCredits(double gains){
		credit = credit + gains;
	}
	
	public static void setCredits(int credits){
		credit = credits;
	}
}
