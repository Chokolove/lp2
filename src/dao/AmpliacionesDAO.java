package dao;

import java.util.ArrayList;

import entidad.AmpliacionesBean;
import entidad.ExpedienteBean;
import entidad.TrabajadorBean;

public interface AmpliacionesDAO {
	
	public ArrayList<ExpedienteBean> listaExpediente();
	public int insertaAmpliacion(AmpliacionesBean ampliacion);
	public ArrayList<AmpliacionesBean> consultaAmpliacion();

}
