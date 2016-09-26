package paket;

public class Player{
	
	int credit;
	
	public Player(int credit){
		this.credit = credit;
	}
	
	public void purchaseTroops(int cost){
		this.credit = this.credit - cost;
	}
	
	public void gainCredits(int gains){
		this.credit = this.credit + gains;
	}
}
