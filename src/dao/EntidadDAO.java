package dao;

import java.util.ArrayList;
import java.util.List;

import entidad.AmpliacionesBean;
import entidad.DocumentoBean;
import entidad.EmpleadoBean;
import entidad.EntidadBean;
import entidad.ExpedienteBean;
import entidad.TrabajadorBean;

public interface EntidadDAO {
	
	public abstract int insertaEntidad(EntidadBean obj) throws Exception;
	public abstract List<EntidadBean> consultaEntidadPorNombre(String filtro) throws Exception;
	public abstract List<EntidadBean> listaEntidad();
	public abstract int eliminaEntidad(int idEnt) throws Exception;
	public abstract int actualizaEntidad(EntidadBean obj) throws Exception;

}
