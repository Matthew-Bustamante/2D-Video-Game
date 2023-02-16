package entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import display.graphics.Animation;
import display.graphics.Assets;
import entities.Entity;
import game.Game;
import game.Handler;
import game.inventory.Inventory;
import entities.statics.Tree;

/**
 * Player class that allows the user to interact with.  The player can move up,down, left, right via key input
 * and can do melee attacks against other entities, and takes damage from enemy entities
 * @author Matthew-Bustamante
 *
 */
public class Player extends Creature{
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	
	//Attack Timer
	private long lastAttackTimer, attackCooldown = 500, attackTimer = attackCooldown;
	
	//Iventory
	private Inventory inventory;

	/**
	 * Player Constructor
	 * @param Handler object
	 * @param x position (float)
	 * @param y position (float)
	 */
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		//Collision Box
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Creature.DEFAULT_CREATURE_WIDTH - 25;
		bounds.height = Creature.DEFAULT_CREATURE_HEIGHT - 10;
		
		//Animations
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
		
		inventory = new Inventory(handler);
	}

	@Override
	/**
	 * tick method that overrides the tick method in Entity and is used for player animations and for 
	 * key inputs and for movement
	 */
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		//Attack
		checkAttacks();
		//inventory
		inventory.tick();
	}
	
	/**
	 * Melee attack method:
	 * When left, right, up, arrow keys are pressed this method checks if an entity is near the player
	 * if so the method calls the hurt() method in the entity class to deal damage to other entities
	 */
	public void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown) {
			return;
		}
		
		if(inventory.isActive()) {
			return;
		}
		
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().aUp) {
			ar.x = cb.x + cb.width / 2 - arSize /2;
			ar.y = cb.y - arSize;
		}else if(handler.getKeyManager().aDown) {
			ar.x = cb.x + cb.width / 2 - arSize /2;
			ar.y = cb.y - cb.height;
		}else if(handler.getKeyManager().aLeft) {
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else if(handler.getKeyManager().aRight) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else {
			return;
		}
		
		attackTimer = 0;
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}
			if(e.getCollisionBounds(0, 0).intersects(ar)) {
				e.hurt(1);
				return;
			}
		}
		
	}
	
	@Override
	/**
	 * Unimplemented die method that when player health is 0 the game ends
	 */
	public void die() {
		System.out.println("Game Over");
	}
	
	/**
	 * Gathers key input from the user by utilizing the KeyManager class to use for movement and other player actions
	 */
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(inventory.isActive()) {
			return;
		}
		if(handler.getKeyManager().up) {
			yMove = -speed;
		}
		if(handler.getKeyManager().down) {
			yMove = speed;
		}
		if(handler.getKeyManager().left) {
			xMove = -speed;
		}
		if(handler.getKeyManager().right) {
			xMove = speed;
		}
		
		
	}

	@Override
	/**
	 * Renders the player to the screen and renders player animations to the screen
	 * @param Graphics object
	 */
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		 /*
		  //TEST CODE FOR COLLISIONS
		g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		 */
	}
	
	public void postRender(Graphics g) {
		inventory.render(g);
	}
	
	/**
	 * getCurrentAnimationFrame method that returns the current frame of the player.
	 * This is used to allow animations to appear on the screen
	 * @return current animation frame (BufferedImage)
	 */
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			return animLeft.getCurrentFrame();
		}else if (xMove > 0) {
			return animRight.getCurrentFrame();
		}else if (yMove < 0) {
			return animUp.getCurrentFrame();
		}else {
			return animDown.getCurrentFrame();
		}
	}
	
	/**
	 * Returns the player's inventory.
	 * @return inventory object (Inventory)
	 */
	public Inventory getInventory() {
		return inventory;
	}
	
	/**
	 * Sets the player's inventory
	 * @param inventory object (Inventory)
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
}

