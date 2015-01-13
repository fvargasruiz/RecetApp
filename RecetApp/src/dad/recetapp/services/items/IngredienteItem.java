package dad.recetapp.services.items;

public class IngredienteItem {
	private Long id;
	private Integer cantidad;
	private MedidaItem medida;
	private TipoIngredienteItem tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public MedidaItem getMedida() {
		return medida;
	}

	public void setMedida(MedidaItem medida) {
		this.medida = medida;
	}

	public TipoIngredienteItem getTipo() {
		return tipo;
	}

	public void setTipo(TipoIngredienteItem tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IngredienteItem) {
			IngredienteItem tipo = (IngredienteItem) obj;
			return tipo.getId() == this.id;
		}
		return false;
	}
	
	@Override
	public String toString() {
		if (medida.getAbreviatura() == null && medida.getAbreviatura().isEmpty())  {
			return cantidad + " " + medida.getNombre() + " de " + tipo.getNombre();
		} else if (medida.getNombre().trim().equals(""))  {
			return cantidad + " " + tipo.getNombre();
		}
		return cantidad + " " + medida.getAbreviatura() + " de " + tipo.getNombre();
	}
	
}
