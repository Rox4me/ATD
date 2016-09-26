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
		//draw troop if its health is above 0
		if(Troops.troops[0].getHealth() > 0){
			g.drawImage(troopImages[Troops.troops[0].troopImage], Troops.troops[0].positionX, Troops.troops[0].positionY);
		}
		//draw tower range
		g.draw(Tower.turrets[0].range);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	//	this.game.enterState(1);
		//if troop 0 is within range of tower1 0
		if(Troops.troops[0].hitBox.intersects(Tower.turrets[0].range) && Troops.troops[0].getHealth() > 0){
			System.out.println("pew pew");
			//tower1 0 shoots troop 0
			Tower.turrets[0].shootTroop(Troops.troops[0]);
		}

	}

	@Override
	public int getID() {
		return 0;
	}

}
