package paket;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

//screen displayed when the game is over, ie when the player has won or lost
public class EndScreen extends BasicGameState{

	Image lossScreen;
	Image winScreen;
	StateBasedGame game;
	boolean playerWin;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		lossScreen = new Image("textures/gameover.png");
		winScreen = new Image("textures/winner.png");
		this.game = game;
		
		if(Enemy.getHealth() <= 0){
			playerWin = true;
		}else{
			playerWin = false;
		}
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.drawImage(winScreen, 0, 0);
		if(playerWin == true){
			g.drawImage(winScreen, 0, 0);
		}else{
			g.drawImage(lossScreen, 0, 0);
		}
		
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
		return 1;
	}

}
