package dad.recetapp.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;
import java.awt.Toolkit;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_1;
	private JTextField textField_2;
	private JTable table_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_3;
	private JTable table_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/dad/recetapp/ui/images/logo.png")));
		setTitle("RecetApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pestanasPanel = new JPanel();
		contentPane.add(pestanasPanel, BorderLayout.CENTER);
		pestanasPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		pestanasPanel.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel recetasPanel = new JPanel();
		tabbedPane.addTab("Recetas", null, recetasPanel, null);
		recetasPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		recetasPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Filtrar:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblNombre_2 = new JLabel("Nombre:");
		panel_7.add(lblNombre_2);
		
		textField_5 = new JTextField();
		panel_7.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblTiempo = new JLabel("Hasta:");
		panel_7.add(lblTiempo);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		panel_7.add(spinner);
		
		JLabel lblM = new JLabel("M");
		panel_7.add(lblM);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		panel_7.add(spinner_1);
		
		JLabel lblS = new JLabel("S");
		panel_7.add(lblS);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		panel_7.add(lblCategora);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Todas>", "Caldos", "Carnes", "Pescados", "Postres", "Salsas"}));
		panel_7.add(comboBox);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Recetas:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_10.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel_11.add(scrollPane_4, BorderLayout.CENTER);
		
		table_4 = new JTable();
		table_4.setFillsViewportHeight(true);
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{"Alb\u00F3ndigas", "3 personas", "45M 30S", "20/11/2013 11:25", "Carnes"},
				{"Sopa de pollo", "4 personas", "150M", "12/10/2012 13:56", "Caldos"},
			},
			new String[] {
				"Nombre", "Para", "Tiempo total", "Fecha de creaci\u00F3n", "Categor\u00EDa"
			}
		));
		table_4.getColumnModel().getColumn(0).setPreferredWidth(108);
		table_4.getColumnModel().getColumn(3).setPreferredWidth(136);
		scrollPane_4.setViewportView(table_4);
		
		JPanel panel_8 = new JPanel();
		recetasPanel.add(panel_8, BorderLayout.EAST);
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 5));
		
		JButton btnAadir_4 = new JButton("A\u00F1adir");
		panel_9.add(btnAadir_4);
		
		JButton btnEliminar_4 = new JButton("Eliminar");
		panel_9.add(btnEliminar_4);
		
		JButton btnEditar = new JButton("Editar");
		panel_9.add(btnEditar);
		
		JPanel categoriasPanel = new JPanel();
		tabbedPane.addTab("Categor\u00EDas", null, categoriasPanel, null);
		categoriasPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		categoriasPanel.add(panel_6, BorderLayout.NORTH);
		
		JLabel lblDescripcin_1 = new JLabel("Descripci\u00F3n:");
		panel_6.add(lblDescripcin_1);
		
		textField_4 = new JTextField();
		panel_6.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAadir_3 = new JButton("A\u00F1adir");
		panel_6.add(btnAadir_3);
		
		JButton btnEliminar_3 = new JButton("Eliminar");
		panel_6.add(btnEliminar_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		categoriasPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_1.add(scrollPane_3, BorderLayout.CENTER);
		
		table_3 = new JTable();
		table_3.setFillsViewportHeight(true);
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{"Arroces"},
				{"Carnes"},
				{"Pescados"},
				{"Postres"},
				{"Salsas"},
				{"Sopas"},
			},
			new String[] {
				"Descripci\u00F3n"
			}
		));
		scrollPane_3.setViewportView(table_3);
		
		JPanel ingredientesPanel = new JPanel();
		tabbedPane.addTab("Ingredientes", null, ingredientesPanel, null);
		ingredientesPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		ingredientesPanel.add(scrollPane_2, BorderLayout.CENTER);
		
		table_2 = new JTable();
		table_2.setFillsViewportHeight(true);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"Az\u00FAcar"},
				{"Carne picada"},
				{"Harina"},
				{"Huevos"},
				{"Or\u00E9gano"},
				{"Piment\u00F3n"},
				{"Pimienta blanca"},
				{"Sal"},
			},
			new String[] {
				"Nombre"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		JPanel panel_5 = new JPanel();
		ingredientesPanel.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		panel_5.add(lblNombre_1);
		
		textField_3 = new JTextField();
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAadir_2 = new JButton("A\u00F1adir");
		panel_5.add(btnAadir_2);
		
		JButton btnEliminar_2 = new JButton("Eliminar");
		panel_5.add(btnEliminar_2);
		
		JPanel medidasPanel = new JPanel();
		tabbedPane.addTab("Medidas", null, medidasPanel, null);
		medidasPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		medidasPanel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"gramos", "g"},
				{"unidades", "ud"},
				{"litros", "l"},
				{"mililitros", "ml"},
				{"kilogramos", "kg"},
			},
			new String[] {
				"Nombre", "Abreviatura"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		medidasPanel.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNombre = new JLabel("Nombre:");
		panel_3.add(lblNombre);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblAbreviatura = new JLabel("Abreviatura:");
		panel_3.add(lblAbreviatura);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		panel_3.add(btnAadir);
		
		JButton btnEliminar = new JButton("Eliminar");
		panel_3.add(btnEliminar);
		
		JPanel anotacionesPanel = new JPanel();
		tabbedPane.addTab("Anotaciones", null, anotacionesPanel, null);
		anotacionesPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		anotacionesPanel.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		table_1.setFillsViewportHeight(true);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nota"},
				{"Sugerencia"},
				{"Comentario"},
			},
			new String[] {
				"Descripci\u00F3n"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_4 = new JPanel();
		anotacionesPanel.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		panel_4.add(lblDescripcin);
		
		textField_2 = new JTextField();
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAadir_1 = new JButton("A\u00F1adir");
		panel_4.add(btnAadir_1);
		
		JButton btnEliminar_1 = new JButton("Eliminar");
		panel_4.add(btnEliminar_1);
		
		JPanel estadoPanel = new JPanel();
		FlowLayout fl_estadoPanel = (FlowLayout) estadoPanel.getLayout();
		fl_estadoPanel.setAlignment(FlowLayout.LEFT);
		contentPane.add(estadoPanel, BorderLayout.SOUTH);
		
		JLabel lblRecetas = new JLabel("Recetas: 2");
		estadoPanel.add(lblRecetas);
	}

}
