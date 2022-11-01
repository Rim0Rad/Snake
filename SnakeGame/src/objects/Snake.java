package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Snake extends GameObject {
	
	int velX, velY;
	int speed;
	int size;
	LinkedList<int[]> snakeBody = new LinkedList<int[]>();
	

	public Snake(int x, int y, int speed) {
		super(x, y);
		this.speed = speed;
		velX = speed;
		velY = 0;
		
		size = 10;
		snakeBody.add(new int[]{x, y});
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		System.out.println("Snake Tick");
		this.x += velX;
		this.y += velY;
		snakeBody.remove();
		snakeBody.add(new int[]{x, y});
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
		for(int [] bodyPart: snakeBody) {
			g.fillRect(bodyPart[0], bodyPart[1], size, size);
		}
		
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void setVelY(int direction) {
		velY = speed * direction;
		velX = 0;
		
	}

	@Override
	public void setVelX(int direction) {
		velX = speed * direction;
		velY = 0;
	}
}
