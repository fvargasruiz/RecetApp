package dad.recetapp.ui;

import javafx.application.Application;
import javafx.stage.Stage;
import dad.recetapp.ui.stages.InitStage;
import dad.recetapp.ui.stages.MainStage;

public class RecetApp extends Application {

	public static void main(String[] args) {
		RecetApp.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new InitStage().showAndWait();
		new MainStage().show();
	}
	
}
