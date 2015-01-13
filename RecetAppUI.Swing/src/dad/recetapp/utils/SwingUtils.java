package dad.recetapp.utils;

import java.awt.Component;
import java.awt.Container;

public class SwingUtils {
	
	public static Container findParentByName(Component c, String name) {
		Container parent = null;
		while (c.getParent() != null && !name.equals(c.getName())) {
			System.out.println(c.getClass().getName() + "/" + c.getName());
			c= c.getParent();
		}
		return parent;
	}

}
