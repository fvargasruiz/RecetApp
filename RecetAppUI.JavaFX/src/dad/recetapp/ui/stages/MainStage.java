package dad.recetapp.ui.stages;

import javafx.scene.image.Image;
import dad.recetapp.ui.utils.MyStage;

public class MainStage extends MyStage {

	public MainStage() {
		super("/dad/recetapp/ui/views/Main.fxml");
	}

	@Override
	protected void initStage() {
		setTitle("RecetApp");
		setSize(640, 480);
		centerOnScreen();
		getIcons().add(new Image(MainStage.class.getResourceAsStream("/dad/recetapp/ui/images/logo.png")));
	}

}
