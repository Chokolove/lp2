package dao;

import java.util.List;

import entidad.ExpedienteBean;
import entidad.TrabajadorBean;
import entidad.TramiteBean;

public interface TramiteDAO {
	
	public abstract List<TramiteBean> consultaTramite(String filtro) throws Exception;
	public abstract int insertaTramite(TramiteBean obj) throws Exception;

	public abstract int actualizaTramite(TramiteBean obj) throws Exception;
}
