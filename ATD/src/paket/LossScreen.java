package paket;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class LossScreen extends BasicGameState {

	Image lossScreen;
	StateBasedGame game;

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		lossScreen = new Image("textures/gameover.png");
		this.game = game;

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.drawImage(lossScreen, 0, 0);		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		//exit game
		if(container.getInput().isKeyDown(Input.KEY_ESCAPE)){
			container.exit();
		}

	}

	@Override
	public int getID() {
		return 2;
	}

}
