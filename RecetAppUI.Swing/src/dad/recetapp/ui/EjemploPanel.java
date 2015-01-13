package dad.recetapp.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class EjemploPanel extends JPanel {
	private JTextField seccionText;
	private JTabbedPane contenedor;

	public EjemploPanel() {
		this.setLayout(new BorderLayout());

		JPanel principalPanel = new JPanel();
		this.add(principalPanel, BorderLayout.CENTER);
		principalPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel superiorPanel = new JPanel();
			principalPanel.add(superiorPanel, BorderLayout.NORTH);
			superiorPanel.setLayout(new BorderLayout(0, 0));
			{
				JPanel datosSeccionPanel = new JPanel();
				superiorPanel.add(datosSeccionPanel, BorderLayout.WEST);
				{
					JLabel seccionLabel = new JLabel("Secci\u00F3n:");
					datosSeccionPanel.add(seccionLabel);
				}
				{
					seccionText = new JTextField();
					seccionText.addKeyListener(new KeyAdapter() {
						@Override
						public void keyReleased(KeyEvent e) {
							onSeccionTextKeyReleased(e);
						}
					});
					datosSeccionPanel.add(seccionText);
					seccionText.setColumns(30);
				}
			}
			{
				JPanel eliminarSeccionPanel = new JPanel();
				superiorPanel.add(eliminarSeccionPanel, BorderLayout.EAST);
				{
					JButton eliminarSeccionButton = new JButton("-");
					eliminarSeccionButton
							.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									onEliminarSeccionButtonActionPerformed(e);
								}
							});
					eliminarSeccionPanel.add(eliminarSeccionButton);
				}
			}
		}

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
