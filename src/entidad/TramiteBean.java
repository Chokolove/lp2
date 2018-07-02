package entidad;

public class TramiteBean {
	private int idTramite;
	private ExpedienteBean expediente;
	private String fchVenc;
	private String estado;
	private String tipo;
	public int getIdTramite() {
		return idTramite;
	}
	public void setIdTramite(int idTramite) {
		this.idTramite = idTramite;
	}
	public ExpedienteBean getExpediente() {
		return expediente;
	}
	public void setExpediente(ExpedienteBean expediente) {
		this.expediente = expediente;
	}
	public String getFchVenc() {
		return fchVenc;
	}
	public void setFchVenc(String fchVenc) {
		this.fchVenc = fchVenc;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
