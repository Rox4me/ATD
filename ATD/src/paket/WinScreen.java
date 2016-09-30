package paket;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

//screen displayed when the game is over, ie when the player has won or lost
public class WinScreen extends BasicGameState{

	Image winScreen[] = new Image[3];
	StateBasedGame game;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		winScreen[0] = new Image("textures/winnerlvl1.png");
		winScreen[1] = new Image("textures/winnerlvl2.png");
		winScreen[2] = new Image("textures/winnerlvl3.png");
		this.game = game;
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.drawImage(winScreen[Start.mapID], 0, 0);		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		Input input = container.getInput();

		int posX = Mouse.getX();
		int posY = Mouse.getY();

		//exit game
		if(container.getInput().isKeyDown(Input.KEY_ESCAPE)){
			container.exit();
		}
		if(container.getInput().isKeyDown(Input.KEY_R)){
			Troops.NTroops = 0;
			Towers.Nturrets = 0;
			this.game.enterState(0);
		}

		//enter next level
		if((posX>270 && posX<550) && (posY>460 && posY<540)){
			this.game.enterState(3);
		}
		
	}

	@Override
	public int getID() {
		return 1;
	}

}
