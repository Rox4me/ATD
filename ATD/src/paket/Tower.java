package paket;

public class Tower {
	private int maxTurrets=50;
	private int Nturrets=0;
	private Tower1[] turrets= new Tower1[50] ;
	
	public void createTower(){
		if(Nturrets>=maxTurrets){}
		else{
			turrets[Nturrets]= new Tower1();
			Nturrets++;
		}
	}
	public void shoot(){
		for(int i=0;i>=Nturrets;i++){
			turrets[i].shootTroop();
		}
	}
}
