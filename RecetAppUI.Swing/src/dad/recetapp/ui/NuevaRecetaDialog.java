package dad.recetapp.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dad.recetapp.services.ServiceLocator;
import dad.recetapp.services.ServiceException;
import dad.recetapp.services.items.CategoriaItem;

@SuppressWarnings("serial")
public class NuevaRecetaDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombreText;
	private JTextField cantidadText;
	private JComboBox<CategoriaItem> categoriaCombo;
	private JComboBox<String> paraCombo;
	private List<JTextField> textosSecciones = new ArrayList<JTextField>();
	private JTabbedPane seccionesTabbedPane;

	private Boolean habilitarCambioPestana = true;
	
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
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Nueva receta");
		setIconImage(Toolkit.getDefaultToolkit().getImage(NuevaRecetaDialog.class.getResource("/dad/recetapp/ui/images/logo.png")));
		setModal(true);
		setBounds(100, 100, 742, 443);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel datosRecetaPanel = new JPanel();
			datosRecetaPanel.setBorder(new EmptyBorder(0, 0, 5, 0));
			contentPanel.add(datosRecetaPanel, BorderLayout.NORTH);
			GridBagLayout gbl_datosRecetaPanel = new GridBagLayout();
			gbl_datosRecetaPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_datosRecetaPanel.rowHeights = new int[]{0, 0, 0, 0};
			gbl_datosRecetaPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_datosRecetaPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			datosRecetaPanel.setLayout(gbl_datosRecetaPanel);
			{
				JLabel nombreLabel = new JLabel("Nombre:");
				GridBagConstraints gbc_nombreLabel = new GridBagConstraints();
				gbc_nombreLabel.insets = new Insets(0, 0, 5, 5);
				gbc_nombreLabel.anchor = GridBagConstraints.EAST;
				gbc_nombreLabel.gridx = 0;
				gbc_nombreLabel.gridy = 0;
				datosRecetaPanel.add(nombreLabel, gbc_nombreLabel);
			}
			{
				nombreText = new JTextField();
				GridBagConstraints gbc_nombreText = new GridBagConstraints();
				gbc_nombreText.insets = new Insets(0, 0, 5, 5);
				gbc_nombreText.fill = GridBagConstraints.HORIZONTAL;
				gbc_nombreText.gridx = 1;
				gbc_nombreText.gridy = 0;
				datosRecetaPanel.add(nombreText, gbc_nombreText);
				nombreText.setColumns(10);
			}
			{
				JLabel tiempoTotalLabel = new JLabel("Tiempo total:");
				GridBagConstraints gbc_tiempoTotalLabel = new GridBagConstraints();
				gbc_tiempoTotalLabel.anchor = GridBagConstraints.EAST;
				gbc_tiempoTotalLabel.insets = new Insets(0, 0, 5, 5);
				gbc_tiempoTotalLabel.gridx = 2;
				gbc_tiempoTotalLabel.gridy = 0;
				datosRecetaPanel.add(tiempoTotalLabel, gbc_tiempoTotalLabel);
			}
			{
				DuracionPanel tiempoTotalPanel = new DuracionPanel();
				tiempoTotalPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
				GridBagConstraints gbc_tiempoTotalPanel = new GridBagConstraints();
				gbc_tiempoTotalPanel.insets = new Insets(0, 0, 5, 0);
				gbc_tiempoTotalPanel.fill = GridBagConstraints.BOTH;
				gbc_tiempoTotalPanel.gridx = 3;
				gbc_tiempoTotalPanel.gridy = 0;
				datosRecetaPanel.add(tiempoTotalPanel, gbc_tiempoTotalPanel);
			}
			{
				JLabel paraLabel = new JLabel("Para:");
				GridBagConstraints gbc_paraLabel = new GridBagConstraints();
				gbc_paraLabel.anchor = GridBagConstraints.EAST;
				gbc_paraLabel.insets = new Insets(0, 0, 5, 5);
				gbc_paraLabel.gridx = 0;
				gbc_paraLabel.gridy = 1;
				datosRecetaPanel.add(paraLabel, gbc_paraLabel);
			}
			{
				JPanel paraPanel = new JPanel();
				FlowLayout fl_paraPanel = (FlowLayout) paraPanel.getLayout();
				fl_paraPanel.setHgap(0);
				fl_paraPanel.setVgap(0);
				fl_paraPanel.setAlignment(FlowLayout.LEFT);
				GridBagConstraints gbc_paraPanel = new GridBagConstraints();
				gbc_paraPanel.insets = new Insets(0, 0, 5, 5);
				gbc_paraPanel.fill = GridBagConstraints.HORIZONTAL;
				gbc_paraPanel.gridx = 1;
				gbc_paraPanel.gridy = 1;
				datosRecetaPanel.add(paraPanel, gbc_paraPanel);
				{
					cantidadText = new JTextField();
					cantidadText.setHorizontalAlignment(SwingConstants.RIGHT);
					cantidadText.setText("0");
					paraPanel.add(cantidadText);
					cantidadText.setColumns(4);
				}
				{
					paraCombo = new JComboBox<String>();
					paraCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"Personas", "Unidades", "Gramos"}));
					paraPanel.add(paraCombo);
				}
			}
			{
				JLabel tiempoThermomixLabel = new JLabel("Tiempo con Thermomix:");
				GridBagConstraints gbc_tiempoThermomixLabel = new GridBagConstraints();
				gbc_tiempoThermomixLabel.anchor = GridBagConstraints.EAST;
				gbc_tiempoThermomixLabel.insets = new Insets(0, 0, 5, 5);
				gbc_tiempoThermomixLabel.gridx = 2;
				gbc_tiempoThermomixLabel.gridy = 1;
				datosRecetaPanel.add(tiempoThermomixLabel, gbc_tiempoThermomixLabel);
			}
			{
				DuracionPanel tiempoThermomixPanel = new DuracionPanel();
				GridBagConstraints gbc_tiempoThermomixPanel = new GridBagConstraints();
				gbc_tiempoThermomixPanel.insets = new Insets(0, 0, 5, 0);
				gbc_tiempoThermomixPanel.fill = GridBagConstraints.BOTH;
				gbc_tiempoThermomixPanel.gridx = 3;
				gbc_tiempoThermomixPanel.gridy = 1;
				datosRecetaPanel.add(tiempoThermomixPanel, gbc_tiempoThermomixPanel);
			}
			{
				JLabel categoriaLabel = new JLabel("Categor\u00EDa:");
				GridBagConstraints gbc_categoriaLabel = new GridBagConstraints();
				gbc_categoriaLabel.anchor = GridBagConstraints.EAST;
				gbc_categoriaLabel.insets = new Insets(0, 0, 0, 5);
				gbc_categoriaLabel.gridx = 0;
				gbc_categoriaLabel.gridy = 2;
				datosRecetaPanel.add(categoriaLabel, gbc_categoriaLabel);
			}
			{
				categoriaCombo = new JComboBox<CategoriaItem>();
				GridBagConstraints gbc_categoriaCombo = new GridBagConstraints();
				gbc_categoriaCombo.anchor = GridBagConstraints.WEST;
				gbc_categoriaCombo.insets = new Insets(0, 0, 0, 5);
				gbc_categoriaCombo.gridx = 1;
				gbc_categoriaCombo.gridy = 2;
				datosRecetaPanel.add(categoriaCombo, gbc_categoriaCombo);
			}
		}
		{
			seccionesTabbedPane = new JTabbedPane(JTabbedPane.TOP);
			seccionesTabbedPane.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					onSeccionesTabbedPaneStateChanged(e);
				}
			});
			contentPanel.add(seccionesTabbedPane, BorderLayout.CENTER);
			{
				nuevoSeccionPanel();
			}
		}
		{
			JPanel botonesPanel = new JPanel();
			getContentPane().add(botonesPanel, BorderLayout.SOUTH);
			botonesPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			{
				JButton crearButton = new JButton("Crear");
				crearButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onCrearButtonActionPerformed(e);
					}
				});
				botonesPanel.add(crearButton);
			}
			{
				JButton cancelarButton = new JButton("Cancelar");
				cancelarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onCancelarButtonActionPerformed(e);
					}
				});
				botonesPanel.add(cancelarButton);
			}
		}
		cargarFrame();
	}

	protected void onCancelarButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	protected void onCrearButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		nuevoSeccionPanel();
	}

	private void nuevoSeccionPanel() {
		habilitarCambioPestana = false;
		if (seccionesTabbedPane.getTabCount() > 0) {
			seccionesTabbedPane.remove(seccionesTabbedPane.getTabCount() - 1);
		}
		SeccionPanel seccionPanel = new SeccionPanel();
		seccionPanel.getSeccionText().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) { onSeccionPanelKeyReleased(e); }
		});
		seccionesTabbedPane.addTab("", seccionPanel);
		textosSecciones.add(seccionPanel.getSeccionText());
		seccionesTabbedPane.setSelectedIndex(seccionesTabbedPane.getTabCount() - 1);
		seccionesTabbedPane.addTab("+", new JPanel());
		habilitarCambioPestana = true;
	}

	protected void onSeccionPanelKeyReleased(KeyEvent e) {
		JTextField textField = (JTextField) e.getSource();
		int tabPos = textosSecciones.indexOf(textField);
		seccionesTabbedPane.setTitleAt(tabPos, textField.getText());
	}

	protected void onSeccionesTabbedPaneStateChanged(ChangeEvent e) {
		if (habilitarCambioPestana && seccionesTabbedPane.getSelectedIndex() == seccionesTabbedPane.getTabCount() - 1) {
			System.out.println("se ha cambiado de pestaña");
		}
	}
	
	private void cargarFrame() {
		try {
			List<CategoriaItem> categorias = ServiceLocator.getCategoriasService().listarCategorias();
			categoriaCombo.setModel(new DefaultComboBoxModel<CategoriaItem>(categorias.toArray(new CategoriaItem[categorias.size()])));
		} catch (ServiceException e) {
			JOptionPane.showMessageDialog(this, "Error", e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}

}
