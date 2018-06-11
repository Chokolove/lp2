package entidad;

import java.sql.Date;

public class ExpedienteBean {
		
	private int idExpediente;
	private TrabajadorBean trabajador;
	private EntidadBean entidad;
	private String estado;
	private String fchaApertura;
	public int getIdExpediente() {
		return idExpediente;
	}
	public void setIdExpediente(int idExpediente) {
		this.idExpediente = idExpediente;
	}
	public TrabajadorBean getTrabajador() {
		return trabajador;
	}
	public void setTrabajador(TrabajadorBean trabajador) {
		this.trabajador = trabajador;
	}
	public EntidadBean getEntidad() {
		return entidad;
	}
	public void setEntidad(EntidadBean entidad) {
		this.entidad = entidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFchaApertura() {
		return fchaApertura;
	}
	public void setFchaApertura(String fchaApertura) {
		this.fchaApertura = fchaApertura;
	}
	
}
