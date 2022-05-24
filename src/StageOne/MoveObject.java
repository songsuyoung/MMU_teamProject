package StageOne;

import java.awt.Graphics;

public abstract class MoveObject { //움직이는 게임 Object
	int x = 0;
	int y = 0;	
	int width = 0;
	int height = 0;
	int speed = 0;
	
	public MoveObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}


	
	abstract public void updateLocation();
	abstract public void draw(Graphics g);
	
   /* public Rectangle getBound(){
        return new Rectangle(x, y, width, height);
    }
    
    public Rectangle getBottomBound(){
        return new Rectangle((int)x+width/6, (int)y + height/2, 2*width/3, height/2);
    }
    
    public Rectangle getTopBound(){
        return new Rectangle((int)x+width/6, (int)y, 2*width/3, height/2);
    }
    */ //동우오빠가 이용할거같아서 남겨놨어요.
}
