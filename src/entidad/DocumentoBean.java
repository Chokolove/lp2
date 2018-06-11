package entidad;

import java.sql.Date;

public class DocumentoBean {
	private int idDocumento;
	private ExpedienteBean expediente;
	private String descripcion, link;
	public int getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}
	public ExpedienteBean getExpediente() {
		return expediente;
	}
	public void setExpediente(ExpedienteBean expediente) {
		this.expediente = expediente;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
