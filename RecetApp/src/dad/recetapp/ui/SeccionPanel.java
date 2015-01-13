package dad.recetapp.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SeccionPanel extends JPanel {
	
	private JTextField seccionText;
	private JTabbedPane contenedor;

	public SeccionPanel() {
		JPanel principalPanel = new JPanel();
		principalPanel.setLayout(new BorderLayout(0, 0));

		JPanel superiorPanel = new JPanel();
		principalPanel.add(superiorPanel, BorderLayout.NORTH);
		superiorPanel.setLayout(new BorderLayout(0, 0));

		JPanel datosSeccionPanel = new JPanel();
		superiorPanel.add(datosSeccionPanel, BorderLayout.WEST);

		JLabel seccionLabel = new JLabel("Sección:");
		datosSeccionPanel.add(seccionLabel);

		seccionText = new JTextField();
		seccionText.setColumns(30);
		seccionText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				onSeccionTextKeyReleased(e);
			}
		});
		datosSeccionPanel.add(seccionText);
		
		JPanel eliminarSeccionPanel = new JPanel();
		superiorPanel.add(eliminarSeccionPanel, BorderLayout.EAST);

		JButton eliminarSeccionButton = new JButton(new ImageIcon(SeccionPanel.class.getResource("/dad/recetapp/ui/images/closeTabOverIcon.png")));
		eliminarSeccionButton.setToolTipText("Eliminar sección");
		eliminarSeccionButton.setBorderPainted(false);
		eliminarSeccionButton.setOpaque(false);
		eliminarSeccionButton.setContentAreaFilled(false);
		eliminarSeccionButton.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				eliminarSeccionButton.setIcon(new ImageIcon(SeccionPanel.class.getResource("/dad/recetapp/ui/images/closeTabOverIcon.png")));
			}
			public void mouseEntered(MouseEvent e) {
				eliminarSeccionButton.setIcon(new ImageIcon(SeccionPanel.class.getResource("/dad/recetapp/ui/images/closeTabIcon.png")));
			}						
		});
		eliminarSeccionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onEliminarSeccionButtonActionPerformed(e);
			}
		});
		eliminarSeccionPanel.add(eliminarSeccionButton);

		setLayout(new BorderLayout());
		add(principalPanel, BorderLayout.CENTER);
	}

	protected void onSeccionTextKeyReleased(KeyEvent e) {
		contenedor.setTitleAt(contenedor.getSelectedIndex(), seccionText.getText());		
	}

	protected void onEliminarSeccionButtonActionPerformed(ActionEvent e) {
		int posicion = contenedor.getSelectedIndex();
		if (posicion > 0) {
			contenedor.setSelectedIndex(posicion - 1);		// evita que se seleccione la pestaña "+" de nuevo al eliminar una sección
		}
		contenedor.remove(posicion);
	}

	public void setContenedor(JTabbedPane contenedor) {
		this.contenedor = contenedor;
	}

}
