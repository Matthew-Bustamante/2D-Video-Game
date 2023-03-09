package worlds;

import entities.EntityManager;
import entities.creatures.Player;
import entities.statics.Portal;
import entities.statics.Rock;
import entities.statics.Tree;
import game.Handler;
import game.items.ItemManager;

public class WorldOne extends Universe{
	
	public WorldOne(Handler handler, String path) {
		super(handler, path);
		//entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		
		//Trees
		entityManager.addEntity(new Tree(handler, 500, 280));
		entityManager.addEntity(new Tree(handler, 200, 250));
		entityManager.addEntity(new Tree(handler, 500, 550));
		
		//Rocks
		
		entityManager.addEntity(new Rock(handler, 300, 500));
		entityManager.addEntity(new Rock(handler, 550, 480));
		
		//Portal
		entityManager.addEntity(new Portal(handler, 1050, 500));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
		//itemManager = new ItemManager(handler);
	}
}
