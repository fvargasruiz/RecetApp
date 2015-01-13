package dad.recetapp.ui.controllers;

import java.net.URL;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.Window;

public class InitWindow extends Window implements Bindable {

	@BXML private Label etiqueta;
	@BXML private PushButton boton;
	
	@Override
	public void initialize(Map<String, Object> namespace, URL location, Resources resources) {		
		boton.getButtonPressListeners().add(new ButtonPressListener() {
			public void buttonPressed(Button button) {
				onBotonButtonPressed();
			}
		});
	}

	private void onBotonButtonPressed() {
		etiqueta.setText("Hola Mundo!");
		Alert.alert("Hola Mundo!", this);
	}	

}
