package dad.recetapp.services.items;

import java.util.ArrayList;
import java.util.List;

public class SeccionItem {
	private Long id;
	private String nombre;
	private List<IngredienteItem> ingredientes;
	private List<InstruccionItem> instrucciones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<IngredienteItem> getIngredientes() {
		if (ingredientes == null) {
			ingredientes = new ArrayList<IngredienteItem>();
		}
		return ingredientes;
	}

	public List<InstruccionItem> getInstrucciones() {
		if (instrucciones == null) {
			instrucciones = new ArrayList<InstruccionItem>();
		}
		return instrucciones;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SeccionItem) {
			SeccionItem tipo = (SeccionItem) obj;
			return tipo.getId() == this.id;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
}
