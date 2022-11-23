package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import display.Display;
import display.graphics.Assets;
import display.graphics.GameCamera;
import display.graphics.ImageLoader;
import display.graphics.SpriteSheet;
import input.KeyManager;
import states.*;

public class Game implements Runnable{

	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//STATES
	private State gameState;
	private State menuState;
	
	//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	/**
	 * Game Constructor that initializes the title, width, and height
	 * @param Game Title
	 * @param Screen Width
	 * @param Screen Height
	 */
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		

	}
	/**
	 * init method that initalizes certain aspects of the game
	 */
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		//Initialize States
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
	}
	
	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null) 
			State.getState().tick();
		
	}
	
	/**
	 * render method that deals with the graphics of the game
	 */
	private void render() {
		 bs = display.getCanvas().getBufferStrategy();
		 if(bs == null) {
			 display.getCanvas().createBufferStrategy(3);
			 return;
		 }
		 g = bs.getDrawGraphics();
		 //Clear Screen
		 g.clearRect(0, 0, width, height);
		 //Draw Here!
		 
		if(State.getState() != null) 
			State.getState().render(g);

		 //End Drawing!
		 bs.show();
		 g.dispose();
	}
	
	/**
	 * Run method that runs the game 
	 */
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now  = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				ticks ++;
				delta --;
			}
			
			if(timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
				
			}
			
		}
		
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	/**
	 * Starts the thread
	 */
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * Ends the Thread
	 */
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
