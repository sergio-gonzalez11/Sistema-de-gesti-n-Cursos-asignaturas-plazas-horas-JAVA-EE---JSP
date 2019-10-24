package entidades;

public class OfertaEducativa {
	private long idIes;
	private String nombreIes;
	private long idCiclo;
	private String nombreCiclo;
	private long idTurno;
	private String nombreTurno;
	private long plazas;
	
	public OfertaEducativa() {}

	public long getIdCiclo() {
		return idCiclo;
	}
	public void setIdCiclo(long idCiclo) {
		this.idCiclo = idCiclo;
	}

	public String getNombreCiclo() {
		return nombreCiclo;
	}
	public void setNombreCiclo(String nombreCiclo) {
		this.nombreCiclo = nombreCiclo;
	}

	public long getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}

	public String getNombreTurno() {
		return nombreTurno;
	}
	public void setNombreTurno(String nombreTurno) {
		this.nombreTurno = nombreTurno;
	}

	public long getPlazas() {
		return plazas;
	}
	public void setPlazas(long plazas) {
		this.plazas = plazas;
	}

	public long getIdIes() {
		return idIes;
	}
	public void setIdIes(long idIes) {
		this.idIes = idIes;
	}

	public String getNombreIes() {
		return nombreIes;
	}
	public void setNombreIes(String nombreIes) {
		this.nombreIes = nombreIes;
	}

	
}
