package paket;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

//screen displayed when the game is over, ie when the player has won or lost
public class EndScreen extends BasicGameState{

	Image lossScreen;
	Image winScreen;
	StateBasedGame game;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
//		lossScreen = new Image("LossScreen.png");
//		winScreen = new Image("WinScreen.png");
		this.game = game;
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
	}

	@Override
	public int getID() {
		return 1;
	}

}
