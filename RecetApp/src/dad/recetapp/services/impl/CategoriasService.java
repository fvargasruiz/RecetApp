package dad.recetapp.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dad.recetapp.db.DataBase;
import dad.recetapp.services.ICategoriasService;
import dad.recetapp.services.ServiceException;
import dad.recetapp.services.items.CategoriaItem;

public class CategoriasService implements ICategoriasService {

	public void crearCategoria(CategoriaItem categoria) throws ServiceException {
		try {
			Connection conn = DataBase.getConnection();
			PreparedStatement sentencia = conn.prepareStatement("insert into categorias (descripcion) values (?)");
			sentencia.setString(1, categoria.getDescripcion());
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			throw new ServiceException("Error al crear la categoría '" + categoria.getDescripcion() + "': " + e.getMessage());
		}		
	}
	
	public void modificarCategoria(CategoriaItem categoria) throws ServiceException {
		try {
			Connection conn = DataBase.getConnection();
			PreparedStatement sentencia = conn.prepareStatement("update categorias set descripcion=? where id=?");
			sentencia.setString(1, categoria.getDescripcion());
			sentencia.setLong(2, categoria.getId());
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			throw new ServiceException("Error al modificar la categoría '" + categoria.getDescripcion() + "': " + e.getMessage());
		}		
	}
	
	public void eliminarCategoria(Long id) throws ServiceException {
		try {
			Connection conn = DataBase.getConnection();
			PreparedStatement sentencia = conn.prepareStatement("delete from categorias where id=?");
			sentencia.setLong(1, id);
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			throw new ServiceException("Error al eliminar la categoría con ID '" + id + "': " + e.getMessage());
		}	
	}
	
	public List<CategoriaItem> listarCategorias() throws ServiceException {
		List<CategoriaItem> categorias = new ArrayList<CategoriaItem>();
		try {
			Connection conn = DataBase.getConnection();
			Statement sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery("select * from categorias order by descripcion");
			while (rs.next()) {
				categorias.add(resultSetToItem(rs));
			}
			rs.close();
			sentencia.close();
		} catch (SQLException e) {
			throw new ServiceException("Error al recuperar las categorías: " + e.getMessage());
		}	
		return categorias;
	}
	
	public CategoriaItem obtenerCategoria(Long id) throws ServiceException {
		CategoriaItem categoria = null;
		try {
			Connection conn = DataBase.getConnection();
			PreparedStatement sentencia = conn.prepareStatement("select * from categorias where id=?");
			sentencia.setLong(1, id);
			ResultSet rs = sentencia.executeQuery();
			if (rs.next()) {
				categoria = resultSetToItem(rs);
			}
			rs.close();
			sentencia.close();
		} catch (SQLException e) {
			throw new ServiceException("Error al recuperar la categoría con ID '" + id + "': " + e.getMessage());
		}	
		return categoria;
	}
	
	private CategoriaItem resultSetToItem(ResultSet rs) throws SQLException {
		CategoriaItem item = new CategoriaItem();
		item.setId(rs.getLong("id"));
		item.setDescripcion(rs.getString("descripcion"));
		return item;
	}
	
}
