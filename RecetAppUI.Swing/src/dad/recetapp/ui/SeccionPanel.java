package dad.recetapp.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class SeccionPanel extends JPanel {
	private JTable ingredientesTable;
	private JTable instruccionesTable;
	private JTextField seccionText;

	private Integer posicion;

	/**
	 * Create the panel.
	 */
	public SeccionPanel() {
		setName("raiz");
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
		{
			JSplitPane centralSplitPane = new JSplitPane();
			centralSplitPane.setResizeWeight(0.5);
			centralSplitPane.setOneTouchExpandable(true);
			principalPanel.add(centralSplitPane, BorderLayout.CENTER);
			{
				JPanel ingredientesPanel = new JPanel();
				ingredientesPanel.setBorder(new TitledBorder(null,
						"Ingredientes:", TitledBorder.LEADING,
						TitledBorder.TOP, null, null));
				centralSplitPane.setLeftComponent(ingredientesPanel);
				ingredientesPanel.setLayout(new BorderLayout(0, 0));
				{
					JPanel rellenoIngredientesPanel = new JPanel();
					rellenoIngredientesPanel.setBorder(new EmptyBorder(5, 5, 5,
							5));
					ingredientesPanel.add(rellenoIngredientesPanel,
							BorderLayout.CENTER);
					rellenoIngredientesPanel.setLayout(new BorderLayout(0, 0));
					{
						JScrollPane ingredientesScrollPane = new JScrollPane();
						rellenoIngredientesPanel.add(ingredientesScrollPane,
								BorderLayout.CENTER);
						{
							ingredientesTable = new JTable();
							ingredientesTable.setModel(new DefaultTableModel(
									new Object[][] {}, new String[] {
											"Cantidad", "Medida", "Tipo" }));
							ingredientesTable.setFillsViewportHeight(true);
							ingredientesScrollPane
									.setViewportView(ingredientesTable);
						}
					}
				}
				{
					JPanel ingredientesBotonesPanel = new JPanel();
					FlowLayout fl_ingredientesBotonesPanel = (FlowLayout) ingredientesBotonesPanel
							.getLayout();
					fl_ingredientesBotonesPanel.setAlignment(FlowLayout.RIGHT);
					ingredientesPanel.add(ingredientesBotonesPanel,
							BorderLayout.SOUTH);
					{
						JButton nuevoIngredienteButton = new JButton("");
						nuevoIngredienteButton
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										onNuevoIngredienteButtonActionPerformed(e);
									}
								});
						nuevoIngredienteButton
								.setIcon(new ImageIcon(
										NuevaRecetaDialog.class
												.getResource("/dad/recetapp/ui/images/add-icon-20x20.png")));
						ingredientesBotonesPanel.add(nuevoIngredienteButton);
					}
					{
						JButton editarIngredienteButton = new JButton("");
						editarIngredienteButton
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										onEditarIngredienteButtonActionPerformed(e);
									}
								});
						editarIngredienteButton
								.setIcon(new ImageIcon(
										NuevaRecetaDialog.class
												.getResource("/dad/recetapp/ui/images/edit-icon-20x20.png")));
						ingredientesBotonesPanel.add(editarIngredienteButton);
					}
					{
						JButton eliminarIngredienteButton = new JButton("");
						eliminarIngredienteButton
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										onEliminarIngredienteButtonActionPerformed(e);
									}
								});
						eliminarIngredienteButton
								.setIcon(new ImageIcon(
										NuevaRecetaDialog.class
												.getResource("/dad/recetapp/ui/images/delete-icon-20x20.png")));
						ingredientesBotonesPanel.add(eliminarIngredienteButton);
					}
				}
			}
			{
				JPanel instruccionesPanel = new JPanel();
				instruccionesPanel.setBorder(new TitledBorder(null,
						"Instrucciones:", TitledBorder.LEADING,
						TitledBorder.TOP, null, null));
				centralSplitPane.setRightComponent(instruccionesPanel);
				instruccionesPanel.setLayout(new BorderLayout(0, 0));
				{
					JPanel rellenoInstruccionesPanel = new JPanel();
					rellenoInstruccionesPanel.setBorder(new EmptyBorder(5, 5,
							5, 5));
					instruccionesPanel.add(rellenoInstruccionesPanel,
							BorderLayout.CENTER);
					rellenoInstruccionesPanel.setLayout(new BorderLayout(0, 0));
					{
						JScrollPane instruccionesScrollPane = new JScrollPane();
						rellenoInstruccionesPanel.add(instruccionesScrollPane,
								BorderLayout.CENTER);
						{
							instruccionesTable = new JTable();
							instruccionesTable
									.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
							instruccionesTable.setModel(new DefaultTableModel(
									new Object[][] {}, new String[] { "Orden",
											"Descripci\u00F3n" }));
							instruccionesTable.setFillsViewportHeight(true);
							instruccionesScrollPane
									.setViewportView(instruccionesTable);
						}
					}
				}
				{
					JPanel instruccionesBotonesPanel = new JPanel();
					FlowLayout fl_instruccionesBotonesPanel = (FlowLayout) instruccionesBotonesPanel
							.getLayout();
					fl_instruccionesBotonesPanel.setAlignment(FlowLayout.RIGHT);
					instruccionesPanel.add(instruccionesBotonesPanel,
							BorderLayout.SOUTH);
					{
						JButton nuevaInstruccionButton = new JButton("");
						nuevaInstruccionButton
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										onNuevaInstruccionButtonActionPerformed(e);
									}
								});
						nuevaInstruccionButton
								.setIcon(new ImageIcon(
										NuevaRecetaDialog.class
												.getResource("/dad/recetapp/ui/images/add-icon-20x20.png")));
						instruccionesBotonesPanel.add(nuevaInstruccionButton);
					}
					{
						JButton editarInstruccionButton = new JButton("");
						editarInstruccionButton
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										onEditarInstruccionButtonActionPerformed(e);
									}
								});
						editarInstruccionButton
								.setIcon(new ImageIcon(
										NuevaRecetaDialog.class
												.getResource("/dad/recetapp/ui/images/edit-icon-20x20.png")));
						instruccionesBotonesPanel.add(editarInstruccionButton);
					}
					{
						JButton eliminarInstruccionButton = new JButton("");
						eliminarInstruccionButton
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										onEliminarInstruccionButtonActionPerformed(e);
									}
								});
						eliminarInstruccionButton
								.setIcon(new ImageIcon(
										NuevaRecetaDialog.class
												.getResource("/dad/recetapp/ui/images/delete-icon-20x20.png")));
						instruccionesBotonesPanel
								.add(eliminarInstruccionButton);
					}
				}
			}
		}

	}

	public JTextField getSeccionText() {
		return seccionText;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	protected void onSeccionTextKeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	protected void onNuevoIngredienteButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	protected void onEditarIngredienteButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	protected void onEliminarIngredienteButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	protected void onNuevaInstruccionButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	protected void onEditarInstruccionButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	protected void onEliminarInstruccionButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	protected void onEliminarSeccionButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
