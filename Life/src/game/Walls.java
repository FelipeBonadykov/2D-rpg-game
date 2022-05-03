package game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Walls {
	//private Rectangle rectangle1=new Rectangle(21, 70, 3, 330);
	private static Rectangle[] walls = new Rectangle[20];
	static {
		walls[ 0] = new Rectangle(21, 70, 3, 330);
		walls[ 1] = new Rectangle(20, 70, 356, 3);
		walls[ 2] = new Rectangle(218, 70, 3, 218);
		walls[ 3] = new Rectangle(218, 285, 30, 3);
		walls[ 4] = new Rectangle(246, 70, 3, 218);
		walls[ 5] = new Rectangle(377, 70, 3, 330);
		walls[ 6] = new Rectangle(250, 395, 128, 3);
		walls[ 7] = new Rectangle(22, 395, 100, 3);
		walls[ 8] = new Rectangle(22, 235, 93, 3);
		walls[ 9] = new Rectangle(22, 262, 91, 3);
		walls[10] = new Rectangle(186, 393, 32, 3);
		walls[11] = new Rectangle(221, 364, 23, 3);
		walls[12] = new Rectangle(118, 235, 3, 30);
		walls[13] = new Rectangle(295, 172, 82, 3);
		walls[14] = new Rectangle(295, 199, 82, 3);
		walls[15] = new Rectangle(295, 173, 3, 27);
		walls[16] = new Rectangle(118, 395, 3, 28);
		walls[17] = new Rectangle(186, 395, 3, 32);
		walls[18] = new Rectangle(244, 364, 3, 33);
		walls[19] = new Rectangle(218, 365, 3, 29);
		for (Rectangle rectangle : walls) 
			rectangle.setFill(Color.TRANSPARENT);
	}
	public Rectangle[] getWalls() {
		return walls;
	}
	public boolean willNotCollide(Actor actor, double x, double y) {
		actor.setX(actor.getX()+x);
		actor.setY(actor.getY()+y);
			for (Rectangle rectangle : walls) 
				if (actor.getBoundsInParent().intersects(rectangle.getBoundsInParent())) {
					actor.setX(actor.getX()-x);
					actor.setY(actor.getY()-y);
					return false;//has collided
				}
			actor.setX(actor.getX()-x);
			actor.setY(actor.getY()-y);
		return true;//no collusion
	}
}
