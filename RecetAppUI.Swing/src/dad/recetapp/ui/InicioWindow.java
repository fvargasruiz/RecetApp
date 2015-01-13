package dad.recetapp.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class InicioWindow extends JWindow {
	
	private static final int DURACION = 4000; // milisegundos
	
	private Timer temporizador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioWindow frame = new InicioWindow();
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
	public InicioWindow() {
		temporizador = new Timer(DURACION, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				temporizador.start();
			}
			@Override
			public void windowClosed(WindowEvent e) {
				temporizador.stop();
			}
		});
		setBounds(100, 100, 472, 250);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(InicioWindow.class.getResource("/dad/recetapp/ui/images/recetapp-inicio.png")));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				temporizador.stop();
				dispose();
			}
		});
		getContentPane().add(label, BorderLayout.CENTER);
	}

}
