package paket;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {
	
	Image startBackground1;
	Image startBackground2;
	Image startBackground3;
	
	StateBasedGame game;

	//Image startBackground;
	
	public void enter(GameContainer container, StateBasedGame game) throws SlickException{
		Start.mapID = 0;
		this.game = game;
		//load images
		startBackground1  = new Image("textures/startmeny1.png");
		startBackground2  = new Image("textures/startmeny12.png");
		startBackground3  = new Image("textures/startmeny123.png");
		
		
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.drawImage(startBackground2, 0,0);		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
