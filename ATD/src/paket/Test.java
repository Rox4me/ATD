package paket;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Test extends BasicGameState {

	
	Rectangle test1;
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		test1 = new Rectangle(10,0,10,10);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.draw(test1);
		
	}

	int x = 0;
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		test1 = new Rectangle(x,x,10,10);
	
		x++;
		if(x > 799){
			x = 0;
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
