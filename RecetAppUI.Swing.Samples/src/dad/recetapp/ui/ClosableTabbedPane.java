package dad.recetapp.ui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class ClosableTabbedPane extends JTabbedPane {
	
	private static final Icon ADD_TAB_ICON = new ImageIcon(ClosableTabbedPane.class.getResource("/dad/recetapp/ui/images/addTabIcon.png"));
	private static final Icon CLOSE_TAB_ICON = new ImageIcon(ClosableTabbedPane.class.getResource("/dad/recetapp/ui/images/closeTabIcon.png"));
	private static final Icon CLOSE_TAB_OVER_ICON = new ImageIcon(ClosableTabbedPane.class.getResource("/dad/recetapp/ui/images/closeTabOverIcon.png"));

	public ClosableTabbedPane() {
		addAddTab();
	}
	
	@Override
	public void addTab(String title, Component component) {
		addTab(title, null, component);
	}
	
	@Override
	public void addTab(String title, Icon icon, Component component) {
		addTab(title, icon, component, null);
	}
	
	@Override
	public void addTab(String title, Icon icon, final Component component, String tip) {

		// si hay pestañas en el tabbedPane, quito la última (la del +)
		if (getTabCount() > 0) {
			remove(getTabCount() - 1);
		}
		
		// añade la pestaña sin etiqueta
		super.addTab(null, component);
		
		int pos = indexOfComponent(component);

		// añade una etiqueta al panel con un título
		JLabel titleLabel = new JLabel(title);

		// crea el botón para cerrar la pestaña
		JButton closeButton = new JButton(CLOSE_TAB_OVER_ICON);
		closeButton.setOpaque(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setRolloverIcon(CLOSE_TAB_ICON);
		closeButton.setRolloverEnabled(true);
		closeButton.setBorder(null);
		closeButton.setFocusable(false);
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(component);
			}
		});

		// crea un panel transparente y añade el botón y la etiqueta
		JPanel tabPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
		tabPanel.setOpaque(false);
		tabPanel.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
		tabPanel.add(titleLabel);
		tabPanel.add(closeButton);
		tabPanel.setToolTipText(tip);

		// Now assign the component for the tab
		setTabComponentAt(pos, tabPanel);

		// Optionally bring the new tab to the front
		setSelectedComponent(component);

		addAddTab();
	}
	
	private void addAddTab() {
		super.addTab("", ADD_TAB_ICON, null);
	}

}
