package dad.recetapp.ui;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JSpinner;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class DuracionPanel extends JPanel {
	private JSpinner minutosSpinner;
	private JSpinner segundosSpinner;

	/**
	 * Create the panel.
	 */
	public DuracionPanel() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel, BorderLayout.CENTER);
		
		minutosSpinner = new JSpinner();
		minutosSpinner.setPreferredSize(new Dimension(40, 20));
		panel.add(minutosSpinner);
		
		JLabel minutosLabel = new JLabel("M");
		panel.add(minutosLabel);
		
		segundosSpinner = new JSpinner();
		segundosSpinner.setPreferredSize(new Dimension(40, 20));
		panel.add(segundosSpinner);
		
		JLabel segundosLabel = new JLabel("S");
		panel.add(segundosLabel);

	}

	public Integer getSegundos() {
		Integer minutos = (Integer) minutosSpinner.getValue();
		Integer segundos = (Integer) segundosSpinner.getValue();
		return (minutos * 60) + segundos;
	}

	public void setSegundos(Integer segundos) {
		minutosSpinner.setValue(segundos / 60);
		segundosSpinner.setValue(segundos % 60);
	}

}
