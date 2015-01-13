package dad.recetapp.ui;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class NuevaRecetaDialog extends JDialog {

	private JTabbedPane seccionesTabbedPane;
	private ChangeListener seccionesChangeListener;
	
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

	/**
	 * Create the dialog.
	 */
	public NuevaRecetaDialog() {
		
		// creo y guardo una referencia al Listener que se activa cuando se cambia de pestaña en el tabbedPane
		seccionesChangeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				onSeccionesTabbedPaneStateChanged(e);
			}
		};
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Ejemplo de añadir y eliminar pestañas");
		setIconImage(new ImageIcon(NuevaRecetaDialog.class.getResource("/dad/recetapp/ui/images/logo.png")).getImage());
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
		seccionesTabbedPane.removeChangeListener(seccionesChangeListener); 				// quito el listener para deshabilitar la captura del evento "stateChanged" del TabbedPane
		
		// si hay pestañas en el tabbedPane, quito la última (la del +)
		if (seccionesTabbedPane.getTabCount() > 0) {
			seccionesTabbedPane.remove(seccionesTabbedPane.getTabCount() - 1);
		}
		
		SeccionPanel ejemploPanel = new SeccionPanel(); 								// creo el panel para los datos de la sección (uno de los SeccionItem de la receta)
		ejemploPanel.setContenedor(seccionesTabbedPane);
		
		seccionesTabbedPane.addTab("", ejemploPanel); 									// añado la pestala para la nueva sección
		seccionesTabbedPane.setSelectedIndex(seccionesTabbedPane.getTabCount() - 1); 	// selecciono la pestaña que acabo de añadir 
		seccionesTabbedPane.addTab("", new ImageIcon(NuevaRecetaDialog.class.getResource("/dad/recetapp/ui/images/addTabIcon.png")), new JPanel()); // añado al final la pestaña del "+"
		
		seccionesTabbedPane.addChangeListener(seccionesChangeListener);					// volvemos a poner el listener para habilitar la captura del evento "stateChanged" del TabbedPane	
	}

	protected void onSeccionesTabbedPaneStateChanged(ChangeEvent e) {
		// si se ha seleccionado la última pestaña (la del +), añadimos una nueva sección
		if (seccionesTabbedPane.getSelectedIndex() == seccionesTabbedPane.getTabCount() - 1) {
			nuevoSeccionPanel();
		}
	}

}
