package objects;

import java.awt.Graphics;

public abstract class GameObject {
	protected int x;
	protected int y;
	
	public GameObject(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public abstract int getSpeed();

	public abstract void setVelY(int direction);

	public abstract void setVelX(int direction);
	
	
}
