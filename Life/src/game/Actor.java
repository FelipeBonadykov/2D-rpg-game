package game;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Actor extends ImageView{
	private boolean canGo = true;
	private MediaPlayer mediaPlayer;
	private Walls walls = new Walls();
	
	void setActor(double x, double y) { 
		setImage(new Image("file:files/boy.png"));
		setPlace(x, y);
	}
	void goTo(int x, int y) {
		if (walls.willNotCollide(Screen.actor, x, y))
			if (canGo) 
				setPlace(getX()+x, getY()+y);
	}
	private void setPlace(double x, double y) {
		setX(x);
		setY(y);
	}
	
	private void sound(String action) {
		mediaPlayer = new MediaPlayer(new Media(new File(action).toURI().toString()));
		mediaPlayer.play();
	}
	void perform(String action, int x, int y, long time) {
		setImage(new Image("file:files/actions/"+action+".png"));
		sound("files/sounds/"+action+".wav");
		canGo = false;
		double X= getX();
		double Y= getY();
		setPlace(x, y);
		
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				setActor(X, Y);
				canGo = true;
			}
		}, time*1000L);
	}
}
