package dad.recetapp.ui.stages;

import javafx.stage.StageStyle;
import dad.recetapp.ui.utils.MyStage;
import dad.recetapp.ui.utils.Timer;

public class InitStage extends MyStage {

	private Timer timer;

	public InitStage() {
		super("/dad/recetapp/ui/views/Init.fxml");
	}

	@Override
	protected void initStage() {
		initStyle(StageStyle.UNDECORATED);
		setSize(472, 250);
		centerOnScreen();
	}

	@Override
	protected void initComponents() {
		timer = new Timer(4000, 1) {
			protected void task() {
				onTimerTask();
			}
		};
		timer.start();
	}

	protected void onTimerTask() {
		timer.cancel();
		close();
	}
}
