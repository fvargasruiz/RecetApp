package dad.recetapp.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SpinnerNumberModel;

public class EditarRecetaDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtAlbndigasEnSalsa;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	private JTextField txtAlbndigas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditarRecetaDialog dialog = new EditarRecetaDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditarRecetaDialog() {
		setTitle("Editar receta");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditarRecetaDialog.class.getResource("/dad/recetapp/ui/images/logo.png")));
		setModal(true);
		setBounds(100, 100, 742, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(0, 0, 5, 0));
			contentPanel.add(panel, BorderLayout.NORTH);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel lblNewLabel = new JLabel("Nombre:");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 0;
				panel.add(lblNewLabel, gbc_lblNewLabel);
			}
			{
				txtAlbndigasEnSalsa = new JTextField();
				txtAlbndigasEnSalsa.setText("Alb\u00F3ndigas en salsa");
				GridBagConstraints gbc_txtAlbndigasEnSalsa = new GridBagConstraints();
				gbc_txtAlbndigasEnSalsa.insets = new Insets(0, 0, 5, 5);
				gbc_txtAlbndigasEnSalsa.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtAlbndigasEnSalsa.gridx = 1;
				gbc_txtAlbndigasEnSalsa.gridy = 0;
				panel.add(txtAlbndigasEnSalsa, gbc_txtAlbndigasEnSalsa);
				txtAlbndigasEnSalsa.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Tiempo total:");
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 2;
				gbc_lblNewLabel_1.gridy = 0;
				panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				flowLayout.setVgap(0);
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.insets = new Insets(0, 0, 5, 0);
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 3;
				gbc_panel_1.gridy = 0;
				panel.add(panel_1, gbc_panel_1);
				{
					JSpinner spinner = new JSpinner();
					spinner.setModel(new SpinnerNumberModel(new Integer(45), null, null, new Integer(1)));
					panel_1.add(spinner);
				}
				{
					JLabel lblM = new JLabel("M");
					panel_1.add(lblM);
				}
				{
					JSpinner spinner = new JSpinner();
					spinner.setModel(new SpinnerNumberModel(new Integer(15), null, null, new Integer(1)));
					panel_1.add(spinner);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("S");
					panel_1.add(lblNewLabel_2);
				}
			}
			{
				JLabel lblPara = new JLabel("Para:");
				GridBagConstraints gbc_lblPara = new GridBagConstraints();
				gbc_lblPara.anchor = GridBagConstraints.EAST;
				gbc_lblPara.insets = new Insets(0, 0, 5, 5);
				gbc_lblPara.gridx = 0;
				gbc_lblPara.gridy = 1;
				panel.add(lblPara, gbc_lblPara);
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setHgap(0);
				flowLayout.setVgap(0);
				flowLayout.setAlignment(FlowLayout.LEFT);
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.insets = new Insets(0, 0, 5, 5);
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 1;
				gbc_panel_1.gridy = 1;
				panel.add(panel_1, gbc_panel_1);
				{
					textField_1 = new JTextField();
					textField_1.setText("3");
					panel_1.add(textField_1);
					textField_1.setColumns(10);
				}
				{
					JComboBox comboBox = new JComboBox();
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"Personas", "Unidades", "Gramos"}));
					panel_1.add(comboBox);
				}
			}
			{
				JLabel lblTiempoConThermomix = new JLabel("Tiempo con Thermomix:");
				GridBagConstraints gbc_lblTiempoConThermomix = new GridBagConstraints();
				gbc_lblTiempoConThermomix.anchor = GridBagConstraints.EAST;
				gbc_lblTiempoConThermomix.insets = new Insets(0, 0, 5, 5);
				gbc_lblTiempoConThermomix.gridx = 2;
				gbc_lblTiempoConThermomix.gridy = 1;
				panel.add(lblTiempoConThermomix, gbc_lblTiempoConThermomix);
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				flowLayout.setVgap(0);
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.insets = new Insets(0, 0, 5, 0);
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 3;
				gbc_panel_1.gridy = 1;
				panel.add(panel_1, gbc_panel_1);
				{
					JSpinner spinner = new JSpinner();
					spinner.setModel(new SpinnerNumberModel(new Integer(31), null, null, new Integer(1)));
					panel_1.add(spinner);
				}
				{
					JLabel label = new JLabel("M");
					panel_1.add(label);
				}
				{
					JSpinner spinner = new JSpinner();
					spinner.setModel(new SpinnerNumberModel(new Integer(50), null, null, new Integer(1)));
					panel_1.add(spinner);
				}
				{
					JLabel label = new JLabel("S");
					panel_1.add(label);
				}
			}
			{
				JLabel lblCategora = new JLabel("Categor\u00EDa:");
				GridBagConstraints gbc_lblCategora = new GridBagConstraints();
				gbc_lblCategora.anchor = GridBagConstraints.EAST;
				gbc_lblCategora.insets = new Insets(0, 0, 0, 5);
				gbc_lblCategora.gridx = 0;
				gbc_lblCategora.gridy = 2;
				panel.add(lblCategora, gbc_lblCategora);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Carnes", "Caldos", "Arroces", "<Seleccione una categor\u00EDa>"}));
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.anchor = GridBagConstraints.WEST;
				gbc_comboBox.insets = new Insets(0, 0, 0, 5);
				gbc_comboBox.gridx = 1;
				gbc_comboBox.gridy = 2;
				panel.add(comboBox, gbc_comboBox);
			}
		}
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			contentPanel.add(tabbedPane, BorderLayout.CENTER);
			{
				JPanel panel = new JPanel();
				tabbedPane.addTab("Alb\u00F3ndigas", null, panel, null);
				panel.setLayout(new BorderLayout(0, 0));
				{
					JPanel panel_1 = new JPanel();
					panel.add(panel_1, BorderLayout.NORTH);
					panel_1.setLayout(new BorderLayout(0, 0));
					{
						JPanel panel_2 = new JPanel();
						panel_1.add(panel_2, BorderLayout.WEST);
						{
							JLabel lblSeccin = new JLabel("Secci\u00F3n:");
							panel_2.add(lblSeccin);
						}
						{
							txtAlbndigas = new JTextField();
							txtAlbndigas.setText("Alb\u00F3ndigas");
							panel_2.add(txtAlbndigas);
							txtAlbndigas.setColumns(30);
						}
					}
					{
						JPanel panel_2 = new JPanel();
						panel_1.add(panel_2, BorderLayout.EAST);
						{
							JButton btnNewButton_8 = new JButton("-");
							panel_2.add(btnNewButton_8);
						}
					}
				}
				{
					JSplitPane splitPane = new JSplitPane();
					splitPane.setResizeWeight(0.5);
					splitPane.setOneTouchExpandable(true);
					panel.add(splitPane, BorderLayout.CENTER);
					{
						JPanel panel_1 = new JPanel();
						panel_1.setBorder(new TitledBorder(null, "Ingredientes:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						splitPane.setLeftComponent(panel_1);
						panel_1.setLayout(new BorderLayout(0, 0));
						{
							JPanel panel_2 = new JPanel();
							panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
							panel_1.add(panel_2, BorderLayout.CENTER);
							panel_2.setLayout(new BorderLayout(0, 0));
							{
								JScrollPane scrollPane = new JScrollPane();
								panel_2.add(scrollPane, BorderLayout.CENTER);
								{
									table = new JTable();
									table.setModel(new DefaultTableModel(
										new Object[][] {
											{"500", "Gramos", "Carne picada"},
											{"120", "Gramos", "Champi\u00F1ones"},
											{"1", "Cucharadita", "Sal"},
											{"600", "Gramos", "Tomate triturado"},
										},
										new String[] {
											"Cantidad", "Medida", "Tipo"
										}
									));
									table.setFillsViewportHeight(true);
									scrollPane.setViewportView(table);
								}
							}
						}
						{
							JPanel panel_2 = new JPanel();
							FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
							flowLayout.setAlignment(FlowLayout.RIGHT);
							panel_1.add(panel_2, BorderLayout.SOUTH);
							{
								JButton btnNewButton_4 = new JButton("");
								btnNewButton_4.setIcon(new ImageIcon(EditarRecetaDialog.class.getResource("/dad/recetapp/ui/images/add-icon-20x20.png")));
								panel_2.add(btnNewButton_4);
							}
							{
								JButton btnNewButton_3 = new JButton("");
								btnNewButton_3.setIcon(new ImageIcon(EditarRecetaDialog.class.getResource("/dad/recetapp/ui/images/edit-icon-20x20.png")));
								panel_2.add(btnNewButton_3);
							}
							{
								JButton btnNewButton = new JButton("");
								btnNewButton.setIcon(new ImageIcon(EditarRecetaDialog.class.getResource("/dad/recetapp/ui/images/delete-icon-20x20.png")));
								panel_2.add(btnNewButton);
							}
						}
					}
					{
						JPanel panel_1 = new JPanel();
						panel_1.setBorder(new TitledBorder(null, "Instrucciones:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						splitPane.setRightComponent(panel_1);
						panel_1.setLayout(new BorderLayout(0, 0));
						{
							JPanel panel_2 = new JPanel();
							panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
							panel_1.add(panel_2, BorderLayout.CENTER);
							panel_2.setLayout(new BorderLayout(0, 0));
							{
								JScrollPane scrollPane = new JScrollPane();
								panel_2.add(scrollPane, BorderLayout.CENTER);
								{
									table_1 = new JTable();
									table_1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
									table_1.setModel(new DefaultTableModel(
										new Object[][] {
											{"1", "Introduzca la carne picada en el vaso, junto con el aceite, y cocine a Temperatura Varoma, velocidad 5, 10 minutos"},
											{"2", "Meta los champi\u00F1ones en el vaso y triture durante 5 segundos velocidad 4."},
											{"3", "Eche la sal y los condimentos y remueva con la esp\u00E1tula."},
											{"4", "Me estoy inventando los pasos."},
											{"5", "As\u00ED que no lo pruebes en tu casa."},
										},
										new String[] {
											"Orden", "Descripci\u00F3n"
										}
									));
									table_1.setFillsViewportHeight(true);
									scrollPane.setViewportView(table_1);
								}
							}
						}
						{
							JPanel panel_2 = new JPanel();
							FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
							flowLayout.setAlignment(FlowLayout.RIGHT);
							panel_1.add(panel_2, BorderLayout.SOUTH);
							{
								JButton btnNewButton_7 = new JButton("");
								btnNewButton_7.setIcon(new ImageIcon(EditarRecetaDialog.class.getResource("/dad/recetapp/ui/images/add-icon-20x20.png")));
								panel_2.add(btnNewButton_7);
							}
							{
								JButton btnNewButton_6 = new JButton("");
								btnNewButton_6.setIcon(new ImageIcon(EditarRecetaDialog.class.getResource("/dad/recetapp/ui/images/edit-icon-20x20.png")));
								panel_2.add(btnNewButton_6);
							}
							{
								JButton btnNewButton_5 = new JButton("");
								btnNewButton_5.setIcon(new ImageIcon(EditarRecetaDialog.class.getResource("/dad/recetapp/ui/images/delete-icon-20x20.png")));
								panel_2.add(btnNewButton_5);
							}
						}
					}
				}
			}
			{
				JPanel panel = new JPanel();
				tabbedPane.addTab("Salsa de tomate", null, panel, null);
			}
			{
				JPanel panel = new JPanel();
				tabbedPane.addTab("+", null, panel, null);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel = new JPanel();
				buttonPane.add(panel, BorderLayout.WEST);
			}
			{
				JPanel panel = new JPanel();
				buttonPane.add(panel, BorderLayout.EAST);
				{
					JButton btnNewButton_1 = new JButton("Guardar cambios");
					panel.add(btnNewButton_1);
				}
				{
					JButton btnNewButton_2 = new JButton("Cancelar");
					panel.add(btnNewButton_2);
				}
			}
		}
	}

}
