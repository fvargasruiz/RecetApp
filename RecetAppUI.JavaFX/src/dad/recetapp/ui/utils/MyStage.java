package dad.recetapp.ui.utils;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public abstract class MyStage extends Stage {
	
	public MyStage(String resourceName) {
		initStage();
		initScene(resourceName);
		initComponents();
	}

	@Override
	public void centerOnScreen() {
		Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();  
		setX((screenSize.getMinX() + screenSize.getWidth() - getWidth()) / 2);
		setY((screenSize.getMinY() + screenSize.getHeight() - getHeight()) / 2);
	}
	
	public void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);
	}
	
	private void initScene(String resourceName) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(resourceName));
	        Scene scene = new Scene(root);
			setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}        
	}

	protected abstract void initStage();
	
	protected void initComponents() { }
	
}
