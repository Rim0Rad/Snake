package engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import control.KeyControl;
import objects.Snake;

public class SnakeGame extends Canvas implements Runnable {

	
	private Handler handler;
	private boolean running;
	private Thread thread;
	
	public static final Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = (int) resolution.getWidth(),  HEIGHT = (int) resolution.getHeight();

	public SnakeGame() {
		
		handler = new Handler();
		this.addKeyListener(new KeyControl(handler));
		
		//Initial game objects:
		handler.addObject(new Snake(500, 500, 2));
		
		
		
		new Window(WIDTH, HEIGHT, "Strategy game", this);
	}
		
		
	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/ amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta +=(now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) {
				render();
			}
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
		
	}
	private void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void tick() {
		handler.tick();		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(1);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		//Background
		g.setColor(Color.red);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
		
	}
	
	public static void main(String[] args) {
		new SnakeGame();
	}

}
