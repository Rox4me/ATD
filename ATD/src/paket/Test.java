package paket;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Test extends BasicGameState {

	StateBasedGame game;

	Image[] troopImages = new Image[4];
	Image background;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		this.game = game;
		//create tower and troop
		troopImages[0] = new Image("textures/Troop1.png");
		Troops.createTroop();
		Tower.createTower();
		//load temp background
		background  = new Image("textures/map.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		//draw background
		g.drawImage(background, 0,0);
		//draw troops
		for(int i=0;i<Troops.NTroops;i++){
			g.drawImage(troopImages[Troops.troops[i].troopImage], Troops.troops[i].positionX, Troops.troops[i].positionY);
		}
		for(int i=0;i<Tower.Nturrets;i++){
			g.draw(Tower.turrets[i].range);
		}
		//draw tower range
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	//	this.game.enterState(1);
		//if troop 0 is within range of tower1 0
		for(int i=0;i<Tower.Nturrets;i++){
			System.out.println("hej");
			for(int ii=0; ii<Troops.NTroops;ii++){
				System.out.println(i+":"+ii);
				if(Troops.troops[ii].hitBox.intersects(Tower.turrets[i].range) && Troops.troops[ii].getHealth() > 0){
					System.out.println("pew pew");
					//tower1 0 shoots troop 0
					Tower.turrets[i].shootTroop(Troops.troops[ii], ii);
				}
			}
			
		}
		

	}

	@Override
	public int getID() {
		return 0;
	}

}
