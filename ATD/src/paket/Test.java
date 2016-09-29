package paket;

import org.lwjgl.input.Mouse;
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
	Image towerTurretLaser;
	Image unitMenu;
	private int Startcredit = 10000;
	long lastSpawn;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		this.game = game;
		//create tower and troop
		troopImages[0] = new Image("textures/bandvagn.png");
		troopImages[1] = new Image("textures/bandvagn.png");
		troopImages[1].rotate(90);
		background  = new Image("textures/map.png");
		towerBase = new Image("textures/enemybottom.png");
		towerTurret = new Image("textures/enemytop.png");
		towerTurretLaser = new Image("textures/enemytoplaser.png");
		unitMenu = new Image("textures/playmenystruktur.png");
		Troops.NTroops = 0;
		Towers.Nturrets = 0;
		Player.credit = Startcredit;
		Player.updateTime=0;
		this.lastSpawn=0;
		
		Troop.setSpawnPoint(0,350);
		
		Towers.createTower(100, 300, 1, 1);
		Towers.createTower(400, 300, 1, 1);
	
		
	}

	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		//draw background
		g.drawImage(background, 0,0);
		g.drawImage(unitMenu, 200, 660);
		//draw troops
		for(int i=0;i<Troops.NTroops;i++){
			if(Troops.troops[i].positionX > 200){
				g.drawImage(troopImages[Troops.troops[i].troopImage+1], Troops.troops[i].positionX, Troops.troops[i].positionY);
				
			}else{
				g.drawImage(troopImages[Troops.troops[i].troopImage], Troops.troops[i].positionX, Troops.troops[i].positionY);
				
			}
//			g.draw(Troops.troops[i].hitBox);
		}
		for(int i=0;i<Towers.Nturrets;i++){
			//draw tower base
			g.drawImage(towerBase, Towers.turrets[i].x-20, Towers.turrets[i].y-20);
			//rotate image to "aim" at target
			towerTurret.rotate((float)Towers.turrets[i].aimingAt - 90);
			towerTurretLaser.rotate((float)Towers.turrets[i].aimingAt - 90);
			//draw tower turret
			if(Towers.turrets[i].hasShot){
				//draw idle turret
				g.drawImage(towerTurretLaser, Towers.turrets[i].x-15, Towers.turrets[i].y-15);
			}else{
				//draw firing turret
				g.drawImage(towerTurret, Towers.turrets[i].x-15, Towers.turrets[i].y-15);
			}
			//reset tower rotation
			towerTurret.setRotation(0);
			towerTurretLaser.setRotation(0);
			//draw towers range
			g.draw(Towers.turrets[i].range);
		}
		
		//draw tower range

		//draw money
		g.drawString(String.valueOf((int)Player.credit), 500, 20);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		towerTurret.setCenterOfRotation(15, 15);
		towerTurretLaser.setCenterOfRotation(15, 15);
		Player.updateTime++;
		//exit game
		if(container.getInput().isKeyDown(Input.KEY_ESCAPE)){
			container.exit();
		}
		//spawnKey
		if(50 < Player.updateTime-lastSpawn){
			if(container.getInput().isKeyDown(Input.KEY_S) && Troops.NTroops < 50){
				Troops.createTroop();
				lastSpawn = Player.updateTime;
			}
		}
		//restart key
		if(container.getInput().isKeyDown(Input.KEY_R)){
			container.reinit();
			lastSpawn = 0;
		}
		
		Input input = container.getInput();
		
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		//buy helikopter
		if((posX>246 && posX<310) && (posY>10 && posY<130)){
			if(input.isMousePressed(0)){
				if(50 < Player.updateTime-lastSpawn){
					Troops.createTroop();
					lastSpawn = Player.updateTime;
				}
			}
		}
		//buy pansarvagn
		if((posX>320 && posX<385) && (posY>10 && posY<130)){
			if(input.isMousePressed(0)){
				if(50 < Player.updateTime-lastSpawn){
					Troops.createTroop();
					lastSpawn = Player.updateTime;
				}
			}
		}
		//buy bandvagn
		if((posX>395 && posX<450) && (posY>10 && posY<130)){
			if(input.isMousePressed(0)){
				if(50 < Player.updateTime-lastSpawn){
					Troops.createTroop();
					lastSpawn = Player.updateTime;
				}
				
			}
		}
		
		//restart game
		if((posX>512 && posX<586) && (posY>8 && posY<30)){
			if(input.isMousePressed(0)){
				container.reinit();
				lastSpawn = 0;
			}
		}


		
//		System.out.println(Enemy.health);
		//killing troops and checking if the enemy is dead (player has won)
		for(int i=0; i<Troops.NTroops;i++){
			Troops.troops[i].move();
			//if troop is out of map
			if(Troops.troops[i].positionX > 800){
				Enemy.health--;
				//remove troop from game
				Towers.killtroop(i);
				Player.gainCredits(Startcredit/2);
				if(Enemy.health <=0){
					//enter victory screen
					this.game.enterState(1);
				}
			//if troop is out of map
			}else if(Troops.troops[i].positionX < 0){
				Enemy.health--;
				//remove troop from game
				Towers.killtroop(i);
				Player.gainCredits(Startcredit/2);
				if(Enemy.health <=0){
					//enter victory screen
					this.game.enterState(1);
				}
			//if troop is out of map
			}else if(Troops.troops[i].positionY > 800){
				Enemy.health--;
				//remove troop from game
				Towers.killtroop(i);
				Player.gainCredits(Startcredit/2);
				if(Enemy.health <=0){
					//enter victory screen
					this.game.enterState(1);
				}
 			//if troop is out of map
			}else if(Troops.troops[i].positionY < 0){
				Enemy.health--;
				//remove troop from game
				Towers.killtroop(i);
				Player.gainCredits(Startcredit/2);
				if(Enemy.health <=0){
					//enter victory screen
					this.game.enterState(1);
				}
			}
		}
		//check if player has no credits and no troops (player has lost)
		if(Player.credit < 50 && Troops.NTroops == 0){
			//enter loss screen
			this.game.enterState(2);
		}
		//	this.game.enterState(1);
		//if troop 0 is within range of tower1 0
		for(int i=0;i<Towers.Nturrets;i++){
			Towers.turrets[i].hasShot = false;
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
