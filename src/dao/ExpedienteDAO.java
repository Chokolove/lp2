package dao;

import java.util.List;

import entidad.ExpedienteBean;

public interface ExpedienteDAO {
	
	public abstract List<ExpedienteBean> consultaExpediente(String filtro) throws Exception;
	public abstract int eliminaExpediente(int idExpediente) throws Exception;
	public abstract int insertaExpediente(ExpedienteBean obj) throws Exception;
	public abstract int actualizaExpediente(ExpedienteBean obj) throws Exception;

}
