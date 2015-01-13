package dad.recetapp.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PruebasFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebasFrame frame = new PruebasFrame();
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
	public PruebasFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ClosableTabbedPane closableTabbedPane = new ClosableTabbedPane();
		contentPane.add(closableTabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		closableTabbedPane.addTab("New tab", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		closableTabbedPane.addTab("New tab", null, panel_1, null);
	}

}
