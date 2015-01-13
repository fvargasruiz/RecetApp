package dad.recetapp.services;

import java.util.ResourceBundle;

public class ServiceLocator {
	
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ServiceLocator.class.getPackage().getName() + ".services");
	
	private static ICategoriasService cs = (ICategoriasService) instanceService(BUNDLE.getString("service.categorias"));
	private static IMedidasService ms = (IMedidasService) instanceService(BUNDLE.getString("service.medidas"));
	private static ITiposAnotacionesService tas = (ITiposAnotacionesService) instanceService(BUNDLE.getString("service.tiposAnotaciones"));
	private static ITiposIngredientesService tis = (ITiposIngredientesService) instanceService(BUNDLE.getString("service.tiposIngredientes"));
	private static IRecetasService rs = (IRecetasService) instanceService(BUNDLE.getString("service.recetas"));
	
	public static ICategoriasService getCategoriasService() {
		return cs;
	}
	
	public static IMedidasService getMedidasService() {
		return ms;
	}
	
	public static ITiposAnotacionesService getTiposAnotacionesService() {
		return tas;
	}
	
	public static ITiposIngredientesService getTiposIngredientesService() {
		return tis;
	}
	
	public static IRecetasService getRecetasService() {
		return rs;
	}
	
	private static Object instanceService(String className) {
		Object service = null;
		try {
			Class<?> clazz = ServiceLocator.class.getClassLoader().loadClass(className);
			service = clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return service;
	}

}
