package paket;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Test extends BasicGameState {

	StateBasedGame game;

	Image[] troopImages = new Image[4];
	Image background;
	Image towerBase;
	Image towerTurret;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		this.game = game;
		//create tower and troop
		troopImages[0] = new Image("textures/bandvagn.png");
		background  = new Image("textures/map.png");
		towerBase = new Image("textures/enemybottom.png");
		towerTurret = new Image("textures/enemytop.png");
		
		
		Troops.createTroop();

		Troops.createTroop();
		Troops.troops[1].tempMove(150, 150);
		Troops.createTroop();
		Troops.troops[2].tempMove(100, 100);
		Troops.createTroop();
		Troops.troops[3].tempMove(120, 120);
		
		Towers.createTower(150, 150, 1, 1);
		Towers.createTower(200, 200, 1, 1);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		//draw background
		g.drawImage(background, 0,0);
		//draw troops
		for(int i=0;i<Troops.NTroops;i++){
			g.drawImage(troopImages[Troops.troops[i].troopImage], Troops.troops[i].positionX, Troops.troops[i].positionY);
			g.draw(Troops.troops[i].hitBox);
		}
		for(int i=0;i<Towers.Nturrets;i++){
			g.drawImage(towerBase, Towers.turrets[i].x-20, Towers.turrets[i].y-20);
			g.drawImage(towerTurret, Towers.turrets[i].x-15, Towers.turrets[i].y-15);
			g.draw(Towers.turrets[i].range);
		}
		
		//draw tower range
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		System.out.println(Enemy.health);
		if(container.getInput().isKeyDown(Input.KEY_ESCAPE)){
			container.exit();
		}
		for(int i=0; i<Troops.NTroops;i++){
			Troops.troops[i].move();
			if(Troops.troops[i].positionX > 800){
				Enemy.health--;
				Towers.killtroop(i);
				if(Enemy.health <=0){
					this.game.enterState(1);
				}
			}else if(Troops.troops[i].positionX < 0){
				Enemy.health--;
				Towers.killtroop(i);
			}else if(Troops.troops[i].positionY > 800){
				Enemy.health--;
				Towers.killtroop(i);
			}else if(Troops.troops[i].positionY < 0){
				Enemy.health--;
				Towers.killtroop(i);
			}
		}
		//	this.game.enterState(1);
		//if troop 0 is within range of tower1 0
		for(int i=0;i<Towers.Nturrets;i++){
			for(int ii=0; ii<Troops.NTroops;ii++){
				//debug message, what tower and troop is being checked
				//if troop is within range of a tower.
				if(Troops.troops[ii].hitBox.intersects(Towers.turrets[i].range) ){
					//debug message, tower shooting troop
//					System.out.print("Hitbox check 1: " + i+": Hitbox check 2: "+ii + "  | ");
					Towers.turrets[i].shootTroop(Troops.troops[ii], ii);
					//check no more troops, jump to next tower
					ii = Troops.NTroops;

				}else{
					//debug message, tower not shooting troop
//					System.out.println("Hitbox check 1: " + i+": Hitbox check 2: "+ii + "  | false");
				}
			}
			
		}
		

	}

	@Override
	public int getID() {
		return 0;
	}

}
