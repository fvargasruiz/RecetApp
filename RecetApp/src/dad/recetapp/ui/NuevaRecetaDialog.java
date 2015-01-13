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
		
		// creo y guardo una referencia al Listener que se activa cuando se cambia de pesta�a en el tabbedPane
		seccionesChangeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				onSeccionesTabbedPaneStateChanged(e);
			}
		};
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Ejemplo de a�adir y eliminar pesta�as");
		setIconImage(new ImageIcon(NuevaRecetaDialog.class.getResource("/dad/recetapp/ui/images/logo.png")).getImage());
		setModal(true);
		setBounds(100, 100, 742, 443);
		
		seccionesTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		seccionesTabbedPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		seccionesTabbedPane.addChangeListener(seccionesChangeListener);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(seccionesTabbedPane, BorderLayout.CENTER);

		nuevoSeccionPanel(); // para que se a�ada una secci�n vac�a y la pesta�a "+" al tabbedPane inicialmente.
	}

	private void nuevoSeccionPanel() {
		seccionesTabbedPane.removeChangeListener(seccionesChangeListener); 				// quito el listener para deshabilitar la captura del evento "stateChanged" del TabbedPane
		
		// si hay pesta�as en el tabbedPane, quito la �ltima (la del +)
		if (seccionesTabbedPane.getTabCount() > 0) {
			seccionesTabbedPane.remove(seccionesTabbedPane.getTabCount() - 1);
		}
		
		SeccionPanel ejemploPanel = new SeccionPanel(); 								// creo el panel para los datos de la secci�n (uno de los SeccionItem de la receta)
		ejemploPanel.setContenedor(seccionesTabbedPane);
		
		seccionesTabbedPane.addTab("", ejemploPanel); 									// a�ado la pestala para la nueva secci�n
		seccionesTabbedPane.setSelectedIndex(seccionesTabbedPane.getTabCount() - 1); 	// selecciono la pesta�a que acabo de a�adir 
		seccionesTabbedPane.addTab("", new ImageIcon(NuevaRecetaDialog.class.getResource("/dad/recetapp/ui/images/addTabIcon.png")), new JPanel()); // a�ado al final la pesta�a del "+"
		
		seccionesTabbedPane.addChangeListener(seccionesChangeListener);					// volvemos a poner el listener para habilitar la captura del evento "stateChanged" del TabbedPane	
	}

	protected void onSeccionesTabbedPaneStateChanged(ChangeEvent e) {
		// si se ha seleccionado la �ltima pesta�a (la del +), a�adimos una nueva secci�n
		if (seccionesTabbedPane.getSelectedIndex() == seccionesTabbedPane.getTabCount() - 1) {
			nuevoSeccionPanel();
		}
	}

}
