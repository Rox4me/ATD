package paket;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import maps.Map2;
import maps.Test;

public class Start extends StateBasedGame {
	
	public static int mapID;
	
	public Start(String name) {
		super(name);

	}

	public static void main(String[] args) {
		Start game = new Start("Slick Tutorial");
		
		AppGameContainer container;
		try {
			container = new AppGameContainer(game);
			container.setDisplayMode(800, 800, false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}


		
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new Test());
		this.addState(new WinScreen());
		this.addState(new LossScreen());
		this.addState(new Map2());
		this.addState(new Menu());
		
		
	}

}
