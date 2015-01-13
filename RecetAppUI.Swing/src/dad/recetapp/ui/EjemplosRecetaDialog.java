package dad.recetapp.ui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class EjemplosRecetaDialog extends JDialog {

	private JTabbedPane seccionesTabbedPane;
	private ChangeListener seccionesChangeListener;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EjemplosRecetaDialog dialog = new EjemplosRecetaDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EjemplosRecetaDialog() {
		
		// creo y guardo una referencia al Listener que se activa cuando se cambia de pestaña en el tabbedPane
		seccionesChangeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				onSeccionesTabbedPaneStateChanged(e);
			}
		};
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Ejemplo de a\u00F1adir nuevas pesta\u00F1as");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EjemplosRecetaDialog.class.getResource("/dad/recetapp/ui/images/logo.png")));
		setModal(true);
		setBounds(100, 100, 742, 443);
		
		seccionesTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		seccionesTabbedPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		seccionesTabbedPane.addChangeListener(seccionesChangeListener);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(seccionesTabbedPane, BorderLayout.CENTER);

		nuevoSeccionPanel(); // para que se añada una sección vacía y la pestaña "+" al tabbedPane inicialmente.
	}

	private void nuevoSeccionPanel() {
		System.out.println("holaaa");
		
		seccionesTabbedPane.removeChangeListener(seccionesChangeListener); 				// quito el listener para deshabilitar la captura del evento "stateChanged" del TabbedPane
		
		// si hay pestañas en el tabbedPane, quito la última (la del +)
		if (seccionesTabbedPane.getTabCount() > 0) {
			seccionesTabbedPane.remove(seccionesTabbedPane.getTabCount() - 1);
		}
		
		EjemploPanel ejemploPanel = new EjemploPanel(); 								// creo el panel para los datos de la sección (uno de los SeccionItem de la receta)
		ejemploPanel.setContenedor(seccionesTabbedPane);
		
		seccionesTabbedPane.addTab("", ejemploPanel); 									// añado la pestala para la nueva sección
		seccionesTabbedPane.setSelectedIndex(seccionesTabbedPane.getTabCount() - 1); 	// la selecciono 
		seccionesTabbedPane.addTab("+", new JPanel()); 									// añado al final la pestaña del "+"
		
		seccionesTabbedPane.addChangeListener(seccionesChangeListener);					// volvemos a poner el listener para habilitar la captura del evento "stateChanged" del TabbedPane	
	}

	protected void onSeccionesTabbedPaneStateChanged(ChangeEvent e) {
		// si se ha seleccionado la última pestaña (la del +), añadimos una nueva sección
		if (seccionesTabbedPane.getSelectedIndex() == seccionesTabbedPane.getTabCount() - 1) {
			nuevoSeccionPanel();
		}
	}

}
