package dad.recetapp;

import java.sql.SQLException;
import java.util.List;

import dad.recetapp.db.DataBase;
import dad.recetapp.services.ServiceLocator;
import dad.recetapp.services.ServiceException;
import dad.recetapp.services.items.CategoriaItem;

public class Main {

	public static void main(String[] args) throws SQLException, ServiceException {
		List<CategoriaItem> categorias = ServiceLocator.getCategoriasService().listarCategorias();
		for (CategoriaItem c : categorias) {
			System.out.println(c.getId() + "/" + c.getDescripcion());
		}
		DataBase.disconnect();
	}

}
