package dad.recetapp.ui.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class CategoriasPane extends BorderPane implements Initializable {
	
	@FXML 
	private TextField descripcionText;

	@FXML 
	private Button anadirButton;

	@FXML 
	private Button eliminarButton;
	
	@FXML
	private TableView<?> categoriasTable;

	public CategoriasPane() {
		super();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dad/recetapp/ui/views/CategoriasPane.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	@FXML
	private void anadirCategoria() {
		
	}
	
	@FXML 
	private void eliminarCategoria() {
		
	}

	@Override
	public void initialize(URL url, ResourceBundle properties) {
		System.out.println("inicializando CategoriasPane: " + url);
	}

}
