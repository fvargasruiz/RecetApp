package dad.recetapp.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

public class EditarInstruccionDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditarInstruccionDialog dialog = new EditarInstruccionDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditarInstruccionDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditarInstruccionDialog.class.getResource("/dad/recetapp/ui/images/logo.png")));
		setTitle("Editar instrucci\u00F3n para 'Alb\u00F3ndigas'");
		setBounds(100, 100, 450, 206);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCantidad = new JLabel("Orden:");
			GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
			gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
			gbc_lblCantidad.anchor = GridBagConstraints.EAST;
			gbc_lblCantidad.gridx = 0;
			gbc_lblCantidad.gridy = 0;
			contentPanel.add(lblCantidad, gbc_lblCantidad);
		}
		{
			textField = new JTextField();
			textField.setText("2");
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JLabel lblMedida = new JLabel("Descripci\u00F3n:");
			GridBagConstraints gbc_lblMedida = new GridBagConstraints();
			gbc_lblMedida.anchor = GridBagConstraints.NORTHEAST;
			gbc_lblMedida.insets = new Insets(0, 0, 5, 5);
			gbc_lblMedida.gridx = 0;
			gbc_lblMedida.gridy = 1;
			contentPanel.add(lblMedida, gbc_lblMedida);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 1;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				JTextArea txtrMetaLosChampiones = new JTextArea();
				txtrMetaLosChampiones.setLineWrap(true);
				txtrMetaLosChampiones.setWrapStyleWord(true);
				txtrMetaLosChampiones.setFont(new Font("Tahoma", Font.PLAIN, 11));
				txtrMetaLosChampiones.setText("Meta los champi\u00F1ones en el vaso y triture durante 5 segundos velocidad 4.");
				scrollPane.setViewportView(txtrMetaLosChampiones);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
