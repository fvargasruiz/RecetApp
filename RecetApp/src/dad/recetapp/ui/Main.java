package dad.recetapp.ui;

import javax.swing.JDialog;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NuevaRecetaDialog dialog = new NuevaRecetaDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
