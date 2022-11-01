package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import engine.Handler;
import objects.GameObject;

public class KeyControl extends KeyAdapter{

	private Handler handler;

	public KeyControl(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == e.VK_W) {
			handler.object.get(0).setVelY(-1);
		}else if(key == e.VK_S) {
			handler.object.get(0).setVelY(1);
		}else if(key == e.VK_D) {
			handler.object.get(0).setVelX(1);
		}else if(key == e.VK_A) {
			handler.object.get(0).setVelX(-1);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == e.VK_W) {
				
		}else if(key == e.VK_S) {
				
		}else if(key == e.VK_D) {
				
		}else if(key == e.VK_A) {
				
		}
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}
	
	
}
