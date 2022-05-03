package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Screen extends Application{
	private Walls wall = new Walls();
	static Actor actor = new Actor();
	{ actor.setActor(100, 300); }
	
	private boolean check(int x, int y) {
		if (actor.getX()==x & actor.getY()==y) return true;
		else return false;
	}
	@Override
	public void start(Stage primaryStage) {
		primaryStage.getIcons().add(new Image("file:files/icon.png"));
		Pane root = new Pane();
		
	    Scene scene = new Scene(root, 400, 490);
	    scene.getStylesheets().add(Screen.class.getResource("house.css").toExternalForm());
	    scene.setOnKeyPressed(value -> {
	    	//move controls
	    	if (value.getCode()==KeyCode.RIGHT & actor.getX()<370) { actor.goTo(5,  0); }
	    	if (value.getCode()==KeyCode.LEFT & actor.getX()>0.0)  { actor.goTo(-5, 0); }
	    	if (value.getCode()==KeyCode.UP & actor.getY()>0.0)    { actor.goTo(0, -5); }
	    	if (value.getCode()==KeyCode.DOWN & actor.getY()<430)  { actor.goTo(0,  5); }
	    	//actions
	    	if (check(280, 75)) { actor.perform("toilet"        ,280, 70,  1);}
	    	if (check(175, 100)){ actor.perform("phone-call"    ,176, 79,  2);}
	    	if (check(335, 90)) { actor.perform("taking-shower" ,330, 71,  3);}
	    	if (check(60, 75))  { actor.perform("eating"        ,50,  71,  5);}
	    	if (check(30, 290)) { actor.perform("relaxing"      ,25, 281,  7);}
	    	if (check(310, 210)){ actor.perform("sleeping"      ,315,207, 10);}
	    });
	    
	    root.getChildren().addAll(wall.getWalls());
	    root.getChildren().add(actor);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("WORLD");
	    primaryStage.setResizable(false);
	    primaryStage.show();
	}
}