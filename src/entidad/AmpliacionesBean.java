package entidad;

import java.sql.Date;

public class AmpliacionesBean {
	
	private int idAmpliaciones;
	private EmpleadoBean empleado;
	private Date fchVenc;
	private String estado, tipo;
	public int getIdAmpliaciones() {
		return idAmpliaciones;
	}
	public void setIdAmpliaciones(int idAmpliaciones) {
		this.idAmpliaciones = idAmpliaciones;
	}
	public EmpleadoBean getEmpleado() {
		return empleado;
	}
	public void setEmpleado(EmpleadoBean empleado) {
		this.empleado = empleado;
	}
	public Date getFchVenc() {
		return fchVenc;
	}
	public void setFchVenc(Date fchVenc) {
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
