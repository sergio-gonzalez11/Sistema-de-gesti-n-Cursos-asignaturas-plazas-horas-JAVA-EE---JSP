package entidades;

public class Instituto {
	private long id;
	private String nombre;
	private boolean selected = false;
	
	public Instituto() {}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getSelected() {
		return selected;
	}
	public void setSelected(boolean b) {
		this.selected = true;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if(obj==this) {
			return true;
		}
		if(!(obj instanceof Instituto)) {
			return false;
		}
		Instituto p = (Instituto) obj;
		if(p.getId()==this.getId()) {
			return true;
		}else {
			return false;
		}
	}

	
	
}
