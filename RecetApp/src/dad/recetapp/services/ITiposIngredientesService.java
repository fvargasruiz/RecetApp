package dad.recetapp.services;

import java.util.List;

import dad.recetapp.services.items.TipoIngredienteItem;

public interface ITiposIngredientesService {

	public void crearTipoIngrediente(TipoIngredienteItem tipo) throws ServiceException;
	public void modificarTipoIngrediente(TipoIngredienteItem tipo) throws ServiceException;
	public void eliminarTipoIngrediente(Long id) throws ServiceException;
	public List<TipoIngredienteItem> listarTiposIngredientes() throws ServiceException;
	public TipoIngredienteItem obtenerTipoIngrediente(Long id) throws ServiceException;
	
}
