package dad.recetapp.ui.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class RecetasPane extends BorderPane implements Initializable {

	public RecetasPane() {
		super();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dad/recetapp/ui/views/RecetasPane.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	@FXML
	private void anadirReceta() {
		
	}
	
	@FXML 
	private void eliminarReceta() {
		
	}
	
	@FXML 
	private void editarReceta() {
		
	}

	@Override
	public void initialize(URL url, ResourceBundle properties) {
		System.out.println("inicializando RecetasPane: " + url);
	}

}
