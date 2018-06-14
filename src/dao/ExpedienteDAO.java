package dao;

import java.util.ArrayList;
import java.util.List;

import entidad.ExpedienteBean;
import entidad.TrabajadorBean;

public interface ExpedienteDAO {
	
	public abstract List<ExpedienteBean> consultaExpediente(String filtro) throws Exception;
	public abstract List<TrabajadorBean> listaTrabajador();
	public abstract int eliminaExpediente(int idExpediente) throws Exception;
	public abstract int insertaExpediente(ExpedienteBean obj) throws Exception;
	public abstract int actualizaExpediente(ExpedienteBean obj) throws Exception;

}
